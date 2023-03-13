package testing;

import javax.swing.*; 
public class InterfaceTrois extends JFrame{  
        // JFrame this;  
        InterfaceTrois(){  
        // this=new JFrame();//creating instance of JFrame  

        JLabel Titre = new JLabel("Les Attributs de Classe n° 1:");
        Titre.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        Titre.setForeground(new java.awt.Color(102, 102, 102));
        
        JLabel nomAttributeLabel = new JLabel("Nom Attribute n° 1:");
        JTextField nomAttribute = new JTextField();  

        JLabel typeAttributeLabel = new JLabel("Type Attribute :");   
        JTextField typeAttribute = new JTextField();
        
        JLabel valeurAttributeLabel =new JLabel("value Attribute :");
        JTextField valeurAttribute = new JTextField();  
      
        JButton button = new JButton("Next");//creating instance of JButton 
        
        Titre.setBounds(10,10,250,30);

        nomAttributeLabel.setBounds(20,50,200,30);
        nomAttributeLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        nomAttribute.setBounds(150, 50, 200, 30);
        nomAttribute.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        typeAttributeLabel.setBounds(20,100,150,30);
        typeAttributeLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        typeAttribute.setBounds(150, 100, 200, 30);
        typeAttribute.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        valeurAttributeLabel.setBounds(20,150,150,30);
        valeurAttributeLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        valeurAttribute.setBounds(150, 150, 200, 30);
        valeurAttribute.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

       
        button.setBounds(200,300,100, 30);  
        button.setBackground(new java.awt.Color(204, 204, 204));
        
        //TODO 
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterfaceQuatre quatre = new InterfaceQuatre();
                dispose();
            }

           
        });

        this.add(Titre);
        this.add(nomAttributeLabel);
        this.add(nomAttribute);
        this.add(typeAttributeLabel);
        this.add(typeAttribute);          
        this.add(valeurAttributeLabel);
        this.add(valeurAttribute);
          
        this.add(button);
                
        this.setSize(500,500);//400 width and 500 height  
        this.setLayout(null);//using no layout managers  
        this.setVisible(true);//making the frame visible  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        }  
  
  
}