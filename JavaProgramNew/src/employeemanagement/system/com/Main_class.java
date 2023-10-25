package employeemanagement.system.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame{
    Main_class(){
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image im1 = im.getImage().getScaledInstance(900,500, Image.SCALE_DEFAULT);
        ImageIcon im2 = new ImageIcon(im1);
        JLabel img = new JLabel(im2);
        img.setBounds(0,0,900,500);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(250,120,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,19));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(260,200,160,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.DARK_GRAY);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });

        img.add(add);


        JButton view = new JButton("View Employee");
        view.setBounds(430,200,160,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.DARK_GRAY);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmpolyee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(340,270,170,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.DARK_GRAY);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
                setVisible(false);
            }
        });
        img.add(rem);


        setSize(900,500);
        setLocation(200,100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {

        new Main_class();new Main_class();
    }
}
