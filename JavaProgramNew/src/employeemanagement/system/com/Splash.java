package employeemanagement.system.com;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame {
    Splash(){
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image im2 = im.getImage().getScaledInstance(1000,600, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel image = new JLabel(im3);
        image.setBounds(0,0,1000,600);
        add(image);
        setSize(1000,600);
        setLocation(170,70);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        new Splash();
    }
}
