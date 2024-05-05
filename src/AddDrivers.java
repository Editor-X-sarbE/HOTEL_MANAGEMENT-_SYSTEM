import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.EventObject;

public class AddDrivers implements ActionListener {
    JFrame display;
    Container c;
    JLabel background, studentfeetxt, rollnotxt, agetxt, carnumbertxt, nametxt, phonenotxt, carmodeltxt, semestertxt,
            avilavletxt, locationtxt;
    JTextField namefld, carmodelfld, agefld, phonenofld, locationfld, carnumberfld;
    JButton updatebtn, sumbitbtn, cancelbtnl;
    JComboBox gender,avilavlefld;
    Choice rollnofld;

    public AddDrivers() {
        display = new JFrame();
        display.setBounds(-8, 0, 1390, 775);
        display.setTitle("ADD_DRIVERS_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = display.getContentPane();

        // Student fee txt
        studentfeetxt = new JLabel("ADD DRIVERS PAGE");
        studentfeetxt.setBounds(490, 20, 800, 100);
        studentfeetxt.setForeground(Color.gray);
        studentfeetxt.setFont(new Font("name", Font.BOLD, 45));
        c.add(studentfeetxt);

        // name txt
        nametxt = new JLabel("👉 ENTER NAME ");
        nametxt.setBounds(1130, 120, 800, 100);
        nametxt.setForeground(Color.lightGray);
        nametxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(nametxt); // COMBINE
        namefld = new JTextField();
        namefld.setBounds(820, 155, 280, 30);
        namefld.setForeground(Color.white);
        namefld.setFont(new Font("name", Font.BOLD, 23));
        namefld.setOpaque(false);
        // namefld.setEditable(false);
        c.add(namefld);

        // course txt
        phonenotxt = new JLabel("👉 PHONE_NO ");
        phonenotxt.setBounds(1130, 405, 800, 100);
        phonenotxt.setForeground(Color.lightGray);
        phonenotxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(phonenotxt); // COMBINE
        phonenofld = new JTextField();
        phonenofld.setBounds(820, 440, 280, 30);
        phonenofld.setForeground(Color.white);
        phonenofld.setFont(new Font("name", Font.BOLD, 23));
        phonenofld.setOpaque(false);
        // phonenofld.setEditable(false);
        c.add(phonenofld);

        // fathername txt
        carnumbertxt = new JLabel("👉 CAR NUMBER ");
        carnumbertxt.setBounds(1130, 295, 800, 100);
        carnumbertxt.setForeground(Color.lightGray);
        carnumbertxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(carnumbertxt); // COMBINE
        // String job[] = { "<-select->", "Job_1 ", "Job_2 " };
        carnumberfld = new JTextField();
        carnumberfld.setBounds(820, 330, 280, 30);
        carnumberfld.setForeground(Color.white);
        carnumberfld.setBackground(Color.lightGray);
        carnumberfld.setFont(new Font("name", Font.BOLD, 23));
        carnumberfld.setOpaque(false);
        //carnumberfld.setEditable(false);
        c.add(carnumberfld);

        // Branch txt
        carmodeltxt = new JLabel("👉 CAR MODEL ");
        carmodeltxt.setBounds(1130, 345, 800, 100);
        carmodeltxt.setForeground(Color.lightGray);
        carmodeltxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(carmodeltxt); // COMBINE
        carmodelfld = new JTextField();
        carmodelfld.setBounds(820, 380, 280, 30);
        carmodelfld.setForeground(Color.white);
        carmodelfld.setFont(new Font("name", Font.BOLD, 23));
        carmodelfld.setOpaque(false);
        // carmodelfld.setEditable(false);
        c.add(carmodelfld);
        /*
         * try
         * {
         * Connector c= new Connector();
         * ResultSet rs = c.s.executeQuery("select * from student");
         * while(rs.next())
         * {
         * branchfld.add(rs.getString("branch"));
         * }
         * }
         * catch (Exception e)
         * {
         * e.printStackTrace();
         * }
         */

        avilavletxt = new JLabel("👉 AVILAVLE ");
        avilavletxt.setBounds(1130, 465, 800, 100);
        avilavletxt.setForeground(Color.lightGray);
        avilavletxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(avilavletxt); // COMBINE
        String avl[] = { "<-select->", "Avilavle ", "Reserved " };
        avilavlefld = new JComboBox(avl);
        avilavlefld.setBounds(820, 500, 280, 30);
        avilavlefld.setForeground(Color.darkGray);
        avilavlefld.setBackground(Color.lightGray);
        avilavlefld.setFont(new Font("name", Font.BOLD, 23));
        avilavlefld.setOpaque(false);
        // avilavlefld.setEditable(false);
        c.add(avilavlefld);

        locationtxt = new JLabel("👉 LOCATION ");
        locationtxt.setBounds(1130, 515, 800, 100);
        locationtxt.setForeground(Color.lightGray);
        locationtxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(locationtxt); // COMBINE
        locationfld = new JTextField();
        locationfld.setBounds(820, 550, 280, 30);
        locationfld.setForeground(Color.white);
        locationfld.setFont(new Font("name", Font.BOLD, 23));
        locationfld.setOpaque(false);
        // locationfld.setEditable(false);
        c.add(locationfld);

        // Semester txt
        semestertxt = new JLabel("👉 GENDER ");
        semestertxt.setBounds(1130, 240, 800, 100);
        semestertxt.setForeground(Color.lightGray);
        semestertxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(semestertxt); // COMBINE
        String sem[] = { "<-select->", "Male 🤵🏻‍♂️", "Female 🤵🏻‍♀️" };
        gender = new JComboBox(sem);
        gender.setBounds(820, 275, 280, 30);
        gender.setForeground(Color.darkGray);
        gender.setBackground(Color.lightGray);
        gender.setFont(new Font("name", Font.BOLD, 23));
        gender.setOpaque(false);
        c.add(gender);

        // Amount txt
        agetxt = new JLabel("👉 ENTER AGE ");
        agetxt.setBounds(1130, 180, 800, 100);
        agetxt.setForeground(Color.lightGray);
        agetxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(agetxt); // COMBINE
        agefld = new JTextField();
        agefld.setBounds(820, 220, 280, 30);
        agefld.setForeground(Color.white);
        agefld.setFont(new Font("name", Font.BOLD, 23));
        agefld.setOpaque(false);
        // agefld.setEditable(false);
        c.add(agefld);

        // BUTTONS
        updatebtn = new JButton("EXIT");
        updatebtn.setBounds(1100, 600, 120, 30);
        updatebtn.setFont(new Font("name", Font.BOLD, 18));
        updatebtn.setForeground(Color.red);
        updatebtn.setBackground(Color.cyan);
        updatebtn.setOpaque(false);
        updatebtn.addActionListener(this);
        c.add(updatebtn); // BUTTONS
        cancelbtnl = new JButton("CANCEL");
        cancelbtnl.setBounds(960, 600, 120, 30);
        cancelbtnl.setFont(new Font("name", Font.BOLD, 18));
        cancelbtnl.setForeground(Color.red);
        cancelbtnl.setBackground(Color.cyan);
        cancelbtnl.setOpaque(false);
        cancelbtnl.addActionListener(this);
        c.add(cancelbtnl); // BUTTONS
        sumbitbtn = new JButton("SUMBIT");
        sumbitbtn.setBounds(820, 600, 120, 30);
        sumbitbtn.setFont(new Font("name", Font.BOLD, 18));
        sumbitbtn.setForeground(Color.cyan);
        sumbitbtn.setBackground(Color.cyan);
        sumbitbtn.setOpaque(false);
        sumbitbtn.addActionListener(this);
        c.add(sumbitbtn); // BUTTONS

        // ImageIcon ic = new
        // ImageIcon(ClassLoader.getSystemResource("NewCustomer.jpg"));
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Driverimage.jpg"));
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
            if (ae.getSource() == sumbitbtn) 
            {
                String Name = namefld.getText();
                String Age = agefld.getText();
                String Gender = (String) gender.getSelectedItem();
                String Car_Number = carnumberfld.getText();
                String Car_Model = carmodelfld.getText();
                String Phone_No = phonenofld.getText();
                String Avilavle = (String) avilavlefld.getSelectedItem();
                String Location = locationfld.getText();
                
                if ((Name.isEmpty() == false) && (Age.isEmpty() == false) && (Gender.isEmpty() == false)  && (Car_Number.isEmpty() == false)&& (Car_Model.isEmpty() == false)&& (Phone_No.isEmpty() == false)&& (Avilavle.isEmpty() == false)&& (Location.isEmpty() == false)) 
                {
                    try 
                    {
                    //                                               1             2                  3                 4              5                
                    String query = "insert into Add_Drivers values('"+Name+"', '"+Age+"', '"+Gender+"', '"+Car_Number+"', '"+Car_Model+"', '"+Phone_No+"', '"+Avilavle+"', '"+Location+"')";
                     
                     Connector con = new Connector();
                     con.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(display," HOTEL DETAILS INSERTED SUCCESSFULLY .:","POPUP",JOptionPane.INFORMATION_MESSAGE);
                     new HomePage();
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    JOptionPane.showMessageDialog(display," ERROR OCCURED IN DATABASES \n CAN'T STORE DATA SUCCESSFULLY.:","HELP",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(display, " INVALID  PLEASE  ENTER  VALID  DETAILS .:", "HELP",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (ae.getSource() == cancelbtnl) {
                new HomePage(); // home page
            }
            if (ae.getSource() == updatebtn) {
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(display, "INVALID CREDENTIAL ", "help", JOptionPane.DEFAULT_OPTION);
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }

}
