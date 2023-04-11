package MyLibraries.Convertion;

public class Testing {
    public static void main(String[] args) {
    String path  = "MyLibraries/Convertion/db_design.xml";
    WriteXmlToJava wjtx = new WriteXmlToJava();
    WriteXmlToSql wxts = new WriteXmlToSql();
    wjtx.ConvertFromJava2XML(path);
    wxts.ConvertFromXML2Sql(path);
}
}
