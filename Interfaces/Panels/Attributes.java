
package Panels;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Pieces.GTextField;
import Pieces.MyButton;

public class Attributes extends JPanel {

    private String nomDeCurrentClass;

   
    public String getNomDeCurrentClass() {
        return nomDeCurrentClass;
    }



    public void setNomDeCurrentClass(String nomDeCurrentClass) {
        this.nomDeCurrentClass = nomDeCurrentClass;
    }



    public JLabel getTitreDePanel() {
        return titreDePanel;
    }



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
        inputNom = new GTextField(25);
        inputValeur = new GTextField(25);
        choixDesTypes = new JComboBox<>();
        addButton = new MyButton("Add");
        jScrollPane1 = new JScrollPane();
        errorsField = new JTextArea();
        listDesTypesAttributes = new String[] { "Entier", "Reel", "Chaine", "Charactere", "Booleen" };

        titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        titreDePanel.setText("Attributes De Class: "+nomDeCurrentClass);

        nomLabel.setText("Nom");
        nomLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N


        typeLabel.setText("Type");
        typeLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

        valeurLabel.setText("Valeur");
        valeurLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

        inputNom.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        
        inputValeur.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        



        choixDesTypes.setModel(new DefaultComboBoxModel<>(listDesTypesAttributes));
        choixDesTypes.setBackground(Color.white);
        choixDesTypes.setForeground(Color.BLACK);
        choixDesTypes.setFont(new java.awt.Font("Liberation Sans", 0, 18));

        errorsField.setEditable(false);
        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBackground(new Color(242,242,242));
        errorsField.setForeground(Color.red);
        errorsField.setFont(new java.awt.Font("Liberation Sans", 0, 18));
        jScrollPane1.setViewportView(errorsField);

        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titreDePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(valeurLabel)
                        .addGap(255, 255, 255))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(choixDesTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(128, 128, 128)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(268, 268, 268))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(titreDePanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(nomLabel)
                .addGap(18, 18, 18)
                .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(typeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(choixDesTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valeurLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputValeur, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(addButton)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }        
    private void addButtonActionPerformed() {
        String nom = inputNom.getText();
        String type = choixDesTypes.getSelectedItem().toString();
        String valeur = inputValeur.getText();
        if(nom.equals("") || type.equals("")){
            errorsField.setText("Veuillez remplir tous les champs");
        }else{
            if(valeur.equals("")){
                errorsField.setText(type + " " + nom + "; Added");
            }else{
                errorsField.setText(type + " " + nom + " = " + valeur + "; Added");
            }
            inputNom.setText("");
            inputValeur.setText("");
            choixDesTypes.setSelectedIndex(0);
        }
    }
                          

                                           


    // Variables declaration - do not modify                     
    private MyButton addButton;
    private JComboBox<String> choixDesTypes;
    private JLabel titreDePanel;
    private JLabel nomLabel;
    private JLabel typeLabel;
    private JLabel valeurLabel;
    private JScrollPane jScrollPane1;
    private JTextArea errorsField;
    private GTextField inputNom;
    private GTextField inputValeur;
    private String [] listDesTypesAttributes;
    // End of variables declaration                   
}
