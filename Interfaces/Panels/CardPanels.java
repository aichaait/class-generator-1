package Panels;

import java.awt.CardLayout;

import javax.swing.JPanel;


public class CardPanels extends JPanel {
    //variables declaration
    private Attributes attributesPage;
    private Methodes methodesPage;

    
    //end of variables declaration


    public CardPanels() {
        initComponents();
    }
    private void initComponents() {

        attributesPage = new Attributes();
        methodesPage = new Methodes();
        setLayout(new CardLayout());

        



        add(attributesPage, "attributes");
        add(methodesPage , "methodes");

        ((CardLayout) getLayout()).show(this, "attributes");

    }
}
