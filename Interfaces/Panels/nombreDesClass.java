
package Panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Pieces.MyButton;

public class nombreDesClass extends JPanel {

    
    private int nombreDeClass;

    
    public int getNombreDeClass() {
        return nombreDeClass;
    }
    public void setNombreDeClass(int nombreDeClass) {
        this.nombreDeClass = nombreDeClass;
    }

    
    public nombreDesClass() {
        initComponents();
    }                       
    private void initComponents() {

        titreDePanel = new JLabel();
        nombreDeclassLabel = new JLabel();
        inputNombreDeClass = new JTextField();
        jScrollPane1 = new JScrollPane();
        errorField = new JTextArea();
        submitButton = new MyButton("submit");


        titreDePanel.setFont(new java.awt.Font("Liberation Serif", 1, 30)); // NOI18N
        titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);
        titreDePanel.setText("Initialisation");

        nombreDeclassLabel.setText("Combien Des Class Tu Veux Creer :");

        errorField.setEditable(false);
        errorField.setColumns(20);
        errorField.setRows(5);
        errorField.setBackground(new Color(242,242,242));
        errorField.setBorder(null);
        jScrollPane1.setViewportView(errorField);


        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(inputNombreDeClass, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(nombreDeclassLabel)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(74, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(nombreDeclassLabel)
                .addGap(38, 38, 38)
                .addComponent(inputNombreDeClass, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(submitButton)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );
    }
    private void submitButtonActionPerformed(ActionEvent evt){
        String nombreDeClassStr = inputNombreDeClass.getText();
        if(nombreDeClassStr.equals("")){
            errorField.setText("Veuillez Entrer Un Nombre");
        }else{
            try{
                nombreDeClass = Integer.parseInt(nombreDeClassStr);
                if(nombreDeClass <= 0){
                    errorField.setText("Veuillez Entrer Un Nombre Superieur A 0");
                }else{
                    errorField.setText("Nombre Valide : click button next To Continue");
                    inputNombreDeClass.setText("");
                }
            }catch(Exception e){
                errorField.setText("Veuillez Entrer Un Nombre");
            }
        }
    }                     


    // Variables declaration - do not modify                     
    private JLabel titreDePanel;
    private JLabel nombreDeclassLabel;
    private JScrollPane jScrollPane1;
    private JTextArea errorField;
    private JTextField inputNombreDeClass;
    private MyButton submitButton ;
    // End of variables declaration                   
}
