import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PickupCustomer  implements ActionListener
{
    JFrame display;
    Container c;
    JLabel background, teacherlvtxt, cartypetxt, drivernotxt, pickuploctntxt,avlivletxt;
    Choice cartypefld;
    JButton checkoutbtn, cancelbtnl;
    JTextField drivernofld,pickuploctnfld,avlivlefld;

    public PickupCustomer() 
    {
        display = new JFrame();
        display.setBounds(-5, -3, 1377, 775);
        display.setTitle("HOTEL_PICKUP_CUSTOMER_PAGE");
        display.setLayout(null);
        display.setResizable(true);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = display.getContentPane();

        // teacherleave txt 
        teacherlvtxt = new JLabel("PICLUP CUSTOMER 💢");
        teacherlvtxt.setBounds(310, 20, 800, 100);
        teacherlvtxt.setForeground(Color.white);
        teacherlvtxt.setFont(new Font("name", Font.BOLD, 45));
        c.add(teacherlvtxt);

        // employeeid 
        cartypetxt = new JLabel("TYPES OF CAR :"); 
        cartypetxt.setBounds(800, 140, 800, 80);
        cartypetxt.setForeground(Color.white);
        cartypetxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(cartypetxt); // COMBINE
        cartypefld = new Choice();
        cartypefld.setBounds(800, 230, 250, 30);
        cartypefld.setForeground(Color.darkGray);
        cartypefld.setFont(new Font("name", Font.BOLD, 20));
        c.add(cartypefld);
        // set querry for showing customer id in the field
        try               
        {
            Connector c= new Connector();
            ResultSet rs = c.s.executeQuery("select * from Add_Drivers");
            while(rs.next())
            {
                cartypefld.add(rs.getString("Car_Model"));
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
            String query="select * from Add_Drivers where Car_Model='"+cartypefld.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) 
            {
                drivernofld.setText(rs.getString("Phone_No"));
                pickuploctnfld.setText(rs.getString("Location"));
                avlivlefld.setText(rs.getString("Avilavle"));

            }
        }
        catch (Exception e) 
        {
           e.printStackTrace();
        }

        //displayed the ordor data in frame 
        cartypefld.addItemListener(new ItemListener() 
            {
                public void itemStateChanged(ItemEvent ie)
                {
                    try 
                      {
                         Connector c = new Connector();
                          String query="select * from Add_Drivers where Car_Model='"+cartypefld.getSelectedItem()+"'";
                           ResultSet rs = c.s.executeQuery(query);
                           while (rs.next()) 
                           {
                            drivernofld.setText(rs.getString("Phone_No"));
                            pickuploctnfld.setText(rs.getString("Location")); 
                            avlivlefld.setText(rs.getString("Avilavle"));                            
                           }
                     }
                     catch (Exception e) 
                     {
                        e.printStackTrace();
                     }
                }
            });

        // date txtt
        drivernotxt = new JLabel("DRIVER NO :");
        drivernotxt.setBounds(300, 260, 800, 100);
        drivernotxt.setForeground(Color.white);
        drivernotxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(drivernotxt); // COMBINE
        drivernofld = new JTextField();
        drivernofld.setBounds(300, 350, 250, 30);
        drivernofld.setForeground(Color.white);
        drivernofld.setBackground(Color.lightGray);
        drivernofld.setFont(new Font("name", Font.BOLD, 20));
        drivernofld.setOpaque(false);
        drivernofld.setEditable(false);
        c.add(drivernofld);

        // time txtt
        pickuploctntxt = new JLabel("PICKUP LOCATION :");
        pickuploctntxt.setBounds(300, 380, 800, 80);
        pickuploctntxt.setForeground(Color.white);
        pickuploctntxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(pickuploctntxt); // COMBINE
        pickuploctnfld = new JTextField();
        pickuploctnfld.setBounds(300, 470, 250, 30);
        pickuploctnfld.setForeground(Color.white);
        pickuploctnfld.setBackground(Color.lightGray);
        pickuploctnfld.setFont(new Font("name", Font.BOLD, 20));
        pickuploctnfld.setOpaque(false);
        pickuploctnfld.setEditable(false);
        c.add(pickuploctnfld);

        avlivletxt = new JLabel("AVILAVLIBILITY :");
        avlivletxt.setBounds(300, 140, 800, 80);
        avlivletxt.setForeground(Color.white);
        avlivletxt.setFont(new Font("name", Font.BOLD, 25));
        c.add(avlivletxt); // COMBINE
        avlivlefld = new JTextField();
        avlivlefld.setBounds(300, 230, 250, 30);
        avlivlefld.setForeground(Color.white);
        avlivlefld.setBackground(Color.lightGray);
        avlivlefld.setFont(new Font("name", Font.BOLD, 20));
        avlivlefld.setOpaque(false);
        //avlivlefld.setEditable(false);
        c.add(avlivlefld);

        // sumbit
        checkoutbtn = new JButton("RESERVE ");
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

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("PickupCustomer.jpg"));
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
               String Id=cartypefld.getSelectedItem();
               String Phone_No = drivernofld.getText();
               String Location = pickuploctnfld.getText();
               String Avilavle = avlivlefld.getText();

               if((Id.isEmpty()==false)&&(Phone_No.isEmpty()==false)&&(Location.isEmpty()==false)&&(Avilavle.isEmpty()==false))
               {
                try 
                {
                   String query="update Add_Drivers set Phone_No='"+Phone_No+"', Location='"+Location+"', Avilavle='"+Avilavle+"' where Car_Model ='"+cartypefld.getSelectedItem()+"'";
                    Connector c= new Connector();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(display,"RESERVE  SUCCESSFULLY .:","POPUP",JOptionPane.INFORMATION_MESSAGE);
                   
                    //JOptionPane.showMessageDialog(display,"DATA IS NOT INSERTED IN DATABASE .\nTHANK YOU .:","POPUP",JOptionPane.INFORMATION_MESSAGE);
                    new PickupService();
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
        new PickupCustomer();
    }
}
