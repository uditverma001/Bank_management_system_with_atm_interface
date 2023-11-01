package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton rs100 , rs500 , rs1000 , rs2000 , rs5000 , rs10000 ,back ;
    String pinnumber ;
    FastCash(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); // gets the image from the system
        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResources("icons/atm.jpg")); this will give error because
        //                                                                    getSystemResource and getSystemResources
        //                                                                           these are two diff. methods
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        rs100 = new JButton("Rs 100");
        rs100.setBounds(170,415,150,30);
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.setBounds(355,415,150,30);
        rs500.addActionListener(this);
        image.add(rs500);

        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(170,450,150,30);
        rs1000.addActionListener(this);
        image.add(rs1000);

        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(355,450,150,30);
        rs2000.addActionListener(this);
        image.add(rs2000);

        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(170,485,150,30);
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(355,485,150,30);
        rs10000.addActionListener(this);
        image.add(rs10000);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text); // here we use image object to call add method becasue we need text above the image
        //  add(text); If we use this method only then our text will be on the frame but below the image


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
          // here we have done explicit typecasting becasue ae.getSource returns Oject which we convert into Jbutton
           //so that we can get text from the button which user click eg. Rs 500
           // here we use substring to remove (Rs ) because we only require the amount
           // this is a dynamic approach because otherwise we have to create conditions for each button
            Conn conn = new Conn();
            try {
                String query = "select * from bank where pin ='"+pinnumber+"'" ;
                 ResultSet rs = conn.s.executeQuery(query);
                 int balance = 0 ;
                 while (rs.next()){
                     if (rs.getString("type").equals("deposit")){
                         balance += Integer.parseInt(rs.getString("amount"));
                     }else if (rs.getString("type").equals("withdrawl")){
                         balance -= Integer.parseInt(rs.getString("amount"));
                     }

                     if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                         JOptionPane.showMessageDialog(null , "Insufficient Balance");
                         return ;
                     }

                      Date date  = new Date();
                     String query2 = "insert into bank values ('"+pinnumber+"', '"+date+"','withdrawl','"+amount+"')";
                     conn.s.executeUpdate(query2);
                     JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
                 }
            }catch (Exception e){

            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
