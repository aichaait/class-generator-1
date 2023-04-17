package Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Help extends JPanel {
    JLabel titreDePanel;
    public Help() {
        initComponents();
    }
    private void initComponents() {
        titreDePanel = new JLabel();
        titreDePanel.setText("Help");
        titreDePanel.setHorizontalAlignment(SwingConstants.CENTER);
        titreDePanel.setFont(new Font("Tahoma", 1, 24));
        titreDePanel.setForeground(new Color(0, 0, 255));
        titreDePanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }
}
