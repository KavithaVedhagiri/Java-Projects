package employeemanagement.system.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login() {
        JLabel username = new JLabel("Username :");
        username.setBounds(40, 30, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(130, 30, 150, 30);
        add(tusername);

        JLabel password = new JLabel("Password :");
        password.setBounds(40, 80, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(130, 80, 150, 30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(130, 160, 150, 30);
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(300, 160, 150, 30);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image im2 = im1.getImage().getScaledInstance(500, 250, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel img = new JLabel(im3);
        img.setBounds(350, 5, 500, 250);
        add(img);

        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image im11 = im.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon im22 = new ImageIcon(im11);
        JLabel imga = new JLabel(im22);
        imga.setBounds(0, 0, 600, 300);
        add(imga);

        setSize(600, 300);
        setLocation(450, 250);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try{
                String username = tusername.getText();
                String password = String.valueOf(tpassword.getPassword());
                conn con = new conn();
                String query = "select * from login where username = '"+username+"' and password = '"+password+"' ";
                ResultSet resultSet = con.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }catch (Exception c){
                c.printStackTrace();
            }


        } else if (e.getSource() == back) {
            System.exit(100);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
