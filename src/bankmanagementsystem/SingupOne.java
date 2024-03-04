package bankmanagementsystem;



import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SingupOne extends JFrame implements ActionListener
{ 
    long random;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser datechooser;
    SingupOne()
    {
        setLayout(null);
        
        setTitle("New Account Aplication Form -Page 1");

        
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("Aplication Form NO. "+random);
        formno.setFont(new Font("Railway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Railway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,40);
        add(personalDetails);
        
        JLabel name=new JLabel("Name : ");
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Surname : ");
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Railway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date of Birth : ");
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        datechooser=new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(Color.red);
        add(datechooser);
        
        JLabel gender=new JLabel("Gender : ");
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email : ");
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Railway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marital=new JLabel("Marital Status : ");
        marital.setFont(new Font("Railway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried=new JRadioButton("UnMarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        
        JLabel address=new JLabel("Address : ");
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Railway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city=new JLabel("City : ");
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Railway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state=new JLabel("State : ");
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("PinCode : ");
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Railway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        String formno=Long.toString(random);
        String name= nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }else if(female.isSelected())
        {
            gender="Female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected())
        {
            marital="Married";
        }else if(unmarried.isSelected())
        {
            marital="UnMarried";
        }else if(other.isSelected())
        {
            marital="Other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        
        try{
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if(fname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Father Name is Required");
            }else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if(city.equals(""))
            {
                JOptionPane.showMessageDialog(null,"City is Required");
            }else if(state.equals(""))
            {
                JOptionPane.showMessageDialog(null,"State is Required");
            }else if(pin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Pin is Required");
            } else
            {
                Conn c=new Conn();
                
                String query="insert into singup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
            
                c.s.executeUpdate(query);
                
                setVisible(false);
                
                new SingupTwo(formno).setVisible(true);
          
            }
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args)
    {
        new SingupOne();
    }    
}
