package lw_second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class RunnerGUI {

    private JFrame frame;
    private JTextField name;
    private JTextField phone;
    private JTextField email;
    private String filename = "D:\\5 СЕМ\\Lab5\\src\\resources\\data.txt";
    private List<lw_second.DataForm> dataFormList = new LinkedList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RunnerGUI window = new RunnerGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RunnerGUI() {
        initialize();
    }


    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 730, 489);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        name = new JTextField();
        name.setBounds(128, 28, 86, 20);
        frame.getContentPane().add(name);
        name.setColumns(10);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(450, 20, 200, 400);
        textArea.setEditable(false);
        JScrollPane sp = new JScrollPane(textArea);
        frame.getContentPane().add(textArea);
        frame.getContentPane().add(sp);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(65, 31, 46, 14);
        frame.getContentPane().add(lblName);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(65, 68, 46, 14);
        frame.getContentPane().add(lblPhone);

        phone = new JTextField();
        phone.setBounds(128, 65, 86, 20);
        frame.getContentPane().add(phone);
        phone.setColumns(10);

        JLabel lblEmailId = new JLabel("Email");
        lblEmailId.setBounds(65, 115, 46, 14);
        frame.getContentPane().add(lblEmailId);

        email = new JTextField();
        email.setBounds(128, 112, 247, 17);
        frame.getContentPane().add(email);
        email.setColumns(10);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(65, 162, 46, 14);
        frame.getContentPane().add(lblAddress);

        JTextArea address = new JTextArea();
        address.setBounds(126, 157, 212, 40);
        frame.getContentPane().add(address);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(190, 387, 89, 23);
        frame.getContentPane().add(btnClear);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(312, 387, 89, 23);
        frame.getContentPane().add(btnUpdate);

        JLabel lblSex = new JLabel("Sex");
        lblSex.setBounds(65, 228, 46, 14);
        frame.getContentPane().add(lblSex);

        JRadioButton radioButton = new JRadioButton("Male");
        radioButton.setBounds(337, 224, 109, 23);
        frame.getContentPane().add(radioButton);

        JRadioButton radioButton_1 = new JRadioButton("Female");
        radioButton_1.setBounds(162, 224, 109, 23);
        frame.getContentPane().add(radioButton_1);

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton);
        group.add(radioButton_1);
        //frame.getContentPane().add(group);

        JLabel lblOccupation = new JLabel("Occupation");
        lblOccupation.setBounds(65, 288, 67, 14);
        frame.getContentPane().add(lblOccupation);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("Select");
        comboBox.addItem("Business");
        comboBox.addItem("Engineer");
        comboBox.addItem("Doctor");
        comboBox.addItem("Student");
        comboBox.addItem("Others");

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });

        comboBox.setBounds(180, 285, 91, 20);
        frame.getContentPane().add(comboBox);


        JButton btnSubmit = new JButton("submit");

        btnSubmit.setBackground(Color.BLUE);
        btnSubmit.setForeground(Color.MAGENTA);
        btnSubmit.setBounds(65, 387, 89, 23);
        frame.getContentPane().add(btnSubmit);


        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (name.getText().isEmpty() ||
                        (phone.getText().isEmpty()) ||
                        (email.getText().isEmpty()) ||
                        (address.getText().isEmpty()) ||
                        ((radioButton_1.isSelected()) && (radioButton.isSelected())) ||
                        (comboBox.getSelectedItem().equals("Select"))) {
                    System.out.println(phone.getText());
                    System.out.println(comboBox.getSelectedItem());

                    JOptionPane.showMessageDialog(null, "Data Missing during filling");

                } else
                    JOptionPane.showMessageDialog(null, "Data Submitted successfully");
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                    String sex = radioButton.isSelected() ? "Male" : "Female";

                    lw_second.DataForm dataForm = new lw_second.DataForm(name.getText(), phone.getText(), email.getText(),
                            address.getText(), sex, (String) comboBox.getSelectedItem());
                    dataFormList.add(dataForm);

                    oos.writeObject(dataFormList);
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }

            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                phone.setText(null);
                email.setText(null);
                name.setText(null);
                address.setText(null);
                radioButton.setSelected(false);
                radioButton_1.setSelected(false);
                comboBox.setSelectedItem("Select");
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                    dataFormList = (List<lw_second.DataForm>) ois.readObject();

                    textArea.setText("");
                    for (lw_second.DataForm d : dataFormList)
                        textArea.append(d.toString());


                } catch (IOException | ClassNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
    }
}