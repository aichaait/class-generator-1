package testing;

import Interfaces.MyButton;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class CardLayoutDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cardPanel = new JPanel(new CardLayout());

        JPanel panel1 = new JPanel();
        panel1.add(new JButton("Panel 1"));

        JPanel panel2 = new JPanel();
        panel2.add(new JButton("Panel 2"));

        JPanel panel3 = new JPanel();
        panel3.add(new JButton("Panel 3"));

        cardPanel.add(panel1, "panel1");
        cardPanel.add(panel2, "panel2");
        cardPanel.add(panel3, "panel3");

        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, "panel1");

        MyButton button = new MyButton("Switch to panel 3");
        button.addActionListener(e -> cardLayout.show(cardPanel, "panel3"));
        panel2.add(button);

        frame.add(cardPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);

        // Switch to panel2 after 3 seconds
        // try {
        //     Thread.sleep(3000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        cardLayout.show(cardPanel, "panel2");
    }
}
 
