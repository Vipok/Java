package HomeWorkJavaCore;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test extends JFrame {
    private JButton button = new JButton("Добавить котёнка");
    private JTextField input = new JTextField("", 10);
    private JLabel label1 = new JLabel("Input:");
    private JTextField output = new JTextField("", 10);
    private JLabel label2 = new JLabel("Output:");
    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select that:");
    private JCheckBox check = new JCheckBox("Check", false);

    public Test(){
        super("Simple Example");
        this.setBounds(300, 300, 600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label1);
        container.add(label2);
        container.add(input);
        container.add(output);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            String message = "";
            message+= "Button was pressed\n";
            message+= "Text is " + input.getText();
            message+= (radio1.isSelected() ? "Radio #1" : "Radio #2") + "is selected \n";
            message+= "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
