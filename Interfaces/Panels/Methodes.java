
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

import Pieces.GTextField;
import Pieces.MyButton;



public class Methodes extends JPanel {
    private String[] listDesTypesDeRetoure = new String[] { "Entier", "Reel", "Chaine", "Charactere" };
    private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(listDesTypesDeRetoure);
    private int hasParametres = -1;
    private String nomDeCurrentClass = "";
    
    

    

    
  
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

        titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 48)); // NOI18N
        titreDePanel.setText("Methodes De Class : ");


        nomLabel.setText("Nom");
        nomLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

    

        choixDesTypes.setModel(model);
        choixDesTypes.setBackground(Color.white);
        choixDesTypes.setForeground(Color.black);


        typeDeRetourLabel.setText("Type De retour");
        typeDeRetourLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N


        parametresLabel.setText("Methodes avoir les parametres");
        parametresLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N


        buttonGroup1.add(ouiRadioButton);
        ouiRadioButton.setText("Oui");
        ouiRadioButton.setFont(new java.awt.Font("Liberation Sans", 1, 14));
        
        
        nonRadioButton.setForeground(Color.decode("#4A00E0"));
        ouiRadioButton.setForeground(Color.decode("#4A00E0"));

        buttonGroup1.add(nonRadioButton);
        nonRadioButton.setText("Non");
        nonRadioButton.setFont(new java.awt.Font("Liberation Sans", 1, 14));


        errorsField.setEditable(false);
        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBackground(new Color(242,242,242));
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
                        .addGap(700, 700, 700)
                        .addComponent(ouiRadioButton)
                        .addGap(140, 140, 140)
                        .addComponent(nonRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(690, 690, 690)
                        .addComponent(parametresLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(800, 800, 800)
                        .addComponent(nomLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(750, 750, 750)
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
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreDePanel)
                .addGap(20, 20, 20)
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
        String nom = inputNom.getText();
        String type = choixDesTypes.getSelectedItem().toString();
        hasParametres = ouiRadioButton.isSelected() ? 1 : 0;
        String errors = "";
        if(nom.equals("")){
            errors += "Nom est obligatoire";
        }
        if(errors.equals("")){
            inputNom.setText("");
            choixDesTypes.setSelectedIndex(0);
            ouiRadioButton.setSelected(true);
            nonRadioButton.setSelected(false);
            errorsField.setText(nom + "Added With Type: " + type + " And Has Parametres: " + hasParametres);
        }else{
            errorsField.setText(errors);
        }

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
