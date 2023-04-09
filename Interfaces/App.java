import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.MenuListener;

import Panels.AssociationsPage;
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

public class App extends JFrame {
    int currentPage = 1;
    int nombreDesClasses = -1;
    int currentClass = 0;
    private String nomDeCurrentClass;
 
    
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
        }else if(currentPage == 4){
           dansMethodesPage();
        }else if(currentPage == 5){
            dansParametresDesMethodesPage();
        }
        else if(currentPage == -1){
           dispose();               
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
            ((Methodes)cardPanels.getComponents()[3]).addToTypes(classesArray);
            ((ParametresDesMethodes)cardPanels.getComponents()[4]).addToTypes(classesArray);
            ((AssociationsPage)cardPanels.getComponents()[5]).addToClasses(classesArray);


            //set up the next page
            nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(currentClass);
            ((Attributes)cardPanels.getComponents()[2]).getTitreDePanel().setText("Attributes De Class : "+nomDeCurrentClass);
            //pass to next page
            this.currentPage++;
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "3");
        }
        else{
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).getErrorsField().setText("Rester "+nombreDesClasses+" classes pour ajouter\n");

        }

    }
    private void dansAttributesPage(){
         //we need to get the attributes of the current class
         nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(currentClass);
         ((Methodes)cardPanels.getComponents()[3]).getTitreDePanel().setText("Methodes De Class : "+nomDeCurrentClass);
         //now we need to show the Methodes page for the current class
         ((CardLayout)cardPanels.getLayout()).show(cardPanels, "4");
         currentPage++;
     
    }
    private void dansMethodesPage(){
        nombreDesClasses = ((nombreDesClass)cardPanels.getComponents()[0]).getNombreDesClasses();
        currentClass++;
        int hasParametres = ((Methodes)cardPanels.getComponents()[3]).getHasParametres();
        if(hasParametres == 1){//if the methode has parametres we go to parameteres page
            //set the name of the current methode 
            myFooter.nextButton.setText("Back to Methodes");
            ((ParametresDesMethodes)cardPanels.getComponents()[4]).getTitreDePanel().setText("Parametres De Methode : "+((Methodes)cardPanels.getComponents()[3]).getNomDeCurrentMethode());
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "5");
            currentPage++;
        }else if (hasParametres == 0){
            if(currentClass < nombreDesClasses){
                nomDeCurrentClass =  ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass().get(currentClass);
                ((Attributes)cardPanels.getComponents()[2]).getTitreDePanel().setText("Attributes De Class : "+nomDeCurrentClass);
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "3");
                currentPage--;
            }else{
                //after we end with all the classes, we need to go back to the first page and reset the count of the
                currentClass = 0;
                ((CardLayout)cardPanels.getLayout()).show(cardPanels, "end");
                currentPage = -1;
                myFooter.nextButton.setText("Finish");
            }
        }else{
            ((Methodes)cardPanels.getComponents()[3]).getErrorsField().setText("Error: hasParametres is not 0 or 1");
        }
    }
    private void dansParametresDesMethodesPage(){
        //were in the parametres page
        //we get back to methodes page
        myFooter.nextButton.setText("Next");
        ((CardLayout)cardPanels.getLayout()).show(cardPanels, "4");
        currentPage--;
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