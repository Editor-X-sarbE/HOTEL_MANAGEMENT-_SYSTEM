import java.sql.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.proteanit.sql.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom implements ActionListener
{
    JFrame display;
    Container c;
    JLabel background,viewstddtltxt,searchbartxt;
    Choice searchbarfld;
    JButton searchbtn,printbtn,addbtn,cancelbtn,updatebtn;
    JTable tablefld;
    public SearchRoom()
    {
        display = new JFrame();
        display.setBounds(-5, 0, 1377, 775);
        display.setTitle("HOTEL_SEARCH_ROOM_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.getContentPane().setBackground(Color.yellow);
        c = display.getContentPane();

        //view student details
        viewstddtltxt = new JLabel("SEARCH🏛️ROOMS ");
        viewstddtltxt.setBounds(15,0,800,100);
        viewstddtltxt.setForeground(Color.white);
        viewstddtltxt.setFont(new Font("name",Font.BOLD,45));
        c.add(viewstddtltxt);

        //search bar
        searchbartxt = new JLabel("Type Of Bed :");
        searchbartxt.setBounds(60,85,200,100);
        searchbartxt.setForeground(Color.white);
        searchbartxt.setFont(new Font("name",Font.BOLD,27));
        searchbartxt.setOpaque(false);
        c.add(searchbartxt);  //COMBINE
        searchbarfld = new Choice(); 
        searchbarfld.setBounds(260,120,150,30);
        searchbarfld.setForeground(Color.blue);
        searchbarfld.setFont(new Font("name",Font.BOLD,19));
        c.add(searchbarfld); //fetching rollno in the databases__________________.........
        try               
        {
            Connector c= new Connector();
            ResultSet rs = c.s.executeQuery("select * from Add_room");
            while(rs.next())
            {
                searchbarfld.add(rs.getString("Bed_Type"));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        //Table field for show data_______________________...........
        tablefld = new JTable();
        try 
        {
            Connector c= new Connector();
            ResultSet rs = c.s.executeQuery("select * from Add_room");
            //ResultSet rs = c.s.executeQuery("select * from Bed_Type");
            tablefld.setModel(DbUtils.resultSetToTableModel(rs));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        JScrollPane scroll = new JScrollPane(tablefld);
        scroll.setBounds(1, 230, 1365, 520);
        c.add(scroll);

        //searchbtn
        searchbtn= new JButton();
        searchbtn.setBounds(100, 175, 100, 30);
        searchbtn.setText("SEARCH");
        searchbtn.setFont(new Font("null",Font.BOLD,15));
        searchbtn.setBackground(Color.cyan);
        searchbtn.setForeground(Color.green);
        searchbtn.setOpaque(false);
        searchbtn.addActionListener(this);
        c.add(searchbtn);

        //printbtn
        printbtn= new JButton();
        printbtn.setBounds(230, 175, 100, 30);
        printbtn.setText("PRINT");
        printbtn.setFont(new Font("null",Font.BOLD,15));
        printbtn.setBackground(Color.cyan);
        printbtn.setForeground(Color.green);
        printbtn.setOpaque(false);
        printbtn.addActionListener(this);
        c.add(printbtn);

        //addnew student information
        addbtn= new JButton();
        addbtn.setBounds(350, 175, 240, 30);
        addbtn.setText("NULL ");
        addbtn.setFont(new Font("null",Font.BOLD,15));
        addbtn.setBackground(Color.cyan);
        addbtn.setForeground(Color.green);
        addbtn.setOpaque(false);
        addbtn.addActionListener(this);
        c.add(addbtn);

        //update btn
        updatebtn= new JButton();
        updatebtn.setBounds(730, 175, 100, 30);
        updatebtn.setText("EXIT");
        updatebtn.setFont(new Font("null",Font.BOLD,15));
        updatebtn.setBackground(Color.cyan);
        updatebtn.setForeground(Color.green);
        updatebtn.setOpaque(false);
        updatebtn.addActionListener(this);
        c.add(updatebtn);

        //cancel btn
        cancelbtn= new JButton();
        cancelbtn.setBounds(610, 175, 100, 30);
        cancelbtn.setText("BACK");
        cancelbtn.setFont(new Font("null",Font.BOLD,15));
        cancelbtn.setBackground(Color.cyan);
        cancelbtn.setForeground(Color.green);
        cancelbtn.setOpaque(false);
        cancelbtn.addActionListener(this);
        c.add(cancelbtn);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("SearchRooms.jpg"));
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
            if(ae.getSource()==searchbtn)
            {
                String query = "select * from Add_room where Bed_Type= '"+searchbarfld.getSelectedItem()+"'";
                try 
                {
                    Connector c= new Connector();
                    ResultSet rs=c.s.executeQuery(query);
                    tablefld.setModel(DbUtils.resultSetToTableModel(rs));
                } 
                catch (Exception e) 
                {
                  e.printStackTrace();
                }
            }
            else if(ae.getSource()==printbtn)
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
            else if(ae.getSource()==cancelbtn)
            {
                new HotelReceptions();
            }
            else if(ae.getSource()==updatebtn)
            {
                System.exit(0);
            }
            if (ae.getSource()==addbtn) {
                //new PickupCustomer();
            }
            else
            {
                //new HomePage();
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(display," INVALID  DETAILS :       PLEASE  ENTER  VALID  DETAILS .","HELP",JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[]args)
    {
      new SearchRoom();
    }
}

