package Panels;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Apropos extends JPanel {
    JTextArea titreDePanel;
    public Apropos() {
        initComponents();
        setBackground(new java.awt.Color(204, 217, 255));
    }
    private void initComponents() {
        titreDePanel = new JTextArea();
      // /JLabel apropos = new JLabel("welcom to UML2CODE generateur\nGenerate your code to cpp,java and sql ");
        titreDePanel.setText("\t\t            Apropos \n\n   Bienvenue dans notre générateur de classes Java à partir de bases de données XML.\nNotre générateur offre une solution efficace pour la création de classes Java,C++ et des \nrequêtes SQL à partir d'une base de données XML en utilisant le concept de mapping \nobjet-relationnel. Notre générateur est conçu pour vous permettre de spécifier les attributs,\nles méthodes et les relations entre les classes en utilisant une interface utilisateur intuitive.\n\nLes informations fournies par l'utilisateur sont ensuite stockées dans une base de données XML \nLe générateur prend ensuite en charge la conversion de cette base de données en classes Java,\nC++ ou des requêtes SQL.\n\nAvec notre générateur, vous pouvez facilement générer des classes qui correspondent à vos \nbesoins spécifiques en un temps record,et cela sans nécessiter une expertise en programmation. \nNous sommes convaincus que notre générateur vous aidera à accélérer le processus de \ndéveloppement et à améliorer la qualité de votre code.");
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