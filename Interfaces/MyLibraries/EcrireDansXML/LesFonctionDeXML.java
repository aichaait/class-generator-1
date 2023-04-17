package MyLibraries.EcrireDansXML;

import java.io.File;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;;

public class LesFonctionDeXML {

    //function to create an folder if it doesn't exist
    public void createFolder(String folderName){
        File folder = new File(folderName);
        if(!folder.exists()){
            folder.mkdir();
        }
    }

    public org.jdom2.output.XMLOutputter creerUnFichierXML(){
        Element root = new Element("classes");
        Document doc = new Document(root);
        try{
            org.jdom2.output.XMLOutputter sortie = new org.jdom2.output.XMLOutputter( org.jdom2.output.Format.getPrettyFormat());
            sortie.output(doc, new java.io.FileOutputStream("classes.xml"));
            return sortie;
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
            monAttribute.setAttribute("name", nom);
            monAttribute.setAttribute("type", type);
            if(valeur != null) {
                monAttribute.setAttribute("value", valeur);
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
            Element monMethod = new Element("methode");
            monMethod.setAttribute("name", nom);
            monMethod.setAttribute("return", typeDeRetoure);
            monClass.getChild("methodes").addContent(monMethod);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean ajouterUnParametreDeMethode(String nom ,String type,Element maMethode){
        try {
            Element monParametre = new Element("parametre");
            monParametre.setAttribute("name", nom);
            monParametre.setAttribute("type", type);
            maMethode.addContent(monParametre);    
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    public boolean ajouterUnAssociation(String classDarrivee ,String type,String multiplicity,String role,Element monClass){
        try {
            Element monAssociation = new Element("association");
            monAssociation.setAttribute("type", type);
            monAssociation.setAttribute("class", classDarrivee);
            monAssociation.setAttribute("role", role);
            monAssociation.setAttribute("multiplicity", multiplicity);
            monClass.getChild("associations").addContent(monAssociation);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
    

}
    
