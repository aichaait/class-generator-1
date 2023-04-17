package Panels;

import javax.swing.DefaultComboBoxModel;

import Pieces.GTextField;
import Pieces.MyButton;

public class Associations extends javax.swing.JPanel {
    DefaultComboBoxModel<String> model =  new DefaultComboBoxModel<String>();

    public void addToClasses(String[] classArray) {
        for (String myClass : classArray) {
            model.addElement(myClass);
        }
    }
        
   
    public javax.swing.JLabel getTitreDePanel() {
        return titreDePanel;
    }


    public Associations() {
        initComponents();
    }

                         
    public MyButton getAddButton() {
        return addButton;
    }


    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        titreDePanel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        errorField = new javax.swing.JTextArea();
        addButton = new MyButton("Add");
        typeLabel = new javax.swing.JLabel();
        choixDeType = new javax.swing.JComboBox<>();
        classDarrivee = new javax.swing.JLabel();
        choixDeClassDarrivee = new javax.swing.JComboBox<>();
        roleLabel = new javax.swing.JLabel();
        inputRole = new GTextField(25);
        multiplicityLabel = new javax.swing.JLabel();
        etoileButton = new javax.swing.JRadioButton();
        unButton = new javax.swing.JRadioButton();

        titreDePanel.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        titreDePanel.setText("Associations De Class : ");

        errorField.setColumns(20);
        errorField.setRows(5);
        errorField.setEditable(false);
        jScrollPane1.setViewportView(errorField);

        
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        typeLabel.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        typeLabel.setText("Type");

        choixDeType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregation", "Composition", "Association Simple" }));
        choixDeType.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N

        classDarrivee.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        classDarrivee.setText("Class D'arriver");

        choixDeClassDarrivee.setModel(model);

        roleLabel.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        roleLabel.setText("Role");

        multiplicityLabel.setFont(new java.awt.Font("Liberation Serif", 1, 18)); // NOI18N
        multiplicityLabel.setText("Multiplicity");

        etoileButton.setText("*");
        

        unButton.setText("1");
        buttonGroup1.add(etoileButton);
        buttonGroup1.add(unButton);
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titreDePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(choixDeType, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(233, 233, 233))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(classDarrivee)
                                .addGap(222, 222, 222)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inputRole, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(choixDeClassDarrivee, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(roleLabel)
                        .addGap(260, 260, 260))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(multiplicityLabel)
                        .addGap(227, 227, 227))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(etoileButton)
                        .addGap(152, 152, 152)
                        .addComponent(unButton)
                        .addGap(173, 173, 173))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titreDePanel)
                .addGap(60, 60, 60)
                .addComponent(typeLabel)
                .addGap(26, 26, 26)
                .addComponent(choixDeType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(classDarrivee)
                .addGap(18, 18, 18)
                .addComponent(choixDeClassDarrivee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputRole, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(multiplicityLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etoileButton)
                    .addComponent(unButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>                        

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String type,multiplicy,role,classDarrivee;
        type = choixDeType.getSelectedItem().toString();
        multiplicy = etoileButton.isSelected() ? "*" : "1";
        role = inputRole.getText();
        classDarrivee = choixDeClassDarrivee.getSelectedItem().toString();

        if(role.equals("")){
            errorField.setText("Remplir touts les champs");
        }else{
            errorField.setText("type: "+type+"\n multiplicity: "+multiplicy+"\nrole: "+role+"\nClass D'arrivee: "+classDarrivee);
        }
        


    }                                        
                                            


    public javax.swing.JComboBox<String> getChoixDeType() {
        return choixDeType;
    }


    public javax.swing.JComboBox<String> getChoixDeClassDarrivee() {
        return choixDeClassDarrivee;
    }


    public javax.swing.JRadioButton getEtoileButton() {
        return etoileButton;
    }


    public javax.swing.JTextArea getErrorField() {
        return errorField;
    }


    public GTextField getInputRole() {
        return inputRole;
    }



    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private MyButton addButton;
    private javax.swing.JComboBox<String> choixDeType;
    private javax.swing.JComboBox<String> choixDeClassDarrivee;
    private javax.swing.JLabel titreDePanel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel classDarrivee;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel multiplicityLabel;
    private javax.swing.JRadioButton etoileButton;
    private javax.swing.JRadioButton unButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea errorField;
    private GTextField inputRole;
    // End of variables declaration                   
}

