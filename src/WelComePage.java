import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelComePage implements ActionListener {
    static int x = 1;
    JFrame display;
    Container c;
    JLabel background, welcometxt;
    JButton welcomebtn,studentpagebtn;

    public WelComePage() 
    {
        display = new JFrame();
        display.setBounds(-8, -3, 1390, 775);
        display.setTitle("HOTEL_WELCOME_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // display.addActionListener(this);
        c = display.getContentPane();

        welcometxt = new JLabel("WELCOME");
        welcometxt.setBounds(520, 60, 1000, 70);
        welcometxt.setForeground(Color.DARK_GRAY);
        welcometxt.setFont(new Font("name", Font.BOLD, 80));
        // c.add(welcometxt);

        ////////////////// HOMEPAGE BUTON VISIBLE (OFF) ///////////////////
        welcomebtn = new JButton("NEXT ⏩");
        welcomebtn.setBounds(1240, 689, 120, 40);
        welcomebtn.setBackground(Color.darkGray);
        welcomebtn.setForeground(Color.white);
        //welcomebtn.setOpaque(false);
        welcomebtn.setFont(new Font("name",Font.BOLD,19));
        welcomebtn.addActionListener(this);
        c.add(welcomebtn);

        studentpagebtn = new JButton("STUDENT");
        studentpagebtn.setBounds(1250, 50, 100, 30);
        studentpagebtn.setBackground(Color.gray);
        //studentpagebtn.setOpaque(false);
        studentpagebtn.setFont(new Font("name",Font.BOLD,14));
        studentpagebtn.addActionListener(this);
        //c.add(studentpagebtn);12345

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("WelComePageimg.jpg"));
        //ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("www.jpg"));
        background = new JLabel();
        background.setBounds(0, 0, 1370, 770);
        Image ig = ic.getImage();
        Image ig2 = ig.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(ig2);
        background.setIcon(ic2);
        // background.addActionListener(this);
        // Thread.sleep(10);
        c.add(background);

        display.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        try 
        {
            if (ae.getSource() == welcomebtn) 
            {
                 new LoginPage();
                 //display.setVisible(false);
            }
            if (ae.getSource()==studentpagebtn) 
            {
               // new StudentLoginPage();
            }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(display, "             INVALID DETAILS :\nPLEASE ENTER VALID DETAILS ",
                    "HELP", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) 
    {
        new WelComePage();
    }
}
// ctrl+y >> forward
// ctrl+q >>formay document
// ctrl+d >>once change
// alt+shift+downarrow >> duplicate 