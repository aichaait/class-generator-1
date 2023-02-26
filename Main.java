
import java.io.File;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

import MyLibraries.WriteXmlToJava;

class Main {
    public static void main(String[] args) {
        // read xml file usign jdom

        SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);
        WriteXmlToJava jwrite = new WriteXmlToJava();
        try {

            Document xmlDocument = builder.build(new File("db_design.xml"));
            Element root = xmlDocument.getRootElement();
            

            List<Element> list = root.getChildren("class");

            jwrite.printClassesFromXmlIntoJavaFile(list);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}