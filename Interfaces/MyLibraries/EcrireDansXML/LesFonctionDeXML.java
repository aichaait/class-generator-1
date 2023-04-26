package MyLibraries.EcrireDansXML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;;

public class LesFonctionDeXML {

    public void createDTDFile(String path) {
        try {
          File file = new File(path+"/DG.dtd");
          if (!file.exists()) {
            file.createNewFile();
          }
      
          FileWriter writer = new FileWriter(file);
          writer.write("<!ELEMENT classes (class+)>");


          writer.write("\n<!ELEMENT class (attributes, methodes,associations)>");
          writer.write("\n<!ATTLIST class name ID #REQUIRED superClass IDREFS #IMPLIED>");
              
          writer.write("\n<!ELEMENT attributes (attribute*)>");
          writer.write("\n<!ELEMENT attribute EMPTY>");
          writer.write("\n<!ATTLIST attribute name CDATA #REQUIRED value CDATA #IMPLIED type CDATA #REQUIRED>");
      
      
          writer.write("\n<!ELEMENT methodes (methode*)>");
          writer.write("\n<!ELEMENT methode (parametres)>");
          writer.write("\n<!ATTLIST methode name CDATA #REQUIRED return CDATA #REQUIRED>");
          writer.write("\n<!ELEMENT parametres (parametre*)>");
          writer.write("\n<!ELEMENT parametre EMPTY>");
          writer.write("\n<!ATTLIST parametre name CDATA #REQUIRED type CDATA #REQUIRED>");
          writer.write("\n<!ELEMENT associations (association*)>");

          writer.write("\n<!ELEMENT association EMPTY>");
          writer.write("\n<!ATTLIST association type (simple | aggregation | composition) #REQUIRED classArrivee IDREF #REQUIRED role CDATA #REQUIRED multiplicity CDATA #REQUIRED>");
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    
    public Element findClass(String name,Document doc){
        try{
            Element root = doc.getRootElement();
            for (Element monClass : root.getChildren("class")) {
                if(name.equals(monClass.getAttributeValue("name"))){
                    return monClass;
                }
                
            }
            return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
    }
    public Element findMethode(String nameDeMethode,Element monClass,Document doc){
        try{
            for (Element maMethode : monClass.getChildren("methodes")) {
                if(nameDeMethode.equals(monClass.getAttributeValue("name"))){
                    return maMethode;
                }
                
            }
            return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }        

    }

    public boolean ajouterUnClass(String nom ,String superClass,Document XMLFile){
        try{
            Element myClass = new Element("class");
            Attribute name =  new Attribute("name", nom);
            myClass.setAttribute(name);
            myClass.addContent(new Element("attributes"));
            myClass.addContent(new Element("methodes"));

            myClass.addContent(new Element("associations"));


            if(!superClass.equals("aucun")){
                Attribute superC =  new Attribute("superClass", superClass);
                myClass.setAttribute(superC);
            }
            XMLFile.getRootElement().addContent(myClass);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean ajouterUnAttributte(String nom ,String type,String valeur,Element monClass){
        try {
            Element monAttribute = new Element("attribute");
            if(type.equals("Entier")){
                type = "int";
            }else if(type.equals("Chaine")){
                type = "String";
            }else if(type.equals("Booleen")){
                type = "boolean";
            }else if(type.equals("Reel")){
                type = "double";
            }else if(type.equals("Charactere")){
                type = "char";
            }
            Attribute typeAttribute = new Attribute("type", type);
            Attribute name = new Attribute("name", nom);
            monAttribute.setAttribute(name);
            monAttribute.setAttribute(typeAttribute);
            if(valeur != null) {
                Attribute value = new Attribute("value", valeur);
                monAttribute.setAttribute(value);
            }
            monClass.getChild("attributes").addContent(monAttribute);
        return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean ajouterUneMethode(String nom ,String typeDeRetoure,Element monClass){
        try {
            Element maMethod = new Element("methode");
            Attribute name = new Attribute("name", nom);
            if(typeDeRetoure.equals("Aucun")){
                typeDeRetoure = "void";
            }
            else if(typeDeRetoure.equals("Entier")){
                typeDeRetoure = "int";
            }else if(typeDeRetoure.equals("Chaine")){
                typeDeRetoure = "String";
            }else if(typeDeRetoure.equals("Booleen")){
                typeDeRetoure = "boolean";
            }else if(typeDeRetoure.equals("Reel")){
                typeDeRetoure = "double";
            }else if(typeDeRetoure.equals("Charactere")){
                typeDeRetoure = "char";
            }
            Attribute typeAttribute = new Attribute("return", typeDeRetoure);
            maMethod.addContent(new Element("parametres"));

            maMethod.setAttribute(name);
            maMethod.setAttribute(typeAttribute);
            monClass.getChild("methodes").addContent(maMethod);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean ajouterUnParametreDeMethode(String nom ,String type,String nomDeMethode,Element monClass){
        try {
            Element monParametre = new Element("parametre");
            Attribute name = new Attribute("name", nom);
            if(type.equals("Entier")){
                type = "int";
            }else if(type.equals("Chaine")){
                type = "String";
            }else if(type.equals("Booleen")){
                type = "boolean";
            }else if(type.equals("Reel")){
                type = "double";
            }else if(type.equals("Charactere")){
                type = "char";
            }
            Attribute typeAttribute = new Attribute("type", type);

            monParametre.setAttribute(name);
            monParametre.setAttribute(typeAttribute);
            for (Element maMethode : monClass.getChild("methodes").getChildren("methode")) {
                if(nomDeMethode.equals(maMethode.getAttributeValue("name"))){
                    maMethode.getChild("parametres").addContent(monParametre);
                }
                
            }
                
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean ajouterUnAssociation(String classDarrivee ,String type,String multiplicity,String role,Element monClass){
        try {
            Element monAssociation = new Element("association");
            Attribute attType = new Attribute("type", type);
            Attribute attClassDarrivee = new Attribute("classArrivee", classDarrivee);
            Attribute attRole = new Attribute("role", role);
            Attribute attMultiplicity = new Attribute("multiplicity", multiplicity);
            monAssociation.setAttribute(attType);
            monAssociation.setAttribute(attClassDarrivee);
            monAssociation.setAttribute(attMultiplicity);
            monAssociation.setAttribute(attRole);
            monClass.getChild("associations").addContent(monAssociation);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    

}
    
