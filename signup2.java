package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class signup2 extends JFrame implements ActionListener {
    JComboBox combobox,combobox2,combobox3,combobox4;
    JTextField text1,text2;
    JRadioButton r1,r2,e1,e2;
    JButton next;
    String formno;
    signup2(String formno){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png") );
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,10,100,100);
        add(image);

        this.formno=formno;

        JLabel l1= new JLabel("Page no : 2");
        l1.setFont(new Font("Arial",Font.BOLD,22));
        l1.setBounds(350,20,400,60);
        add(l1);

        JLabel l2= new JLabel("Additional Information");
        l2.setFont(new Font("Arial",Font.BOLD,22));
        l2.setBounds(300,68,400,60);
        add(l2);

        JLabel label3 = new JLabel("Religion                :");
        label3.setFont (new Font("Arial",Font.BOLD,20));
        label3.setBounds(150,150,240,30);
        add(label3);

        String religion[] = {"Hindu","Muslim","Christian","Other"};
        combobox=new JComboBox(religion);
        combobox.setFont(new Font("Arial",Font.BOLD,14));
        combobox.setBounds(350,150,320,30);
        add(combobox);

        JLabel label4=new JLabel("Category               : ");
        label4.setFont(new Font("Arial",Font.BOLD,20));
        label4.setBounds(150,200,240,30);
        add(label4);

        String category[] = {"General","OBC","SC/ST","Other"};
        combobox2=new JComboBox(category);
        combobox2.setFont(new Font("Arial",Font.BOLD,14));
        combobox2.setBounds(350,200,320,30);
        add(combobox2);

        JLabel label5=new JLabel("Income                  : ");
        label5.setFont(new Font("Arial",Font.BOLD,20));
        label5.setBounds(150,250,240,30);
        add(label5);

        String income[] = {">10,00,000",">5,00,000 & <10,00,000","<5,00,000","null"};
        combobox3=new JComboBox(income);
        combobox3.setFont(new Font("Arial",Font.BOLD,14));
        combobox3.setBounds(350,250,320,30);
        add(combobox3);

        JLabel label6= new JLabel("Occupation           : ");
        label6.setFont(new Font("Arial",Font.BOLD,20));
        label6.setBounds(150,300,240,30);
        add(label6);

        String occupation[] = {"Salaried","Self Employed","Others","null"};
        combobox4=new JComboBox(occupation);
        combobox4.setFont(new Font("Arial",Font.BOLD,14));
        combobox4.setBounds(350,300,320,30);
        add(combobox4);

        JLabel label7= new JLabel("PAN No                 : ");
        label7.setFont(new Font("Arial",Font.BOLD,20));
        label7.setBounds(150,350,240,30);
        add(label7);

        text1= new JTextField();
        text1.setFont(new Font("Arial",Font.BOLD,14));
        text1.setBounds(350,350,320,30);
        add(text1);

        JLabel label8= new JLabel("Aadhaar No          : ");
        label8.setFont(new Font("Arial",Font.BOLD,20));
        label8.setBounds(150,400,240,30);
        add(label8);

        text2= new JTextField();
        text2.setFont(new Font("Arial",Font.BOLD,14));
        text2.setBounds(350,400,320,30);
        add(text2);

        JLabel label9= new JLabel("Senior Citizen      : ");
        label9.setFont(new Font("Arial",Font.BOLD,20));
        label9.setBounds(150,450,240,30);
        add(label9);

        r1=new JRadioButton("Yes");
        r1.setFont(new Font("Arial",Font.BOLD,14));
        r1.setBounds(350,450,75,30);
        add(r1);

        r2=new JRadioButton("No");
        r2.setFont(new Font("Arial",Font.BOLD,14));
        r2.setBounds(450,450,75,30);
        add(r2);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(r1);
        group1.add(r2);

        JLabel label10= new JLabel("Existing Account : ");
        label10.setFont(new Font("Arial",Font.BOLD,20));
        label10.setBounds(150,500,240,30);
        add(label10);

        e1=new JRadioButton("Yes");
        e1.setFont(new Font("Arial",Font.BOLD,14));
        e1.setBounds(350,500,75,30);
        add(e1);

        e2=new JRadioButton("No");
        e2.setFont(new Font("Arial",Font.BOLD,14));
        e2.setBounds(450,500,75,30);
        add(e2);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(e1);
        group2.add(e2);

        JLabel label11 = new JLabel("Form No :");
        label11.setFont(new Font("Arial",Font.BOLD,20));
        label11.setBounds(650,20,240,30);
        add(label11);

        JLabel label12 = new JLabel(formno);
        label12.setFont(new Font("Arial",Font.BOLD,20));
        label12.setBounds(750,20,240,30);
        add(label12);

        next = new JButton("Next");
        next.setFont(new Font("Arial",Font.BOLD,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(650,600,100,30);
        next.addActionListener(this);
        add(next);



        setLayout(null);
        getContentPane().setBackground(new Color( 252,208,76));
        setSize(850,750);
        setLocation(350,80);
        setVisible(true);
    }

    public static void main(String[] args) {
        new signup2(" ");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String rel = (String) combobox.getSelectedItem();
        String cat=(String) combobox2.getSelectedItem();
        String inc=(String) combobox3.getSelectedItem();
        String occ=(String) combobox4.getSelectedItem();

        String pin=text1.getText();
        String aadhaar=text2.getText();

        String citizen=null;
        if(r1.isSelected())
        {
            citizen="Yes";
        }
        else if(r2.isSelected())
        {
            citizen="No";
        }
        String eAccount=null;
        if(e1.isSelected())
        {
            eAccount="Yes";
        }
        else if(e2.isSelected())  {
            eAccount="No";
        }

        try{
            if(pin.equals(null) || aadhaar.equals(null) || citizen==null || eAccount==null )
            {
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }
            else
            {
                connector c= new connector();
                String q="insert into signup2 values('"+formno+"','"+rel+"','"+cat+"','"+inc+"','"+occ+"','"+pin+"','"+aadhaar+"','"+citizen+"','"+eAccount+"')";
                c.statement.executeUpdate(q);
                new signup3(formno);
                setVisible(false);

            }
        } catch (SQLException E) {
            E.printStackTrace();
        }


    }
}
