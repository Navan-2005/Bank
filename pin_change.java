package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;

public class pin_change extends JFrame implements ActionListener {
    String pin;
    JPasswordField text1,text2;
    JButton dep,back;

    pin_change(String pin)
    {
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png") );
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel label1=new JLabel("Change Your current PIN");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial",Font.BOLD,20));
        label1.setBounds(460,180,400,35);
        image.add(label1);

        JLabel label2=new JLabel("Enter New PIN : ");
        label2.setFont(new Font("Arial",Font.BOLD,18));
        label2.setBounds(430,220,200,35);
        label2.setForeground(Color.WHITE);
        image.add(label2);

        text1=new JPasswordField();
        text1.setFont(new Font("Arial",Font.BOLD,16));
        text1.setForeground(Color.BLACK);
        text1.setBounds(600,222,150,25);
        text1.setBackground(Color.WHITE);
        image.add(text1);

        JLabel label3=new JLabel("Re-Enter PIN : ");
        label3.setFont(new Font("Arial",Font.BOLD,18));
        label3.setBounds(430,270,200,35);
        label3.setForeground(Color.WHITE);
        image.add(label3);

        text2=new JPasswordField();
        text2.setFont(new Font("Arial",Font.BOLD,16));
        text2.setBounds(600,272,150,25);
        text2.setForeground(Color.WHITE);
        text2.setForeground(Color.BLACK);
        image.add(text2);

        dep=new JButton("CHANGE");
        dep.setBackground(new Color(65,125,128));
        dep.setForeground(Color.WHITE);
        dep.setBounds(700,362,150,35);
        dep.addActionListener(this);
        image.add(dep);

        back=new JButton("BACK");
        back.setBackground(new Color(65,125,128));
        back.setForeground(Color.WHITE);
        back.setBounds(700,406,150,35);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new pin_change("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String pin1= text1.getText();
         String pin2= text2.getText();
         try
         {

             if(e.getSource()==dep)
             {
                 if(!pin1.equals(pin2))
                 {
                     JOptionPane.showMessageDialog(null,"PIN does not match");
                     return;
                 }
                 if(text1.getText().equals(""))
                 {
                     JOptionPane.showMessageDialog(null,"Enter the PIN");
                     return;
                 }
                 if(text2.getText().equals(""))
                 {
                     JOptionPane.showMessageDialog(null,"Re-Enter the PIN");
                     return;
                 }
                 connector c= new connector();
                 String q1="update bank set pin='"+pin1+"'where pin='"+pin+"'";
                 String q2="update login set PIN_No='"+pin1+"'where PIN_No='"+pin+"'";
                 String q3="update signup3 set PIN_No='"+pin1+"'where PIN_No='"+pin+"'";
                 c.statement.executeUpdate(q1);
                 c.statement.executeUpdate(q2);
                 c.statement.executeUpdate(q3);

                 JOptionPane.showMessageDialog(null,"PIN successfully changed");
                 new main_class(pin);
                 setVisible(false);


             }
             else if(e.getSource()==back)
             {
                 new main_class(pin);
                 setVisible(false);
             }
         } catch (SQLException ex) {
             throw new RuntimeException(ex);
         }
    }
}
