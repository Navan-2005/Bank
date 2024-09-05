
package bank.management.system;
import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import java.awt.*;

public class sign_up extends JFrame implements ActionListener {
    Random ran = new Random();
    String s=""+ran.nextInt(1000,9999);
    JTextField text1,text2,text3,text4;
    JDateChooser date;
    JRadioButton r1,r2,m1,m2,m3;
    JButton next,button2;

    sign_up()
    {
        super("APPLICATION FORM");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png") );
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1= new JLabel("APPLICATION NO:"+s);
        label1.setBounds(220,20,600,40);
        label1.setFont(new Font("Arial",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(400,70,600,30);
        label2.setFont(new Font("Arial",Font.BOLD,22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(350,100,600,30);
        label3.setFont(new Font("Arial",Font.BOLD,22));
        add(label3);

        JLabel label4 = new JLabel("NAME                      :");
        label4.setBounds(130,200,200,30);
        label4.setFont(new Font("Arial",Font.BOLD,20));
        add(label4);

        text1= new JTextField();
        text1.setFont(new Font("Arial",Font.BOLD,14));
        text1.setBounds(320,200,400,30);
        add(text1);

        JLabel label5 = new JLabel("FATHER'S NAME   :");
        label5.setBounds(130,250,200,30);
        label5.setFont(new Font("Arial",Font.BOLD,20));
        add(label5);

        text2= new JTextField();
        text2.setFont(new Font("Arial",Font.BOLD,14));
        text2.setBounds(320,250,400,30);
        add(text2);

        JLabel dob = new JLabel("DATE OF BIRTH     :");
        dob.setBounds(130,300,200,30);
        dob.setFont(new Font("Arial",Font.BOLD,20));
        add(dob);

        date=new JDateChooser();
        date.setForeground(new Color(150,105,105));
        date.setBounds(320,300,400,30);
        add(date);


        JLabel label6= new JLabel("GENDER                 :");
        label6.setBounds(130,350,200,30);
        label6.setFont(new Font("Arial",Font.BOLD,20));
        add(label6);

        r1=new JRadioButton("Male");
        r1.setFont(new Font("Arial",Font.BOLD,20));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(350,350,100,30);
        add(r1);

        r2=new JRadioButton("Female");
        r2.setFont(new Font("Arial",Font.BOLD,20));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(520,350,100,30);
        add(r2);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);

        JLabel labelEmail = new JLabel("EMAIL ADDRESS   :");
        labelEmail.setFont(new Font("Arial", Font.BOLD, 20));
        labelEmail.setBounds(130,400,200,30);
        add(labelEmail);

        text3= new JTextField();
        text3.setFont(new Font("Arial",Font.BOLD,14));
        text3.setBounds(320,400,400,30);
        add(text3);

        JLabel labelMs = new JLabel("MARITAL STATUS :");
        labelMs.setFont(new Font("Arial", Font.BOLD, 20));
        labelMs.setBounds(130,450,200,30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(330,450,100,30);
        m1.setBackground(new Color(222,255,228));
        m1.setFont(new Font("Arial", Font.BOLD,20));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,450,150,30);
        m2.setFont(new Font("Arial", Font.BOLD,20));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBackground(new Color(222,255,228));
        m3.setBounds(600,450,100,30);
        m3.setFont(new Font("Arial", Font.BOLD,20));
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        JLabel labelPin = new JLabel("PIN CODE               :");
        labelPin.setFont(new Font("Arial", Font.BOLD, 20));
        labelPin.setBounds(130,500,200,30);
        add(labelPin);

        text4= new JTextField();
        text4.setFont(new Font("Arial",Font.BOLD,14));
        text4.setBounds(320,500,400,30);
        add(text4);

//        button2 = new JButton("CLEAR");
//        button2.setFont(new Font("Arial",Font.BOLD,14));
//        button2.setBounds(350,550,100,30);
//        button2.setBackground(Color.BLACK);
//        button2.setForeground(Color.WHITE);
//        button2.addActionListener(this);
//        add(button2);

        next = new JButton("Next");
        next.setFont(new Font("Arial",Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(650,550,80,30);
        next.addActionListener(this);
        add(next);







        getContentPane().setBackground(new Color( 222,255,228));
        setLayout(null);
        setSize(850,700);
        setLocation(350,100);
        setVisible(true);



    }

    public static void main(String[] args) {
        new sign_up();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=s;
        String name=text1.getText();
        String fname=text2.getText();
        String dob=null;
        dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(r1.isSelected())
        {
            gender="Male";
        }
        else if (r2.isSelected()){gender="Female";}
        String email=text3.getText();
        String marital=null;
        if(m1.isSelected())
        {
            marital="Married";
        }
        else if(m2.isSelected())
        {
            marital="Unmarried";
        }
        else if(m3.isSelected())marital="Other";
        String pin=text4.getText();
        try
        {
           if (text1.getText().equals("") || text2.getText().equals("")||text3.getText().equals("")||text4.getText().equals("")|| gender == null || marital == null || dob == null)
           {
               JOptionPane.showMessageDialog(null,"Fill all the Fields");
           }
           else {
               connector c1 = new connector();
               String q="insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+pin+"')";
               c1.statement.executeUpdate(q);
               new signup2(s);
               setVisible(false);
           }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
    }
}
