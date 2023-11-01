package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

     JButton deposit , withdrawl , fastcash , mini_statement , balance_enquiry , pin_change ,exit ;
     String pinnumber ;
     Transactions(String pinnumber){

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

               deposit = new JButton("Deposite");
              deposit.setBounds(170,415,150,30);
              deposit.addActionListener(this);
              image.add(deposit);

          withdrawl = new JButton("Cash Withdrawl");
         withdrawl.setBounds(355,415,150,30);
         withdrawl.addActionListener(this);
         image.add(withdrawl);

          fastcash = new JButton("Fast Cash");
         fastcash.setBounds(170,450,150,30);
         fastcash.addActionListener(this);
         image.add(fastcash);

          mini_statement = new JButton("Mini Statement");
         mini_statement.setBounds(355,450,150,30);
         mini_statement.addActionListener(this);
         image.add(mini_statement);

          pin_change = new JButton("PIN Change");
         pin_change.setBounds(170,485,150,30);
         pin_change.addActionListener(this);
         image.add(pin_change);

          balance_enquiry = new JButton("Balance Enquiry");
         balance_enquiry.setBounds(355,485,150,30);
         balance_enquiry.addActionListener(this);
         image.add(balance_enquiry);

          exit = new JButton("Exit");
         exit.setBounds(355,520,150,30);
         exit.addActionListener(this);
         image.add(exit);

              JLabel text = new JLabel("Please select your transaction");
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
         if(ae.getSource()== exit){
             setVisible(false);
         }else if (ae.getSource() == deposit){
             setVisible(false);
             new Deposit(pinnumber).setVisible(true);
         }else if (ae.getSource() == withdrawl){
             new Withdrawl(pinnumber).setVisible(true);
         }else if (ae.getSource() == fastcash){
             setVisible(false);
             new FastCash(pinnumber).setVisible(true);
         }else if (ae.getSource() == pin_change){
             setVisible(false);
             new PinChange(pinnumber).setVisible(true);
         } else if (ae.getSource() == balance_enquiry) {
             setVisible(false);
             new BalanceEnquery(pinnumber).setVisible(true);
         } else if (ae.getSource() == mini_statement) {
             new MiniStatement(pinnumber).setVisible(true);
         }
     }
    public static void main(String[] args) {
        new Transactions("");
    }
}
