package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Help extends JPanel {
    JTextArea titreDePanel;
    public Help() {
        initComponents();
        setBackground(new java.awt.Color(204, 217, 255));
    }
    private void initComponents() {
        titreDePanel = new JTextArea();

        titreDePanel.setText("\t\t\tHelp \n\nVoici quelques règles importantes à respecter lors de la création de vos classes dans notre \ngénérateur :\n\n  • Évitez de commencer le nom de vos classes par un chiffre.\n\n  • Utilisez des noms de classes clairs et significatifs pour faciliter la compréhension et la \n    maintenance du code.\n\n  • Respectez les conventions de nommage recommandées pour les attributs et les méthodes.\n\n  • Évitez d'utiliser des caractères spéciaux ou des espaces dans les noms de classes.\n\n  • Assurez-vous que les informations saisies dans l'interface utilisateur respectent les règles de \n   validation de chaque champ.\n\nEn suivant ces règles,vous pourrez créer des classes claires,concises et bien structurées dans \nnotre générateur.Si vous avez besoin d'aide supplémentaire,n'hésitez pas à nous contacter pour \nobtenir des conseils et des astuces sur la création de classes Java,C++ et SQL.\n\nConnectez-nous : uml2codegenerateur@gmail.com \nversion 2023(0.0)");

        titreDePanel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20));
        titreDePanel.setForeground(new Color(0, 0, 0));

        titreDePanel.setBackground(new java.awt.Color(204, 217, 255));

        // create a scroll pane and add the text area to it
       // JScrollPane scrollPane = new JScrollPane(titreDePanel);
        // set the preferred size of the scroll pane
        //scrollPane.setPreferredSize(new Dimension(880, 540));

        JScrollPane scrollPane = new JScrollPane(titreDePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setOpaque(false);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        //scrollPane.getHorizontalScrollBar().setOpaque(false);
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));



        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }
}

