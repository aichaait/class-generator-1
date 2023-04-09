package Panels;

import javax.swing.JFrame;


public class frameDeTesting {
    public static void main(String[] args) {
        JFrame f = new JFrame("Testing");
        f.add(new AssociationsPage());


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000,600);
        f.setVisible(true);


    }
    
}
