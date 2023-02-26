import org.jdom2.*;
import java.util.List;
import java.io.FileWriter;


public class JWrite {
   public void printClassFromXmlIntoJavaFile(Element monClass){
        try{
            String className = monClass.getAttributeValue("name");
            FileWriter  JavaFile = new FileWriter(capitalize(className)+".java",true );

            JavaFile.write("public class "+capitalize(className) +"{"+"\n");
            printAttributesDeClass(monClass, JavaFile);
            printGettersAndSetters(monClass, JavaFile);
            printMethodesDeClass(monClass, JavaFile);
            JavaFile.write("}"+"\n");
            JavaFile.close();
        }catch(Exception e){
            System.out.println(e.getMessage());

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
        List<Element> listDesAtributtes = monClass.getChildren("attribute");
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
        List<Element> listDesMethodes = monClass.getChildren("methode");
        for (int i = 0; i < listDesMethodes.size(); i++) {
            Element maMethode = (Element) listDesMethodes.get(i);
            String name = maMethode.getAttributeValue("name");
            String type = maMethode.getAttributeValue("return");
            try{
                JavaFile.write("\t"+"public "+type+" "+name+"()"+"{"+"\n");
                JavaFile.write("\t"+"\t"+"//Ecrit ici"+"\n"+"\n");
                JavaFile.write("\t"+"}"+"\n");
            }catch(Exception e){
                System.out.println(e.getMessage());

            }
        }

    }
    public void printGettersAndSetters(Element monClass, FileWriter JavaFile){
        List<Element> listDesAtributtes = monClass.getChildren("attribute");
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
