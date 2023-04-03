
package Panels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Pieces.MyButton;



public class Methodes extends JPanel {

    
  
    public JTextArea getErrorsField() {
        return errorsField;
    }

    public Methodes() {
        initComponents();
    }
                         
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        titreDePanel = new JLabel();
        nomLabel = new JLabel();
        inputNom = new JTextField();
        choixDesTypes = new JComboBox<>();
        typeDeRetourLabel = new JLabel();
        parametresLabel = new JLabel();
        ouiRadioButton = new JRadioButton();
        nonRadioButton = new JRadioButton();
        addButton = new MyButton("Add");
        jScrollPane1 = new javax.swing.JScrollPane();
        errorsField = new javax.swing.JTextArea();

        titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 30)); // NOI18N
        titreDePanel.setText("Methodes De Class : ");
        titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);


        nomLabel.setText("Nom :");
        
        inputNom.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));


        choixDesTypes.setModel(new DefaultComboBoxModel<>(listDesTypes));
        choixDesTypes.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),1));
        choixDesTypes.setBackground(Color.decode("#F8F8FF"));
        choixDesTypes.setForeground(Color.decode("#4A00E0"));


        typeDeRetourLabel.setText("Type De retour");

        parametresLabel.setText("Methodes avoir les parametres :");

        buttonGroup1.add(ouiRadioButton);
        ouiRadioButton.setText("Oui");
        
        
        nonRadioButton.setForeground(Color.decode("#4A00E0"));
        ouiRadioButton.setForeground(Color.decode("#4A00E0"));
        buttonGroup1.add(nonRadioButton);
        nonRadioButton.setText("Non");

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
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(nomLabel)
                                    .addComponent(typeDeRetourLabel))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputNom, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(choixDesTypes, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(parametresLabel)
                                .addGap(48, 48, 48)
                                .addComponent(ouiRadioButton)
                                .addGap(28, 28, 28)
                                .addComponent(nonRadioButton))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(addButton)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(inputNom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomLabel))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(choixDesTypes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeDeRetourLabel))
                        .addGap(74, 74, 74)
                        .addComponent(parametresLabel))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ouiRadioButton)
                        .addComponent(nonRadioButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(47, 47, 47))
        );
    }                                                         


    // Variables declaration - do not modify                     
    private ButtonGroup buttonGroup1;
    private MyButton addButton;
    private JComboBox<String> choixDesTypes;
    private JLabel titreDePanel;
    private JLabel nomLabel;
    private JLabel typeDeRetourLabel;
    private JLabel parametresLabel;
    private JRadioButton ouiRadioButton;
    private JRadioButton nonRadioButton;
    private JTextField inputNom;
    private String[] listDesTypes = new String[] { "Item 1", "Item 2", "Item 3", "Item 4" };
    private JTextArea errorsField;
    private JScrollPane jScrollPane1;
    // End of variables declaration                   
}
