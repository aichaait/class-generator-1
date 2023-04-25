
package Panels;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Pieces.GTextField;
import Pieces.MyButton;



public class Methodes extends JPanel {
    private String[] listDesTypesDeRetoure = new String[] { "Entier", "Reel", "Chaine", "Charactere" };
    private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(listDesTypesDeRetoure);
    private int hasParametres = 0;
    private String nomDeCurrentClass = "";
    private String nomDeCurrentMethode = "";
    
    

    

    public void setNomDeCurrentMethode(String nomDeCurrentMethode) {
        this.nomDeCurrentMethode = nomDeCurrentMethode;
    }

    public void setHasParametres(int hasParametres) {
        this.hasParametres = hasParametres;
    }
  
    public JComboBox<String> getChoixDesTypes() {
        return choixDesTypes;
    }
    public JRadioButton getOuiRadioButton() {
        return ouiRadioButton;
    }
    public JRadioButton getNonRadioButton() {
        return nonRadioButton;
    }
    public GTextField getInputNom() {
        return inputNom;
    }
    public MyButton getAddButton() {
        return addButton;
    }
    public String getNomDeCurrentMethode() {
        return nomDeCurrentMethode;
    }
    public String getNomDeCurrentClass() {
        return nomDeCurrentClass;
    }
    public void setNomDeCurrentClass(String nomDeCurrentClass) {
        this.nomDeCurrentClass = nomDeCurrentClass;
    }
    public int getHasParametres() {
        return hasParametres;
    }
    public JLabel getTitreDePanel() {
        return titreDePanel;
    }
    public String[] getListDesTypesDeRetoure() {
        return listDesTypesDeRetoure;
    }
    public void setListDesTypesDeRetoure(String[] listDesTypesDeRetoure) {
        this.listDesTypesDeRetoure = listDesTypesDeRetoure;
    }
    public JTextArea getErrorsField() {
        return errorsField;
    }
    
    public void addToTypes(String[] lesClasses) {
        for (String unClass : lesClasses) {
            model.addElement(unClass);    
        }
    }



    public Methodes() {
        initComponents();
    }
                         
    private void initComponents() {

        buttonGroup1 = new ButtonGroup();
        titreDePanel = new JLabel();
        nomLabel = new JLabel();
        inputNom = new GTextField(25);
        choixDesTypes = new JComboBox<>();
        typeDeRetourLabel = new JLabel();
        parametresLabel = new JLabel();
        ouiRadioButton = new JRadioButton();
        nonRadioButton = new JRadioButton();
        addButton = new MyButton("Add");
        jScrollPane1 = new javax.swing.JScrollPane();
        errorsField = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(179, 179, 255));


        titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        titreDePanel.setText("Methodes De Class : ");


        nomLabel.setText("Nom");
        nomLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

    

        choixDesTypes.setModel(model);
        choixDesTypes.setBackground(Color.white);
        choixDesTypes.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N


        typeDeRetourLabel.setText("Type De retour");
        typeDeRetourLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N


        parametresLabel.setText("Methodes avoir les parametres");
        parametresLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N


        buttonGroup1.add(ouiRadioButton);
        ouiRadioButton.setText("Oui");
        ouiRadioButton.setFont(new java.awt.Font("Liberation Sans", 1, 14));
        ouiRadioButton.setSelected(false);
        
        
        

        buttonGroup1.add(nonRadioButton);
        nonRadioButton.setText("Non");
        nonRadioButton.setFont(new java.awt.Font("Liberation Sans", 1, 14));
        nonRadioButton.setSelected(true);


        errorsField.setEditable(false);
        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBackground(new Color(242,242,242));
        errorsField.setFont(new java.awt.Font("Liberation Sans", 1, 12));

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
            .addComponent(titreDePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(ouiRadioButton)
                        .addGap(140, 140, 140)
                        .addComponent(nonRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(parametresLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(nomLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(typeDeRetourLabel)))
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(choixDesTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreDePanel)
                .addGap(35, 35, 35)
                .addComponent(nomLabel)
                .addGap(18, 18, 18)
                .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(typeDeRetourLabel)
                .addGap(18, 18, 18)
                .addComponent(choixDesTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(parametresLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ouiRadioButton)
                    .addComponent(nonRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }      
    
    private void addButtonActionPerformed(){
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
    private GTextField inputNom;
    private JTextArea errorsField;
    private JScrollPane jScrollPane1;
    // End of variables declaration                   
}
