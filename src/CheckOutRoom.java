import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckOutRoom  implements ActionListener
{
    JFrame display;
    Container c;
    JLabel background, teacherlvtxt, employeeidtxt, roomnotxt, checktimetxt,nametxt;
    Choice employeeidfld;
    JButton checkoutbtn, cancelbtnl;
    JTextField roomnofld,checktimefld,namefld;

    public CheckOutRoom() 
    {
        display = new JFrame();
        display.setBounds(-5, 0, 1377, 775);
        display.setTitle("HOTEL_CHECK_OUT_ROOM_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = display.getContentPane();

        // teacherleave txt
        teacherlvtxt = new JLabel("CHECK OUT ROOM 💢");
        teacherlvtxt.setBounds(310, 20, 800, 100);
        teacherlvtxt.setForeground(Color.gray);
        teacherlvtxt.setFont(new Font("name", Font.BOLD, 45));
        c.add(teacherlvtxt);

        // employeeid
        employeeidtxt = new JLabel("CUSTOMER I`D :");
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
            ResultSet rs = c.s.executeQuery("select * from New_Customer");
            while(rs.next())
            {
                employeeidfld.add(rs.getString("Id"));
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
            String query="select * from New_Customer where Id='"+employeeidfld.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) 
            {
                roomnofld.setText(rs.getString("Room_Number"));
                checktimefld.setText(rs.getString("Check_In_Time"));
                namefld.setText(rs.getString("Name"));

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
                          String query="select * from New_Customer where Id='"+employeeidfld.getSelectedItem()+"'";
                           ResultSet rs = c.s.executeQuery(query);
                           while (rs.next()) 
                           {
                            roomnofld.setText(rs.getString("Room_Number"));
                            checktimefld.setText(rs.getString("Check_In_Time")); 
                            namefld.setText(rs.getString("Name"));                            
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
        roomnotxt.setForeground(Color.darkGray);
        roomnotxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(roomnotxt); // COMBINE
        roomnofld = new JTextField();
        roomnofld.setBounds(300, 350, 250, 30);
        roomnofld.setForeground(Color.darkGray);
        roomnofld.setBackground(Color.lightGray);
        roomnofld.setFont(new Font("name", Font.BOLD, 20));
        roomnofld.setOpaque(false);
        roomnofld.setEditable(false);
        c.add(roomnofld);

        // time txtt
        checktimetxt = new JLabel("CHECK IN TIME :");
        checktimetxt.setBounds(300, 380, 800, 80);
        checktimetxt.setForeground(Color.darkGray);
        checktimetxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(checktimetxt); // COMBINE
        checktimefld = new JTextField();
        checktimefld.setBounds(300, 470, 250, 30);
        checktimefld.setForeground(Color.darkGray);
        checktimefld.setBackground(Color.lightGray);
        checktimefld.setFont(new Font("name", Font.BOLD, 20));
        checktimefld.setOpaque(false);
        checktimefld.setEditable(false);
        c.add(checktimefld);

        nametxt = new JLabel("NAME :");
        nametxt.setBounds(300, 140, 800, 80);
        nametxt.setForeground(Color.darkGray);
        nametxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(nametxt); // COMBINE
        namefld = new JTextField();
        namefld.setBounds(300, 230, 250, 30);
        namefld.setForeground(Color.darkGray);
        namefld.setBackground(Color.lightGray);
        namefld.setFont(new Font("name", Font.BOLD, 20));
        namefld.setOpaque(false);
        namefld.setEditable(false);
        c.add(namefld);

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

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Checkout.jpg"));
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
               String Id=employeeidfld.getSelectedItem();
               String Room_Number = roomnofld.getText();
               String Check_In_Time= checktimefld.getText();
               String Name = namefld.getText();

               if((Id.isEmpty()==false)&&(Room_Number.isEmpty()==false)&&(Check_In_Time.isEmpty()==false)&&(Name.isEmpty()==false))
               {
                try 
                {
                   /* String query="update New_Customer set Name='"+Name+"', Room_Number='"+Room_Number+"', Check_In_Time='"+Check_In_Time+"' where Id ='"+employeeidfld.getSelectedItem()+"'";
                    Connector c= new Connector();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(display,"UPDATED  SUCCESSFULLY .:","POPUP",JOptionPane.INFORMATION_MESSAGE);
                   */ 
                    JOptionPane.showMessageDialog(display,"DATA IS NOT INSERTED IN DATABASE .\nTHANK YOU .:","POPUP",JOptionPane.INFORMATION_MESSAGE);
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
        new CheckOutRoom();
    }
}
