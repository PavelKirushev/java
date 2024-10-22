import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class ContactForm extends JFrame {
    JTextField name_field;
    JTextField mail_field;
    JRadioButton male;
    JCheckBox check;
    public ContactForm(){
        super("Контактная информация");
        super.setBounds(200, 100, 500, 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(4, 2, 2, 2));

        JLabel name = new JLabel("Введите имя");
        name_field = new JTextField("", 1);
        JLabel mail = new JLabel("Введите e-mail");
        mail_field = new JTextField("@", 1);

        container.add(name);
        container.add(name_field);
        container.add(mail);
        container.add(mail_field);

        male = new JRadioButton("Мужской");
        JRadioButton female = new JRadioButton("Женский");
        check = new JCheckBox("Согласен?", false);
        JButton button = new JButton("Отправить");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(button);

        button.addActionListener(new ButtonEvent());

    }

    class ButtonEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            String name = name_field.getText();
            String mail = mail_field.getText();

            String isMale = "Женский";
            if(male.isSelected()){
                isMale = "Мужской";
            }
            boolean checkBox =  check.isSelected();

            JOptionPane.showMessageDialog(null,
                    "Ваша почта: " + mail + "\nВаш пол:" + isMale,
                    "Привет, " + name, JOptionPane.PLAIN_MESSAGE);
        }
    }

}
