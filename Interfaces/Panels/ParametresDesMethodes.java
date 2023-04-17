package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Pieces.GTextField;
import Pieces.MyButton;

public class ParametresDesMethodes extends JPanel {
        private String[] listDesTypesParametres = new String[] { "Entier", "Reel", "Chaine", "Charactere" };
        private String nom,type , nomDeCurrentMethode;
        private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(listDesTypesParametres);


        
        public MyButton getAddButton() {
            return addButton;
        }

        public JLabel getTitreDePanel() {
            return titreDePanel;
        }

        public String getNomDeCurrentMethode() {
                return nomDeCurrentMethode;
        }

        public void setNomDeCurrentMethode(String nomDeCurrentMethode) {
                this.nomDeCurrentMethode = nomDeCurrentMethode;
        }

        public String getNom() {
                return nom;
        }

        public String getType() {
                return type;
        }
        public void addToTypes(String[] lesClasses) {
            for (String unClass : lesClasses) {
                model.addElement(unClass);    
            }
        }

public ParametresDesMethodes() {
        initComponents();
    }

    private void initComponents() {

        titreDePanel = new JLabel();
        nomLabel = new JLabel();
        inputNom = new GTextField(25);
        typeLabel = new JLabel();
        addButton = new MyButton("Add");
        jScrollPane1 = new JScrollPane();
        errorsField = new JTextArea();
        choixDesTypes = new JComboBox<>();

        titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        titreDePanel.setText("Ajouter Parametres de : "+nomDeCurrentMethode);

        nomLabel.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        nomLabel.setText("Nom");

        typeLabel.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        typeLabel.setText("Type");

        errorsField.setEditable(false);
        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBackground(new Color(242,242,242));
        errorsField.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        jScrollPane1.setViewportView(errorsField);

        choixDesTypes.setModel(model);
        choixDesTypes.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        choixDesTypes.setBackground(Color.WHITE);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                addButtonActionPerformed();
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(75, 75, 75))
            .addComponent(titreDePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(575, 575, 575)
                        .addComponent(nomLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(575, 575, 575)
                        .addComponent(typeLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputNom, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(choixDesTypes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreDePanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(nomLabel)
                .addGap(18, 18, 18)
                .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(typeLabel)
                .addGap(33, 33, 33)
                .addComponent(choixDesTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    private void addButtonActionPerformed() {
        nom = inputNom.getText();
        type = choixDesTypes.getSelectedItem().toString();
        if (nom.equals("")) {
            errorsField.setText("Le nom est obligatoire");
        } else {
            errorsField.setText(type + " " + nom +" Added\n");
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
    private GTextField inputNom;
    // End of variables declaration
}
