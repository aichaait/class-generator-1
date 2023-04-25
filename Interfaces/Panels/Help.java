package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Help extends JPanel {
    JTextArea titreDePanel;
    public Help() {
        initComponents();
        setBackground(new java.awt.Color(179, 179, 255));

    }
    private void initComponents() {
        titreDePanel = new JTextArea();
        // /JLabel apropos = new JLabel("welcom to UML2CODE generateur\nGenerate your code to cpp,java and sql ");
          titreDePanel.setText("\t\t\tHelp\n");
         // this.add(apropos);
         // titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);
          titreDePanel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20));
          titreDePanel.setForeground(new Color(0, 0, 0));
          //titreDePanel.setBorder(BorderFactory.createLineBorder(new Color(1, 1, 1)));
          titreDePanel.setBackground(new java.awt.Color(204, 217, 255));
          GroupLayout layout = new GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
                  .addGap(0, 0, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
              layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
                  .addGap(0, 0, Short.MAX_VALUE))
          );
    }
}
