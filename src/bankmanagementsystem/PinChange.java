package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener
{
    JTextField pin,repin;
    JButton change,back;
    
    String pinnumber;
    
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Change Your PIN");
        text.setBounds(250,290,180,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN");
        pintext.setBounds(160,330,500,35);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,18));
        image.add(pintext);
        
        pin=new JTextField();
        pin.setFont(new Font("Railway",Font.BOLD,16));
        pin.setBounds(330,330,150,25);
        image.add(pin);

        JLabel repintext=new JLabel("Re-Enter New PIN");
        repintext.setBounds(160,370,500,35);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,18));
        image.add(repintext);
        
        repin=new JTextField();
        repin.setFont(new Font("Railway",Font.BOLD,16));
        repin.setBounds(330,370,150,25);
        image.add(repin);
        
        change=new JButton("Change");
        change.setBounds(380,490,130,25);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setBounds(380,520,130,25);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==change)
        {
        try
        {
            String npin=pin.getText();
            String rpin=pin.getText();
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null, "Entered Pin Does not Match");
                return;
            }
            if(npin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Entered new PIN");
                return;
            }
            if(rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please re-Entered new PIN");
                return;
            }
            Conn conn=new Conn();
            String query1="update bank set pin = '"+rpin+"' where pin='"+pinnumber+"' ";
            String query2="update login set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"' ";
            String query3="update singupthree set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"' ";

            conn.s.executeUpdate(query3);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query1);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully !");

            setVisible(false);
            new Transaction(rpin).setVisible(true);
            
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        }else{
           setVisible(false); 
           new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new PinChange("").setVisible(true);
    }
}
