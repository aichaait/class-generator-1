
package Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Pieces.MyButton;

public class LesNomsDesClasses extends JPanel {

    
    public JTextArea getErrorsField() {
        return errorsField;
    }

    public LesNomsDesClasses() {
        initComponents();
    }
                     
    private void initComponents() {

        titreDePanel = new JLabel();
        nomLabel = new JLabel();
        inputNom = new JTextField();
        addButton = new MyButton("Add");
        jScrollPane1 = new JScrollPane();
        errorsField = new JTextArea();

        titreDePanel.setFont(new Font("Liberation Serif", 1, 30)); // NOI18N
        titreDePanel.setText("Les Noms Des Classes");
        titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);


        nomLabel.setFont(new Font("Liberation Sans", 1, 15)); // NOI18N
        nomLabel.setText("donner le nom de class : ");

        inputNom.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));


        

        addButton.setText("Add");

        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));
        errorsField.setBackground(new Color(242,242,242));
        jScrollPane1.setViewportView(errorsField);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(titreDePanel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(nomLabel)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(inputNom, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(titreDePanel)
                .addGap(108, 108, 108)
                .addComponent(nomLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(inputNom, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(addButton)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }                                         


    // Variables declaration - do not modify                     
    private MyButton addButton;
    private JLabel titreDePanel;
    private JLabel nomLabel;
    private JScrollPane jScrollPane1;
    private JTextArea errorsField;
    private JTextField inputNom;
    // End of variables declaration                   
}

