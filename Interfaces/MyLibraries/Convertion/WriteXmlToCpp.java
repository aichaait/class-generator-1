package MyLibraries.Convertion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    
            Document xmlDocument = builder.build(new File(xmlFilePath+"/DiagrammeDesClasses/"+"DG.xml"));
            Element root = xmlDocument.getRootElement();
                
            List<Element> list = root.getChildren("class");

            jwrite.printClassesFromXmlIntoCppFile(list,xmlFilePath);
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
    
        }

    }
    public boolean  printClassesFromXmlIntoCppFile(List<Element> list,String path){
        try{
            for (int i = 0; i < list.size(); i++) {
                Element monClass = (Element) list.get(i);
                printClassFromXmlIntoCppFile(monClass,path);
            }
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }
    //depth 1
    private boolean printClassFromXmlIntoCppFile(Element monClass,String path) {
        try{
            String className = monClass.getAttributeValue("name");
            FileWriter  CppFile = new FileWriter(path+"/cppclasses/"+capitalize(className)+".cpp" );
            printIncludes(monClass, CppFile);
            CppFile.write("class "+capitalize(className));

            printExtendIfWeHaveIt(monClass, CppFile);//done
        
            CppFile.write(" {"+"\n");
            CppFile.write("\t"+"private :\n");
            //done
            printAttributesDeClass(monClass, CppFile);
            printLesVariableDautreClasses(monClass, CppFile);
            CppFile.write("\t"+"public:\n");
            printConstructorDeClass(monClass, CppFile);
            printGettersAndSetters(monClass, CppFile);//done
            printMethodesDeClass(monClass, CppFile);//done
            CppFile.write("};\n");
            CppFile.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }
     // depth 2
     private void printIncludes(Element monClass ,FileWriter CppFile){
        String superClass = monClass.getAttributeValue("superClass");

            try {
                CppFile.write("#include <iostream>\n");
                CppFile.write("#include <list>\n");
                CppFile.write("#include <string>\n");


                if(superClass == null){
                    System.out.println("done");
                }else if(!superClass.equals("")){
                    CppFile.write("#include \""+capitalize(superClass)+".cpp\"\n");
                }
                for (Element association : monClass.getChild("associations").getChildren("association")) {
                    CppFile.write("#include \""+association.getAttributeValue("classArrivee")+".cpp\"\n");
                    
                }
                CppFile.write("using namespace std;\n");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     }
    private boolean printExtendIfWeHaveIt(Element monClass, FileWriter CppFile) {
        String superClass = monClass.getAttributeValue("superClass");
        try{
            if(superClass == null){
                return false;
            }
            if(!superClass.equals("")){
                CppFile.write(": public "+ capitalize(superClass));
            }
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    } 
    private void printAttributesDeClass(Element monClass, FileWriter CppFile) {
        List<Element> listDesAtributtes = monClass.getChildren("attributes").get(0).getChildren("attribute");
        for (int i = 0; i < listDesAtributtes.size(); i++) {
            Element monAtributte = (Element) listDesAtributtes.get(i);
            String name = monAtributte.getAttributeValue("name");
            String type = monAtributte.getAttributeValue("type");
            String value  = monAtributte.getAttributeValue("value");
            try{
                if(type.equals("boolean")){
                    type = "bool";
                }
                if(!value.equals("")){
                    if(type.equals("String")){
                        CppFile.write("\t\t"+type+" "+name+" = \""+value+"\";"+"\n"+"\n");
                        
                    }else if(type.equals("char")){
                        CppFile.write("\t\t"+type+" "+name+" = '"+value+"';"+"\n"+"\n");
                    }else{
                        CppFile.write("\t\t"+type+" "+name+" = "+value+";"+"\n"+"\n");
                    }
                }else{
                    CppFile.write("\t\t"+type+" "+name+";"+"\n"+"\n");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }
    }
    private void printGettersAndSetters(Element monClass, FileWriter CppFile) { 
        List<Element> listDesAtributtes = monClass.getChildren("attributes").get(0).getChildren("attribute");
        
        for (int i = 0; i < listDesAtributtes.size(); i++) {
            Element monAtributte = (Element) listDesAtributtes.get(i);
            String name = monAtributte.getAttributeValue("name");
            String type = monAtributte.getAttributeValue("type");
            try{
                if(type.equals("boolean")){
                    type = "bool";
                }
                CppFile.write("\t"+type+" get"+capitalize(name)+"()"+"{"+"\n");
                CppFile.write("\t"+"\t"+"return "+name+";"+"\n");
                CppFile.write("\t"+"}"+"\n");
                CppFile.write("\t"+"void set"+capitalize(name)+"("+type+" My"+name+"){"+"\n");
                CppFile.write("\t"+"\t"+name+" = My"+name+";"+"\n");
                CppFile.write("\t"+"}"+"\n");
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }
    }
    private void printConstructorDeClass(Element monClass, FileWriter CppFile) {
        printLeNomEtLesParametresDeConstructeur(monClass, CppFile);
        printSuperInConstructor(monClass, CppFile);
        printContenueDeConstructeur(monClass, CppFile);
        try{
        CppFile.write("\t"+"}"+"\n");
        }catch(Exception e){
         System.out.println(e.getMessage());
        }
    }
    private void printLesVariableDautreClasses(Element monClass, FileWriter CppFile) {
        List<Element> listDesAssociation = monClass.getChildren("associations").get(0).getChildren("association");
        String classDArrivee,multiplicity;
        if(listDesAssociation.size() == 0){
            return;
        }
        for (Element association : listDesAssociation) {
            classDArrivee = association.getAttributeValue("classArrivee");
            multiplicity = association.getAttributeValue("multiplicity");
            
            if(multiplicity.equals("1")){
                try{
                    CppFile.write("\t\t"+capitalize(classDArrivee)+" "+classDArrivee.toLowerCase()+";"+"\n");
                }catch(Exception e){
                    System.out.println(e.getMessage());
    
                }
            }else{
                try{
                    CppFile.write("\t\tlist<"+capitalize(classDArrivee)+"> "+classDArrivee.toLowerCase()+"s;"+"\n");
                }catch(Exception e){
                    System.out.println(e.getMessage());

                }
            }
        }
    }
    
    private void printMethodesDeClass(Element monClass, FileWriter CppFile) {
        List<Element> listDesMethodes = monClass.getChildren("methodes").get(0).getChildren("methode");
        for (int i = 0; i < listDesMethodes.size(); i++) {
            Element maMethode = (Element) listDesMethodes.get(i);
            String name = maMethode.getAttributeValue("name");
            String type = maMethode.getAttributeValue("return");
            try{
                if(type.equals("boolean")){
                    type = "bool";
                }
                CppFile.write("\t"+type+" "+name+"(");

                printLesParametres(maMethode, CppFile);
                
                CppFile.write(")"+"{"+"\n");
                CppFile.write("\t"+"\t"+"//Ecrit ici"+"\n"+"\n");
                CppFile.write("\t"+"}"+"\n");
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }
    }

   private void printLesParametres(Element maMethode, FileWriter CppFile) {
    List<Element> listDesParametres = maMethode.getChildren("param");
    for (int i = 0; i < listDesParametres.size(); i++) {
        Element monParametre = (Element) listDesParametres.get(i);
        String name = monParametre.getAttributeValue("name");
        String type = monParametre.getAttributeValue("type");
        try{
            if(type.equals("boolean")){
                type = "bool";
            }
            CppFile.write(type+" "+name);
            if(i != listDesParametres.size()-1){
                CppFile.write(",");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }

    }
    //composant du constructeur 
    private void printLeNomEtLesParametresDeConstructeur(Element monClass, FileWriter CppFile) {
        try{
            CppFile.write("\t\t"+capitalize(monClass.getAttributeValue("name"))+"(");
            printLesVariablesDeSuperClass(monClass, CppFile, true);
            CppFile.write(")"+"{"+"\n");
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }
    
    private void printContenueDeConstructeur(Element monClass, FileWriter CppFile) {
        List<Element> listDesAssociation = monClass.getChildren("associations").get(0).getChildren("association");
        String associationType,classDArrivee,multiplicity;
        try{
            if(listDesAssociation.size() == 0){
                return;
            }
            for (Element association : listDesAssociation) {
                associationType = association.getAttributeValue("type");
                classDArrivee = association.getAttributeValue("classArrivee");
                multiplicity = association.getAttributeValue("multiplicity");
                if(!associationType.equals("composition")){
                    if(multiplicity.equals("1")){
                        CppFile.write("\t"+"\t"+"this->"+classDArrivee.toLowerCase()+" = "+classDArrivee.toLowerCase()+";"+"\n");
                    }else{
                        CppFile.write("\t"+"\t"+"this->"+classDArrivee.toLowerCase()+"s = "+classDArrivee.toLowerCase()+"s;"+"\n");
                    }
                }else{
                    if(multiplicity.equals("1")){
                        CppFile.write("\t"+"\t"+"this->"+classDArrivee.toLowerCase()+" = new "+capitalize(classDArrivee)+"();"+"\n");
                    }else{
                        CppFile.write("\t"+"\t"+"this->"+classDArrivee.toLowerCase()+"s = new list<"+capitalize(classDArrivee)+">();"+"\n");
                        
                    }
                }
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }
    
    private void printSuperInConstructor(Element monClass, FileWriter CppFile) {
        String superClass = monClass.getAttributeValue("superClass"),className= monClass.getAttributeValue("name");
        Element monSuperClass ;
        try{
            if(superClass != null){
                CppFile.write("\t\t"+capitalize(superClass)+"::"+capitalize(className)+"(");
                for (Element classParent : monClass.getParentElement().getChildren("class")) {
                    if (classParent.getAttributeValue("name").equals(superClass)){
                        monSuperClass = classParent;
                        printLesVariablesDeSuperClass(monSuperClass, CppFile,false);
                        break;
                    }
                    
                }
                CppFile.write(");"+"\n");
               

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
   
    private void printLesVariablesDeSuperClass(Element monClass, FileWriter CppFile, boolean withType) {
        String superClass = monClass.getAttributeValue("superClass");
        Element monSuperClass ;

        try{
            //check there is a super class
            if(superClass != null){
                //get the super class
                for (Element classParent : monClass.getParentElement().getChildren("class")) {
                    if (classParent.getAttributeValue("name").equals(superClass)){
                        monSuperClass = classParent;
                        printLesVariablesDeSuperClass(monSuperClass, CppFile,withType);
                        break;
                    }
                }
            }else{
                //print the variables of the class
                List<Element> listDesAssociation = monClass.getChildren("associations").get(0).getChildren("association");
                String associationType,classDArrivee,multiplicity;
                for (Element association : listDesAssociation) {
                    associationType = association.getAttributeValue("type");
                    classDArrivee = association.getAttributeValue("classArrivee");
                    multiplicity = association.getAttributeValue("multiplicity");
                    if(!associationType.equals("composition")){
                        //print the variable with type in the Constructor
                        if(withType){
                        
                            if(multiplicity.equals("1")){
                                CppFile.write(capitalize(classDArrivee)+" "+classDArrivee.toLowerCase()+",");
                            }else{
                                CppFile.write("list<"+capitalize(classDArrivee)+"> "+classDArrivee.toLowerCase()+"s,");
                            }
                        }else{//print the variable without type in the Super
                            if(multiplicity.equals("1")){
                                CppFile.write(classDArrivee.toLowerCase()+",");
                            }else{
                                CppFile.write(classDArrivee.toLowerCase()+"s,");
                            }
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
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
