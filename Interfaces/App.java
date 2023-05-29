import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.TreePath;

import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import Panels.Associations;
import Panels.Attributes;
import Panels.CardPanels;
import Panels.DispalyPanel;
import Panels.LesNomsDesClasses;
import Panels.Methodes;
import Panels.ParametresDesMethodes;
import Panels.StartPage;
import Panels.nombreDesClass;
import Pieces.FolderPanel;
import Pieces.Footer;
import Pieces.Header;
import Pieces.MenuBar;
import Pieces.MyButton;
import MyLibraries.EcrireDansXML.*;
import MyLibraries.Convertion.*;

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
    private String GlobalprojectPath;
    private WriteXmlToJava writeXmlToJava = new WriteXmlToJava();
    private WriteXmlToSql writeXmlToSql = new WriteXmlToSql();
    private WriteXmlToCpp writeXmlToCpp = new WriteXmlToCpp();

 
    
    public App() {
        initComponents();
    }
 
    private void initComponents() {
        
        try {
            setIconImage(ImageIO.read(new File("Interfaces/images/sprint.png")));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("problem in the logo");

        }
        

        header = new Header();
        header.setPreferredSize(new Dimension(100,100));

        myMenuBar = new MenuBar();
        setJMenuBar(myMenuBar);

        DocType dtype = new DocType("classes", "DG.dtd");
        doc.setDocType(dtype);

        

        cardPanels = new CardPanels();
        cardPanels.setPreferredSize(new Dimension(300,500));

        mySideBar = new FolderPanel();
        mySideBar.setBackground(Color.WHITE);
        mySideBar.setPreferredSize(new Dimension(300,500));


        myFooter = new Footer();
        myFooter.nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed();
            }
        });

        MyButton nomDesClassAddButton = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getAddButton();
        MyButton attributesAddButton = ((Attributes)cardPanels.getComponents()[2]).getAddButton();
        MyButton associationsAddButton = ((Associations)cardPanels.getComponents()[3]).getAddButton();
        MyButton methodesAddButton = ((Methodes)cardPanels.getComponents()[4]).getAddButton();
        MyButton parametresAddButton = ((ParametresDesMethodes)cardPanels.getComponents()[5]).getAddButton();
        JLabel newProjectLabel = ((StartPage)cardPanels.getComponents()[9]).getNewProjectLabel();
        JMenuItem newProjectItem = myMenuBar.getNewProjectItem();
        JLabel openProjectLabel = ((StartPage)cardPanels.getComponents()[9]).getOpenProjectLabel();
        JMenuItem openProjectItem = myMenuBar.getOpenProjectItem();

        JTree fileTree = FolderPanel.getFileTree();



        nomDesClassAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomDeCurrentClass = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getInputNom().getText();
                int nombreDesClasseshere = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getNombreDesClasses();
                if(((LesNomsDesClasses)cardPanels.getComponents()[1]).isValidClassName(nomDeCurrentClass) && nombreDesClasseshere != 0 ){
                    String nomDeSuperClass = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getSuperClassChoix().getSelectedItem().toString();
                    Writer.ajouterUnClass(nomDeCurrentClass,nomDeSuperClass , doc);
                }
               
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
                    ((Associations)cardPanels.getComponents()[3]).getErrorField().setText("Remplir tous les champs");
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
                    errors += "le Nom est obligatoire";
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
                    ((ParametresDesMethodes)cardPanels.getComponents()[5]).getErrorsField().setText(type + " " + nom +" Est Ajouté \n");
                    ((ParametresDesMethodes)cardPanels.getComponents()[5]).getInputNom().setText("");
                    ((ParametresDesMethodes)cardPanels.getComponents()[5]).getChoixDesTypes().setSelectedIndex(0);
                    elementClass = Writer.findClass(nomDeCurrentClass, doc);

                    Writer.ajouterUnParametreDeMethode(nom, type, nomDeCurrentMethode, elementClass);
                }
        
            }
        });
        newProjectLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                newProjectItemActionPerformed();
            }

        });
        newProjectItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newProjectItemActionPerformed();
            }
        });
        openProjectLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                openProjectItemActionPerformed();
            }
            

        });
        openProjectItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openProjectItemActionPerformed();
            }
        });
        fileTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                
                try {
                    // Get the node that was clicked
                    TreePath path = fileTree.getSelectionPath();
                
                    // Create a new path starting from the third element in the original path
                    Object[] newPath = new Object[path.getPathCount() - 2];
                    ((DispalyPanel)cardPanels.getComponents()[10]).getTextArea().setText("");
                    for (int i = 2; i < path.getPathCount(); i++) {
                        newPath[i - 2] = path.getPathComponent(i);
                    }
                    TreePath newTreePath = new TreePath(newPath);
                    String pathString = newTreePath.toString();
                    //java.lang.IllegalArgumentException error
                    if(pathString.equals("[.]")){
                        ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");
                        return;
                    }


                    if (pathString.equals("")) {
                        System.out.println("No path selected");
                        // ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");
                    }

                    // Replace the square brackets and commas with forward slashes
                    pathString = pathString.replace("[", "").replace("]", "").replace(", ", "/");

                    // Print the path string
                    File file = new File(GlobalprojectPath+"/"+pathString);
                    if (file.isDirectory()) {
                        // ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");
                        return;
                    }
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        ((DispalyPanel)cardPanels.getComponents()[10]).getTextArea().append(line + "\n");
                    }
                    reader.close();
                    ((CardLayout)cardPanels.getLayout()).show(cardPanels, "display");
                }catch (java.lang.IllegalArgumentException ex) {
                    // ex.printStackTrace();
                    System.out.println("1");

                    // ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");
                }catch (IOException e) {
                    // TODO Auto-generated catch block
                    System.out.println("2");
                    
                        // ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");

                }catch(java.lang.NegativeArraySizeException ex){
                    System.out.println("3");
                    // ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");
                }
                
               

            }
        });
        
        

        myMenuBar.getHomeMenu().addMenuListener(new MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {

            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {

            }

            
        });
        myMenuBar.getApropoJMenu().addMenuListener(new MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "apropos");
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");
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
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");

            }
        });

        
        add(cardPanels, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);
        add(mySideBar,BorderLayout.WEST);
        add(myFooter,BorderLayout.SOUTH);

        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UML Generator");
        setSize(1200, 750);
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
            System.out.println(GlobalprojectPath+"/DiagrammeDesClasses/DG.xml");
            enregistre(GlobalprojectPath+"/DiagrammeDesClasses/DG.xml");
            Writer.createDTDFile(GlobalprojectPath+"/DiagrammeDesClasses");

            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "welcome");
            myFooter.nextButton.setText("Suivant");
            myFooter.nextButton.setVisible(false);
            currentPage = 1;
            doc.getRootElement().removeChildren("class");
            writeXmlToJava.ConvertFromJava2XML(GlobalprojectPath);
            writeXmlToSql.ConvertFromXML2Sql(GlobalprojectPath);
            writeXmlToCpp.ConvertFromXML2Cpp(GlobalprojectPath);
            FolderPanel.updateFolder(new File(GlobalprojectPath) );


        }
    }


    private void dansLeNombreDesClassesPage(int nombreDesClasses) {
        //get the number of class from the first page
        if(nombreDesClasses == -1){
            ((nombreDesClass)cardPanels.getComponents()[0]).getErrorsField().setText("Il faut donner un nombre puis clicker sur SOUMETTRE");
        }else{
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).setNombreDesClasses(nombreDesClasses);
            //print the number of class in component 2

            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "2");
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).getErrorsField().setText("Le nombre des Classes est " +nombreDesClasses+"\n");
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
            ((Attributes)cardPanels.getComponents()[2]).getTitreDePanel().setText("Les Attributs De la  Classe : "+nomDeCurrentClass);
            //pass to next page
            this.currentPage++;
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "3");
            }catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        else{
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).getErrorsField().setText("Il Reste "+nombreDesClasses+" Classes A Ajouter\n");

        }

    }
    private void dansAttributesPage(){
         //we need to get the attributes of the current class
        try{
            nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(currentClass);
            ((Associations)cardPanels.getComponents()[3]).getTitreDePanel().setText("Les Associations De la Classe :" +nomDeCurrentClass);
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
        ((Methodes)cardPanels.getComponent(4)).getTitreDePanel().setText("Les Méthodes De la Classe : "+nomDeCurrentClass);
        ((CardLayout)cardPanels.getLayout()).show(cardPanels,"5");
        currentPage++;
    }
    private void dansMethodesPage(){
        nombreDesClasses = ((nombreDesClass)cardPanels.getComponents()[0]).getNombreDesClasses();
        int hasParametres = ((Methodes)cardPanels.getComponents()[4]).getHasParametres();
        String nomDeCurrentMethode = ((Methodes)cardPanels.getComponents()[4]).getNomDeCurrentMethode();

        if(hasParametres == 1){//if the methode has parametres we go to parameteres page
            //set the name of the current methode 
            myFooter.nextButton.setText("Veuillez Retourner Aux Méthodes");
            ((ParametresDesMethodes)cardPanels.getComponents()[5]).getTitreDePanel().setText("Parametres De la Methode : "+nomDeCurrentMethode);
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "6");
            currentPage++;
        }else if (hasParametres == 0){
            if(currentClass < nombreDesClasses-1){
                try{
                    

                    nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(++currentClass);
                    ((Attributes)cardPanels.getComponents()[2]).getTitreDePanel().setText("Les Attributs De la Classe : "+nomDeCurrentClass);
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
                myFooter.nextButton.setText("Terminer");
            }
        }else{
            ((Methodes)cardPanels.getComponents()[4]).getErrorsField().setText("Error: hasParametres is not 0 or 1");
        }
    }
    private void dansParametresDesMethodesPage(){
        //were in the parametres page
        //we get back to methodes page
        myFooter.nextButton.setText("Suivant");
        ((CardLayout)cardPanels.getLayout()).show(cardPanels, "5");
        currentPage--;
        ((Methodes)cardPanels.getComponents()[4]).setHasParametres(0);
        ((Methodes)cardPanels.getComponents()[4]).getErrorsField().setText("");
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
    private void newProjectItemActionPerformed() {
        int i=1; 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(((StartPage)cardPanels.getComponents()[9]));
        if (result == JFileChooser.APPROVE_OPTION) {
            String projectPath = fileChooser.getSelectedFile().getAbsolutePath() + File.separator + "project";
            GlobalprojectPath = projectPath;
            File projectFolder = new File(projectPath);
            while(projectFolder.exists()){
                projectPath = fileChooser.getSelectedFile().getAbsolutePath() + File.separator + "project-"+(i++);
                projectFolder = new File(projectPath);
                GlobalprojectPath = projectPath;



            }
            if (!projectFolder.exists()) {
                projectFolder.mkdir();
                File DGFolder = new File(projectPath + File.separator + "DiagrammeDesClasses");
                DGFolder.mkdir();
                File javaFolder = new File(projectPath + File.separator + "javaclasses");
                javaFolder.mkdir();
                File cppFolder = new File(projectPath + File.separator + "cppclasses");
                cppFolder.mkdir();
                File sqlFolder = new File(projectPath + File.separator + "SQLrequetes");
                sqlFolder.mkdir();
                FolderPanel.updateFolder(projectFolder );
                JOptionPane.showMessageDialog(((StartPage)cardPanels.getComponents()[9]), "Dossiers créés avec succès");
                myFooter.nextButton.setVisible(true);
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "1");


            } else {
                JOptionPane.showMessageDialog(((StartPage)cardPanels.getComponents()[9]), "Le dossier de projet existe déjà");
            }
        }
    }
    private void openProjectItemActionPerformed() {
        //choose a directory
        
                JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                chooser.setDialogTitle("choisir un dossier ");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
                int returnValue = chooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    System.out.println("le Dossier sélectionné :" + chooser.getSelectedFile().getPath());
                    FolderPanel.updateFolder(new File(chooser.getSelectedFile().getPath()));
                    GlobalprojectPath = chooser.getSelectedFile().getAbsolutePath();
                }
    
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