package Pieces;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
  
    public MenuBar() {
        initComponents();
    }

    private void initComponents() {
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

        ImageIcon exitIcon = new ImageIcon(getClass().getResource("../images/exit.png"));
        JMenuItem exitItem = new JMenuItem("Exit", exitIcon);
        fileMenu.add(exitItem);

        ImageIcon saveIcon = new ImageIcon(getClass().getResource("../images/save.png"));
        JMenuItem saveItem = new JMenuItem("Save", saveIcon);
        fileMenu.add(saveItem);

        add(fileMenu);
        add(new JMenu(" Apropos "));
        add(new JMenu(" Help "));
    }
}