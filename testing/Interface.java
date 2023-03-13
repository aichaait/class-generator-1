package testing;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField; 
public class Interface  extends JFrame {  
        // JFrame f;  
        Interface(){  
        
        // f=new JFrame( );//creating instance of JFrame  
        this.setTitle("Generateur de code");

        JLabel Title = new JLabel("Generateur de code");
        JLabel label = new JLabel("Nombre des classes :");        
        JTextField userInput = new JTextField();  
        JButton button=new JButton("Next");//creating instance of JButton  
        Title.setBounds(100,50,250,30);
        Title.setFont(new java.awt.Font("Nirmala UI", 3, 20));
        Title.setForeground(new java.awt.Color(0, 0, 153));

        label.setBounds(10,150,150,30);
        userInput.setBounds(150, 150, 200, 30);
        userInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));


        button.setBounds(150,230,100, 30);  
        button.setBackground(new java.awt.Color(204, 204, 204));
        
        //TODO add action listener to button to pass to the next interface
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterfaceDeux deux = new InterfaceDeux();
                dispose();
            }

           
        });
        
        
        this.add(Title);
        this.add(label);
        this.add(userInput);          
        this.add(button);//adding button in JFrame  
                
        this.setSize(500,500);//400 width and 500 height  
        this.setLayout(null);//using no layout managers  
        this.setVisible(true);//making the frame visible  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        }  
  

}