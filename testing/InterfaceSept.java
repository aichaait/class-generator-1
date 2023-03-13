package testing;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel; 

public class InterfaceSept extends JFrame {  
        // JFrame this;  
        InterfaceSept(){  
        // this=new JFrame();//creating instance of JFrame  
        this.setTitle("Generateur de code");

        JLabel Titre = new JLabel("Generer vers code :");

        JCheckBox javaCheckBox = new JCheckBox();
        JLabel javaLabel = new JLabel("Java");
        javaLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
    
        
        JCheckBox cppCheckBox = new JCheckBox();
        JLabel cppLabel = new JLabel("C++");
        javaLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
       

        JCheckBox sqlCheckBox = new JCheckBox();
        JLabel sqlLabel = new JLabel("SQL");
        sqlLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));

        JCheckBox allCheckBox = new JCheckBox();
        JLabel allLabel = new JLabel("ALL");
        allLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        
        JButton button = new JButton("Terminer");//creating instance of JButton 
        Titre.setBounds(100,20,450,30);
        Titre.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16));

        javaCheckBox.setBounds(20, 60, 20, 20);
        javaLabel.setBounds(60,60,200,30);
        javaLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));

        cppCheckBox.setBounds(20, 100, 20, 20);
        cppLabel.setBounds(60,100,150,30);
        cppLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
      
        
        sqlCheckBox.setBounds(20, 140, 20, 20);
        sqlLabel.setBounds(60,140,150,30);
        sqlLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));

        allCheckBox.setBounds(20, 180, 20, 20);
        allLabel.setBounds(60,180,150,30);
        allLabel.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12));
        
        button.setBounds(200,300,100, 30);  
        button.setBackground(new java.awt.Color(204, 204, 204));
        
        //TODO
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
        
        //add
        this.add(Titre);
        this.add(javaCheckBox);
        this.add(javaLabel);
        this.add(cppCheckBox);
        this.add(cppLabel);
        this.add(sqlCheckBox);
        this.add(sqlLabel);
        this.add(allCheckBox);
        this.add(allLabel);
            
       
        this.add(button);
                
        this.setSize(500,500);//400 width and 500 height  
        this.setLayout(null);//using no layout managers  
        this.setVisible(true);//making the frame visible  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        }  
  
 
}
