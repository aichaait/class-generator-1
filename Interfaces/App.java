import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import Panels.Attributes;
import Panels.CardPanels;
import Panels.LesNomsDesClasses;
import Panels.Methodes;
import Panels.nombreDesClass;
import Pieces.Footer;
import Pieces.Header;
import Pieces.MenuBar;
import Pieces.FilePanel;

public class App extends JFrame {
    int currentPage = 1;
 
    
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

        mySideBar = new FilePanel();
        mySideBar.setBackground(Color.WHITE);
        mySideBar.setPreferredSize(new Dimension(300,500));


        myFooter = new Footer();
        myFooter.nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(currentPage == 1){
                    toLesNomsDesClassesPages();
                     
                }else if(currentPage == 2){
                    ((CardLayout)cardPanels.getLayout()).show(cardPanels, "methodes");
                }
                else if(currentPage == 3){
                    ((CardLayout)cardPanels.getLayout()).show(cardPanels, "attributes");
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

    public void toLesNomsDesClassesPages() {
        //get the number of class from the first page
        int nombreDeClass = ((nombreDesClass)cardPanels.getComponents()[0]).getNombreDeClass();
        if(nombreDeClass == -1){
            ((nombreDesClass)cardPanels.getComponents()[0]).getErrorsField().setText("Il faut donner un nombre puis clicker sur SUBMIT");
        }else{
                         
            //print the number of class in component 2
            ((CardLayout)cardPanels.getLayout()).show(cardPanels, "2");
            ((LesNomsDesClasses)cardPanels.getComponents()[1]).getErrorsField().setText("Le nombre est "+nombreDeClass);
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
    FilePanel mySideBar;
    Footer myFooter;
    // End of variables declaration//GEN-END:variables
 
}