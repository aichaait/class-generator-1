package Panels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

import Pieces.MyButton;

public class Attributes extends JPanel{
        public Attributes(){
            initComponents();
        }
        private void initComponents() {

            titreDePage = new JLabel();
            nomLabel = new JLabel();
            typeLabel = new JLabel();
            valeurLabel = new JLabel();
            inputNom = new JTextField();
            inputValeur = new JTextField();
            choixDesType = new JComboBox<>();
            addButton = new MyButton("Add");
    
            titreDePage.setFont(new java.awt.Font("Liberation Serif", 1, 30)); // NOI18N
            titreDePage.setText("Attributes De Class");
            titreDePage.setMaximumSize(new java.awt.Dimension(300, 40));
            titreDePage.setMinimumSize(new java.awt.Dimension(300, 40));
            titreDePage.setPreferredSize(new java.awt.Dimension(300, 40));
    
            nomLabel.setText("Nom :");
    
            typeLabel.setText("Type :");
    
            valeurLabel.setText("Valeur :");
        
            choixDesType.setModel(new DefaultComboBoxModel<>(listDesTypes));
            choixDesType.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),1));
            choixDesType.setBackground(Color.decode("#F8F8FF"));
            choixDesType.setForeground(Color.decode("#4A00E0"));

            inputNom.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));
            inputValeur.setBorder(BorderFactory.createLineBorder(Color.decode("#8E2DE2"),2));
            
        
            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(valeurLabel)
                            .addGap(100, 100, 100)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(inputNom, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(choixDesType, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputValeur, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(typeLabel)
                                .addComponent(nomLabel))
                            .addGap(200, 200, 200)
                            .addComponent(titreDePage, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(123, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton)
                    .addGap(450, 450, 450))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(titreDePage)
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(nomLabel)
                        .addComponent(inputNom, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(typeLabel)
                        .addComponent(choixDesType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(valeurLabel)
                        .addComponent(inputValeur, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addComponent(addButton)
                    .addGap(500, 500, 500))
            );
        }
        // funtions declaration
        public boolean addType(String type){
            for (String item : listDesTypes) {
                if(item.equals(type)){
                    return false;
                }
            }
            choixDesType.addItem(type);
            return true;
        }
        public MyButton getAddButton() {
            return addButton;
        }


    //variables declaration
    private MyButton addButton;
    private JComboBox<String> choixDesType;
    private JLabel titreDePage;
    private JLabel nomLabel;
    private JLabel typeLabel;
    private JLabel valeurLabel;
    private JTextField inputNom;
    private JTextField inputValeur;
    private String[] listDesTypes = {"int", "float", "double", "String", "char", "boolean"};
    //end of variables declaration
}