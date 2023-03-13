package testing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
public class Interface
{
 //Nous allons commencer notre arborescence en créant la racine XML
 //qui sera ici "personnes".
 static Element racine = new Element("xml");
 //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
 static org.jdom2.Document document = new Document(racine);
  
 public static void main(String[] args)
 {
    //swing
   
    JFrame frame = new JFrame("Testing");
        // 3 labels with different text 2 text areas and 1 check box
        JLabel label1 = new JLabel("Name");
        JLabel label2 = new JLabel("value");
        JLabel label3 = new JLabel("Type");
        JTextField text1 = new JTextField();
        JTextField text2 = new JTextField();
        String[] options =  {"int", "float", "double", "char", "String"};
        JComboBox combo = new JComboBox(options);
        JButton submitButton = new JButton("Submit");
        //JCheckBox check = new JCheckBox("I agree to the terms and conditions");
        // set bounds of labels
        label1.setBounds(50, 50, 100, 30);
        label2.setBounds(50, 100, 100, 30);
        label3.setBounds(50, 150, 100, 30);

        // set bounds of text fields
        text1.setBounds(150, 50, 200, 30);
        text2.setBounds(150, 100, 200, 30);
        // set bounds of check box
        //check.setBounds(50, 200, 300, 30);
        submitButton.setBounds(50, 200, 300, 30);
        combo.setBounds(150, 150, 200, 30);
        // add labels, text fields and check box to frame
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(text1);
        frame.add(text2);
        //frame.add(check);
        frame.add(submitButton);
        frame.add(combo);

        // set frame properties

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);

       
        
        
        //enregister les infos dans des variables 
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Use the name variable in your application logic
                
                //On crée un nouvel Element etudiant et on l'ajoute
                //en tant qu'Element de racine
                Element etudiant = new Element("class");
                racine.addContent(etudiant);
                //On crée un nouvel Attribut classe et on l'ajoute à etudiant
                //grâce à la méthode setAttribute
                Attribute name = new Attribute(text1.getText(),text2.getText());
                etudiant.setAttribute(name);
                Attribute supperClasse = new Attribute("superClassse","");
                etudiant.setAttribute(supperClasse);
                Attribute Relation = new Attribute("Relation","");
                etudiant.setAttribute(Relation);
                //On crée un nouvel Element nom, on lui assigne du texte
                //et on l'ajoute en tant qu'Element de etudiant
                Element atr1 = new Element("attribute");
                Attribute nameatr1 = new Attribute(text1.getText(),text2.getText());
                atr1.setAttribute(nameatr1);
                Attribute nameatr2 = new Attribute("value","1");
                atr1.setAttribute(nameatr2);
                Attribute nameatr3 = new Attribute("type","int");
                atr1.setAttribute(nameatr3);
                etudiant.addContent(atr1);

                Element atr2 = new Element("attribute");
                Attribute nameatr21 = new Attribute("name","attribute2");
                atr2.setAttribute(nameatr21);
                Attribute nameatr22 = new Attribute("value","mohamed");
                atr2.setAttribute(nameatr22);
                Attribute nameatr23 = new Attribute("type","string");
                atr2.setAttribute(nameatr23);
                etudiant.addContent(atr2);

                Element atr3 = new Element("attribute");
                Attribute nameatr31 = new Attribute("name","attribute3");
                atr3.setAttribute(nameatr31);
                Attribute nameatr32 = new Attribute("value","1.0");
                atr3.setAttribute(nameatr32);
                Attribute nameatr33 = new Attribute("type","float");
                atr3.setAttribute(nameatr33);
                etudiant.addContent(atr3);

                Element method1 = new Element("methode");
                Attribute namemeth1 = new Attribute("name","methode1");
                method1.setAttribute(namemeth1);
                Attribute namemeth2 = new Attribute("return","int");
                method1.setAttribute(namemeth2);
                etudiant.addContent(method1);

                Element method2 = new Element("methode");
                Attribute namemeth21 = new Attribute("name","methode2");
                method2.setAttribute(namemeth21);
                Attribute namemeth22 = new Attribute("return","string");
                method2.setAttribute(namemeth22);
                etudiant.addContent(method2);

                Element method3 = new Element("methode");
                Attribute namemeth31 = new Attribute("name","methode1");
                method3.setAttribute(namemeth31);
                Attribute namemeth32 = new Attribute("return","float");
                method3.setAttribute(namemeth32);
                etudiant.addContent(method3);





  
        
    



                    //Les deux méthodes qui suivent seront définies plus loin dans l'article
                    affiche();
                    enregistre("Exercice1.xml");

            }
        });
    }
 //Ajouter ces deux méthodes à notre classe JDOM1
static void affiche()
{
 try
 {
 //On utilise ici un affichage classique avec getPrettyFormat()
 XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
 sortie.output(document, System.out);
 }
 catch (java.io.IOException e){}
}
static void enregistre(String fichier)
{
 try
 {
 //On utilise ici un affichage classique avec getPrettyFormat()
 XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
 //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
 //avec en argument le nom du fichier pour effectuer la sérialisation.
 sortie.output(document, new FileOutputStream(fichier));
 }
 catch (java.io.IOException e){}
}

}