import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.EventObject;

public class AddEmployee implements ActionListener {
    JFrame display;
    Container c;
    JLabel background, studentfeetxt, rollnotxt, agetxt, jobtypetxt, nametxt, phonenotxt, salarytxt, semestertxt,
            emailtxt, addhartxt;
    JTextField namefld, salaryfld, agefld, phonenofld, emailfld, addharfld;
    JButton updatebtn, sumbitbtn, cancelbtnl;
    JComboBox gender, jobtype;
    Choice rollnofld;

    public AddEmployee() {
        display = new JFrame();
        display.setBounds(-8, 0, 1390, 775);
        display.setTitle("ADD_EMPLOYEE_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = display.getContentPane();

        // Student fee txt
        studentfeetxt = new JLabel("ADD EMPLOYEE PAGE");
        studentfeetxt.setBounds(370, 20, 800, 100);
        studentfeetxt.setForeground(Color.white);
        studentfeetxt.setFont(new Font("name", Font.BOLD, 45));
        c.add(studentfeetxt);

        // name txt
        nametxt = new JLabel("👉 ENTER NAME ");
        nametxt.setBounds(980, 120, 800, 100);
        nametxt.setForeground(Color.lightGray);
        nametxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(nametxt); // COMBINE
        namefld = new JTextField();
        namefld.setBounds(680, 155, 280, 30);
        namefld.setForeground(Color.white);
        namefld.setFont(new Font("name", Font.BOLD, 23));
        namefld.setOpaque(false);
        // namefld.setEditable(false);
        c.add(namefld);

        // course txt
        phonenotxt = new JLabel("👉 PHONE_NO ");
        phonenotxt.setBounds(980, 405, 800, 100);
        phonenotxt.setForeground(Color.lightGray);
        phonenotxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(phonenotxt); // COMBINE
        phonenofld = new JTextField();
        phonenofld.setBounds(680, 440, 280, 30);
        phonenofld.setForeground(Color.white);
        phonenofld.setFont(new Font("name", Font.BOLD, 23));
        phonenofld.setOpaque(false);
        // phonenofld.setEditable(false);
        c.add(phonenofld);

        // fathername txt
        jobtypetxt = new JLabel("👉 JOB TYPE");
        jobtypetxt.setBounds(980, 295, 800, 100);
        jobtypetxt.setForeground(Color.lightGray);
        jobtypetxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(jobtypetxt); // COMBINE
        String job[] = { "<-select->", "Job_1 ", "Job_2 " };
        jobtype = new JComboBox(job);
        jobtype.setBounds(680, 330, 280, 30);
        jobtype.setForeground(Color.darkGray);
        jobtype.setBackground(Color.lightGray);
        jobtype.setFont(new Font("name", Font.BOLD, 23));
        jobtype.setOpaque(false);
        jobtype.setEditable(false);
        c.add(jobtype);

        // Branch txt
        salarytxt = new JLabel("👉 SALARY ");
        salarytxt.setBounds(980, 345, 800, 100);
        salarytxt.setForeground(Color.lightGray);
        salarytxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(salarytxt); // COMBINE
        salaryfld = new JTextField();
        salaryfld.setBounds(680, 380, 280, 30);
        salaryfld.setForeground(Color.white);
        salaryfld.setFont(new Font("name", Font.BOLD, 23));
        salaryfld.setOpaque(false);
        // salaryfld.setEditable(false);
        c.add(salaryfld);

        emailtxt = new JLabel("👉 ENTER_EMAIL ");
        emailtxt.setBounds(980, 465, 800, 100);
        emailtxt.setForeground(Color.lightGray);
        emailtxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(emailtxt); // COMBINE
        emailfld = new JTextField();
        emailfld.setBounds(680, 500, 280, 30);
        emailfld.setForeground(Color.white);
        emailfld.setFont(new Font("name", Font.BOLD, 20));
        emailfld.setOpaque(false);
        // emailfld.setEditable(false);
        c.add(emailfld);

        addhartxt = new JLabel("👉 ENTER_ADDHAR ");
        addhartxt.setBounds(980, 515, 800, 100);
        addhartxt.setForeground(Color.lightGray);
        addhartxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(addhartxt); // COMBINE
        addharfld = new JTextField();
        addharfld.setBounds(680, 550, 280, 30);
        addharfld.setForeground(Color.white);
        addharfld.setFont(new Font("name", Font.BOLD, 23));
        addharfld.setOpaque(false);
        // addharfld.setEditable(false);
        c.add(addharfld);

        // Semester txt
        semestertxt = new JLabel("👉 GENDER ");
        semestertxt.setBounds(980, 240, 800, 100);
        semestertxt.setForeground(Color.lightGray);
        semestertxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(semestertxt); // COMBINE
        String sem[] = { "<-select->", "Male 🤵🏻‍♂️", "Female 🤵🏻‍♀️" };
        gender = new JComboBox(sem);
        gender.setBounds(680, 275, 280, 30);
        gender.setForeground(Color.darkGray);
        gender.setBackground(Color.lightGray);
        gender.setFont(new Font("name", Font.BOLD, 23));
        gender.setOpaque(false);
        c.add(gender);

        // Amount txt
        agetxt = new JLabel("👉 ENTER AGE ");
        agetxt.setBounds(980, 180, 800, 100);
        agetxt.setForeground(Color.lightGray);
        agetxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(agetxt); // COMBINE
        agefld = new JTextField();
        agefld.setBounds(680, 220, 280, 30);
        agefld.setForeground(Color.white);
        agefld.setFont(new Font("name", Font.BOLD, 23));
        agefld.setOpaque(false);
        // agefld.setEditable(false);
        c.add(agefld);

        // BUTTONS
        updatebtn = new JButton("EXIT");
        updatebtn.setBounds(820, 600, 120, 30);
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
        sumbitbtn.setBounds(680, 600, 120, 30);
        sumbitbtn.setFont(new Font("name", Font.BOLD, 18));
        sumbitbtn.setForeground(Color.cyan);
        sumbitbtn.setBackground(Color.cyan);
        sumbitbtn.setOpaque(false);
        sumbitbtn.addActionListener(this);
        c.add(sumbitbtn); // BUTTONS

        // ImageIcon ic = new
        // ImageIcon(ClassLoader.getSystemResource("NewCustomer.jpg"));
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("AddHotelEmployee.jpg"));
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
                String Job_Type = (String) jobtype.getSelectedItem();
                String Salary = salaryfld.getText();
                String Phone_No = phonenofld.getText();
                String Email_Id = emailfld.getText();
                String Addhar_Id = addharfld.getText();

                if ((Name.isEmpty() == false) && (Age.isEmpty() == false) && (Gender.isEmpty() == false)  && (Job_Type.isEmpty() == false)&& (Salary.isEmpty() == false)&& (Phone_No.isEmpty() == false)&& (Email_Id.isEmpty() == false)&& (Addhar_Id.isEmpty() == false)) 
                {
                    try 
                    {
                    //                                               1             2                  3                 4              5                
                    String query = "insert into Add_Employee values('"+Name+"', '"+Age+"', '"+Gender+"', '"+Job_Type+"', '"+Salary+"', '"+Phone_No+"', '"+Email_Id+"', '"+Addhar_Id+"')";
                     
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
        new AddEmployee();
    }

}
