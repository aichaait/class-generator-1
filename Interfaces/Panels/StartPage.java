package Panels;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;



public class StartPage extends JPanel {

    public StartPage() {
        initComponents();
    }

                           
    public JLabel getNewProjectLabel() {
        return newProjectLabel;
    }


    public JLabel getOpenProjectLabel() {
        return openProjectLabel;
    }


    private void initComponents() {

        ImageIcon folderIcon = new ImageIcon(getClass().getResource("../images/folder.png"));
        ImageIcon openProjectIcon = new ImageIcon(getClass().getResource("../images/open.png"));

        titreDePage = new JLabel();
        sousTitre = new JLabel();
        jLabel3 = new JLabel();
        newProjectLabel = new JLabel(folderIcon);
        openProjectLabel = new JLabel(openProjectIcon);
        //newProjectLabel = new JLabel(folderIcon);
        //openProjectLabel = new JLabel(openProjectIcon);
        
        titreDePage.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titreDePage.setForeground(new java.awt.Color(102, 102, 102));
        titreDePage.setText("WELCOME  TO UML2CODE");

        sousTitre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        sousTitre.setForeground(new java.awt.Color(102, 102, 102));
        sousTitre.setText("Emulateur de code ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Start");
         
        newProjectLabel.setText("New Project");
        newProjectLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newProjectLabel.setForeground(new java.awt.Color(0, 102, 204));
        
       

        openProjectLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        openProjectLabel.setForeground(new java.awt.Color(0, 102, 204));
        openProjectLabel.setText("Open Project");
        

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(titreDePage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sousTitre, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(openProjectLabel)
                                    .addComponent(newProjectLabel))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(titreDePage)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sousTitre)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newProjectLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openProjectLabel)
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

                        


    // Variables declaration - do not modify                     
    private JLabel titreDePage;
    private JLabel sousTitre;
    private JLabel jLabel3;
    private JLabel newProjectLabel;
    private JLabel openProjectLabel;
    // End of variables declaration                   
}