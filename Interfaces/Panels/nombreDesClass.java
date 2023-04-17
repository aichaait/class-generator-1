
package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Pieces.GTextField;
import Pieces.MyButton;

public class nombreDesClass extends JPanel {

    
    private int nombreDesClasses = -1;
    
    
    public JTextArea getErrorsField() {
        return errorsField;
    }
    public int getNombreDesClasses() {
        return nombreDesClasses;
    }
    public void setNombreDesClasses(int nombreDesClasses) {
        this.nombreDesClasses = nombreDesClasses;
    }

    
    public nombreDesClass() {
        initComponents();
    }                       
    private void initComponents() {

        titreDePanel = new JLabel();
        nombreDesClassesLabel = new JLabel();
        inputNombreDesClasses = new GTextField(25);
        jScrollPane1 = new JScrollPane();
        errorsField = new JTextArea();
        submitButton = new MyButton("submit");
        setBackground(new java.awt.Color(179, 179, 255));

    //     titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 30)); // NOI18N
    //     titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);
    //     titreDePanel.setText("salam");

        nombreDesClassesLabel.setText("Nombre de classes :");
        nombreDesClassesLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        nombreDesClassesLabel.setForeground(new java.awt.Color(66, 70, 137));

        errorsField.setEditable(false);
        errorsField.setColumns(20);
        errorsField.setRows(5);
        errorsField.setBackground(new Color(242,242,242));
        errorsField.setBorder(null);
        errorsField.setFont(new java.awt.Font("Liberation Sans", 1, 12));
        //errorsField.setForeground(Color.RED);
        jScrollPane1.setViewportView(errorsField);


        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitButtonActionPerformed();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addGap(20, 20, 20))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputNombreDesClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(titreDePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(350, 350, 350))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(nombreDesClassesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(300, 300, 300)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titreDePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(nombreDesClassesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputNombreDesClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }
    private void submitButtonActionPerformed(){
        String nombreDesClassesStr = inputNombreDesClasses.getText();
        if(nombreDesClassesStr.equals("")){
            errorsField.setText("Veuillez vous donner un nombre");
        }else{
            try{
                nombreDesClasses = Integer.parseInt(nombreDesClassesStr);
                if(nombreDesClasses <= 0){
                    errorsField.setText("Veuillez vous donner un nombre superieur à 0");
                }else{
                    errorsField.setText("Nombre valide\nNext pour continue");
                    inputNombreDesClasses.setText("");
                }
            }catch(Exception e){
                errorsField.setText("Veuillez vous donner un nombre valide");
            }
        }
        inputNombreDesClasses.setText("");
    }                     


    // Variables declaration - do not modify                     
    private JLabel titreDePanel;
    private JLabel nombreDesClassesLabel;
    private JScrollPane jScrollPane1;
    private JTextArea errorsField;
    private GTextField inputNombreDesClasses;
    private MyButton submitButton ;
    // End of variables declaration                   
}
