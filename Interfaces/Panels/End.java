package Panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class End extends JPanel {
    JLabel titreDePanel;
    public End() {
        initComponents();
        setBackground(new java.awt.Color(179, 179, 255));

    }
    private void initComponents() {
        titreDePanel = new JLabel();
        titreDePanel.setText("Fin");
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
                .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titreDePanel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }
}
