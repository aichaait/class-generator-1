import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClassInputUI extends JFrame {
    private JLabel classesLabel, nameLabel, attributesLabel, functionsLabel;
    private JTextField classesTextField, nameTextField, attributesTextField, functionsTextField;
    private JButton submitButton;
    private int numClasses;
    private int currentClass;

    public ClassInputUI() {
        super("Class Input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        classesLabel = new JLabel("Number of classes:");
        add(classesLabel);
        classesTextField = new JTextField(10);
        add(classesTextField);

        nameLabel = new JLabel("Class name:");
        add(nameLabel);
        nameTextField = new JTextField(10);
        add(nameTextField);

        attributesLabel = new JLabel("Number of attributes:");
        add(attributesLabel);
        attributesTextField = new JTextField(10);
        add(attributesTextField);

        functionsLabel = new JLabel("Number of functions:");
        add(functionsLabel);
        functionsTextField = new JTextField(10);
        add(functionsTextField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());
        add(submitButton);

        pack();
        setVisible(true);
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentClass == 0) {
                numClasses = Integer.parseInt(classesTextField.getText());
            }

            String className = nameTextField.getText();
            int numAttributes = Integer.parseInt(attributesTextField.getText());
            int numFunctions = Integer.parseInt(functionsTextField.getText());

            // Process the class data here
            // ...

            currentClass++;

            if (currentClass > numClasses) {
                dispose();
            } else {
                nameTextField.setText("");
                attributesTextField.setText("");
                functionsTextField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        ClassInputUI inputUI = new ClassInputUI();
    }
}

