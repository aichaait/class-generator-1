
package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Pieces.GTextField;
import Pieces.MyButton;

public class LesNomsDesClasses extends JPanel {
    private String nomDeClass,nomDeSuperClass;
    private int nombreDesClasses;
    private List<String> lesNomDesClass = new ArrayList<String>();
    private DefaultComboBoxModel<String> model =  new DefaultComboBoxModel<String>();
    
    public List<String> getLesNomDesClass() {
        return lesNomDesClass;
    }

    public void setLesNomDesClass(List<String> lesNomDesClass) {
        this.lesNomDesClass = lesNomDesClass;
    }

    public String getNomDeClass() {
        return nomDeClass;
    }
    public javax.swing.JComboBox<String> getSuperClassChoix() {
        return superClassChoix;
    }

    public JTextField getInputNom() {
        return inputNom;
    }

    public String getNomDeSuperClass() {
        return nomDeSuperClass;
    }

    public MyButton getAddButton() {
        return addButton;
    }

    public void setNomDeClass(String nomDeClass) {
        this.nomDeClass = nomDeClass;
    }

    public int getNombreDesClasses() {
        return nombreDesClasses;
    }

    public void setNombreDesClasses(int nombreDesClasses) {
        this.nombreDesClasses = nombreDesClasses;
    }

    public JTextArea getErrorsField() {
        return errorsField;
    }
    

    public LesNomsDesClasses() {
        initComponents();
    }
                     
    private void initComponents() {

        titreDePanel = new JLabel();
        nomLabel = new JLabel();
        inputNom = new GTextField(25);
        addButton = new MyButton("Add");
        jScrollPane1 = new JScrollPane();
        errorsField = new JTextArea();
        superClassLabel = new javax.swing.JLabel();
        superClassChoix = new javax.swing.JComboBox<String>();

        titreDePanel.setFont(new Font("Liberation Serif", 1, 48)); // NOI18N
        titreDePanel.setText("Les noms du classes");
        titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);


        nomLabel.setFont(new Font("Liberation Sans", 1, 18)); // NOI18N
        nomLabel.setText("Nom du classe : ");
        inputNom.setHorizontalAlignment(SwingConstants.CENTER);

        inputNom.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));

        superClassLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        superClassLabel.setText("Super Class");
        model.addElement("aucun");
        superClassChoix.setModel(model);
        superClassChoix.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        superClassChoix.setBackground(Color.WHITE);
        superClassChoix.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

        addButton.setText("Add");

        errorsField.setEditable(false);
        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBackground(new Color(242,242,242));
        errorsField.setFont(new Font("Liberation Sans", 1, 12)); // NOI18N
        //errorsField.setForeground(Color.RED);
        jScrollPane1.setViewportView(errorsField);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(titreDePanel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(nomLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(superClassLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(superClassChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(titreDePanel)
                .addGap(59, 59, 59)
                .addComponent(nomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputNom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(superClassLabel)
                .addGap(18, 18, 18)
                .addComponent(superClassChoix, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    addButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt){
            if(nombreDesClasses == 0){
                errorsField.append("Vous fini, press Next pour continue\n");
            }else{
                nomDeClass = inputNom.getText();
                nomDeSuperClass = superClassChoix.getSelectedItem().toString();
                addClass(nomDeClass,nomDeSuperClass);
                nombreDesClasses--;
            }
            inputNom.setText("");
        }
    });
    }   
    public void addClass(String nom,String superClass) {
            if(nom == null || nom.equals("")){
                errorsField.append("il faut donner un nom\n");
            }
            else if(superClass.equals("aucun")) {

                errorsField.append(nom+" Added\n");
                lesNomDesClass.add(nom);
                model.addElement(nom);
            }else{
                errorsField.append(nom+" Added,le Super Class est "+superClass);
                lesNomDesClass.add(nom);

                model.addElement(nom);

                
            }
    }
                                          


    // Variables declaration - do not modify                     
    private MyButton addButton;
    private JLabel titreDePanel;
    private JLabel nomLabel;
    private JScrollPane jScrollPane1;
    private JTextArea errorsField;
    private JTextField inputNom;
    private javax.swing.JComboBox<String> superClassChoix;
    private javax.swing.JLabel superClassLabel;
    // End of variables declaration                   
}

