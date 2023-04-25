import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.MenuListener;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import Panels.Associations;
import Panels.Attributes;
import Panels.CardPanels;
import Panels.LesNomsDesClasses;
import Panels.Methodes;
import Panels.ParametresDesMethodes;
import Panels.nombreDesClass;
import Pieces.FolderPanel;
import Pieces.Footer;
import Pieces.Header;
import Pieces.MenuBar;
import Pieces.MyButton;
import MyLibraries.EcrireDansXML.*;

public class App extends JFrame {
    public Document getDoc() {
        return doc;
    }

    private int currentPage = 1;
    private int nombreDesClasses = -1;
    private int currentClass = 0;
    private String nomDeCurrentClass;
    private Element racine = new Element("classes");
    private Document doc = new Document(racine); 
    private LesFonctionDeXML Writer = new LesFonctionDeXML();
    private Element elementClass;
    private String nomDeCurrentMethode;

 
    
    public App() {
        initComponents();
    }
 
    private void initComponents() {

        header = new Header();
        header.setPreferredSize(new Dimension(100,100));

        myMenuBar = new MenuBar();
        setJMenuBar(myMenuBar);

        
        

        cardPanels = new CardPanels();
        cardPanels.setPreferredSize(new Dimension(300,500));

        MyButton nomDesClassAddButton = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getAddButton();
        MyButton attributesAddButton = ((Attributes)cardPanels.getComponents()[2]).getAddButton();
        MyButton associationsAddButton = ((Associations)cardPanels.getComponents()[3]).getAddButton();
        MyButton methodesAddButton = ((Methodes)cardPanels.getComponents()[4]).getAddButton();
        MyButton parametresAddButton = ((ParametresDesMethodes)cardPanels.getComponents()[5]).getAddButton();


        nomDesClassAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomDeCurrentClass = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getInputNom().getText();
                String nomDeSuperClass = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getSuperClassChoix().getSelectedItem().toString();
                Writer.ajouterUnClass(nomDeCurrentClass,nomDeSuperClass , doc);
            }
        });
        attributesAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nom = ((Attributes)cardPanels.getComponents()[2]).getInputNom().getText();
                String type = ((Attributes)cardPanels.getComponents()[2]).getChoixDesTypes().getSelectedItem().toString();
                String valeur = ((Attributes)cardPanels.getComponents()[2]).getInputValeur().getText();
                
                if(nom.equals("") || type.equals("")){
                    ((Attributes)cardPanels.getComponents()[2]).getErrorsField().setText("Veuillez remplir tous les champs");
                }else{
                    elementClass = Writer.findClass(nomDeCurrentClass, doc);
                    Writer.ajouterUnAttributte(nom, type, valeur, elementClass);
                    ((Attributes)cardPanels.getComponents()[2]).getInputNom().setText("");
                    ((Attributes)cardPanels.getComponents()[2]).getInputValeur().setText("");
                    ((Attributes)cardPanels.getComponents()[2]).getChoixDesTypes().setSelectedIndex(0);
                }
        
            }
        });
        associationsAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String type,multiplicy,role,classDarrivee;
                type = ((Associations)cardPanels.getComponents()[3]).getChoixDeType().getSelectedItem().toString();
                multiplicy = ((Associations)cardPanels.getComponents()[3]).getEtoileButton().isSelected() ? "*" : "1";
                role = ((Associations)cardPanels.getComponents()[3]).getInputRole().getText();
                classDarrivee = ((Associations)cardPanels.getComponents()[3]).getChoixDeClassDarrivee().getSelectedItem().toString();

                if(role.equals("")){
                    ((Associations)cardPanels.getComponents()[3]).getErrorField().setText("Remplir touts les champs");
                }else{
                    elementClass = Writer.findClass(nomDeCurrentClass, doc);

                    Writer.ajouterUnAssociation(classDarrivee, type, multiplicy, role, elementClass);
                }
        
            }
        });
        methodesAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                nomDeCurrentMethode = ((Methodes)cardPanels.getComponents()[4]).getInputNom().getText();
                ((Methodes)cardPanels.getComponents()[4]).setNomDeCurrentMethode(nomDeCurrentMethode);
                ((Methodes)cardPanels.getComponents()[4]).setHasParametres(((Methodes)cardPanels.getComponents()[4]).getOuiRadioButton().isSelected() ? 1 : 0);

                String type = ((Methodes)cardPanels.getComponents()[4]).getChoixDesTypes().getSelectedItem().toString();
                String errors = "";
                if(nomDeCurrentMethode.equals("")){
                    errors += "Nom est obligatoire";
                }
                if(errors.equals("")){
                    ((Methodes)cardPanels.getComponents()[4]).getInputNom().setText("");
                    ((Methodes)cardPanels.getComponents()[4]).getChoixDesTypes().setSelectedIndex(0);
                    ((Methodes)cardPanels.getComponents()[4]).getOuiRadioButton().setSelected(false);
                    ((Methodes)cardPanels.getComponents()[4]).getNonRadioButton().setSelected(true);
                    elementClass = Writer.findClass(nomDeCurrentClass, doc);

                    Writer.ajouterUneMethode(nomDeCurrentMethode, type, elementClass);
                }else{
                    ((Methodes)cardPanels.getComponents()[4]).getErrorsField().setText(errors);
                }
        
        

            }
        });
        parametresAddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                nomDeCurrentMethode = ((Methodes)cardPanels.getComponents()[4]).getNomDeCurrentMethode();
                System.out.println("name: "+nomDeCurrentMethode);
                String nom = ((ParametresDesMethodes)cardPanels.getComponents()[5]).getInputNom().getText();
                String type = ((ParametresDesMethodes)cardPanels.getComponents()[5]).getChoixDesTypes().getSelectedItem().toString();
                if (nom.equals("")) {
                    ((ParametresDesMethodes)cardPanels.getComponents()[5]).getErrorsField().setText("Le nom est obligatoire");
                } else {
                    ((ParametresDesMethodes)cardPanels.getComponents()[5]).getErrorsField().setText(type + " " + nom +" Added\n");
                    ((ParametresDesMethodes)cardPanels.getComponents()[5]).getInputNom().setText("");
                    ((ParametresDesMethodes)cardPanels.getComponents()[5]).getChoixDesTypes().setSelectedIndex(0);
                    elementClass = Writer.findClass(nomDeCurrentClass, doc);

                    Writer.ajouterUnParametreDeMethode(nom, type, nomDeCurrentMethode, elementClass);
                }
        
            }
        });

        mySideBar = new FolderPanel();
        mySideBar.setBackground(Color.WHITE);
        mySideBar.setPreferredSize(new Dimension(300,500));


        myFooter = new Footer();
        myFooter.nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed();
            }
        });
        myMenuBar.getApropoJMenu().addMenuListener(new MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "apropos");
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "1");
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        myMenuBar.getHelpJMenu().addMenuListener(new MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "help");
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });

        
        add(cardPanels, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);
        add(mySideBar,BorderLayout.WEST);
        add(myFooter,BorderLayout.SOUTH);

        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UML Generator");
        setSize(1200, 800);
    }
    private void nextButtonActionPerformed(){
        if(currentPage == 1){
            nombreDesClasses = ((nombreDesClass)cardPanels.getComponents()[0]).getNombreDesClasses();
            dansLeNombreDesClassesPage(nombreDesClasses);
        }else if(currentPage == 2){
            nombreDesClasses = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getNombreDesClasses();
            dansLesNomsDesClassesPage(nombreDesClasses);
        }
        else if(currentPage == 3){
            dansAttributesPage();
        }else if (currentPage == 4){

            dansAssociationsPage();
        }
        else if(currentPage == 5){
           dansMethodesPage();
        }else if(currentPage == 6){
            dansParametresDesMethodesPage();
        }
        
        else if(currentPage == -1){
            affiche();
            enregistre("test.xml");

           System.exit(0);               
        }
    }


    private void dansLeNombreDesClassesPage(int nombreDesClasses) {
        //get the number of class from the first page
        if(nombreDesClasses == -1){
            ((nombreDesClass)cardPanels.getComponents()[0]).getErrorsField().setText("Il faut donner un nombre puis clicker sur SUBMIT");
        }else{
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).setNombreDesClasses(nombreDesClasses);
            //print the number of class in component 2

            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "2");
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).getErrorsField().setText("Le nombre est "+nombreDesClasses+"\n");
            this.currentPage++;
        }
       
    }
    private void dansLesNomsDesClassesPage(int nombreDesClasses){

        if(nombreDesClasses == 0){
            //after getting the names of classes, we need to pass them to the methods and parametres page
            //get the names of classes we just entered
            List<String> classes = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass();
            String[] classesArray = new String[classes.size()];
            classesArray = classes.toArray(classesArray);
            //add the names of classes to the types used in Methodes and parameters
            ((Methodes)cardPanels.getComponents()[4]).addToTypes(classesArray);
            ((ParametresDesMethodes)cardPanels.getComponents()[5]).addToTypes(classesArray);
            ((Associations)cardPanels.getComponents()[3]).addToClasses(classesArray);

            //set up the next page
            try{
            nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(currentClass);
            ((Attributes)cardPanels.getComponents()[2]).getTitreDePanel().setText("Attributes De Class : "+nomDeCurrentClass);
            //pass to next page
            this.currentPage++;
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "3");
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        else{
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).getErrorsField().setText("Rester "+nombreDesClasses+" classes pour ajouter\n");

        }

    }
    private void dansAttributesPage(){
         //we need to get the attributes of the current class
        try{
            nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(currentClass);
            ((Associations)cardPanels.getComponents()[3]).getTitreDePanel().setText("Associations De Class : "+nomDeCurrentClass);
            //now we need to show the Associations page for the current class
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "4");
         currentPage++;
        }catch(Exception e){
            ((Attributes)cardPanels.getComponents()[2]).getErrorsField().setText("Error: "+e.getMessage());

        }
         
     
    }

    private void dansAssociationsPage(){
        try{
            nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(currentClass);
        }catch(Exception e){
            ((Attributes)cardPanels.getComponents()[2]).getErrorsField().setText("Error: "+e.getMessage());

        }
        ((Methodes)cardPanels.getComponent(4)).getTitreDePanel().setText("Methodes De Class : "+nomDeCurrentClass);
        ((CardLayout)cardPanels.getLayout()).show(cardPanels,"5");
        currentPage++;
    }
    private void dansMethodesPage(){
        nombreDesClasses = ((nombreDesClass)cardPanels.getComponents()[0]).getNombreDesClasses();
        int hasParametres = ((Methodes)cardPanels.getComponents()[4]).getHasParametres();
        String nomDeCurrentMethode = ((Methodes)cardPanels.getComponents()[4]).getNomDeCurrentMethode();

        if(hasParametres == 1){//if the methode has parametres we go to parameteres page
            //set the name of the current methode 
            myFooter.nextButton.setText("Back to Methodes");
            ((ParametresDesMethodes)cardPanels.getComponents()[5]).getTitreDePanel().setText("Parametres De Methode : "+nomDeCurrentMethode);
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "6");
            currentPage++;
        }else if (hasParametres == 0){
            if(currentClass < nombreDesClasses-1){
                try{
                    

                    nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(++currentClass);
                    ((Attributes)cardPanels.getComponents()[2]).getTitreDePanel().setText("Attributes De Class : "+nomDeCurrentClass);
                    ((CardLayout)cardPanels.getLayout()).show(cardPanels, "3");
                }catch(Exception e){
                    ((Methodes)cardPanels.getComponents()[4]).getErrorsField().setText("Error: "+e.getMessage());
                }
                
                currentPage = 3;
            }else{
                //after we end with all the classes, we need to go back to the first page and reset the count of the
                currentClass = 0;
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "end");
                currentPage = -1;
                myFooter.nextButton.setText("Finish");
            }
        }else{
            ((Methodes)cardPanels.getComponents()[4]).getErrorsField().setText("Error: hasParametres is not 0 or 1");
        }
    }
    private void dansParametresDesMethodesPage(){
        //were in the parametres page
        //we get back to methodes page
        myFooter.nextButton.setText("Next");
        ((CardLayout)cardPanels.getLayout()).show(cardPanels, "5");
        currentPage--;
    }

    public void affiche(){
    try{
        //On utilise ici un affichage classique avec getPrettyFormat()
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(doc, System.out);
    }
    catch (java.io.IOException e){
        System.out.println("Error: "+e.getMessage());
    }
    }
    public void enregistre(String fichier){
        try
            {
                //On utilise ici un affichage classique avec getPrettyFormat()
                XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
                //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
                //avec en argument le nom du fichier pour effectuer la sérialisation.
                sortie.output(doc, new FileOutputStream(fichier));
            }
        catch (java.io.IOException e){}
    }
    
 
    
    public static void main(String args[]) {
        //create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    Header header;
    MenuBar myMenuBar;
    CardPanels cardPanels;
    FolderPanel mySideBar;
    Footer myFooter;
    // End of variables declaration//GEN-END:variables
 
}