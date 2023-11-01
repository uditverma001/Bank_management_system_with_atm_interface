package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String pinnumber ;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(130,20,150,20);
        bank.setFont(new Font("system", Font.BOLD,20));
        add(bank);

        JLabel card = new JLabel("Card");
        card.setBounds(20,30,300,200);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,500,400,20);
        balance.setFont(new Font("raleway",Font.BOLD,16));
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
             while(rs.next()){
                 card.setText(" cardnumber:" + rs.getString("cardnumber").substring(0,4)+"XXXXXXXX" + rs.getString("cardnumber").substring(12));

             }
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            int bal = 0 ;
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
              while(rs.next()) {
                  mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");
                  if (rs.getString("type").equals("deposit")) {
                      bal += Integer.parseInt(rs.getString("amount"));
                  } else if (rs.getString("type").equals("withdrawl")) {
                      bal -= Integer.parseInt(rs.getString("amount"));
                  }
              }
              balance.setText("Your current account balance is Rs "+ bal);
        }catch (Exception e){
            System.out.println(e);
        }


        setTitle("Mini Statement ");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("") ;
    }
}
