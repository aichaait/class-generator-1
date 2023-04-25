package Panels;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import Pieces.FolderPanel;



public class StartPage extends javax.swing.JPanel {

    public StartPage() {
        initComponents();
    }

                           
    public javax.swing.JLabel getNewProjectLabel() {
        return newProjectLabel;
    }


    public javax.swing.JLabel getOpenProjectLabel() {
        return openProjectLabel;
    }


    private void initComponents() {

        ImageIcon folderIcon = new ImageIcon(getClass().getResource("../images/folder.png"));
        ImageIcon openProjectIcon = new ImageIcon(getClass().getResource("../images/open.png"));

        titreDePage = new javax.swing.JLabel();
        sousTitre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        newProjectLabel = new javax.swing.JLabel(folderIcon);
        openProjectLabel = new javax.swing.JLabel(openProjectIcon);
        //newProjectLabel = new javax.swing.JLabel(folderIcon);
        //openProjectLabel = new javax.swing.JLabel(openProjectIcon);
        
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
        openProjectLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                openProjectItemActionPerformed();
            }

        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(titreDePage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sousTitre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(openProjectLabel)
                                    .addComponent(newProjectLabel))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(titreDePage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sousTitre)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newProjectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openProjectLabel)
                .addContainerGap(125, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void openProjectItemActionPerformed() {
        //choose a directory
        
                JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                chooser.setDialogTitle("Choose a folder");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
                int returnValue = chooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    System.out.println("Selected folder: " + chooser.getSelectedFile().getPath());
                    FolderPanel.updateFolder(new File(chooser.getSelectedFile().getPath()));
                }
    
        }                      


    // Variables declaration - do not modify                     
    private javax.swing.JLabel titreDePage;
    private javax.swing.JLabel sousTitre;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel newProjectLabel;
    private javax.swing.JLabel openProjectLabel;
    // End of variables declaration                   
}