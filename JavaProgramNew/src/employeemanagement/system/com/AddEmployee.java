package employeemanagement.system.com;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation,tfield;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox Boxeducation;
    JButton add, back;
    AddEmployee(){
        getContentPane().setBackground(new Color(0,128,128));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(300,25,500,50);
        heading.setFont(new Font("serif",Font.BOLD,23));
        add(heading);

        JLabel name = new JLabel("Name :");
        name.setBounds(50,100,150,20);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(name);
        tname = new JTextField();
        tname.setBounds(210,100,150,20);
        tname.setBackground(new Color(224,255,255));
        add(tname);

        JLabel fname = new JLabel("Father's Name :");
        fname.setBounds(430,100,200,20);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(630,100,150,20);
        tfname.setBackground(new Color(224,255,255));
        add(tfname);

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setBounds(50,150,150,20);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(210,150,150,20);
        tdob.setBackground(new Color(224,255,255));
        add(tdob);

        JLabel salary = new JLabel("Salary :");
        salary.setBounds(430,150,200,20);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(salary);

        tsalary= new JTextField();
        tsalary.setBounds(630,150,150,20);
        tsalary.setBackground(new Color(224,255,255));
        add(tsalary);

        JLabel address = new JLabel("Address :");
        address.setBounds(50,200,150,20);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(210,200,150,20);
        taddress.setBackground(new Color(224,255,255));
        add(taddress);

        JLabel phone = new JLabel("Phone :");
        phone.setBounds(430,200,200,20);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(630,200,150,20);
        tphone.setBackground(new Color(224,255,255));
        add(tphone);

        JLabel email = new JLabel("Email :");
        email.setBounds(50,250,150,20);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(email);

        temail = new JTextField();
        temail.setBounds(210,250,150,20);
        temail.setBackground(new Color(224,255,255));
        add(temail);

        JLabel education = new JLabel("Highest Education :");
        education.setBounds(430,250,200,20);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(education);

        String items[] = {"B.E","BBA","B.Tech","BCA","BA","BSC","B.COM","MBA","MCA","MA","MTech","MSC","PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(224,255,255));
        Boxeducation.setBounds(630,250,150,20);
        add(Boxeducation);

        JLabel designation = new JLabel("Designation :");
        designation.setBounds(50,300,150,20);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(210,300,150,20);
        tdesignation.setBackground(new Color(224,255,255));
        add(tdesignation);

        JLabel aadhar = new JLabel("Aadhar :");
        aadhar.setBounds(430,300,200,20);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(630,300,150,20);
        taadhar.setBackground(new Color(224,255,255));
        add(taadhar);

        JLabel empid = new JLabel("Employee ID :");
        empid.setBounds(50,350,150,20);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(210,350,150,20);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,17));
        tempid.setForeground(Color.red);
        add(tempid);

        add = new JButton("ADD");
        add.setBounds(240,420,150,40);
        add.setBackground(Color.DARK_GRAY);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(420,420,150,40);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setSize(850,550);
        setLocation(300,70);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String)Boxeducation.getSelectedItem();
            String aadhar = taadhar.getText();
            String designation = tdesignation.getText();
            String empid = tempid.getText();
            try{
                conn c = new conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+aadhar+"','"+designation+"','"+empid+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else if (e.getSource() == back) {
            System.exit(100);
        }
    }

    public static void main(String[] args) {

        new AddEmployee();
    }
}
