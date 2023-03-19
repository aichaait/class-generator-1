package MyLibraries;
import org.jdom2.*;
import java.util.List;
import java.io.FileWriter;


public class WriteXmlToJava {
   public void printClassFromXmlIntoJavaFile(Element monClass){
        try{
            String className = monClass.getAttributeValue("name");
            FileWriter  JavaFile = new FileWriter(capitalize(className)+".java" );

            JavaFile.write("public class "+capitalize(className));
            printExtendIfWeHaveIt(monClass, JavaFile);
        
            JavaFile.write(" {"+"\n");
            printAttributesDeClass(monClass, JavaFile);
            printLesVariableDautreClasses(monClass, JavaFile);
            printConstructorDeClass(monClass, JavaFile);
            printGettersAndSetters(monClass, JavaFile);
            printMethodesDeClass(monClass, JavaFile);
            JavaFile.write("}"+"\n");
            JavaFile.close();
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }




    public void printExtendIfWeHaveIt(Element monClass ,FileWriter JavaFile){
        
        String superClass = monClass.getAttributeValue("superClass");
        if(superClass == null){
            return;
        }
        if(!superClass.equals("")){
            try{
                JavaFile.write(" extends "+ capitalize(superClass));
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }





    public void  printClassesFromXmlIntoJavaFile(List<Element> list){
        try{
            for (int i = 0; i < list.size(); i++) {
                Element monClass = (Element) list.get(i);
                printClassFromXmlIntoJavaFile(monClass);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }





    public void printAttributesDeClass(Element monClass, FileWriter JavaFile){
        List<Element> listDesAtributtes = monClass.getChildren("attributes").get(0).getChildren("attribute");
        for (int i = 0; i < listDesAtributtes.size(); i++) {
            Element monAtributte = (Element) listDesAtributtes.get(i);
            String name = monAtributte.getAttributeValue("name");
            String type = monAtributte.getAttributeValue("type");
            String value  = monAtributte.getAttributeValue("value");
            try{
                if(!value.equals("")){
                    if(!type.equals("String")){
                        JavaFile.write("\t"+"private "+type+" "+name+" = "+value+";"+"\n"+"\n");
                    }else{
                        JavaFile.write("\t"+"private "+type+" "+name+" = \""+value+"\";"+"\n"+"\n");
                    }
                }else{
                    JavaFile.write("\t"+"private "+type+" "+name+";"+"\n"+"\n");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }

    }



    public void printMethodesDeClass(Element monClass, FileWriter JavaFile){
        List<Element> listDesMethodes = monClass.getChildren("methodes").get(0).getChildren("methode");
        for (int i = 0; i < listDesMethodes.size(); i++) {
            Element maMethode = (Element) listDesMethodes.get(i);
            String name = maMethode.getAttributeValue("name");
            String type = maMethode.getAttributeValue("return");
            try{
                JavaFile.write("\t"+"public "+type+" "+name+"(");

                printLesParametres(maMethode, JavaFile);
                
                JavaFile.write(")"+"{"+"\n");
                JavaFile.write("\t"+"\t"+"//Ecrit ici"+"\n"+"\n");
                JavaFile.write("\t"+"}"+"\n");
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }

    }
    public void printLesParametres(Element maMethode, FileWriter JavaFile){
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




    public void printGettersAndSetters(Element monClass, FileWriter JavaFile){
        List<Element> listDesAtributtes = monClass.getChildren("attributes").get(0).getChildren("attribute");
        for (int i = 0; i < listDesAtributtes.size(); i++) {
            Element monAtributte = (Element) listDesAtributtes.get(i);
            String name = monAtributte.getAttributeValue("name");
            String type = monAtributte.getAttributeValue("type");
            try{
                JavaFile.write("\t"+"public "+type+" get"+capitalize(name)+"()"+"{"+"\n");
                JavaFile.write("\t"+"\t"+"return "+"this."+name+";"+"\n");
                JavaFile.write("\t"+"}"+"\n");
                JavaFile.write("\t"+"public void set"+capitalize(name)+"("+type+" "+name+"){"+"\n");
                JavaFile.write("\t"+"\t"+"this."+name+" = "+name+";"+"\n");
                JavaFile.write("\t"+"}"+"\n");
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }

    }

    public void printConstructorDeClass(Element monClass, FileWriter JavaFile){
       printLeNomEtLesParametresDeConstructeur(monClass, JavaFile);
       printContenueDeConstructeur(monClass, JavaFile);

    }

    public void printLeNomEtLesParametresDeConstructeur(Element monClass, FileWriter JavaFile){
        try{
        JavaFile.write("\t"+"public "+capitalize(monClass.getAttributeValue("name"))+"(");
            List<Element> listDesAssociation = monClass.getChildren("associations").get(0).getChildren("association");
            String associationType,classDArrivee,multiplicity;
            for (Element association : listDesAssociation) {
                associationType = association.getAttributeValue("type");
                classDArrivee = association.getAttributeValue("classArrivee");
                multiplicity = association.getAttributeValue("multiplicity");
                if(associationType.equals("compsition")){
                    if(multiplicity.equals("1")){
                        JavaFile.write(classDArrivee+" "+classDArrivee.toLowerCase());
                    }else{
                        JavaFile.write("List<"+classDArrivee+"> "+classDArrivee.toLowerCase()+"s");
                    }
                    if(listDesAssociation.indexOf(association) != listDesAssociation.size()-1){
                        JavaFile.write(",");
                    }
                }
                
            }
            JavaFile.write(")"+"{"+"\n");
        }catch(Exception e){
            System.out.println(e.getMessage());

        }

    }
    public void printContenueDeConstructeur(Element monClass, FileWriter JavaFile){
        List<Element> listDesAssociation = monClass.getChildren("associations").get(0).getChildren("association");
        String associationType,classDArrivee,multiplicity;
        try{
            for (Element association : listDesAssociation) {
                associationType = association.getAttributeValue("type");
                classDArrivee = association.getAttributeValue("classArrivee");
                multiplicity = association.getAttributeValue("multiplicity");
                if(associationType.equals("compsition")){
                    if(multiplicity.equals("1")){
                        JavaFile.write("\t"+"\t"+"this."+classDArrivee.toLowerCase()+" = "+classDArrivee.toLowerCase()+";"+"\n");
                    }else{
                        JavaFile.write("\t"+"\t"+"this."+classDArrivee.toLowerCase()+"s = "+classDArrivee.toLowerCase()+"s;"+"\n");
                    }
                }else if(associationType.equals("aggregation")){
                    if(multiplicity.equals("1")){
                        JavaFile.write("\t"+"\t"+"this."+classDArrivee.toLowerCase()+" = new "+classDArrivee+"();"+"\n");
                    }else{
                        JavaFile.write("\t"+"\t"+"this."+classDArrivee.toLowerCase()+"s = new ArrayList<"+classDArrivee+">();"+"\n");
                        
                    }
                }
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
        

    }
    public void printLesVariableDautreClasses(Element monClass ,FileWriter JavaFile){
        List<Element> listDesAssociation = monClass.getChildren("associations").get(0).getChildren("association");
        String classDArrivee,multiplicity;
        for (Element association : listDesAssociation) {
            classDArrivee = association.getAttributeValue("classArrivee");
            multiplicity = association.getAttributeValue("multiplicity");
            
            if(multiplicity.equals("1")){
                try{
                    JavaFile.write("\t"+"private "+classDArrivee+" "+classDArrivee.toLowerCase()+";"+"\n");
                }catch(Exception e){
                    System.out.println(e.getMessage());
    
                }
            }else{
                try{
                    JavaFile.write("\t"+"private List<"+classDArrivee+"> "+classDArrivee.toLowerCase()+"s;"+"\n");
                }catch(Exception e){
                    System.out.println(e.getMessage());

                }
            }
        }
            
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
