package Panels;

import java.awt.CardLayout;

import javax.swing.JPanel;


public class CardPanels extends JPanel {
    //variables declaration
    private Attributes attributesPage;
    private Methodes methodesPage;
    private nombreDesClass nombreDeClassPage;
    private LesNomsDesClasses nomsDesClassesPage;
    private ParametresDesMethodes parametresDesMethodesPage;
    private Associations associationsPage;
    private End endPage;
    private Apropos aproposPage;
    private Help helpPage;
    private StartPage start;

    
    //end of variables declaration


    public CardPanels() {
        initComponents();
    }
    private void initComponents() {

        attributesPage = new Attributes();
        methodesPage = new Methodes();
        nombreDeClassPage = new nombreDesClass();
        nomsDesClassesPage = new LesNomsDesClasses();
        parametresDesMethodesPage = new ParametresDesMethodes();
        associationsPage = new Associations();
        endPage = new End();
        aproposPage = new Apropos();
        helpPage = new Help();
        start = new StartPage();

        setLayout(new CardLayout());

        


        add(nombreDeClassPage, "1");
        add(nomsDesClassesPage,"2");
        add(attributesPage, "3");
        add(associationsPage,"4");
        add(methodesPage , "5");
        add(parametresDesMethodesPage, "6");

        
        add(endPage, "end");
        add(aproposPage, "apropos");
        add(helpPage, "help");
        add(start,"welcome");
        ((CardLayout) getLayout()).show(this, "welcome");
        

    }
}
