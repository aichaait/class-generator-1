import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;

import Panels.CardPanels;
import Panels.LesNomsDesClasses;
import Panels.nombreDesClass;
import Panels.Methodes;
import Pieces.Footer;
import Pieces.Header;
import Pieces.MenuBar;
import Pieces.SideBar;

public class App extends JFrame {
    int currentPage = 1;
    int nombreDesClasses = -1;
 
    
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

        mySideBar = new SideBar();
        mySideBar.setBackground(Color.WHITE);
        mySideBar.setPreferredSize(new Dimension(300,500));


        myFooter = new Footer();
        myFooter.nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(currentPage == 1){
                    nombreDesClasses = ((nombreDesClass)cardPanels.getComponents()[0]).getNombreDesClasses();
                    dansLeNombreDesClassesPage(nombreDesClasses);
                     
                }else if(currentPage == 2){
                    nombreDesClasses = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getNombreDesClasses();
                    dansLesNomsDesClassesPage(nombreDesClasses);
                }
                else if(currentPage == 3){
                }


            }
    });

        
        add(cardPanels, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);
        add(mySideBar,BorderLayout.WEST);
        add(myFooter,BorderLayout.SOUTH);


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UML Generator");
        setSize(1200, 800);
    }

    public void dansLeNombreDesClassesPage(int nombreDesClasses) {
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
    public void dansLesNomsDesClassesPage(int nombreDesClasses){

        if(nombreDesClasses == 0){
            //get the names of classes from the second page
            List<String> classes = ((LesNomsDesClasses)cardPanels.getComponents()[1]).getLesNomDesClass();
            String[] classesArray = new String[classes.size()];
            classesArray = classes.toArray(classesArray);
            //add the names of classes to the types used in Methodes and parameters
            ((Methodes)cardPanels.getComponents()[3]).addToTypes(classesArray);
            //pass to next page
            this.currentPage++;
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "4");
        }
        else{
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).getErrorsField().setText("Rester "+nombreDesClasses+" classes pour ajouter\n");

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
    SideBar mySideBar;
    Footer myFooter;
    // End of variables declaration//GEN-END:variables
 
}