
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SingupThree extends JFrame implements ActionListener
{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit,cancel;
    String formno;
    SingupThree(String formno)
    {
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3 : Account Deatails");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        getContentPane().setBackground(Color.white);
        add(l1);
        
        JLabel type=new JLabel("Account Type :");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100,100,200,30);
        add(type);
        
        r1 = new JRadioButton("Savin Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(120,140,250,20);
        add(r1);
        
        r2 = new JRadioButton(" Fixed Deposit Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(370,140,250,20);
        add(r2);
        
        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(120,180,250,20);
        add(r3);
        
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(370,180,250,20);
        add(r4);
        
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number : ");;
        card.setFont(new Font("Railway",Font.BOLD,22));
        card.setBounds(100,220,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Railway",Font.BOLD,22));
        number.setBounds(330,240,250,30);
        add(number);
        
        JLabel details=new JLabel("(Your 16 Digit Card Number)");
        details.setFont(new Font("Railway",Font.BOLD,12));
        details.setBounds(120,250,300,20);
        add(details);
        
        JLabel pindetails=new JLabel("(Your 4 Digit Password) ");
        pindetails.setFont(new Font("Railway",Font.BOLD,12));
        pindetails.setBounds(120,330,300,20);
        add(pindetails);
        
        JLabel pin=new JLabel("PIN : ");
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(100,300,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Railway",Font.BOLD,22));
        pnumber.setBounds(330,300,200,30);
        add(pnumber);
        
        JLabel services=new JLabel("Services Required : ");
        services.setFont(new Font("Railway",Font.BOLD,22));
        services.setBounds(100,370,300,20);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(120,410,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(370,410,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(120,450,200,30);
        add(c3);
        
        c4=new JCheckBox("E-Mail & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(370,450,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(120,490,200,30);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(370,490,200,30);
        add(c6);
        
        c7=new JCheckBox("I hearby declares that the above entered details are correct to the best of my knowledge !  ");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Railway",Font.BOLD,15));
        c7.setBounds(80,550,700,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Railway",Font.BOLD,12));
        submit.setBounds(250,590,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Railway",Font.BOLD,12));
        cancel.setBounds(420,590,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850,820);
        setLocation(350,0);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String accountType = null;
            if(r1.isSelected())
            {
                accountType="Saving Account";
            }else if(r2.isSelected())
            {
                accountType="Fixed Deposit Account";
            }else if(r3.isSelected())
            {
                accountType="Current Account";
            }else if(r4.isSelected())
            {
                accountType="Reccuring Account";
            }
            
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040409060000000L);
            String pinnumber=""+Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility=null;
            if(c1.isSelected())
            {
                facility=facility+" ATM Card";
            }else if(c2.isSelected())
            {
                facility=facility+" Internet Banking";
            }else if(c3.isSelected())
            {
                facility=facility+" Mobile Banking";
            }else if(c4.isSelected())
            {
                facility=facility+" Email & SMS Alerts";
            }else if(c5.isSelected())
            {
                facility=facility+" Check Book";
            }else if(c6.isSelected())
            {
                facility=facility+" E-Statement";
            }
            
            try{
                
                if(accountType.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Account Type is Required ");
                }else
                {
                    Conn conn=new Conn();
                    String quiry1="insert into singupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String quiry2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                   
                    conn.s.executeUpdate(quiry1);
                    conn.s.executeUpdate(quiry2);
                    
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardnumber+"\n"+"PIN : "+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
        }else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args)
    {
        new SingupThree("");
    }
}
