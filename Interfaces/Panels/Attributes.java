
package Panels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import Pieces.MyButton;

public class Attributes extends JPanel {

    

   
    public JTextArea getErrorsField() {
        return errorsField;
    }



    public Attributes() {
        initComponents();
    }

    
                   
    private void initComponents() {

        titreDePanel = new JLabel();
        nomLabel = new JLabel();
        typeLabel = new JLabel();
        valeurLabel = new JLabel();
        inputNom = new JTextField();
        inputValeur = new JTextField();
        choixDesTypes = new JComboBox<>();
        addButton = new MyButton("Add");
        jScrollPane1 = new JScrollPane();
        errorsField = new JTextArea();
        listDesTypesAttributes = new String[] { "Item 1", "Item 2", "Item 3", "Item 4" };

        titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 30)); // NOI18N
        titreDePanel.setText("Attributes De Class: ");
        titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);

        nomLabel.setText("Nom :");

        typeLabel.setText("Type :");

        valeurLabel.setText("Valeur :");

        inputNom.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));

        

        inputValeur.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));


        choixDesTypes.setModel(new DefaultComboBoxModel<>(listDesTypesAttributes));
        choixDesTypes.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),1));
        choixDesTypes.setBackground(Color.decode("#F8F8FF"));
        choixDesTypes.setForeground(Color.decode("#4A00E0"));

        errorsField.setEditable(false);
        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));
        errorsField.setBackground(new Color(242,242,242));
        jScrollPane1.setViewportView(errorsField);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(typeLabel)
                                .addGap(87, 87, 87)
                                .addComponent(choixDesTypes, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(nomLabel)
                                    .addComponent(valeurLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(inputValeur, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputNom, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreDePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titreDePanel)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomLabel))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(typeLabel)
                    .addComponent(choixDesTypes, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(valeurLabel, GroupLayout.Alignment.TRAILING)
                    .addComponent(inputValeur, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(addButton)
                .addGap(72, 72, 72))
        );
    }// </editor-fold>                        

                                           


    // Variables declaration - do not modify                     
    private MyButton addButton;
    private JComboBox<String> choixDesTypes;
    private JLabel titreDePanel;
    private JLabel nomLabel;
    private JLabel typeLabel;
    private JLabel valeurLabel;
    private JScrollPane jScrollPane1;
    private JTextArea errorsField;
    private JTextField inputNom;
    private JTextField inputValeur;
    private String [] listDesTypesAttributes;
    // End of variables declaration                   
}
