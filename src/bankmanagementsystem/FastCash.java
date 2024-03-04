package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,emergency;
    String pinnumber;
    
    
    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(200,250,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        btn1=new JButton("Rs 100");
        btn1.setBounds(170,380,150,25);
        btn1.addActionListener(this);
        image.add(btn1);
        
        btn2=new JButton("Rs 500");
        btn2.setBounds(350,345,150,25);
        btn2.addActionListener(this);
        image.add(btn2);
        
        btn3=new JButton("Rs 1000");
        btn3.setBounds(170,415,150,25);
        btn3.addActionListener(this);
        image.add(btn3);
        
        btn4=new JButton("Rs 2000");
        btn4.setBounds(350,380,150,25);
        btn4.addActionListener(this);
        image.add(btn4);
        
        btn5=new JButton("Rs 5000");
        btn5.setBounds(170,345,150,25);
        btn5.addActionListener(this);
        image.add(btn5);
        
        btn6=new JButton("Rs 10000");
        btn6.setBounds(350,415,150,25);
        btn6.addActionListener(this);
        image.add(btn6);
        
        btn7=new JButton("Back");
        btn7.setBounds(350,450,150,25);
        btn7.addActionListener(this);
        image.add(btn7);
        
        emergency=new JButton("Emergency");
        emergency.setBounds(170,450,150,25);
        image.add(emergency);
        
        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn7)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else 
        {
           String amount=((JButton)ae.getSource()).getText().substring(3);
           Conn c=new Conn();
           try
           {
              ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
              int balance =0;
              while(rs.next())
              {
                  if(rs.getString("type").equals("Deposit"))
                  {
                      balance += Integer.parseInt(rs.getString("amount"));
                  }else
                  {
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
              }
              if(ae.getSource() != btn7 && balance<Integer.parseInt(amount))
              {
                  JOptionPane.showMessageDialog(null, "Insuffiecient Balance");
                  return;
              } 
              Date date=new Date();
              String query="Insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Succefully !");
              
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
           }catch(Exception e)
           {
               System.out.println(e);
           }
        }
    }
    
    public static void main(String [] args)
    {
        new FastCash("");
    }    
}
