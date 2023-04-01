import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import Panels.CardPanels;
import Panels.Methodes;
import Panels.nombreDesClass;
import Pieces.Footer;
import Pieces.Header;
import Pieces.MenuBar;
import Pieces.SideBar;

public class App extends JFrame {
    int currentPage = 1;
 
    /**
     * Constructs a new App instance.
     */
    public App() {
        initComponents();
    }
 
    /**
     * Initializes the JFrame components.
     */
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
                    //get the number of class from the first page
                    int nombreDeClass = ((nombreDesClass)cardPanels.getComponents()[0]).getNombreDeClass();
                    
                    //print the number of class in component 2
                    ((CardLayout)cardPanels.getLayout()).show(cardPanels, "attributes");
                    ((Methodes)cardPanels.getComponents()[1]).getErroeField().setText("Le nombre est "+nombreDeClass);
                     
                }else if(currentPage == 2){
                    ((CardLayout)cardPanels.getLayout()).show(cardPanels, "methodes");
                
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
 
    /**
     * Launches the App.
     * 
     * @param args not used
     */
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