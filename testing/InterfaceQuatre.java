package testing;

import javax.swing.*; 
import java.awt.*; 
public class InterfaceQuatre extends JFrame {  
        // JFrame this;  
        InterfaceQuatre(){  
        // this=new JFrame();//creating instance of JFrame  

        JLabel Titre = new JLabel("Les methodes de Classe n° 1:");
        Titre.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        Titre.setForeground(new java.awt.Color(102, 102, 102));
        
        JLabel nomDeMethodeLabel = new JLabel("Nom Methode n° 1:");
        JTextField nomDeMethode = new JTextField();  

        JLabel typeDeMethodeLabel = new JLabel("Type Return :");   
        JTextField typeDeMethode = new JTextField();
        
        JLabel nombreDesParametresLabel =new JLabel("Nombre de Parametres :");
        JTextField nombreDesParametres = new JTextField();  
      
        JButton button = new JButton("Next");//creating instance of JButton 
        
        Titre.setBounds(10,10,300,30);

        nomDeMethodeLabel.setBounds(20,50,200,30);
        nomDeMethodeLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        nomDeMethode.setBounds(200, 50, 200, 30);
        nomDeMethode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        typeDeMethodeLabel.setBounds(20,100,150,30);
        typeDeMethodeLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        typeDeMethode.setBounds(200, 100, 200, 30);
        typeDeMethode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nombreDesParametresLabel.setBounds(20,150,200,30);
        nombreDesParametresLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        nombreDesParametres.setBounds(200, 150, 200, 30);
        nombreDesParametres.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

       
        button.setBounds(200,300,100, 30);  
        button.setBackground(new java.awt.Color(204, 204, 204));
        
        //TODO 

        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterfaceCinq i = new InterfaceCinq();
                dispose();

            }
            

        });
        //add
        this.add(Titre);
        this.add(nomDeMethodeLabel);
        this.add(nomDeMethode);
        this.add(typeDeMethodeLabel);
        this.add(typeDeMethode);          
        this.add(nombreDesParametresLabel);
        this.add(nombreDesParametres);
          
        this.add(button);
                
        this.setSize(500,500);//400 width and 500 height  
        this.setLayout(null);//using no layout managers  
        this.setVisible(true);//making the frame visible  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        }  
  
public static void main(String[] args) {  
    new InterfaceQuatre();  
    }  
}