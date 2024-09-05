package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class balance extends JFrame implements ActionListener {
    String pin;
    JLabel label2;
    JButton back;

    balance(String pin)
    {
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png") );
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);

        JLabel label1=new JLabel("Your current Balance :");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial",Font.BOLD,20));
        label1.setBounds(510,180,400,35);
        image.add(label1);

        label2=new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Arial",Font.BOLD,20));
        label2.setBounds(510,230,400,35);
        image.add(label2);

        back=new JButton("BACK");
        back.setBounds(700,406,150,35);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(65,125,128));
        back.setFont(new Font("Arial",Font.BOLD,18));
        back.addActionListener(this);
        image.add(back);

        int balance =0;
        try{
            connector c= new connector();
            ResultSet result=c.statement.executeQuery("select * from bank where pin='"+pin+"'");
            while(result.next())
            {
                if (result.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(result.getString("amount"));

                } else {
                    balance -= Integer.parseInt(result.getString("amount"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        label2.setText(""+balance);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);

    }



    public static void main(String[] args) {
        new balance("");

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            new main_class(pin);
        }
    }
}
