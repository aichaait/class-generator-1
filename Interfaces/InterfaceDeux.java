package Interfaces;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField; 


public class InterfaceDeux extends JFrame{  
        // JFrame f2;  
        InterfaceDeux(){  


            // f2=new JFrame();//creating instance of JFrame  
            this.setTitle("Generateur de code");

            JLabel nomDeClassLabel = new JLabel("Nom Classe n° 1:");
            JTextField nomDeClass = new JTextField();  

            JLabel superClassLabel = new JLabel("SupperClasse :");   
            JComboBox superClass = new JComboBox<String>();
        
            JLabel nombreDesAttributesLabel =new JLabel("Nombre Attributes :");
            JTextField nombreDesAttributes = new JTextField();  

            JLabel nombreDesMethodesLabel =new JLabel("Nombre Methodes :");
            JTextField nombreDesMethodes = new JTextField();  

            JLabel nombreAssociationsLabel =new JLabel("Nombre Associations :");
            JTextField nombreAssociations = new JTextField();  


            MyButton_2 button = new MyButton_2("Next");//creating instance of JButton 

            nomDeClassLabel.setBounds(20,50,200,30);
            nomDeClassLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
            //nomDeClassLabel.setForeground(new java.awt.Color(0, 0, 153));
            nomDeClass.setBounds(160, 50, 200, 30);
            nomDeClass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

            superClassLabel.setBounds(20,100,150,30);
            superClassLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
            superClass.setBounds(160, 100, 200, 30);
            superClass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

            nombreDesAttributesLabel.setBounds(20,150,150,30);
            nombreDesAttributesLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
            nombreDesAttributes.setBounds(160, 150, 200, 30);
            nombreDesAttributes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

            nombreDesMethodesLabel.setBounds(20,200,150,30);
            nombreDesMethodesLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
            nombreDesMethodes.setBounds(160, 200, 200, 30);
            nombreDesMethodes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

            nombreAssociationsLabel.setBounds(20,250,150,30);
            nombreAssociationsLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
            nombreAssociations.setBounds(160, 250, 200, 30);
            nombreAssociations.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));


            button.setBounds(200,300,100, 30);  
            button.setBackground(new java.awt.Color(204, 204, 204));
        
            //TODO  add action listener to button that take you to the interface
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    InterfaceTrois trois = new InterfaceTrois();
                    dispose();

                }
                

            });

        
            this.add(nomDeClassLabel);
            this.add(nomDeClass);
            this.add(superClassLabel);
            this.add(superClass);          
            this.add(nombreDesAttributesLabel);
            this.add(nombreDesAttributes);
            this.add(nombreDesMethodesLabel);
            this.add(nombreDesMethodes);
            this.add(nombreAssociationsLabel);
            this.add(nombreAssociations);  
            this.add(button);
                
            this.setSize(500,500);//400 width and 500 height  
            this.setLayout(null);//using no layout managers  
            this.setVisible(true);//making the frame visible  
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        }  
  
}