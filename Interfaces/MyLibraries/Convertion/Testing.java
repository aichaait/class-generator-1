package MyLibraries.Convertion;

public class Testing {
    public static void main(String[] args) {
    String path  = "MyLibraries/Convertion/project";
    WriteXmlToJava wjtx = new WriteXmlToJava();
    WriteXmlToSql wxts = new WriteXmlToSql();
    WriteXmlToCpp wxtc = new WriteXmlToCpp();
    wjtx.ConvertFromJava2XML(path);
    wxts.ConvertFromXML2Sql(path);
    wxtc.ConvertFromXML2Cpp(path);
}
}
