package bank.management.system;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5;
    JButton save,next;
    String formno;
    signup3(String formno)
    {
        this.formno=formno;

        JLabel label11 = new JLabel("Form No :");
        label11.setFont(new Font("Arial",Font.BOLD,20));
        label11.setBounds(650,20,240,30);
        add(label11);

        JLabel label12 = new JLabel(formno);
        label12.setFont(new Font("Arial",Font.BOLD,20));
        label12.setBounds(750,20,240,30);
        add(label12);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png") );
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,10,100,100);
        add(image);

        JLabel l1= new JLabel("Page no : 3");
        l1.setFont(new Font("Arial",Font.BOLD,22));
        l1.setBounds(350,20,400,60);
        add(l1);

        JLabel l2= new JLabel("Account Details");
        l2.setFont(new Font("Arial",Font.BOLD,22));
        l2.setBounds(330,68,400,60);
        add(l2);

        JLabel l3= new JLabel("Account Type :");
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setBounds(150,150,200,30);
        add(l3);

        r1=new JRadioButton("Savings Account");
        r1.setBounds(150,185,180,30);
        r1.setBackground(new Color(215,252,252));
        r1.setFont(new Font("Arial",Font.BOLD,18));
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBounds(400,185,250,30);
        r2.setBackground(new Color(215,252,252));
        r2.setFont(new Font("Arial",Font.BOLD,18));
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setBounds(150,220,180,30);
        r3.setBackground(new Color(215,252,252));
        r3.setFont(new Font("Arial",Font.BOLD,18));
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(400,220,300,30);
        r4.setBackground(new Color(215,252,252));
        r4.setFont(new Font("Arial",Font.BOLD,18));
        add(r4);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(r1);
        group1.add(r2);
        group1.add(r3);
        group1.add(r4);

        JLabel l4 = new JLabel(" Card Number:");
        l4.setBounds(140,270,200,30);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        add(l4);

        JLabel l5 = new JLabel("(Your 16-Digit card Number)");
        l5.setBounds(145,290,300,30);
        l5.setFont(new Font("Arial",Font.BOLD,15));
        add(l5);

        JLabel l8 = new JLabel("XXXX-XXXX-XXXX-4841");
        l8.setBounds(400,270,500,30);
        l8.setFont(new Font("Arial",Font.BOLD,20));
        add(l8);

        JLabel l9= new JLabel("(It would appear on atm card/cheque Book and Statements)");
        l9.setBounds(370,290,700,30);
        l9.setFont(new Font("Arial",Font.BOLD,15));
        add(l9);

        JLabel l6 = new JLabel(" PIN No :");
        l6.setBounds(145,340,200,30);
        l6.setFont(new Font("Arial",Font.BOLD,20));
        add(l6);

        JLabel l7= new JLabel("XXXX");
        l7.setBounds(400,340,200,30);
        l7.setFont(new Font("Arial",Font.BOLD,20));
        add(l7);

        JLabel l10= new JLabel("Service Required : ");
        l10.setBounds(150,390,200,30);
        l10.setFont(new Font("Arial",Font.BOLD,20));
        add(l10);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(new Color(215,252,252));
        c1.setBounds(150,430,150,30);
        c1.setFont(new Font("Arial",Font.BOLD,18));
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(215,252,252));
        c2.setBounds(400,430,300,30);
        c2.setFont(new Font("Arial",Font.BOLD,18));
        add(c2);

        c3 = new JCheckBox("Cheque Book");
        c3.setBackground(new Color(215,252,252));
        c3.setBounds(150,470,150,30);
        c3.setFont(new Font("Arial",Font.BOLD,18));
        add(c3);

        c4 = new JCheckBox("Email Query");
        c4.setBackground(new Color(215,252,252));
        c4.setBounds(400,470,200,30);
        c4.setFont(new Font("Arial",Font.BOLD,18));
        add(c4);

        c5= new JCheckBox("I here by declare that the above entered details correct to the best of my knowledge.",true);
        c5.setBackground(new Color(215,252,252));
        c5.setBounds(150,520,650,30);
        c5.setFont(new Font("Arial",Font.BOLD,15));
        add(c5);

        save = new JButton("Cancel");
        save.setBounds(100,600,100,30);
        save.setForeground(Color.WHITE);
        save.setBackground(Color.BLACK);
        save.addActionListener(this);
        save.setFont(new Font("Arial",Font.BOLD,20));
        add(save);

        next= new JButton("Next");
        next.setBounds(500,600,100,30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Arial",Font.BOLD,20));
        next.addActionListener(this);
        add(next);

        setLayout(null);
        getContentPane().setBackground(new Color( 215, 252, 252));
        setSize(850,750);
        setLocation(350,80);
        setVisible(true);

    }

    public static void main(String[] args) {
            new signup3("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acc=null;
        if(r1.isSelected())
        {
            acc="Savings Account";
        }
        else if(r2.isSelected())
        {
            acc="Fixed Deposit Account";
        }
        else if(r3.isSelected())
        {
            acc="Current Account";
        }
        else if(r4.isSelected())
        {
            acc="Recurring Deposit Account";
        }

        Random ran = new Random();
        String cardno=""+ran.nextLong(1000000000,9999999999L);

        Random ran1= new Random();
        String pin=""+ran1.nextInt(1000,9999);

        String fac="";
        if(c1.isSelected())
        {
            fac+="ATM Card";
        }
        else if(c2.isSelected())
        {
            fac+="Internet Banking";
        }
        else if(c3.isSelected())
        {
            fac+="Cheque Book";
        }
        else if(c4.isSelected())
        {
            fac+="Email Query";
        }
        try {
            if(e.getSource()==next)
            {
                if(acc==null || fac=="")
                {
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                }
                else {

                    connector c1= new connector();
                    String q1= "insert into signup3 values('"+formno+"','"+acc+"','"+cardno+"','"+pin+"','"+fac+"')";
                    String q2="insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.statement.executeUpdate(q1);
                    c1.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardno+"\n Pin : "+pin );
                    new login();
                    setVisible(false);
                }
            }
            else if(e.getSource()==save)
            {
                System.exit(0);

            }
        } catch (SQLException E) {
            E.printStackTrace();
        }

    }
}
