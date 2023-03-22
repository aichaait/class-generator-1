package Interfaces;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField; 


public class InterfaceCinq extends JFrame{  
        // JFrame this;  
        InterfaceCinq(){  
        // this=new JFrame();//creating instance of JFrame  

        JLabel Titre = new JLabel("Les methodes de Classe n° 1:");
        Titre.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        Titre.setForeground(new java.awt.Color(102, 102, 102));
        
        JLabel nomDeParametreLabel = new JLabel("Nom parametre n° 1:");
        JTextField nomDeParametre = new JTextField();  

        JLabel typeDeParametreLabel = new JLabel("Type :");   
        JTextField typeDeParametre = new JTextField(); 
      
        JButton button = new JButton("Next");//creating instance of JButton 
        
        Titre.setBounds(10,10,300,30);

        nomDeParametreLabel.setBounds(20,50,200,30);
        nomDeParametreLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        nomDeParametre.setBounds(150, 50, 200, 30);
        nomDeParametre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        typeDeParametreLabel.setBounds(20,100,150,30);
        typeDeParametreLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        typeDeParametre.setBounds(150, 100, 200, 30);
        typeDeParametre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
       
        button.setBounds(200,300,100, 30);  
        button.setBackground(new java.awt.Color(204, 204, 204));
        
        //TODO 
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterfaceSix i = new InterfaceSix();
                dispose();

            }
            

        });
        //we need actionperformed for button b 
        this.add(Titre);
        this.add(nomDeParametreLabel);
        this.add(nomDeParametre);
        this.add(typeDeParametreLabel);
        this.add(typeDeParametre);          
       
        this.add(button);
                
        this.setSize(500,500);//400 width and 500 height  
        this.setLayout(null);//using no layout managers  
        this.setVisible(true);//making the frame visible 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        }  
  
}