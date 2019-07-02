package HomeWorkJavaCore;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class KittensGUI extends JFrame {
    private String nickname;//кличка
    private int age;//возраст в днях
    private int growth;//рост в сантиметрах
    private int weight;//вес в граммах
    private String color;//цвет
    //сеттеры
    public String getNickname(){return nickname;}
    public int getAge() {return age;}
    public int getGrowth(){return growth;}
    public int getWeight(){return weight;}
    public String getColor(){return color;}
    //геттеры
    public void setNickname(String nickname){this.nickname = nickname;}
    public void setAge(int age){this.age = age;}
    public void setGrowth(int growth){this.growth = growth;}
    public void setWeight(int weight){this.weight = weight;}
    public void setColor(String color){this.color = color;}

    private JButton addKitten = new JButton("Добавить котёнка");
    protected JTextField inputNickname = new JTextField("", 1);
    private JLabel nickname1 = new JLabel("Кличка: ");
    protected JTextField inputAge = new JTextField("", 1);
    private JLabel age1 = new JLabel("Возраст (в днях): ");
    protected JTextField inputGrowth = new JTextField("", 1);
    private JLabel growth1 = new JLabel("Рост (в сантиметрах): ");
    protected JTextField inputWeight = new JTextField("", 1);
    private JLabel weight1 = new JLabel("Вес (в граммах): ");
    protected JTextField inputColor = new JTextField("", 1);
    private JLabel color1 = new JLabel("Цвет: ");



    public KittensGUI (){
        super("Кошачий питомник");
        this.setBounds(550,300,700,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(6,5,5,5));
        container.add(nickname1);
        container.add(inputNickname);
        container.add(age1);
        container.add(inputAge);
        container.add(growth1);
        container.add(inputGrowth);
        container.add(weight1);
        container.add(inputWeight);
        container.add(color1);
        container.add(inputColor);
        addKitten.addActionListener(new LogicsGui());
        container.add(addKitten);
    }

class LogicsGui implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            if (e.getSource()==addKitten){
                setNickname(inputNickname.getText());
                setAge(Integer.parseInt(inputAge.getText()));
                setGrowth(Integer.parseInt(inputGrowth.getText()));
                setWeight(Integer.parseInt(inputWeight.getText()));
                setColor(inputColor.getText());
            }
            if (e.getSource()==addKitten){
                inputNickname.setText(null);
                inputAge.setText(null);
                inputGrowth.setText(null);
                inputWeight.setText(null);
                inputColor.setText(null);
            }
            FileWriter file = null;
            try {
                file = new FileWriter("text.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                file.write(getNickname() + ", " + getAge() + ", " + getGrowth() + ", " + getWeight() + ", " + getColor());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                file.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            String message;
            String messageError;
            message = "Вы успешно добавили котенка.";
            messageError = "Что-то пошло не так.";
            JOptionPane.showMessageDialog(null, message, "Успех", JOptionPane.PLAIN_MESSAGE);
    }
}
}

