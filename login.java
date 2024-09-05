package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JTextField field2;
    JPasswordField password3;
    JButton button1,button2,button3;
    login()
    {
        super("Bank Management System ");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png") );
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/card.png") );
        Image i22=i11.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image3 = new JLabel(i33);
        image3.setBounds(730,320,100,100);
        add(image3);

        label1=new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD,25));
//        label1.setFont(new Font(Font.CENTER_BASELINE));
        label1.setBounds(290,102,450,40);
        add(label1);

        label2=new  JLabel("Card No : ");
        label2.setForeground(Color.YELLOW);
        label2.setFont(new Font("Ralway",Font.BOLD,25));
        label2.setBounds(120,160,375,30);
        add(label2);

        field2 = new JTextField(15);
        field2.setForeground(Color.BLACK);
        field2.setBackground(Color.WHITE);
        field2.setFont(new Font("Ariel",Font.BOLD,15));
        field2.setBounds(240,165,350,25);
        add(field2);

        label3=new  JLabel("PIN NO   : ");
        label3.setForeground(Color.YELLOW);
        label3.setFont(new Font("Ralway",Font.BOLD,25));
        label3.setBounds(120,220,375,30);
        add(label3);

        password3 = new JPasswordField(15);
        password3.setForeground(Color.BLACK);
        password3.setBackground(Color.WHITE);
        password3.setEchoChar('*');
        password3.setFont(new Font("Arial",Font.BOLD,15));
        password3.setBounds(240,224,350,25);
        add(password3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial",Font.BOLD,15));
        button1.setBounds(270,264,100,50);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial",Font.BOLD,15));
        button2.setBounds(430,264,100,50);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial",Font.BOLD,15));
        button3.setBounds(350,334,100,50);
        button3.addActionListener(this);
        add(button3);

        ImageIcon ii1=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png") );
        Image ii2=ii1.getImage().getScaledInstance(850,450,Image.SCALE_DEFAULT);
        ImageIcon ii3=new ImageIcon(ii2);
        JLabel image1 = new JLabel(ii3);
        image1.setBounds(0,0,850,450);
        add(image1);

        setLayout(null);
        setSize(850,450);
        setLocation(350,200);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == button1) {

                connector c= new connector();
                String cardno=field2.getText();
                String pin=password3.getText();
                String q="select * from login where Card_No = '"+cardno+"' and PIN_No='"+pin+"'";
                ResultSet result=c.statement.executeQuery(q);
                if(result.next())
                {
                    setVisible(false);
                    new main_class(pin);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

            }else if (e.getSource() == button2) {
                field2.setText("");
                password3.setText("");
            } else if (e.getSource() == button3) {
                new sign_up();
                setVisible(false);

            }

        }
       catch( Exception E)
        {
           E.printStackTrace();
       }
    }

    public static void main(String[] args) {
        new login();

    }


}
