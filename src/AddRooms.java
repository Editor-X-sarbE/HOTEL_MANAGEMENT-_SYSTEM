import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.EventObject;

public class AddRooms implements ActionListener {
    JFrame display;
    Container c;
    JLabel background, studentfeetxt, avilavletxt, bedtypetxt, roomnotxt, pricetxt, cleaningtxt;
    JTextField roomnofld, pricefld;
    JButton updatebtn, addroombtn, cancelbtnl;
    JComboBox cleaningfld, bedtype, avilavlefld;
    Choice rollnofld;

    public AddRooms() 
    {
        display = new JFrame();
        display.setBounds(-8, 0, 1390, 775);
        display.setTitle("ADD_ROOMS_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = display.getContentPane();

        // Student fee txt
        studentfeetxt = new JLabel("ADD ROOMS PAGE");
        studentfeetxt.setBounds(370, 20, 800, 100);
        studentfeetxt.setForeground(Color.white);
        studentfeetxt.setFont(new Font("name", Font.BOLD, 45));
        c.add(studentfeetxt);

        // name txt
        roomnotxt = new JLabel("👉 ROOM NO ");
        roomnotxt.setBounds(180, 120, 800, 100);
        roomnotxt.setForeground(Color.darkGray);
        roomnotxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(roomnotxt); // COMBINE
        roomnofld = new JTextField();
        roomnofld.setBounds(460, 155, 280, 30);
        roomnofld.setForeground(Color.darkGray);
        roomnofld.setFont(new Font("name", Font.BOLD, 23));
        roomnofld.setOpaque(false);
        // roomnofld.setEditable(false);
        c.add(roomnofld);

        // fathername txt
        bedtypetxt = new JLabel("👉 BED TYPE");
        bedtypetxt.setBounds(180, 295, 800, 100);
        bedtypetxt.setForeground(Color.darkGray);
        bedtypetxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(bedtypetxt); // COMBINE
        String bed[] = { "<-select->", "Single bed ", "Double bed " };
        bedtype = new JComboBox(bed);
        bedtype.setBounds(460, 330, 280, 30);
        bedtype.setForeground(Color.darkGray);
        bedtype.setBackground(Color.lightGray);
        bedtype.setFont(new Font("name", Font.BOLD, 23));
        bedtype.setOpaque(false);
        bedtype.setEditable(false);
        c.add(bedtype);

        // Branch txt
        pricetxt = new JLabel("👉      PRICE  ");
        pricetxt.setBounds(180, 345, 800, 100);
        pricetxt.setForeground(Color.darkGray);
        pricetxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(pricetxt); // COMBINE
        pricefld = new JTextField();
        pricefld.setBounds(460, 380, 280, 30);
        pricefld.setForeground(Color.darkGray);
        pricefld.setFont(new Font("name", Font.BOLD, 23));
        pricefld.setOpaque(false);
        // pricefld.setEditable(false);
        c.add(pricefld);

        // Semester txt
        cleaningtxt = new JLabel("👉 CLEANING STATUS ");
        cleaningtxt.setBounds(180, 240, 800, 100);
        cleaningtxt.setForeground(Color.darkGray);
        cleaningtxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(cleaningtxt); // COMBINE
        String cln[] = { "<-select->", "Not Cleaned ", "Cleaned " };
        cleaningfld = new JComboBox(cln);
        cleaningfld.setBounds(460, 275, 280, 30);
        cleaningfld.setForeground(Color.darkGray);
        cleaningfld.setBackground(Color.lightGray);
        cleaningfld.setFont(new Font("name", Font.BOLD, 23));
        cleaningfld.setOpaque(false);
        c.add(cleaningfld);

        // Amount txt
        avilavletxt = new JLabel("👉 ROOM AVILAVEL ");
        avilavletxt.setBounds(180, 180, 800, 100);
        avilavletxt.setForeground(Color.darkGray);
        avilavletxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(avilavletxt); // COMBINE
        String avlvl[] = { "<-select->", "Avilavle", "Not Avilavle" };
        avilavlefld = new JComboBox(avlvl);
        avilavlefld.setBounds(460, 220, 280, 30);
        avilavlefld.setForeground(Color.darkGray);
        avilavlefld.setBackground(Color.lightGray);
        avilavlefld.setFont(new Font("name", Font.BOLD, 23));
        avilavlefld.setOpaque(false);
        // avilavlefld.setEditable(false);
        c.add(avilavlefld);

        // BUTTONS
        updatebtn = new JButton("EXIT");
        updatebtn.setBounds(480, 600, 120, 30);
        updatebtn.setFont(new Font("name", Font.BOLD, 18));
        updatebtn.setForeground(Color.red);
        updatebtn.setBackground(Color.cyan);
        updatebtn.setOpaque(false);
        updatebtn.addActionListener(this);
        c.add(updatebtn); // BUTTONS
        cancelbtnl = new JButton("CANCEL");
        cancelbtnl.setBounds(340, 600, 120, 30);
        cancelbtnl.setFont(new Font("name", Font.BOLD, 18));
        cancelbtnl.setForeground(Color.red);
        cancelbtnl.setBackground(Color.cyan);
        cancelbtnl.setOpaque(false);
        cancelbtnl.addActionListener(this);
        c.add(cancelbtnl); // BUTTONS
        addroombtn = new JButton("ADD ROOM");
        addroombtn.setBounds(180, 600, 140, 30);
        addroombtn.setFont(new Font("name", Font.BOLD, 18));
        addroombtn.setForeground(Color.cyan);
        addroombtn.setBackground(Color.cyan);
        addroombtn.setOpaque(false);
        addroombtn.addActionListener(this);
        c.add(addroombtn); // BUTTONS

        // ImageIcon ic = new
        // ImageIcon(ClassLoader.getSystemResource("NewCustomer.jpg"));
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Roomsimage.jpg"));
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
        try {
            if (ae.getSource() == addroombtn) 
            {
                String RoomNo = roomnofld.getText();
                String Room_Avlvl = (String) avilavlefld.getSelectedItem();
                String Clean_Sts = (String) cleaningfld.getSelectedItem();
                String Bed_Type = (String) bedtype.getSelectedItem();
                String Price = pricefld.getText();

                if ((RoomNo.isEmpty() == false) && (Room_Avlvl.isEmpty() == false) && (Clean_Sts.isEmpty() == false)  && (Bed_Type.isEmpty() == false)&& (Price.isEmpty() == false)) 
                {
                    try 
                    {
                    //                                               1             2                  3                 4              5                
                    String query = "insert into Add_room values('"+RoomNo+"', '"+Room_Avlvl+"', '"+Clean_Sts+"', '"+Bed_Type+"', '"+Price+"')";
                     
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
        new AddRooms();
    }

}
