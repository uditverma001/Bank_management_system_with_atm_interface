package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
       String pinnumber ;
       JTextField pintf , repintf ;
       JButton back , change ;

    public PinChange(String pinnumber) {
        this.pinnumber = pinnumber ;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change Your PIN ");
        text. setBounds(265,280,500,35);
        text.setFont(new Font("system", Font.BOLD, 16));
        text.setForeground(Color.white);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN: ");
        pintext. setBounds(165,320,100,25);
        pintext.setFont(new Font("system", Font.BOLD, 16));
        pintext.setForeground(Color.white);
        image.add(pintext);

         pintf = new JTextField();
        pintf.setBounds(330,320,180,25);
        pintf.setFont(new Font("raleway", Font.BOLD, 16));
        pintf.setBackground(Color.white);
        image.add(pintf);

        JLabel repintext = new JLabel("Re-Enter NEW PIN: ");
        repintext. setBounds(165,360,150,25);
        repintext.setFont(new Font("system", Font.BOLD, 16));
        repintext.setForeground(Color.white);
        image.add(repintext);

         repintf = new JTextField();
        repintf.setBounds(330,360,180,25);
        repintf.setFont(new Font("raleway", Font.BOLD, 16));
        repintf.setBackground(Color.white);
        image.add(repintf);

         change  = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

         back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);




        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == change) {
            try {
                String npin = pintf.getText();
                String rpin = repintf.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, " New PIN and Re-Entered PIN doesn't match");
                return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the New PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter the New PIN");
                    return;
                }

                if (npin.equals(rpin)) {
                    String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'" ;
                    String query2 = "update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'" ;
                    String query3 = "update signupthree set pin = '"+rpin+"' where pin ='"+pinnumber+"'" ;
                    Conn conn = new Conn();
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"PIN has Successfully Changed");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);
                }
            } catch (Exception e) {

            }
        }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }


}
