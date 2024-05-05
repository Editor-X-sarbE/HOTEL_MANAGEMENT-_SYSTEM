import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotelReceptions implements ActionListener 
{
    JFrame display;
    Container c;
    JLabel background, usernmtxt, pswdtxt, adminlogintxt, receptiontxt;
    JMenuBar menubar;
    JMenu servicestxt, admin, adminsocialprofile, aboutproject, exitt, bck, utility;
    JMenuItem receptionx, addemployee, addrooms, addrivers, adminsocialprofilex, aboutprojectx, exittx, bckx,
            calculator,notepad,newcustomerbtn,roomsbtn,departmentbtn,allemployebtn,customerinfobtn,managerinfobtn,checkoutbtn,updtroomsbtn,pickupsrvbtn,searchroombtn,backbtn,exitbtn;
    // JTextField usernmfld;
    //JButton newcustomerbtn,roomsbtn,departmentbtn,allemployebtn,customerinfobtn,managerinfobtn,checkoutbtn,updtroomsbtn,pickupsrvbtn,searchroombtn,backbtn,exitbtn;

    public HotelReceptions() 
    {
        display = new JFrame();
        display.setBounds(-8, -5, 1390, 782);
        display.setTitle("HOTEL_RECEPTION_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = display.getContentPane();

        receptiontxt = new JLabel("✨ RECEPTIONS 🎉");
        receptiontxt.setBounds(870, 20, 800, 100);
        receptiontxt.setForeground(Color.white);
        receptiontxt.setFont(new Font("name", Font.BOLD, 45));
        c.add(receptiontxt);

        menubar = new JMenuBar();
        menubar.setBounds(0, 0, display.getWidth(), 20);
        menubar.setFont(new Font("name", Font.BOLD, 15));
        menubar.setOpaque(false);

        servicestxt = new JMenu(" Avilavle Services🔰 ");
        servicestxt.setForeground(Color.lightGray);
        servicestxt.setFont(new Font("name", Font.BOLD, 16));

        admin = new JMenu("Admin🔰 ");
        admin.setForeground(Color.darkGray);
        admin.setFont(new Font("name", Font.BOLD, 16));

        adminsocialprofile = new JMenu("AdminSocialProfile🔰 ");
        adminsocialprofile.setForeground(Color.darkGray);
        adminsocialprofile.setFont(new Font("name", Font.BOLD, 16));

        aboutproject = new JMenu("About🔰 ");
        aboutproject.setForeground(Color.darkGray);
        aboutproject.setFont(new Font("name", Font.BOLD, 16));

        exitt = new JMenu("Exit🔰 ");
        exitt.setForeground(Color.red);
        exitt.setFont(new Font("name", Font.BOLD, 16));

        bck = new JMenu("Back🔰 ");
        bck.setForeground(Color.red);
        bck.setFont(new Font("name", Font.BOLD, 16));

        utility = new JMenu("Utility🔰 ");
        utility.setForeground(Color.darkGray);
        utility.setFont(new Font("name", Font.BOLD, 16));

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

        newcustomerbtn = new JMenuItem("New Customer ");
        newcustomerbtn.setFont(new Font("name", Font.BOLD, 16));
        newcustomerbtn.addActionListener(this);
        servicestxt.add(newcustomerbtn);

        roomsbtn = new JMenuItem("View Rooms ");
        roomsbtn.setFont(new Font("name", Font.BOLD, 16));
        roomsbtn.addActionListener(this);
        servicestxt.add(roomsbtn);

        departmentbtn = new JMenuItem("Department ");
        departmentbtn.setFont(new Font("name", Font.BOLD, 16));
        departmentbtn.addActionListener(this);
        servicestxt.add(departmentbtn);

        allemployebtn = new JMenuItem("All Employee ");
        allemployebtn.setFont(new Font("name", Font.BOLD, 16));
        allemployebtn.addActionListener(this);
        servicestxt.add(allemployebtn);

        customerinfobtn = new JMenuItem("Customer Info ");
        customerinfobtn.setFont(new Font("name", Font.BOLD, 16));
        customerinfobtn.addActionListener(this);
        servicestxt.add(customerinfobtn);

        managerinfobtn = new JMenuItem("Manager Info ");
        managerinfobtn.setFont(new Font("name", Font.BOLD, 16));
        managerinfobtn.addActionListener(this);
        servicestxt.add(managerinfobtn);

        checkoutbtn = new JMenuItem("Check Out ");
        checkoutbtn.setFont(new Font("name", Font.BOLD, 16));
        checkoutbtn.addActionListener(this);
        servicestxt.add(checkoutbtn);

        updtroomsbtn = new JMenuItem("Update Rooms ");
        updtroomsbtn.setFont(new Font("name", Font.BOLD, 16));
        updtroomsbtn.addActionListener(this);
        servicestxt.add(updtroomsbtn);

        pickupsrvbtn = new JMenuItem("Pickup Service ");
        pickupsrvbtn.setFont(new Font("name", Font.BOLD, 16));
        pickupsrvbtn.addActionListener(this);
        servicestxt.add(pickupsrvbtn);

        searchroombtn = new JMenuItem("Search Rooms ");
        searchroombtn.setFont(new Font("name", Font.BOLD, 16));
        searchroombtn.addActionListener(this);
        servicestxt.add(searchroombtn);

        backbtn = new JMenuItem("Logout ");
        backbtn.setFont(new Font("name", Font.BOLD, 16));
        backbtn.addActionListener(this);
        servicestxt.add(backbtn);

        menubar.add(servicestxt);
        menubar.add(admin);
        menubar.add(adminsocialprofile);
        menubar.add(aboutproject);
        menubar.add(utility);
        menubar.add(bck);
        menubar.add(exitt);
        c.add(menubar);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("HotelReception.jpg"));
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

    public void actionPerformed(ActionEvent ae) 
    {
        try 
        {
            if (ae.getSource()==addemployee) {
                new AddEmployee();
            }
            if (ae.getSource()==addrivers) {
                new AddDrivers();
            }
            if (ae.getSource()==addrooms) {
                new AddRooms();
            }


            if (ae.getSource() == newcustomerbtn) {
                new NewCustomerPage();
            }
            if (ae.getSource()==roomsbtn) {
                new ViewRooms();
            }
            if (ae.getSource()==departmentbtn) {
                new Department();
            }
            if (ae.getSource()==allemployebtn) {
                new AllEmployee();
            }
            if (ae.getSource()==customerinfobtn) {
                new ViewCustomerInfo();
            }
            if (ae.getSource()==managerinfobtn) {
                new ViewManagerInfo();
            }
            if (ae.getSource()==checkoutbtn) {
                new CheckOutRoom();
            }
            if (ae.getSource()==pickupsrvbtn) {
                new PickupService();
            }
            if (ae.getSource()==updtroomsbtn) {
                new UpdateRoomStatus();
            }
            if (ae.getSource()==backbtn) {
                new WelComePage();
            }if (ae.getSource()==searchroombtn) {
                new SearchRoom();
            }
            if (ae.getSource() == adminsocialprofilex) // admin txt 
            {
                JOptionPane.showMessageDialog(display,
                        "Name :-Sarbeswar Rout\n Gmail :- routsarbeswar29@gmail.com\n Contact :- 9178Xxxxxx\n Github :- Editor_x_sarbE .",
                        "ADMIN SOCIAL PROFILE", JOptionPane.INFORMATION_MESSAGE);
            }

            if (ae.getSource() == aboutprojectx) // project txt
            {
                JOptionPane.showMessageDialog(display,
                        "The University Management Project is made for store some \n university informational data in the databases and \n only admin can operate the project . not any user can't operate .\n (PROJECT COMPLITING SOON).",
                        "PROJECT", JOptionPane.INFORMATION_MESSAGE);
            }

            if (ae.getSource() == exittx) {
                System.exit(0); // SYSTEM EXIT.
            }

            if (ae.getSource() == bckx) {
                new HomePage(); // >>>
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
            JOptionPane.showMessageDialog(display, "             INVALID DETAILS :\nPLEASE ENTER VALID DETAILS ",
                    "HELP",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new HotelReceptions();
    }
}
