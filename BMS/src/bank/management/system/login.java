package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener  {
           JButton login , clear , signup ;
           JTextField cardtextfield   ;
           JPasswordField  pintextfield;
    login(){
        setLayout(null); //make it null so we can use our customize layout
        setTitle("AUTOMATED TELLER MACHINE");  // sets the title of the frame

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); // gets the image from the system
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);// converted image obj back into imageicon obj because image obj. con't be passed in label obj
        JLabel label = new JLabel(i3);  // used to place the image on the frame. image can't be placed directly on the frame
        label.setBounds(70,10,100,100);
        add(label);                                  // label is added to the frame

        JLabel text = new JLabel("Welcome to  ATM");
        text.setFont(new Font("osward", Font.BOLD ,38));
        text.setBounds(200,40,400,40);
       // text.setBounds(200,40,100,40);  uncomment and see what happen
        add(text);

        JLabel Cardno = new JLabel("Card no:");
        Cardno.setFont(new Font("raleway", Font.BOLD ,28));
        Cardno.setBounds(120,150,400,40);
        // text.setBounds(200,40,100,40);  uncomment and see what happen
        add(Cardno);

         cardtextfield = new JTextField();
        cardtextfield.setBounds(300,150,230, 40);
        cardtextfield.setFont(new Font("arial",Font.BOLD,14));
        add(cardtextfield);

        JLabel PIN = new JLabel("PIN:");
        PIN.setFont(new Font("raleway", Font.BOLD ,28));
        PIN.setBounds(120,220,400,40);
        // text.setBounds(200,40,100,40);  uncomment and see what happen
        add(PIN);

         pintextfield = new JPasswordField();
        pintextfield.setBounds(300,220,230, 40);
        pintextfield.setFont(new Font("arial",Font.BOLD,14));
        add(pintextfield);

         login = new JButton("LOG IN");                   // login button
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

         clear = new JButton("CLEAR");                     // clear button
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

         signup = new JButton("SIGN UP");                  // signup button
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE); //to set the background of the frame

        setSize(800, 480);                // frame size
        setVisible(true);
        setLocation(350, 200);                 // initial frame location when pops up on the screen
    }
         public void actionPerformed(ActionEvent ae){


              if(ae.getSource() == login){
                  Conn conn = new Conn();
                  String cardnumber = cardtextfield.getText();
                      String pinnumber = pintextfield.getText();
                      String query = "select * from login where cardnumber = '"+cardnumber+"'and pin ='"+pinnumber+"'";
                      if(cardnumber.equals("")){
                          JOptionPane.showMessageDialog(null, "Please enter the Card no.");
                          return ;
                      }
                  if(pinnumber.equals("")){
                      JOptionPane.showMessageDialog(null, "Please enter the pin");
                      return ;
                  }
                      try {
                        ResultSet rs = conn.s.executeQuery(query); //resultset is a class in sql package used to retrieve data from database
                            if (rs.next()){  // this next method is used to move curse in the resultset gives true if their is next row otherwise false
                                setVisible(false);
                               new Transactions(pinnumber).setVisible(true);
                            }else{
                                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                               cardtextfield.setText("");
                               pintextfield.setText("");
                            }
                      }catch (Exception e){
                          System.out.println(e);
                      }
              } else if (ae.getSource() == clear) {
                 cardtextfield.setText("");
                 pintextfield.setText("");
              } else if (ae.getSource() == signup){
                        setVisible(false);
                    new SignupOne().setVisible(true);
              }
         }
    public static void main(String[] args) {
        new login ();
    }

}
