package Pieces;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class Footer extends JPanel {

    public MyButton nextButton = new MyButton("Next");


    public Footer(){
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(nextButton);
    }
    
}
