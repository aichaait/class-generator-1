package Pieces;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

public class FolderPanel extends JPanel {
    private static JTree fileTree;

    public static JTree getFileTree() {
        return fileTree;
    }

    public FolderPanel() {
        setLayout(new BorderLayout());

        // Create a root node for the JTree
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(".");

        // Create a JTree component with the root node
        fileTree = new JTree(rootNode);

        // Add the JTree to a JScrollPane to enable scrolling
        JScrollPane scrollPane = new JScrollPane(fileTree);
        add(scrollPane, BorderLayout.CENTER);

        // Set the preferred size of the panel
        setPreferredSize(new Dimension(200, 200));
        
    }

    // Method to update the JTree with the contents of a folder
    public static void updateFolder(File folder) {
        // Clear the existing tree
        DefaultTreeModel model = (DefaultTreeModel) fileTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();

        // Create a new root node for the JTree with the name of the folder
        DefaultMutableTreeNode folderNode = new DefaultMutableTreeNode(folder.getName());
        root.add(folderNode);

        // Add the files and subfolders to the JTree
        addFilesAndFoldersToTree(folder, folderNode);

        // Expand the root node to show the contents of the folder
        fileTree.expandRow(0);

        // Update the JTree
        model.reload();
    }
    //addDile
    private static void addFilesAndFoldersToTree(File folder, DefaultMutableTreeNode folderNode) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    DefaultMutableTreeNode subfolderNode = new DefaultMutableTreeNode(file.getName());
                    folderNode.add(subfolderNode);
                    addFilesAndFoldersToTree(file, subfolderNode);
                } else {
                    DefaultMutableTreeNode fileNode = new DefaultMutableTreeNode(file.getName());
                    folderNode.add(fileNode);
                }
            }
        }
    }

    // public static void main(String[] args) {
    //     // Create a JFrame to hold the FolderPanel
    //     JFrame frame = new JFrame("FolderPanel");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //     // Create a FolderPanel and add it to the JFrame
    //     FolderPanel folderPanel = new FolderPanel();
    //     frame.getContentPane().add(folderPanel, BorderLayout.CENTER);

    //     // Display the window
    //     frame.pack();
    //     frame.setVisible(true);

    //     // Update the FolderPanel with the contents of the current folder
    //     folderPanel.updateFolder(new File("/home/bssayla/Downloads/class-generator"));
    // }
}
