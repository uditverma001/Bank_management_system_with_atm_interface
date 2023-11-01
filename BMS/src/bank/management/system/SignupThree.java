package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1 , r2 , r3 , r4 ;
    JCheckBox c1,c2,c3,c4,c5,c6,c7 ;
    JButton submit , cancel ;
     String formno ;
    SignupThree(String formno){

       this.formno = formno;

            setLayout(null);
          JLabel l1 = new JLabel("Page 3 : Account Details");
          l1.setBounds(280 , 40 , 400 , 40);
          l1.setFont(new Font("raleway" , Font.BOLD, 22));
          add(l1);

        JLabel type = new JLabel("Account Type");
        type.setBounds(100 , 140 , 200 , 30);
        type.setFont(new Font("raleway" , Font.BOLD, 22));
        type.setBackground(Color.white);
        add(type);

              r1 = new JRadioButton("Savings Account");
              r1.setBounds(100,180,220,20);
              r1.setFont(new Font("raleway" , Font.BOLD,16));
              r1.setBackground(Color.white);
              add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setBounds(350,180,250,20);
        r2.setFont(new Font("raleway" , Font.BOLD,16));
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setBounds(100,220,250,20);
        r3.setFont(new Font("raleway" , Font.BOLD,16));
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,220,250,20);
        r4.setFont(new Font("raleway" , Font.BOLD,16));
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup acctype = new ButtonGroup();
        acctype.add(r1);
        acctype.add(r2);
        acctype.add(r3);
        acctype.add(r4);


        JLabel card = new JLabel("Card Number:");
        card.setBounds(100 , 300 , 200 , 30);
        card.setFont(new Font("raleway" , Font.BOLD, 22));
        card.setBackground(Color.white);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1301");
        number.setBounds(330 , 300 , 300 , 30);
        number.setFont(new Font("raleway" , Font.BOLD, 22));
        number.setBackground(Color.white);
        add(number);

        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setBounds(100 , 330 , 300 , 20);
        carddetails.setFont(new Font("raleway" , Font.BOLD, 12));
        carddetails.setBackground(Color.white);
        add(carddetails);

        JLabel pin = new JLabel("PIN  Number:");
        pin.setBounds(100 , 370 , 200 , 30);
        pin.setFont(new Font("raleway" , Font.BOLD, 22));
        pin.setBackground(Color.white);
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setBounds(330 , 370 , 300 , 30);
        pinnumber.setFont(new Font("raleway" , Font.BOLD, 22));
        pinnumber.setBackground(Color.white);
        add(pinnumber);

        JLabel pindetails = new JLabel("Your 4 Digit PIN ");
        pindetails.setBounds(100 , 400 , 300 , 20);
        pindetails.setFont(new Font("raleway" , Font.BOLD, 12));
        pindetails.setBackground(Color.white);
        add(pindetails);

        JLabel service = new JLabel("Service Required:");
        service.setBounds(100 , 450 , 200 , 30);
        service.setFont(new Font("raleway" , Font.BOLD, 22));
        service.setBackground(Color.white);
        add(service);

         c1 = new JCheckBox("ATM Card");
         c1.setBackground(Color.white);
         c1.setBounds(100,500,200,30);
         c1.setFont(new Font("raleway" , Font.BOLD ,16));
         add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(350,500,200,30);
        c2.setFont(new Font("raleway" , Font.BOLD ,16));
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(100,550,200,30);
        c3.setFont(new Font("raleway" , Font.BOLD ,16));
        add(c3);

        c4 = new JCheckBox("SMS Alerts");
        c4.setBackground(Color.white);
        c4.setBounds(350,550,200,30);
        c4.setFont(new Font("raleway" , Font.BOLD ,16));
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setBounds(100,600,200,30);
        c5.setFont(new Font("raleway" , Font.BOLD ,16));
        add(c5);

        c6 = new JCheckBox("E-Statements");
        c6.setBackground(Color.white);
        c6.setBounds(350,600,200,30);
        c6.setFont(new Font("raleway" , Font.BOLD ,16));
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setBounds(100,650,600,30);
        c7.setFont(new Font("raleway" , Font.BOLD ,12));
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBounds(200,720,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("raleway" , Font.BOLD,16));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(520,720,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("raleway" , Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,820);
          setLocation(350,0);
          setVisible(true);
          getContentPane().setBackground(Color.WHITE); // To change the color of the frame
          setTitle("Account Details Form ");

    }

    public void actionPerformed (ActionEvent ae){
         if (ae.getSource() == submit){
             String accountype = "" ;
             if (r1.isSelected()){
                 accountype = "Saving Account";
             }else if (r2.isSelected()){
                 accountype = "Fixed Deposit Account";
             }else if ( r3.isSelected()){
                 accountype = "Current Account";
             }else if(r4.isSelected()){
                 accountype = "Reccuring Deposit Account";
             }
             Random random = new Random();
             String cardnumber ="" + Math.abs(( random.nextLong() % 90000000L) + 8307139000000000L) ;
             String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L) ;
             String facility = "";
             String agree = "";
             if(c1.isSelected()){
                 facility = facility + "ATM Card";
             } else if (c2.isSelected()) {
                 facility = facility+ "Internet Banking";
             }else if (c3.isSelected()) {
                 facility = facility+ "Mobile Banking";
             }else if (c4.isSelected()) {
                 facility = facility+ "SMS Alerts";
             }else if (c5.isSelected()) {
                 facility = facility+ "Cheque Book";
             }else if (c6.isSelected()) {
                 facility = facility+ "E-Statement";
             }else if (c7.isSelected()){
                      agree = "true";
             }
             try {
//                    if (agree.equals("")) {
//                    JOptionPane.showMessageDialog(null, "To proceed further pick tick the last check box");
//                        return;}
                    if (facility.equals("")) {
                         JOptionPane.showMessageDialog(null, "Please Select atleast 1 of the facilities");
                        return;
                    }

                   if(accountype.equals("")){
                       JOptionPane.showMessageDialog(null,"Account Type is required to Selected");
                        return;
                   }
                       Conn conn = new Conn();
                       String query1 = "insert into signupthree values('" + formno + "','" + accountype + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                       String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                       conn.s.executeUpdate(query1);
                       conn.s.executeUpdate(query2);
                       JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n PIN:" + pinnumber);

                      setVisible(false );
                      new Deposit(pinnumber).setVisible(true);

             }catch (Exception e){
                 System.out.println(e);
             }

         }else if(ae.getSource() == cancel){
                   setVisible(false);
                   new login().setVisible(true);
         }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
