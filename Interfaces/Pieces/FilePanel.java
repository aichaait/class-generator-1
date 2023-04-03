package Pieces;



import javax.swing.*;
import java.awt.*;

public class FilePanel extends JPanel {
    private static JList<String> fileList;

    public FilePanel() {
        setLayout(new BorderLayout());

        // Create a JList component to display the list of files
        fileList = new JList<String>();
        

        // Add the JList to a JScrollPane to enable scrolling
        JScrollPane scrollPane = new JScrollPane(fileList);
        add(scrollPane, BorderLayout.CENTER);

        // Set the preferred size of the panel
        setPreferredSize(new Dimension(200, 200));
        setBorder(null);
        
    }

    // Method to update the list of files
    public static void updateFileList(String[] files) {
        fileList.setListData(files);
    }

    

}
    

