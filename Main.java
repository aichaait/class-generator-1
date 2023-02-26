
import java.io.*;
import org.jdom2.*;
import org.jdom2.input.*;
import java.util.List;



class Main extends JWrite{
    public static void main(String[] args) {
        //read xml file usign jdom

        SAXBuilder file =new SAXBuilder();
        JWrite jwrite = new JWrite();
        try{
            Document doc = file.build(new File("db_design.xml"));
            Element root = doc.getRootElement();
            List<Element> list = root.getChildren("class");


            jwrite.printClassesFromXmlIntoJavaFile(list);
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
        
    }
    
}