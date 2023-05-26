package Pieces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;



public class MenuBar extends JMenuBar {
    List<String> data = new ArrayList<String>();
    public JFileChooser fileChooser;
    JMenu apropoJMenu =  new JMenu(" Apropos ");
    JMenu helpJMenu =  new JMenu(" Aider ");
    JMenu fileMenu = new JMenu(" Fichier");
    JMenu homeMenu = new JMenu("home");
    JMenuItem newProjectItem;
    JMenuItem openProjectItem;

    

    public JMenuItem getOpenProjectItem() {
        return openProjectItem;
    }

    public JMenuItem getNewProjectItem() {
        return newProjectItem;
    }

    public JMenu getApropoJMenu() {
        return apropoJMenu;
    }

    public JMenu getHelpJMenu() {
        return helpJMenu;
    }

    public MenuBar() {
        initComponents();
    }

    private void initComponents() {


         // Create a file chooser
         fileChooser = new JFileChooser();
         fileChooser.setFileFilter(new FileNameExtensionFilter("XML Files", "xml"));


        ImageIcon folderIcon = new ImageIcon(getClass().getResource("../images/folder.png"));
        newProjectItem = new JMenuItem("Nouveau projet ", folderIcon);
        fileMenu.add(newProjectItem);

        ImageIcon openProjectIcon = new ImageIcon(getClass().getResource("../images/open.png"));
        openProjectItem = new JMenuItem("Ouvrir un projet ", openProjectIcon);
        fileMenu.add(openProjectItem);
        

        ImageIcon exitIcon = new ImageIcon(getClass().getResource("../images/exit.png"));
        JMenuItem exitItem = new JMenuItem("Quitter", exitIcon);
        fileMenu.add(exitItem);
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                	
		if(evt.getSource()==exitItem) {
            System.exit(0);
        }}});

        
        

        add(homeMenu);
        add(fileMenu);
        add(apropoJMenu);
        add(helpJMenu);
    }

    public JMenu getHomeMenu() {
        return homeMenu;
    }
    
}