package Pieces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Header extends JPanel {


    public Header() {
        initComponents();
    }
    private void initComponents() {
        // TODO
       
        setLayout(new BorderLayout(400,0));
        setPreferredSize(new Dimension(25,25));
        setBackground(Color.CYAN);

        img = new ImageIcon(getClass().getResource("../images/web-programming.png"),"logo");
       // picLabel = new JLabel();
        //resize the image
        reSizedImg =  img.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        
       // picLabel.setIcon(new ImageIcon(reSizedImg));

         
        Titre = new JLabel("UML2Code");
        Titre.setSize(50, 100);
        Titre.setFont(new Font("Times New Roman", Font.BOLD, 50)); // NOI18N
        Titre.setIcon(new ImageIcon(reSizedImg));
        Titre.setHorizontalAlignment(SwingConstants.CENTER);

        add(Titre,BorderLayout.CENTER);

        
       // add(picLabel,BorderLayout.WEST);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        Color color1 = Color.decode("#33cccc");
        Color color2 = Color.decode("#9966ff");
        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    //JLabel picLabel ;
    ImageIcon img;
    Image reSizedImg;
    JLabel Titre;
    Graphics2D g2d;
    int width,height;
    Color color1,color2;
    GradientPaint gp;
    // End of variables declaration//GEN-END:variables
    
}
