package MyLibraries.Convertion;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

public class WriteXmlToCpp {
    public void ConvertFromXML2Cpp(String xmlFilePath){
        // read xml file usign jdom

        SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);
        WriteXmlToCpp jwrite = new WriteXmlToCpp();
        try {
    
            Document xmlDocument = builder.build(new File(xmlFilePath));
            Element root = xmlDocument.getRootElement();
                
            List<Element> list = root.getChildren("class");

            jwrite.printClassesFromXmlIntoCppFile(list);
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
    
        }

    }
    public boolean  printClassesFromXmlIntoCppFile(List<Element> list){
        try{
            for (int i = 0; i < list.size(); i++) {
                Element monClass = (Element) list.get(i);
                printClassFromXmlIntoCppFile(monClass);
            }
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }
    //depth 1
    private boolean printClassFromXmlIntoCppFile(Element monClass) {
        try{
            String className = monClass.getAttributeValue("name");
            FileWriter  JavaFile = new FileWriter(capitalize(className)+".cpp" );
            JavaFile.write("#include <iostream>\n");

            JavaFile.write("class "+capitalize(className));
            printExtendIfWeHaveIt(monClass, JavaFile);
        
            JavaFile.write(" {"+"\n");
            JavaFile.write("\t"+"private :\n");
            printAttributesDeClass(monClass, JavaFile);
           // printLesVariableDautreClasses(monClass, JavaFile);
            JavaFile.write("\t"+"public:\n");
            printConstructorDeClass(monClass, JavaFile);
            printGettersAndSetters(monClass, JavaFile);
            printMethodesDeClass(monClass, JavaFile);
            JavaFile.write("}\";"+"\n");
            JavaFile.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }
     // depth 2
    private boolean printExtendIfWeHaveIt(Element monClass, FileWriter JavaFile) {
        String superClass = monClass.getAttributeValue("superClass");
        try{
            if(superClass == null){
                return false;
            }
            if(!superClass.equals("")){
                JavaFile.write(": public "+ capitalize(superClass));
            }
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    } 
    private void printAttributesDeClass(Element monClass, FileWriter JavaFile) {
        List<Element> listDesAtributtes = monClass.getChildren("attributes").get(0).getChildren("attribute");
        for (int i = 0; i < listDesAtributtes.size(); i++) {
            Element monAtributte = (Element) listDesAtributtes.get(i);
            String name = monAtributte.getAttributeValue("name");
            String type = monAtributte.getAttributeValue("type");
            String value  = monAtributte.getAttributeValue("value");
            try{
                if(!value.equals("")){
                    if(!type.equals("String")){
                        JavaFile.write("\t"+type+" "+name+" = "+value+";"+"\n"+"\n");
                    }else{
                        JavaFile.write("\t"+type+" "+name+" = \""+value+"\";"+"\n"+"\n");
                    }
                }else{
                    JavaFile.write("\t"+type+" "+name+";"+"\n"+"\n");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }
    }
    private void printGettersAndSetters(Element monClass, FileWriter JavaFile) { 
        List<Element> listDesAtributtes = monClass.getChildren("attributes").get(0).getChildren("attribute");
        
        for (int i = 0; i < listDesAtributtes.size(); i++) {
            Element monAtributte = (Element) listDesAtributtes.get(i);
            String name = monAtributte.getAttributeValue("name");
            String type = monAtributte.getAttributeValue("type");
            try{
                JavaFile.write("\t"+type+" get"+capitalize(name)+"()"+"{"+"\n");
                JavaFile.write("\t"+"\t"+"return "+"this."+name+";"+"\n");
                JavaFile.write("\t"+"}"+"\n");
                JavaFile.write("\t"+"void set"+capitalize(name)+"("+type+" "+name+"){"+"\n");
                JavaFile.write("\t"+"\t"+"this."+name+" = "+name+";"+"\n");
                JavaFile.write("\t"+"}"+"\n");
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }
    }
    private void printConstructorDeClass(Element monClass, FileWriter JavaFile) {
        printLeNomEtLesParametresDeConstructeur(monClass, JavaFile);
        printSuperInConstructor(monClass, JavaFile);
        printContenueDeConstructeur(monClass, JavaFile);
        try{
        JavaFile.write("\t"+"}"+"\n");
        }catch(Exception e){
         System.out.println(e.getMessage());
        }
    }
    /*private void printLesVariableDautreClasses(Element monClass, FileWriter javaFile) {
    }
    */
    private void printMethodesDeClass(Element monClass, FileWriter JavaFile) {
        List<Element> listDesMethodes = monClass.getChildren("methodes").get(0).getChildren("methode");
        for (int i = 0; i < listDesMethodes.size(); i++) {
            Element maMethode = (Element) listDesMethodes.get(i);
            String name = maMethode.getAttributeValue("name");
            String type = maMethode.getAttributeValue("return");
            try{
                JavaFile.write("\t"+type+" "+name+"(");

                printLesParametres(maMethode, JavaFile);
                
                JavaFile.write(")"+"{"+"\n");
                JavaFile.write("\t"+"\t"+"//Ecrit ici"+"\n"+"\n");
                JavaFile.write("\t"+"}"+"\n");
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }
    }

   private void printLesParametres(Element maMethode, FileWriter JavaFile) {
    List<Element> listDesParametres = maMethode.getChildren("param");
    for (int i = 0; i < listDesParametres.size(); i++) {
        Element monParametre = (Element) listDesParametres.get(i);
        String name = monParametre.getAttributeValue("name");
        String type = monParametre.getAttributeValue("type");
        try{
            JavaFile.write(type+" "+name);
            if(i != listDesParametres.size()-1){
                JavaFile.write(",");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    }
    //composant du constructeur 
    private void printContenueDeConstructeur(Element monClass, FileWriter JavaFile) {
    }
    private void printLeNomEtLesParametresDeConstructeur(Element monClass, FileWriter JavaFile) {
    }
    private void printSuperInConstructor(Element monClass, FileWriter JavaFile) {
    }
   



    private String capitalize(String inputString) {
        // get the first character of the inputString
		char firstLetter = inputString.charAt(0);

		// convert it to an UpperCase letter
		char capitalFirstLetter = Character.toUpperCase(firstLetter);

		// return the output string by updating
		//the first char of the input string
		return inputString.replace(inputString.charAt(0), capitalFirstLetter);
        
    }

    
}
