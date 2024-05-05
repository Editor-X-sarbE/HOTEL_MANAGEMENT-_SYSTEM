import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UpdateRoomStatus  implements ActionListener
{
    JFrame display;
    Container c;
    JLabel background, teacherlvtxt, employeeidtxt, roomnotxt, cleaningtxt,avlvltxt;
    Choice employeeidfld;
    JButton checkoutbtn, cancelbtnl;
    JTextField roomnofld,cleaningfld,avlvlfld;

    public UpdateRoomStatus() 
    {
        display = new JFrame();
        display.setBounds(-5, 0, 1377, 775);
        display.setTitle("HOTEL_UPDATE_ROOM_STATUS_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = display.getContentPane();

        // teacherleave txt
        teacherlvtxt = new JLabel("UPDATE ROOM STATUS 💢");
        teacherlvtxt.setBounds(310, 20, 800, 100);
        teacherlvtxt.setForeground(Color.gray);
        teacherlvtxt.setFont(new Font("name", Font.BOLD, 45));
        c.add(teacherlvtxt);

        // employeeid
        employeeidtxt = new JLabel("ROOM NUMBER :");
        employeeidtxt.setBounds(800, 140, 800, 80);
        employeeidtxt.setForeground(Color.darkGray);
        employeeidtxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(employeeidtxt); // COMBINE
        employeeidfld = new Choice();
        employeeidfld.setBounds(800, 230, 250, 30);
        employeeidfld.setForeground(Color.darkGray);
        employeeidfld.setFont(new Font("name", Font.BOLD, 20));
        c.add(employeeidfld);
        // set querry for showing customer id in the field 
        try               
        {
            Connector c= new Connector();
            ResultSet rs = c.s.executeQuery("select * from Add_room");
            while(rs.next())
            {
                employeeidfld.add(rs.getString("RoomNo"));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        // set query for fetch data in the databses 
        try 
         {
            Connector c = new Connector();
            String query="select * from Add_room where RoomNo='"+employeeidfld.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) 
            {
                //roomnofld.setText(rs.getString("Room_Number"));
                avlvlfld.setText(rs.getString("Room_Avlvl"));
                cleaningfld.setText(rs.getString("Clean_Sts"));

            }
        }
        catch (Exception e) 
        {
           e.printStackTrace();
        }

        //displayed the ordor data in frame 
        employeeidfld.addItemListener(new ItemListener() 
            {
                public void itemStateChanged(ItemEvent ie)
                {
                    try 
                      {
                         Connector c = new Connector();
                          String query="select * from Add_room where RoomNo='"+employeeidfld.getSelectedItem()+"'";
                           ResultSet rs = c.s.executeQuery(query);
                           while (rs.next()) 
                           {
                            //roomnofld.setText(rs.getString("Room_Number"));
                            avlvlfld.setText(rs.getString("Room_Avlvl"));
                            cleaningfld.setText(rs.getString("Clean_Sts"));                            
                           }
                     }
                     catch (Exception e) 
                     {
                        e.printStackTrace();
                     }
                }
            });

        // date txtt
        roomnotxt = new JLabel("ROOM NO :");
        roomnotxt.setBounds(300, 260, 800, 100);
        roomnotxt.setForeground(Color.white);
        roomnotxt.setFont(new Font("name", Font.BOLD, 25));
        //c.add(roomnotxt); // COMBINE
        roomnofld = new JTextField();
        roomnofld.setBounds(300, 350, 250, 30);
        roomnofld.setForeground(Color.darkGray);
        roomnofld.setBackground(Color.lightGray);
        roomnofld.setFont(new Font("name", Font.BOLD, 20));
        roomnofld.setOpaque(false);
        roomnofld.setEditable(false);
        //c.add(roomnofld);

        // time txtt
        cleaningtxt = new JLabel("CLEANING STATUS :");
        cleaningtxt.setBounds(400, 260, 800, 80);
        cleaningtxt.setForeground(Color.white);
        cleaningtxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(cleaningtxt); // COMBINE
        cleaningfld = new JTextField();
        cleaningfld.setBounds(400, 350, 250, 30);
        cleaningfld.setForeground(Color.darkGray);
        cleaningfld.setBackground(Color.lightGray);
        cleaningfld.setFont(new Font("name", Font.BOLD, 20));
        cleaningfld.setOpaque(false);
        //cleaningfld.setEditable(false);
        c.add(cleaningfld);

        avlvltxt = new JLabel("AVILAVALIBILITY :");
        avlvltxt.setBounds(400, 140, 800, 80);
        avlvltxt.setForeground(Color.white);
        avlvltxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(avlvltxt); // COMBINE
        avlvlfld = new JTextField();
        avlvlfld.setBounds(400, 230, 250, 30);
        avlvlfld.setForeground(Color.darkGray);
        avlvlfld.setBackground(Color.lightGray);
        avlvlfld.setFont(new Font("name", Font.BOLD, 20));
        avlvlfld.setOpaque(false);
        //avlvlfld.setEditable(false);
        c.add(avlvlfld);

        // sumbit
        checkoutbtn = new JButton("CHECK OUT");
        checkoutbtn.setBounds(300, 600, 150, 30);
        checkoutbtn.setFont(new Font("name", Font.BOLD, 18));
        checkoutbtn.setForeground(Color.green);
        checkoutbtn.setBackground(Color.cyan);
        checkoutbtn.setOpaque(false);
        checkoutbtn.addActionListener(this);
        c.add(checkoutbtn); // BUTTONS
        cancelbtnl = new JButton("BACK");
        cancelbtnl.setBounds(500, 600, 120, 30);
        cancelbtnl.setFont(new Font("name", Font.BOLD, 18));
        cancelbtnl.setForeground(Color.red);
        cancelbtnl.setBackground(Color.cyan);
        cancelbtnl.setOpaque(false);
        cancelbtnl.addActionListener(this);
        c.add(cancelbtnl);

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("UpdateRooms.jpg"));
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
            if(ae.getSource()==checkoutbtn)
            {
               String RoomNo=employeeidfld.getSelectedItem();
               //String Room_Number = roomnofld.getText();
               String Clean_Sts= cleaningfld.getText();
               String Room_Avlvl = avlvlfld.getText();

               if((RoomNo.isEmpty()==false)&&(Clean_Sts.isEmpty()==false)&&(Room_Avlvl.isEmpty()==false))
               {
                try 
                {
                    String query="update Add_room set Clean_Sts='"+Clean_Sts+"', Room_Avlvl='"+Room_Avlvl+"' where RoomNo ='"+employeeidfld.getSelectedItem()+"'";
                    Connector c= new Connector();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(display,"UPDATED  SUCCESSFULLY .:","POPUP",JOptionPane.INFORMATION_MESSAGE);            
                    new HotelReceptions();
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
               }
               else
               {
                JOptionPane.showMessageDialog(display," INVALID  PLEASE  ENTER  VALID  DETAILS .:","HELP",JOptionPane.ERROR_MESSAGE);
               }
            }

            if(ae.getSource()==cancelbtnl)
            {
                new HotelReceptions();     //home page 
            }

        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(display," INVALID  DETAILS :       PLEASE  ENTER  VALID  DETAILS .","HELP",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) 
    {
        new UpdateRoomStatus();
    }
}

