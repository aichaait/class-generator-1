//package Panels;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaders;

import MyLibraries.Convertion.WriteXmlToJava;
import MyLibraries.Convertion.WriteXmlToSql;

class Main {
    public static void main(String[] args) {
        // read xml file usign jdom

        SAXBuilder builder = new SAXBuilder(XMLReaders.DTDVALIDATING);
        WriteXmlToJava jwrite = new WriteXmlToJava();
        WriteXmlToSql sql = new WriteXmlToSql();
        try {

            Document xmlDocument = builder.build(new File("db_design.xml"));
            Element root = xmlDocument.getRootElement();
            FileWriter SqlFile = new FileWriter("file.SQL");
            

            List<Element> list = root.getChildren("class");

            sql.printTablesFromXmlIntoSqlFile(list,SqlFile);
            sql.printLesVariableDautreTables(list,SqlFile);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}