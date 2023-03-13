package testing;



import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;




class MyFrame extends JFrame{
    int nombreDesAttributes;
    
    public MyFrame(int nombreDesAttributes){
        this.nombreDesAttributes = nombreDesAttributes;
        initComponents();
    }
    private void initComponents() {
        for(int i = 0; i<nombreDesAttributes; i++){
            JLabel attributeName = new JLabel("Nom d'Attribute n° "+i + " :");
            JTextField nameTextField = new JTextField();
            JLabel attributeType = new JLabel("Type d'Attribute n°"+i +" :");
            JLabel attributeValue = new JLabel("Valeur d'Attribute n°"+i +" :");
            JTextField valueTextField = new JTextField();
            
            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(attributeName)
                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addComponent(valueTextField)
                    .addContainerGap(280, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(attributeName)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(233, Short.MAX_VALUE))
            );
        }

    }

    public static void main(String[] args) {
        MyFrame f= new MyFrame(5);
        f.setVisible(true);
        f.setSize(400,400);
    }



}