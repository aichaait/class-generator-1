package Panels;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParametresDesMethodes extends JPanel {
        String[] listDesTypesParametres = new String[] { "Entier", "Reel", "Chaine", "Charactere" };
        List<String> listDesTypes = new ArrayList<>(Arrays.asList(listDesTypesParametres));

        String nom,type;

        public String getNom() {
                return nom;
        }

        public String getType() {
                return type;
        }
        public void addType(String myType) {
                listDesTypes.add(myType);
                listDesTypes.toArray(listDesTypesParametres);
        
        }

public ParametresDesMethodes() {
        initComponents();
    }

    private void initComponents() {

        titreDePanel = new JLabel();
        nomLabel = new JLabel();
        inputNom = new JTextField();
        typeLabel = new JLabel();
        addButton = new MyButton("Add");
        jScrollPane1 = new JScrollPane();
        errorsField = new JTextArea();
        choixDesTypes = new JComboBox<>();

        titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 30)); // NOI18N
        titreDePanel.setText("Ajouter Parametres : ");
        titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);

        nomLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        nomLabel.setText("Nom : ");

        inputNom.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));


        typeLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        typeLabel.setText("Type :");

        errorsField.setEditable(false);
        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));
        errorsField.setBackground(new Color(242,242,242));
        jScrollPane1.setViewportView(errorsField);

        choixDesTypes.setModel(new DefaultComboBoxModel<>(listDesTypesParametres));
        choixDesTypes.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),1));
        choixDesTypes.setBackground(Color.decode("#F8F8FF"));
        choixDesTypes.setForeground(Color.decode("#4A00E0"));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                addButtonActionPerformed();
            }
        });


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addGap(115, 115, 115))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 422,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(typeLabel)
                                                        .addComponent(nomLabel))
                                                .addGap(94, 94, 94)
                                                .addGroup(
                                                        layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(inputNom, GroupLayout.DEFAULT_SIZE, 181,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(choixDesTypes, 0, GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 409,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(96, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nomLabel)
                                        .addComponent(inputNom, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(typeLabel)
                                        .addComponent(choixDesTypes, GroupLayout.PREFERRED_SIZE, 35,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)));
    }

    private void addButtonActionPerformed() {
        nom = inputNom.getText();
        type = choixDesTypes.getSelectedItem().toString();
        if (nom.equals("")) {
            errorsField.setText("Le nom est obligatoire");
        } else {
            errorsField.setText("");
            inputNom.setText("");
            choixDesTypes.setSelectedIndex(0);
        }
        
    
    }
    
            
    
    // Variables declaration - do not modify
    private MyButton addButton;
    private JComboBox<String> choixDesTypes;
    private JLabel titreDePanel;
    private JLabel nomLabel;
    private JLabel typeLabel;
    private JScrollPane jScrollPane1;
    private JTextArea errorsField;
    private JTextField inputNom;
    // End of variables declaration
}
