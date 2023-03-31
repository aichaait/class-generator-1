
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutExample {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Card Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the cards
        JPanel card1 = new JPanel();
        card1.setBackground(Color.RED);
        card1.add(new JLabel("This is Card 1"));

        JPanel card2 = new JPanel();
        card2.setBackground(Color.BLUE);
        card2.add(new JLabel("This is Card 2"));

        JPanel card3 = new JPanel();
        card3.setBackground(Color.GREEN);
        card3.add(new JLabel("This is Card 3"));

        // Create the panel that contains the cards
        JPanel cards = new JPanel(new CardLayout());
        cards.add(card1, "card1");
        cards.add(card2, "card2");
        cards.add(card3, "card3");

        // Create the buttons to switch between cards
        JButton button1 = new JButton("Card 1");
        button1.addActionListener(e -> ((CardLayout) cards.getLayout()).show(cards, "card1"));

        JButton button2 = new JButton("Card 2");
        button2.addActionListener(e -> ((CardLayout) cards.getLayout()).show(cards, "card2"));

        JButton button3 = new JButton("Card 3");
        button3.addActionListener(e -> ((CardLayout) cards.getLayout()).show(cards, "card3"));

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        // Add the cards and button panel to the frame
        frame.add(cards);
        frame.add(buttonPanel, "South");

        // Set the initial card to show
        ((CardLayout) cards.getLayout()).show(cards, "card1");

        // Show the frame
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
    }
}
