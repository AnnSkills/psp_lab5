package lw_first;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Reader extends JFrame {
    JList box_1, box_2;
    JButton check, add, delete, delete2, reset, reset_1, reset2, reset_2;
    JTextField text, resetField, resetField2;
    DefaultListModel listModel1, listModel2;
    JPanel jp;

    public Reader(String str) {
        super(str);
        jp = new JPanel();
        listModel1 = new DefaultListModel();
        listModel2 = new DefaultListModel();

        listModel1.addElement("Olga");
        listModel1.addElement("Pasha");
        listModel1.addElement("Vladimir");

        listModel2.addElement("Cool");
        listModel2.addElement("Ulun");
        listModel2.addElement("Marina");


        box_1 = new JList(listModel1);
        box_2 = new JList(listModel2);

        JScrollPane jsp1 = new JScrollPane(box_1);
        jsp1.setBounds(0, 0, 200, 100);
        JScrollPane jsp2 = new JScrollPane(box_2);
        jsp2.setBounds(200, 0, 200, 100);

        text = new JTextField(9);
        text.setBounds(200, 100, 200, 25);

        resetField = new JTextField(9);
        resetField.setBounds(0, 300, 200, 25);

        resetField2 = new JTextField(9);
        resetField2.setBounds(200, 300, 200, 25);

        check = new JButton("Проверить листы");
        check.setBounds(0, 100, 200, 25);

        add = new JButton("Добавить данные");
        add.setBounds(200, 125, 200, 25);

        delete = new JButton("Удалить данные из списка 1");
        delete.setBounds(200, 150, 250, 25);

        delete2 = new JButton("Удалить данные из списка 2");
        delete2.setBounds(200, 175, 250, 25);

        reset = new JButton("Редактировать данные из списка 1");
        reset.setBounds(200, 200, 250, 25);

        reset2 = new JButton("Редактировать данные из списка 2");
        reset2.setBounds(200, 225, 250, 25);

        reset_1 = new JButton("Редактировать_1");
        reset_1.setBounds(0, 325, 200, 25);

        reset_2 = new JButton("Редактировать_2");
        reset_2.setBounds(200, 325, 200, 25);

        jp.add(reset2);
        jp.add(reset_2);
        jp.add(resetField2);
        jp.add(reset_1);
        jp.add(resetField);
        jp.add(reset);
        jp.add(delete2);
        jp.add(delete);
        jp.add(add);
        jp.add(text);
        jp.add(check);
        jp.add(jsp2);
        jp.add(jsp1);
        jp.setLayout(null);


        add(jp);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        check.addActionListener(new CheckLists());
        add.addActionListener(new AddData());
        delete.addActionListener(new DeleteData());
        delete2.addActionListener(new DeleteData2());
        reset.addActionListener(new ResetData());
        reset_1.addActionListener(new ResetData_1());
        reset2.addActionListener(new ResetData2());
        reset_2.addActionListener(new ResetData_2());
    }

    public class CheckLists implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < listModel1.size(); i++) {
                if (listModel1.get(i) != listModel2.get(i))
                    list.add(listModel1.get(i) + " -- " + listModel2.get(i));
            }
            JOptionPane.showMessageDialog(null, list);
        }
    }

    public class AddData implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String inputText = text.getText();
            listModel1.addElement(inputText);
            listModel2.addElement(inputText);
            text.setText(null);
        }
    }

    public class DeleteData implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listModel1.remove(box_1.getSelectedIndex());
        }
    }

    public class DeleteData2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listModel2.remove(box_2.getSelectedIndex());
        }
    }

    public class ResetData implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            resetField.setText(box_1.getSelectedValue().toString());
        }
    }

    public class ResetData2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            resetField2.setText(box_2.getSelectedValue().toString());
        }
    }

    public class ResetData_1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listModel1.remove(box_1.getSelectedIndex());
            listModel1.addElement(resetField.getText());
            resetField.setText(null);
        }
    }

    public class ResetData_2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            listModel2.remove(box_2.getSelectedIndex());
            listModel2.addElement(resetField2.getText());
            resetField2.setText(null);
        }
    }

}
