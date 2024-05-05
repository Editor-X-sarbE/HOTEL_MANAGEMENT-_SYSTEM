import java.sql.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.proteanit.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewRooms  implements ActionListener
{
    JFrame display;
    Container c;
    JLabel background,viewstddtltxt,searchbartxt;
    Choice searchbarfld;
    JButton searchbtn,printbtn,addbtn,cancelbtn,updatebtn;
    JTable tablefld;
    public ViewRooms ()
    {
        display = new JFrame();
        display.setBounds(-5, 0, 1377, 775);
        display.setTitle("VIEW_HOTEL_ROOMS_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.getContentPane().setBackground(Color.yellow);
        c = display.getContentPane();

        //view student details
        viewstddtltxt = new JLabel("VIEW HOTEL ROOMS ");
        viewstddtltxt.setBounds(105,0,800,100);
        viewstddtltxt.setForeground(Color.darkGray);
        viewstddtltxt.setFont(new Font("name",Font.BOLD,45));
        c.add(viewstddtltxt);

        tablefld = new JTable();
        try 
        {
            Connector c= new Connector();
            ResultSet rs = c.s.executeQuery("select * from Add_room");
            tablefld.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        JScrollPane scroll = new JScrollPane(tablefld);
        scroll.setBounds(1, 250, 1365, 520);
        c.add(scroll);

        //printbtn
        printbtn= new JButton();
        printbtn.setBounds(100, 100, 100, 30);
        printbtn.setText("PRINT");
        printbtn.setFont(new Font("null",Font.BOLD,15));
        printbtn.setBackground(Color.cyan);
        printbtn.setForeground(Color.green);
        printbtn.setOpaque(false);
        printbtn.addActionListener(this);
        c.add(printbtn);

        //addnew student information
        addbtn= new JButton();
        addbtn.setBounds(350, 175, 100, 30);
        addbtn.setText("ADD");
        addbtn.setFont(new Font("null",Font.BOLD,15));
        addbtn.setBackground(Color.cyan);
        addbtn.setForeground(Color.green);
        addbtn.setOpaque(false);
        addbtn.addActionListener(this);
        //c.add(addbtn);

        //update btn
        updatebtn= new JButton();
        updatebtn.setBounds(220, 100, 100, 30);
        updatebtn.setText("EXIT");
        updatebtn.setFont(new Font("null",Font.BOLD,15));
        updatebtn.setBackground(Color.cyan);
        updatebtn.setForeground(Color.green);
        updatebtn.setOpaque(false);
        updatebtn.addActionListener(this);
        c.add(updatebtn);

        //cancel btn
        cancelbtn= new JButton();
        cancelbtn.setBounds(335, 100, 100, 30);
        cancelbtn.setText("BACK");
        cancelbtn.setFont(new Font("null",Font.BOLD,15));
        cancelbtn.setBackground(Color.cyan);
        cancelbtn.setForeground(Color.green);
        cancelbtn.setOpaque(false);
        cancelbtn.addActionListener(this);
        c.add(cancelbtn);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("UpdateRooms.jpg"));
        background = new JLabel();
        background.setBounds(0,0,1370,770);
        Image ig =ic.getImage();
        Image ig2= ig.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic2 = new ImageIcon(ig2);
        background.setIcon(ic2);
        c.add(background);

        display.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try 
        {
            if(ae.getSource()==printbtn)
            {
                try 
                {
                    tablefld.print();
                } 
                catch (Exception e) 
                {
                   e.printStackTrace();
                }
            }
            if (ae.getSource()==cancelbtn) 
            {
               new HotelReceptions();    
            }
            else if(ae.getSource()==updatebtn)
            {
                System.exit(0);
            }
            else
            {
                //new StudentHomePage();
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(display," INVALID  DETAILS :       PLEASE  ENTER  VALID  DETAILS .","HELP",JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[]args)
    {
      new ViewRooms ();
    }
    
}

