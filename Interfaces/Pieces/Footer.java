package Pieces;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class Footer extends JPanel {

    public MyButton nextButton = new MyButton("Next");
    


    public Footer(){
        nextButton.setVisible(false);
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(nextButton);
        setBackground(new java.awt.Color(179, 179, 255));
    }
    
}
