package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class deposit extends JFrame implements ActionListener {
    String pin;
    JButton dep,back;
    JTextField text1;
    deposit(String pin)
    {
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png") );
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel label1=new JLabel("Enter Amount You Want to Deposit");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial",Font.BOLD,20));
        label1.setBounds(460,180,400,35);
        image.add(label1);

        text1=new JTextField();
        text1.setBackground(new Color(65,125,128));
        text1.setForeground(Color.WHITE);
        text1.setBounds(460,230,320,25);
        text1.setFont(new Font("Arial",Font.BOLD,20));
        image.add(text1);

        dep=new JButton("DEPOSIT");
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
        new deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String amt=text1.getText();
            Date date= new Date();
            if(e.getSource()==dep)
            {
                if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit");}
                else{
                    connector c = new connector();
                    String q="insert into bank values('"+pin+"','"+date+"','Deposit','"+amt+"')";
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Rs. "+amt+" Deposited Successfully");
                    setVisible(false);
                    new main_class(pin);

                }


            }
            else if(e.getSource()==back)
            {
                setVisible(false);
                new main_class(pin);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}