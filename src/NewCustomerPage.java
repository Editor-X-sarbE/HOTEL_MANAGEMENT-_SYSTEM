import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.EventObject;

public class NewCustomerPage implements ActionListener 
{
    JFrame display;
    Container c;
    JLabel background, studentfeetxt, rollnotxt, roomnotxt, idtxt, phonenotxt, countrytxt, semestertxt,
            checktimetxt, diposittxttxt,nametxt;
    JTextField iffld, countryfld, phonenofld, checktimefld, dipositfld,namefld;
    JButton updatebtn, sumbitbtn, cancelbtnl;
    JComboBox gender, roomnofld;
    Choice rollnofld;

    public NewCustomerPage() 
    {
        display = new JFrame();
        display.setBounds(-8, -3, 1390, 775);
        display.setTitle("NEW_CUSTOMER_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = display.getContentPane();

        // Student fee txt
        studentfeetxt = new JLabel("NEW CUSTOMER PAGE");
        studentfeetxt.setBounds(450, 20, 800, 100);
        studentfeetxt.setForeground(Color.white);
        studentfeetxt.setFont(new Font("name", Font.BOLD, 45));
        c.add(studentfeetxt);

        // name txt
        idtxt = new JLabel("👉 ENTER I`D ");
        idtxt.setBounds(80, 120, 800, 100);
        idtxt.setForeground(Color.gray);
        idtxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(idtxt); // COMBINE
        iffld = new JTextField("I`D_");
        iffld.setBounds(380, 155, 280, 30);
        iffld.setForeground(Color.darkGray);
        iffld.setFont(new Font("name", Font.BOLD, 23));
        iffld.setOpaque(false);
        // iffld.setEditable(false);
        c.add(iffld);

        // course txt
        phonenotxt = new JLabel("👉 PHONE_NO ");
        phonenotxt.setBounds(80, 180, 800, 100);
        phonenotxt.setForeground(Color.gray);
        phonenotxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(phonenotxt); // COMBINE
        phonenofld = new JTextField();
        phonenofld.setBounds(380, 220, 280, 30);
        phonenofld.setForeground(Color.darkGray);
        phonenofld.setFont(new Font("name", Font.BOLD, 23));
        phonenofld.setOpaque(false);
        // phonenofld.setEditable(false);
        c.add(phonenofld);

        // fathername txt
        roomnotxt = new JLabel("👉 ROOM NUMBER ");
        roomnotxt.setBounds(80, 295, 800, 100);
        roomnotxt.setForeground(Color.gray);
        roomnotxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(roomnotxt); // COMBINE
        String job[] = { "<-select->", "Room_101 ", "Room_102 ", "Room_103 ", "Room_104 ", "Room_105 " };
        roomnofld = new JComboBox(job);
        roomnofld.setBounds(380, 330, 280, 30);
        roomnofld.setForeground(Color.darkGray);
        roomnofld.setBackground(Color.lightGray);
        roomnofld.setFont(new Font("name", Font.BOLD, 23));
        roomnofld.setOpaque(false);
        roomnofld.setEditable(false);
        c.add(roomnofld);

        // Branch txt
        countrytxt = new JLabel("👉 COUNTRY ");
        countrytxt.setBounds(80, 345, 800, 100);
        countrytxt.setForeground(Color.darkGray);
        countrytxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(countrytxt); // COMBINE
        countryfld = new JTextField();
        countryfld.setBounds(380, 380, 280, 30);
        countryfld.setForeground(Color.darkGray);
        countryfld.setFont(new Font("name", Font.BOLD, 23));
        countryfld.setOpaque(false);
        // countryfld.setEditable(false);
        c.add(countryfld);

        checktimetxt = new JLabel("👉 CHECK_IN_TIME ");
        checktimetxt.setBounds(80, 465, 800, 100);
        checktimetxt.setForeground(Color.darkGray);
        checktimetxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(checktimetxt); // COMBINE
        checktimefld = new JTextField();
        checktimefld.setBounds(380, 500, 280, 30);
        checktimefld.setForeground(Color.darkGray);
        checktimefld.setFont(new Font("name", Font.BOLD, 23));
        checktimefld.setOpaque(false);
        // checktimefld.setEditable(false);
        c.add(checktimefld);

        diposittxttxt = new JLabel("👉 DIPOSIT_AMT ");
        diposittxttxt.setBounds(80, 515, 800, 100);
        diposittxttxt.setForeground(Color.darkGray);
        diposittxttxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(diposittxttxt); // COMBINE
        dipositfld = new JTextField();
        dipositfld.setBounds(380, 550, 280, 30);
        dipositfld.setForeground(Color.darkGray);
        dipositfld.setFont(new Font("name", Font.BOLD, 23));
        dipositfld.setOpaque(false);
        // dipositfld.setEditable(false);
        c.add(dipositfld);

        // Semester txt
        semestertxt = new JLabel("👉 GENDER ");
        semestertxt.setBounds(80, 240, 800, 100);
        semestertxt.setForeground(Color.gray);
        semestertxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(semestertxt); // COMBINE
        String sem[] = { "<-select->", "Male 🤵🏻‍♂️", "Female 🤵🏻‍♀️" };
        gender = new JComboBox(sem);
        gender.setBounds(380, 275, 280, 30);
        gender.setForeground(Color.darkGray);
        gender.setBackground(Color.lightGray);
        gender.setFont(new Font("name", Font.BOLD, 23));
        gender.setOpaque(false);
        c.add(gender);

        // Amount txt
        nametxt = new JLabel("👉 ENTER_NAME ");
        nametxt.setBounds(80, 405, 800, 100);
        nametxt.setForeground(Color.darkGray);
        nametxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(nametxt); // COMBINE
        namefld = new JTextField();
        namefld.setBounds(380, 440, 280, 30);
        namefld.setForeground(Color.darkGray);
        namefld.setFont(new Font("name", Font.BOLD, 23));
        namefld.setOpaque(false);
        // namefld.setEditable(false);
        c.add(namefld);

        // BUTTONS
        updatebtn = new JButton("EXIT");
        updatebtn.setBounds(360, 635, 120, 30);
        updatebtn.setFont(new Font("name", Font.BOLD, 18));
        updatebtn.setForeground(Color.red);
        updatebtn.setBackground(Color.cyan);
        updatebtn.setOpaque(false);
        updatebtn.addActionListener(this);
        c.add(updatebtn); // BUTTONS
        cancelbtnl = new JButton("CANCEL");
        cancelbtnl.setBounds(220, 635, 120, 30);
        cancelbtnl.setFont(new Font("name", Font.BOLD, 18));
        cancelbtnl.setForeground(Color.red);
        cancelbtnl.setBackground(Color.cyan);
        cancelbtnl.setOpaque(false);
        cancelbtnl.addActionListener(this);
        c.add(cancelbtnl); // BUTTONS
        sumbitbtn = new JButton("SUMBIT");
        sumbitbtn.setBounds(80, 635, 120, 30);
        sumbitbtn.setFont(new Font("name", Font.BOLD, 18));
        sumbitbtn.setForeground(Color.cyan);
        sumbitbtn.setBackground(Color.cyan);
        sumbitbtn.setOpaque(false);
        sumbitbtn.addActionListener(this);
        c.add(sumbitbtn); // BUTTONS

        // ImageIcon ic = new
        // ImageIcon(ClassLoader.getSystemResource("NewCustomer.jpg"));
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("NewCustomer.jpg"));
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
                String Id = iffld.getText();
                String Phone_No = phonenofld.getText();
                String Gender = (String) gender.getSelectedItem();
                String Room_Number = (String) roomnofld.getSelectedItem();
                String Country = countryfld.getText();
                String Name = namefld.getText();
                String Check_In_Time = checktimefld.getText();
                String Diposit_Amt = dipositfld.getText();

                if ((Id.isEmpty() == false) && (Phone_No.isEmpty() == false) && (Gender.isEmpty() == false)  && (Room_Number.isEmpty() == false)&& (Country.isEmpty() == false)&& (Name.isEmpty() == false)&& (Check_In_Time.isEmpty() == false)&& (Diposit_Amt.isEmpty() == false)) 
                {
                    try 
                    {
                    //                                               1             2                  3                 4              5                
                    String query = "insert into New_Customer values('"+Id+"', '"+Phone_No+"', '"+Gender+"', '"+Room_Number+"', '"+Country+"', '"+Name+"', '"+Check_In_Time+"', '"+Diposit_Amt+"')";
                     
                     Connector con = new Connector();
                     con.s.executeUpdate(query);
                     JOptionPane.showMessageDialog(display," HOTEL DETAILS INSERTED SUCCESSFULLY .:","POPUP",JOptionPane.INFORMATION_MESSAGE);
                     new HotelReceptions();
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
                new HotelReceptions(); // home page
            }
            if (ae.getSource() == updatebtn) {
                System.exit(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(display, "INVALID CREDENTIAL ", "help", JOptionPane.DEFAULT_OPTION);
        }
    }

    public static void main(String[] args) {
        new NewCustomerPage();
    }
}
