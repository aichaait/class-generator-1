package MyLibraries.Convertion;

import java.io.File;
import java.io.FileWriter;
import java.net.http.WebSocket.Listener;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

public class WriteXmlToSql {

     // fonction generale
    /*public boolean  printClassesFromXmlIntoSqlFile(List<Element> list){
        try{
            for (int i = 0; i < list.size(); i++) {
                Element monClass = (Element) list.get(i);
                printClassFromXmlIntoSqlFile(monClass);
            }
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }*/
    
    public  boolean printTablesFromXmlIntoSqlFile(List<Element> listdesclasses, FileWriter  JavaFile ) {
        
                
        try{
        
        //FileWriter  JavaFile = new FileWriter("file.sql" );
        for (int i = 0; i < listdesclasses.size(); i++) {
        Element monClass = (Element) listdesclasses.get(i);
        
        
        String className = monClass.getAttributeValue("name");
        
        

        JavaFile.write("\nCREATE TABLE  "+capitalize(className));
        JavaFile.write(" ("+"\n");
        JavaFile.write("\tID INT PRIMARY KEY ,\n");
        printleschampduTable(monClass, JavaFile);
        
        JavaFile.write("\n");
        JavaFile.write(");"+"\n");
        }
        /*for (int i = 0; i < listdesclasses.size(); i++) {
        Element monClass = (Element) listdesclasses.get(i);
        printExtendIfWeHaveIt(monClass ,JavaFile);
        printLesVariableDautreTables(monClass, JavaFile);
        
        }*/
        }
        catch(Exception e )
        {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    
        
    
    
    public boolean printExtendIfWeHaveIt(Element monClass ,FileWriter JavaFile){
        
        String superClass = monClass.getAttributeValue("superClass");
        String className = monClass.getAttributeValue("name");
        try{
            if(superClass == null){
                return false;
            }
            if(!superClass.equals("")){
                JavaFile.write("ALTER TABLE "+capitalize(className)+" ADD CONSTRAINT FK_CHILD FOREIGN KEY (ID) REFERENCES " +capitalize(superClass)+"(ID); \n");
            }
            //anziid les cas (varchar,uint,hdn) wdiiik , nrd m3aha lbal
            //anyiid foreign key 
            // les primary key ach andiir lihoum surtt lakan heritage w assosiations 
            // anyiid select * w selekt were w update w nsmiwhoome 3la khatrnaa bac labghahoum i3iyt 3lihom wikhdmhoum 3aadi bssahl 
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }

    private void printleschampduTable(Element monClass, FileWriter JavaFile) {
       
        List<Element> listDesAtributtes = monClass.getChildren("attributes").get(0).getChildren("attribute");
        for (int i = 0; i < listDesAtributtes.size(); i++) {
            Element monAtributte = (Element) listDesAtributtes.get(i);
            String name = monAtributte.getAttributeValue("name");
            String type = monAtributte.getAttributeValue("type");
            try{
                if(type.equals("String")){
                    JavaFile.write("\t" +name+" "+ "VARCHAR(50) ");
                    if(i<listDesAtributtes.size()-1){ JavaFile.write(",  \n");} 
                }if(type.equals("int")){
                    JavaFile.write("\t" +name+" "+ "INT ");
                    if(i<listDesAtributtes.size()-1){ JavaFile.write(",  \n");} 
                }
                if(type.equals("Char")){
                    JavaFile.write("\t" +name+" "+ "CHAR ");
                    if(i<listDesAtributtes.size()-1){ JavaFile.write(",  \n");} 
                }
                if(type.equals("double")){  
                JavaFile.write("\t" +name+" "+ "FLOAT ");
                if(i<listDesAtributtes.size()-1){ JavaFile.write(",  \n");} 
                }
            }catch(Exception e){

            }
                
        }
    }

    

    public boolean printLesVariableDautreTables(List<Element> listdesclasses, FileWriter  sqlFile ) {
        try{
            
           // FileWriter  sqlFile = new FileWriter("update.sql" );
           
         for (Element monClass : listdesclasses) {
            List<Element> listDesAssociations = monClass.getChildren("associations").get(0).getChildren("association");
            String classDArrivee,typeassociation;
            String className = monClass.getAttributeValue("name");
            /*if(listDesAssociations.size() == 0){
                return ;
            }*/
            for (Element association : listDesAssociations) {
                classDArrivee = association.getAttributeValue("classArrivee");
                typeassociation = association.getAttributeValue("type");
                if(typeassociation.equals("simple")){
                    try{
                    sqlFile.write("\n ALTER TABLE "+classDArrivee+" ADD "+className+"_ID INT ; \n");
                    sqlFile.write("\n ALTER TABLE "+classDArrivee+" ADD FOREING KEY("+className+"_ID"+")REFERENCES "+className+"(ID);");
                    }
                    catch(Exception e)
                    {

                    }
                 }
                    if(typeassociation.equals("aggregation")){
                        try{
                            sqlFile.write("CREATE TABLE AGREGATION ( \n  ");
                            sqlFile.write("\t "+className+"_ID INT ,\n");
                            sqlFile.write("\t "+classDArrivee+"_ID INT ,\n");
                            sqlFile.write("\t PRIMARY KEY ("+className+"_ID,"+classDArrivee+"_ID),\n " );
                            sqlFile.write("\t FOREIGN KEY ("+className+"_ID) REFERENCES "+className+"(ID),\n");
                            sqlFile.write("\t FOREIGN KEY ("+classDArrivee+"_ID) REFERENCES "+classDArrivee+"(ID)\n");
                            sqlFile.write(");\n ");

                        }
                        catch(Exception e)
                        {
                        }
                    }
                    if(typeassociation.equals("composition")){
                        try{
                            sqlFile.write("\n ALTER TABLE "+className+" ADD "+classDArrivee+"_ID INT ; \n");
                            sqlFile.write("\n ALTER TABLE "+className+" ADD FOREING KEY("+classDArrivee+"_ID"+")REFERENCES "+classDArrivee+"(ID) ;\n");
                        }
                        catch(Exception e)
                        {
                            
                        }
                    }
                
                
                }
            } 
       }
    catch(Exception e)
    {
        
    }
    return true;
    }

    public static String capitalize(String inputString) {

		// get the first character of the inputString
		char firstLetter = inputString.charAt(0);

		// convert it to an UpperCase letter
		char capitalFirstLetter = Character.toUpperCase(firstLetter);

		// return the output string by updating
		//the first char of the input string
		return inputString.replace(inputString.charAt(0), capitalFirstLetter);
	}
}

