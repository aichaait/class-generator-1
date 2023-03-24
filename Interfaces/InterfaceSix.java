package Interfaces;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border; 

public class InterfaceSix extends JPanel{  
        // JFrame this;  
        InterfaceSix(){  
            Border blackline = BorderFactory.createTitledBorder("Generateur de code");

        // this=new JFrame();//creating instance of JFrame  
        
        setBorder(blackline);
        JLabel Titre = new JLabel("Les Associations de Classe n° 1:");
        Titre.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        Titre.setForeground(new java.awt.Color(102, 102, 102));
        
        JLabel typeAssociationLabel = new JLabel("Type association :");
        JComboBox typeAssociation = new JComboBox<String>();

        JLabel classArriveeLabel = new JLabel("Classe arrivé :");   
        JTextField classArrivee = new JTextField(); 
        
        JLabel multDepartLabel = new JLabel("multiplicite départ :");   
        JTextField multDepart = new JTextField(); 

        JLabel multArriveeLabel = new JLabel("multiplicite arrivé :");   
        JTextField multArrivee = new JTextField(); 

        JLabel roleDepartLabel = new JLabel("Role départ :");   
        JTextField roleDepart = new JTextField(); 

        JLabel roleArriveeLabel = new JLabel("Role arrivé :");   
        JTextField roleArrivee = new JTextField();

        JButton button = new JButton("Next");//creating instance of JButton 
        
        Titre.setBounds(10,10,300,30);

        typeAssociationLabel.setBounds(20,50,200,30);
        typeAssociationLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        typeAssociation.setBounds(150, 50, 200, 30);
        typeAssociation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        classArriveeLabel.setBounds(20,100,150,30);
        classArriveeLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        classArrivee.setBounds(150, 100, 200, 30);
        classArrivee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
       
        
        multDepartLabel.setBounds(20,150,150,30);
        multDepartLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        multDepart.setBounds(150, 150, 200, 30);
        multDepart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
       
        multArriveeLabel.setBounds(20,200,150,30);
        multArriveeLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        multArrivee.setBounds(150, 200, 200, 30);
        multArrivee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        
        roleDepartLabel.setBounds(20,250,150,30);
        roleDepartLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        roleDepart.setBounds(150, 250, 200, 30);
        roleDepart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        
        roleArriveeLabel.setBounds(20,300,150,30);
        roleArriveeLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        roleArrivee.setBounds(150, 300, 200, 30);
        roleArrivee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        button.setBounds(200,350,100, 30);  
        button.setBackground(new java.awt.Color(204, 204, 204));
        
        //TODO
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterfaceSept i7 = new InterfaceSept();
                setVisible(false);
                

            }
        });    
        //add
        //type des association : composition,aggregation,simple
        typeAssociation.addItem("Composition");
        typeAssociation.addItem("Aggregation");
        typeAssociation.addItem("Simple");


        this.add(Titre);
        this.add(typeAssociationLabel);
        this.add(typeAssociation);
        this.add(classArriveeLabel);
        this.add(classArrivee); 
        this.add(multDepartLabel);
        this.add(multDepart);
        this.add(multArriveeLabel);
        this.add(multArrivee);    
        this.add(roleDepartLabel);
        this.add(roleDepart);
        this.add(roleArriveeLabel);
        this.add(roleArrivee);     
       
        this.add(button);
                
        this.setSize(500,500);//400 width and 500 height  
        this.setLayout(null);//using no layout managers  
        this.setVisible(true);//making the frame visible  
        }  
        public static void main(String[] args) {
            InterfaceSix i6 = new InterfaceSix();
            JFrame f = new JFrame();
            f.add(i6);
            f.setSize(500,500);//400 width and 500 height
            f.setLayout(null);//using no layout managers
            f.setVisible(true);//making the frame visible
            
        }
  
 
}