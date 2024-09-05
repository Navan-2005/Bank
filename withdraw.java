package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {
    String pin;
    JButton dep,back;
    JTextField text1;
    withdraw(String pin)
    {
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png") );
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel label1=new JLabel("Enter Amount You Want to Withdraw");
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

        dep=new JButton("WITHDRAW");
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == dep) {
            try {
                String amount = text1.getText();
                Date date = new Date();
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw");
                } else {
                    connector c = new connector();
                    ResultSet result = c.statement.executeQuery("select * from bank where pin='"+pin+"'");
                    int balance = 0;
                    while (result.next()) {
                        if (result.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(result.getString("amount"));

                        } else {
                            balance -= Integer.parseInt(result.getString("amount"));

                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Withdraw','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new main_class(pin);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new main_class(pin);
        }
    }

    public static void main(String[] args) {
        new withdraw("");
    }
}
