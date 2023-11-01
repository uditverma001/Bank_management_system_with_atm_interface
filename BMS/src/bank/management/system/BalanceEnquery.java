package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BalanceEnquery extends JFrame implements ActionListener {

    String pinnumber ;
    JButton back;

    BalanceEnquery(String pinnumber){

        this.pinnumber = pinnumber ;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

         back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        int balance = 0 ;
        try {
            String query = "select * from bank where pin ='"+pinnumber+"'" ;
            ResultSet rs = conn.s.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else if (rs.getString("type").equals("withdrawl")) {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your current account balance is "+balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.white);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
          if(ae.getSource() == back){
              setVisible(false);
              new Transactions(pinnumber).setVisible(true);
          }
    }
    public static void main(String[] args) {
        new BalanceEnquery("");
    }


}
