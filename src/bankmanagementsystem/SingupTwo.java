package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SingupTwo extends JFrame implements ActionListener
{ 
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion, category,education,income,ocupation;
    String formno;
    SingupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        setTitle("New Account Aplication Form -Page 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,40);
        add(additionalDetails);
        
        JLabel lreligion=new JLabel("Religion : ");
        lreligion.setFont(new Font("Railway",Font.BOLD,20));
        lreligion.setBounds(100,140,100,30);
        add(lreligion);
        
        String varReligion[]={"Hindu","Muslim","Sikh","Other"};
        religion=new JComboBox(varReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.white);
        add(religion);
       
        JLabel lcatogery=new JLabel("Catogery : ");
        lcatogery.setFont(new Font("Railway",Font.BOLD,20));
        lcatogery.setBounds(100,190,200,30);
        add(lcatogery);
        
        String valcat[]={"General","OBC","SC","OTHER"};
        category=new JComboBox(valcat);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel lincome=new JLabel("Income : ");
        lincome.setFont(new Font("Railway",Font.BOLD,20));
        lincome.setBounds(100,240,200,30);
        add(lincome);
        
        String incat[]={"Null","<1,50,000","< 2,50,000","< 5,00,00","Upto 10,00,000"};
        income=new JComboBox(incat);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel ledu=new JLabel("Educational: ");
        ledu.setFont(new Font("Railway",Font.BOLD,20));
        ledu.setBounds(100,290,200,30);
        add(ledu);
       
        JLabel lque=new JLabel("Qulification : ");
        lque.setFont(new Font("Railway",Font.BOLD,20));
        lque.setBounds(100,315,200,30);
        add(lque);
        
        String edu[]={"Non-Graduate","Graduation","Post-Graduation","Other"};
        education=new JComboBox(edu);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel loccu=new JLabel("Occupation : ");
        loccu.setFont(new Font("Railway",Font.BOLD,20));
        loccu.setBounds(100,390,200,30);
        add(loccu);
        
        String occu[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        ocupation=new JComboBox(occu);
        ocupation.setBounds(300,390,400,30);
        ocupation.setBackground(Color.WHITE);
        add(ocupation);
       
        
        JLabel lpan=new JLabel("PAN Number : ");
        lpan.setFont(new Font("Railway",Font.BOLD,20));
        lpan.setBounds(100,440,200,30);
        add(lpan);
        
        pan=new JTextField();
        pan.setFont(new Font("Railway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel ladhar=new JLabel("AADHAR Number : ");
        ladhar.setFont(new Font("Railway",Font.BOLD,20));
        ladhar.setBounds(100,490,200,30);
        add(ladhar);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Railway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel lsenior=new JLabel("Senior Citizen : ");
        lsenior.setFont(new Font("Railway",Font.BOLD,20));
        lsenior.setBounds(100,540,200,30);
        add(lsenior);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
       
        JLabel lexist=new JLabel("Excisting Account : ");
        lexist.setFont(new Font("Railway",Font.BOLD,20));
        lexist.setBounds(100,590,200,30);
        add(lexist);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup marita=new ButtonGroup();
        marita.add(eyes);
        marita.add(eno);
        
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
        
        //String formno=Long.toString(random);
        String sreligion=(String)religion.getSelectedItem();
        String scatogery=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String socupation=(String) ocupation.getSelectedItem();
        String seniorcitizen=null; 
        if(syes.isSelected())
        {
            seniorcitizen="Yes";
        }else if(sno.isSelected())
        {
            seniorcitizen="No";
        }
        String existingaccount=null;
        if(eyes.isSelected())
        {
            existingaccount="Yes";
        }else if(eno.isSelected())
        {
            existingaccount="No";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();
        try{
           
                Conn c=new Conn();
                
                String query="insert into singuptwo values('"+formno+"','"+sreligion+"','"+scatogery+"','"+sincome+"','"+seducation+"','"+socupation+"','"+seniorcitizen+"','"+existingaccount+"','"+span+"','"+saadhar+"')";
            
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SingupThree(formno).setVisible(true);
                
                
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args)
    {
        new SingupTwo("");
    }    
}
