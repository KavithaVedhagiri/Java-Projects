package employeemanagement.system.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID;

    JButton delete,back;
    RemoveEmployee(){
        JLabel label = new JLabel("Employee ID :");
        label.setBounds(50,50,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,20);
        add(choiceEMPID);

        try{
           conn c = new conn();
           ResultSet resultSet = c.statement.executeQuery("select * from employee");
           while (resultSet.next()){
               choiceEMPID.add(resultSet.getString("empid"));
           }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(50,100,150,20);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,150,20);
        add(textName);

        JLabel labelPhone = new JLabel("Phone :");
        labelPhone.setBounds(50,150,150,20);
        labelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(200,150,150,20);
        add(textPhone);

        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setBounds(50,200,150,20);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,150,20);
        add(textEmail);
        try {
          conn c = new conn();
          ResultSet resultSet = c.statement.executeQuery("select * from employee where empid = '"+choiceEMPID.getSelectedItem()+"'");
          while (resultSet.next()){
              textName.setText(resultSet.getString("name"));
              textPhone.setText(resultSet.getString("phone"));
              textEmail.setText(resultSet.getString("email"));
          }
        }catch (Exception e){
            e.printStackTrace();
        }
        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empid = '"+choiceEMPID.getSelectedItem()+"'");
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.DARK_GRAY);
        delete.setForeground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image il1 = il.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon il2 = new ImageIcon(il1);
        JLabel img = new JLabel(il2);
        img.setBounds(600,80,250,200);
        add(img);

        ImageIcon il11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image il12 = il11.getImage().getScaledInstance(900,400,Image.SCALE_DEFAULT);
        ImageIcon il3 = new ImageIcon(il12);
        JLabel image = new JLabel(il3);
        image.setBounds(0,0,900,400);
        add(image);

        setSize(900,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            try{
               conn c = new conn();
               String query = "delete from employee where empid = '"+choiceEMPID.getSelectedItem()+"'";
               c.statement.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");
               setVisible(false);
               new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }


}
