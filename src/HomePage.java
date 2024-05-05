import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage implements ActionListener {
  JFrame display;
  Container c;
  JLabel background, usernmtxt, pswdtxt, adminlogintxt;
  JMenuBar menubar;
  JMenu hotelmanagement, admin, adminsocialprofile, aboutproject, exitt, bck, utility;
  JMenuItem receptionx, addemployee, addrooms, addrivers, adminsocialprofilex, aboutprojectx, exittx, bckx, calculator,
      notepad;
  // JTextField usernmfld;
  // JButton loginbtn,cancelbtnl;

  public HomePage() {
    display = new JFrame();
    display.setBounds(-8, -3, 1390, 775);
    display.setTitle("HOTEL_HOME_PAGE");
    display.setLayout(null);
    display.setResizable(true);
    display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    c = display.getContentPane();

    menubar = new JMenuBar();
    menubar.setBounds(0, 0, display.getWidth(), 20);
    menubar.setFont(new Font("name", Font.BOLD, 15));
    menubar.setOpaque(false);

    hotelmanagement = new JMenu("HotelManagement");
    hotelmanagement.setForeground(Color.darkGray);
    hotelmanagement.setFont(new Font("name", Font.BOLD, 16));

    admin = new JMenu("Admin");
    admin.setForeground(Color.darkGray);
    admin.setFont(new Font("name", Font.BOLD, 16));

    adminsocialprofile = new JMenu("AdminSocialProfile");
    adminsocialprofile.setForeground(Color.darkGray);
    adminsocialprofile.setFont(new Font("name", Font.BOLD, 16));

    aboutproject = new JMenu("About ");
    aboutproject.setForeground(Color.darkGray);
    aboutproject.setFont(new Font("name", Font.BOLD, 16));

    exitt = new JMenu("Exit");
    exitt.setForeground(Color.red);
    exitt.setFont(new Font("name", Font.BOLD, 16));

    bck = new JMenu("Back");
    bck.setForeground(Color.red);
    bck.setFont(new Font("name", Font.BOLD, 16));

    utility = new JMenu("Utility");
    utility.setForeground(Color.darkGray);
    utility.setFont(new Font("name", Font.BOLD, 16));

    // newinformtn=new JMenu("New Information");
    receptionx = new JMenuItem("Reception");
    receptionx.setBackground(Color.cyan);
    receptionx.setFont(new Font("name", Font.BOLD, 14));
    receptionx.addActionListener(this);
    hotelmanagement.add(receptionx);

    // viewdtls= new JMenuItem("View Details");
    addemployee = new JMenuItem("Add Employee");
    addemployee.addActionListener(this);
    admin.add(addemployee);
    addrooms = new JMenuItem("Add Rooms");
    addrooms.addActionListener(this);
    admin.add(addrooms);
    addrivers = new JMenuItem("Add Drivers");
    addrivers.addActionListener(this);
    admin.add(addrivers);

    adminsocialprofilex = new JMenuItem("AdminSocialProfilex");
    adminsocialprofilex.addActionListener(this);
    adminsocialprofile.add(adminsocialprofilex);

    aboutprojectx = new JMenuItem("AboutProjectx");
    aboutprojectx.addActionListener(this);
    aboutproject.add(aboutprojectx);

    exittx = new JMenuItem("Exitx");
    exittx.addActionListener(this);
    exitt.add(exittx);

    bckx = new JMenuItem("Backx");
    bckx.addActionListener(this);
    bck.add(bckx);

    calculator = new JMenuItem("Calculatorx");
    calculator.addActionListener(this);
    utility.add(calculator);

    notepad = new JMenuItem("Notepadx");
    notepad.addActionListener(this);
    utility.add(notepad);

    menubar.add(hotelmanagement);
    menubar.add(admin);
    menubar.add(adminsocialprofile);
    menubar.add(aboutproject);
    menubar.add(utility);
    menubar.add(bck);
    menubar.add(exitt);
    c.add(menubar);

    ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("HotelHomepage.jpg"));
    // ImageIcon ic = new
    // ImageIcon(ClassLoader.getSystemResource("HotelReception.jpg"));
    background = new JLabel();
    background.setBounds(0, 0, 1370, 770);
    Image ig = ic.getImage();
    Image ig2 = ig.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon ic2 = new ImageIcon(ig2);
    background.setIcon(ic2);
    c.add(background);

    display.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    try {
      if (ae.getSource()==addrivers) {
        new AddDrivers();
      }
      if (ae.getSource()==addrooms) {
         new AddRooms();
      }
      if (ae.getSource()==addemployee) {
          new AddEmployee();
      }
      if (ae.getSource() == receptionx) {
         new HotelReceptions();
      }
      if (ae.getSource() == null) // admin txt
      {
        JOptionPane.showMessageDialog(display,
            "Name :-Krishna Patra\n Gmail :- krishnapatra@gmail.com\n Contact :- 9178Xxxxxx\n Github :- KrishnaPatra .",
            "ADMIN SOCIAL PROFILE", JOptionPane.INFORMATION_MESSAGE);
      }
      if (ae.getSource() == null) // project txt 
      {
        JOptionPane.showMessageDialog(display,
            "The Hotel Management Project is made for store some \n Hotel informational data in the databases and \n only admin can operate the project . not any user can't operate .\n (PROJECT COMPLITING SOON).",
            "PROJECT", JOptionPane.INFORMATION_MESSAGE);
      }
      if (ae.getSource() == exittx) {
        System.exit(0); // SYSTEM EXIT.
      }
      if (ae.getSource() == bckx) {
        new WelComePage(); // >>> 
      }
      if (ae.getSource() == calculator) {
        try {
          Runtime.getRuntime().exec("calc.exe");
        } catch (Exception e) {
          System.out.println("an unexpected error occured");
        }
      }
      if (ae.getSource() == notepad) {
        try {
          Runtime.getRuntime().exec("notepad.exe");
        } catch (Exception e) {
          System.out.println("an unexpected error occured");
        }
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(display, "             INVALID DETAILS :\nPLEASE ENTER VALID DETAILS ", "HELP",
          JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public static void main(String[] args) {
    new HomePage();
  }
}
