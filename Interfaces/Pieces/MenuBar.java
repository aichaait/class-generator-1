package Pieces;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class MenuBar extends JMenuBar {
    List<String> data = new ArrayList<String>();
    public JFileChooser fileChooser;
    public MenuBar() {
        initComponents();
    }

    private void initComponents() {


         // Create a file chooser
         fileChooser = new JFileChooser();
         fileChooser.setFileFilter(new FileNameExtensionFilter("XML Files", "xml"));
        JMenu fileMenu = new JMenu("File  ");

        ImageIcon folderIcon = new ImageIcon(getClass().getResource("../images/folder.png"));
        JMenuItem newProjectItem = new JMenuItem("New project ", folderIcon);
        fileMenu.add(newProjectItem);

        ImageIcon addFileIcon = new ImageIcon(getClass().getResource("../images/add-file1.png"));
        JMenuItem newFileItem = new JMenuItem("New file", addFileIcon);
        fileMenu.add(newFileItem);

        ImageIcon openProjectIcon = new ImageIcon(getClass().getResource("../images/open.png"));
        JMenuItem openProjectItem = new JMenuItem("Open project ", openProjectIcon);
        fileMenu.add(openProjectItem);

        ImageIcon openFileIcon = new ImageIcon(getClass().getResource("../images/file.png"));
        JMenuItem openFileItem = new JMenuItem("Open file ", openFileIcon);
        fileMenu.add(openFileItem);
        openFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                	
		if(evt.getSource()==openFileItem) {
            int returnVal = fileChooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               File file = fileChooser.getSelectedFile();
               data.add(file.getName());
               String[] strArray = new String[data.size()];
               strArray = data.toArray(strArray);

               System.out.print(strArray);
               Pieces.FilePanel.updateFileList(strArray);
               /* 
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }*/
            }

        }}});

        ImageIcon exitIcon = new ImageIcon(getClass().getResource("../images/exit.png"));
        JMenuItem exitItem = new JMenuItem("Exit", exitIcon);
        fileMenu.add(exitItem);
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                	
		if(evt.getSource()==exitItem) {
            System.exit(0);
        }}});

        ImageIcon saveIcon = new ImageIcon(getClass().getResource("../images/save.png"));
        JMenuItem saveItem = new JMenuItem("Save", saveIcon);
        fileMenu.add(saveItem);
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                	
		if(evt.getSource()==saveItem) {
            int returnVal = fileChooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               File file = fileChooser.getSelectedFile();
               System.out.print(file.getAbsolutePath());
               data.add(file.getName());
               String[] strArray = new String[data.size()];
               strArray = data.toArray(strArray);

               System.out.print(strArray);
               Pieces.FilePanel.updateFileList(strArray);

            }

        }}});

        add(fileMenu);
        add(new JMenu(" Apropos "));
        add(new JMenu(" Help "));
    }
}