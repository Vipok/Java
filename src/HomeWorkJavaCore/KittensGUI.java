package HomeWorkJavaCore;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class KittensGUI extends JFrame {
    Kittens kit = new Kittens();

    private JButton addKitten = new JButton("Добавить котёнка");
    protected JTextField inputNickname = new JTextField(null, 1);
    private JLabel nickname1 = new JLabel("Кличка: ");
    protected JTextField inputAge = new JTextField(null, 1);
    private JLabel age1 = new JLabel("Возраст (в днях): ");
    protected JTextField inputGrowth = new JTextField(null, 1);
    private JLabel growth1 = new JLabel("Рост (в сантиметрах): ");
    protected JTextField inputWeight = new JTextField(null, 1);
    private JLabel weight1 = new JLabel("Вес (в граммах): ");
    protected JTextField inputColor = new JTextField(null, 1);
    private JLabel color1 = new JLabel("Цвет: ");
    private JButton listOfKittens = new JButton("Список котят");
    protected JTextArea list = new JTextArea();


    public KittensGUI() {
        super("Кошачий питомник");
        this.setBounds(550, 300, 700, 500);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 5, 5, 5));
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
        listOfKittens.addActionListener(new LogicsGui());
        container.add(addKitten);
        container.add(listOfKittens);
        container.add(list);
    }

    class LogicsGui implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            File file = new File("text.txt");
            try {
                if (e.getSource() == addKitten) {
                    kit.setNickname(inputNickname.getText());
                    kit.setAge(Integer.parseInt(inputAge.getText()));
                    kit.setGrowth(Integer.parseInt(inputGrowth.getText()));
                    kit.setWeight(Integer.parseInt(inputWeight.getText()));
                    kit.setColor(inputColor.getText());
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                    writer.write(kit.getNickname() + ", " + kit.getAge() + ", " + kit.getGrowth() + ", "
                            + kit.getWeight() + ", " + kit.getColor() + "\n");
                    writer.flush();
                    writer.close();
                    if (e.getSource() == addKitten) {
                        inputNickname.setText(null);
                        inputAge.setText(null);
                        inputGrowth.setText(null);
                        inputWeight.setText(null);
                        inputColor.setText(null);
                        final String message = "Вы успешно добавили котенка.";
                        JOptionPane.showMessageDialog(null, message, "Успех",
                                JOptionPane.PLAIN_MESSAGE);
                    }

                }
                else {
                    final String messageErrorNullAplet = "Заполните все поля";
                    JOptionPane.showMessageDialog(null, messageErrorNullAplet, "Пустые поля",
                            JOptionPane.PLAIN_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                final String messageError = "Что-то пошло не так.";
                JOptionPane.showMessageDialog(null, messageError, "Неудача", JOptionPane.PLAIN_MESSAGE);
            }
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                if (e.getSource() == listOfKittens) {
                    String text;
                    while ((text = reader.readLine())!=null){
                        System.out.println(text);
                        list.append(text);
                    }
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }}
        }
