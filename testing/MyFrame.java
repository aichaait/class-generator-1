package testing;




import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



class MyFrame {
    
        public static void main(String[] args) {
            
            JFrame frame = new JFrame("MyFrame");
            JButton button = new JButton("Press me");
            JLabel label = new JLabel("Hello World");
            JLabel label2 = new JLabel("Hello World2");
            JTextField text = new JTextField();
            // frame.add(button);
            
            //setBounds(x, y, width, height)
            label.setBounds(50, 50, 100, 30);
            label2.setBounds(50, 100, 100, 30);
            // button.setBounds(10, 50, 100, 30);
            text.setBounds(110, 50, 200, 30);
            frame.add(label);
            frame.add(label2);
            frame.add(text);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setVisible(true);
        }
    }