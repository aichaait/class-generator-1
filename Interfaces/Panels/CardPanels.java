package Panels;

import java.awt.CardLayout;

import javax.swing.JPanel;


public class CardPanels extends JPanel {
    //variables declaration
    private Attributes attributesPage;
    private Methodes methodesPage;
    private nombreDesClass nombreDeClassPage;

    
    //end of variables declaration


    public CardPanels() {
        initComponents();
    }
    private void initComponents() {

        attributesPage = new Attributes();
        methodesPage = new Methodes();
        nombreDeClassPage = new nombreDesClass();
        setLayout(new CardLayout());

        


        add(nombreDeClassPage, "nombre de class");
        add(attributesPage, "attributes");
        add(methodesPage , "methodes");

        ((CardLayout) getLayout()).show(this, "nombre de class");

    }
}
