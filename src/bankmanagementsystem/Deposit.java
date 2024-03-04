package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener
{
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    Deposit(String pinnumber)
    {      
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("Enter the Amount you want to Deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(130,230,400,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Sysytem",Font.BOLD,18));
        amount.setBounds(160,260,200,30);
        add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(300,380,100,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(300,405,100,20);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700,700);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==deposit)
        {
           String number=amount.getText();
           Date date=new Date();
           if(number.contentEquals(""))
           {
               JOptionPane.showMessageDialog(null, "Please Enter Amount");
           }else{
               try{
               Conn conn=new Conn();
               String query="insert into bank values ('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Succefully !");
               setVisible(false);
               new Transaction(pinnumber).setVisible(true);
               }catch(Exception e)
               {
                   System.out.println(e);
               }
         
        }
        }else if(ae.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args)
    {
        new Deposit("");
    }
}
