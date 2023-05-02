package Panels;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DispalyPanel extends JPanel{
    public DispalyPanel() {
        initComponents();
    }
    public JTextArea getTextArea() {
        return textArea;
    }
    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        textArea = new JTextArea();

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setFont(new java.awt.Font("Monospaced", 1, 20));
        jScrollPane1.setViewportView(textArea);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE))
        );
        
    }
     // Variables declaration - do not modify                     
     private JScrollPane jScrollPane1;
     private JTextArea textArea;
     // End of variables declaration      
}
