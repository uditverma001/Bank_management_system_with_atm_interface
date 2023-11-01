package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class SignupOne extends JFrame implements ActionListener {

          long random ;
          JTextField nametf , fnametf ,  emailtf , adstf , citytf , statetf , pintf ;
          JButton next ;
          JRadioButton male , female , married , unmarried , other , others ;
          JDateChooser dc ;

          SignupOne(){
              setLayout(null);

               Random ran = new Random();
               random =  Math.abs((ran.nextLong() % 900L) + 100L) ; // in the brackets it's the formula to generate
                                                                       //a random 4 digit long val whose range is 1 to 9999
                 JLabel formno = new JLabel("APPLICATION FORM NO." + random  );
                 formno.setFont(new Font("raleway" , Font.BOLD , 38));
                 formno.setBounds(140,20, 600,40);
                 add(formno);

                 JLabel personalDetails = new JLabel( " Page 1 : personal Details");
                 personalDetails.setFont(new Font("raleway " , Font.BOLD , 22));
                 personalDetails.setBounds(280 , 80 , 400 , 30 );
                 add(personalDetails);

                 JLabel name = new JLabel("Name:");
                 name.setBounds(100,140,100,30);
                 name.setFont(new Font("raleway" , Font.BOLD, 22));
                 add(name);

                  nametf = new JTextField();
                 nametf.setFont(new Font("raleway",Font.BOLD,14));
                 nametf.setBounds(300,140,400,30);
                 add(nametf);

                 JLabel fname = new JLabel("Father's Name:");
                 fname.setBounds(100,190,200,30);
                 fname.setFont(new Font("raleway" , Font.BOLD, 22));
                 add(fname);

                  fnametf = new JTextField();
                 fnametf.setBounds(300,190,400,30);
                 fnametf.setFont(new Font("raleway",Font.BOLD,14));
                 add(fnametf);

            JLabel dob = new JLabel("Date of Birth:");
            dob.setBounds(100,240,200,30);
            dob.setFont(new Font("raleway" , Font.BOLD, 22));
            add(dob);

             dc = new JDateChooser();
            dc.setBounds(300,240,200,30);
            add(dc);

            JLabel Gender = new JLabel("Gender:");
            Gender.setBounds(100,290,200,30);
            Gender.setFont(new Font("raleway" , Font.BOLD, 22));
            add(Gender);

             male = new JRadioButton("Male");
            male.setBounds(300,290,60,30);
            male.setBackground(Color.WHITE);
            add(male);

             female = new JRadioButton("Female");
            female.setBounds(450,290,80,30);
            female.setBackground(Color.WHITE);
            add(female);

             others = new JRadioButton("others");
            others.setBounds(630,290,80,30);
            others.setBackground(Color.WHITE);
            add(others);

            ButtonGroup gendergroup = new ButtonGroup();  //it is used so that only one button can be selected at a time
            gendergroup.add(male);
            gendergroup.add(female);
            gendergroup.add(others);


            JLabel email = new JLabel("E-mail:");
            email.setBounds(100,340,200,30);
            email.setFont(new Font("raleway" , Font.BOLD, 22));
            add(email);

             emailtf = new JTextField();
            emailtf.setBounds(300,340,400,30);
            emailtf.setFont(new Font("raleway",Font.BOLD,14));
            add(emailtf);

            JLabel ms = new JLabel("Marital Status:");
            ms.setBounds(100,390,200,30);
            ms.setFont(new Font("raleway" , Font.BOLD, 22));
            add(ms);

             married = new JRadioButton("Married");
            married.setBounds(300,390,100,30);
            married.setBackground(Color.WHITE);
            add(married);

             unmarried = new JRadioButton("Unmarried");
            unmarried.setBounds(450,390,100,30);
            unmarried.setBackground(Color.WHITE);
            add(unmarried);

             other = new JRadioButton("Other");
            other.setBounds(630,390,80,30);
            other.setBackground(Color.WHITE);
            add(other);

            ButtonGroup maritalgroup = new ButtonGroup();  //it is used so that only one button can be selected at a time
            maritalgroup.add(married);
            maritalgroup.add(unmarried);
            maritalgroup.add(other);

            JLabel ads = new JLabel("Address:");
            ads.setBounds(100,440,200,30);
            ads.setFont(new Font("raleway" , Font.BOLD, 22));
            add(ads);

             adstf = new JTextField();
            adstf.setBounds(300,440,400,30);
            adstf.setFont(new Font("raleway",Font.BOLD,14));
            add(adstf);

            JLabel city = new JLabel("City:");
            city.setBounds(100,490,200,30);
            city.setFont(new Font("raleway" , Font.BOLD, 22));
            add(city);

             citytf = new JTextField();
            citytf.setBounds(300,490,400,30);
            citytf.setFont(new Font("raleway",Font.BOLD,14));
            add(citytf);

            JLabel state = new JLabel("State:");
            state.setBounds(100,540,200,30);
            state.setFont(new Font("raleway" , Font.BOLD, 22));
            add(state);

             statetf = new JTextField();
            statetf.setBounds(300,540,400,30);
            statetf.setFont(new Font("raleway",Font.BOLD,14));
            add(statetf);

            JLabel pin = new JLabel("PIN code:");
            pin.setBounds(100,590,200,30);
            pin.setFont(new Font("raleway" , Font.BOLD, 22));
            add(pin);

             pintf = new JTextField();
            pintf.setBounds(300,590,400,30);
            pintf.setFont(new Font("raleway",Font.BOLD,14));
            add(pintf);

             next = new JButton("Next");
            next.setBackground(Color.black);
            next.setForeground(Color.white);
            next.setBounds(620,650,80,30);
            next.addActionListener(this);
            add(next);

                 setSize(850,800);
                 getContentPane().setBackground(Color.white);
                 setLocation(350,10);
                 setVisible(true);
                 setTitle("");

         }

         public void actionPerformed(ActionEvent ae){
              String formno = "" + random ;
              String name = nametf.getText();
              String fname = fnametf.getText() ;
              String dob = ( (JTextField)dc.getDateEditor().getUiComponent()).getText();
              String gender = null ;
              if(male.isSelected()){
                  gender = "male" ;
              }else if(female.isSelected()){
                gender = "female";
             }else if(others.isSelected()){
                  gender = "other";
              }
              String email = emailtf.getText();
              String marital = null ;
              if (married.isSelected()){
                  marital = "married " ;
              }else if(unmarried.isSelected()){
                  marital = "unmarried";
              }else if(other.isSelected()){
                  marital = "other" ;
              }
              String ads = adstf.getText();
              String city = citytf.getText() ;
              String state = statetf.getText();
              String pin = pintf.getText();

              try{
                 if(name.equals("")){
                     JOptionPane.showMessageDialog(null, "Name is required");
                 }else {
                     Conn c = new Conn();
                     String query = "Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+ads+"','"+city+"','"+state+"','"+pin+"')";
                     //In the above line this is how we write a sql query in java
                     c.s.executeUpdate(query);

                     setVisible(false);
                     new SignupTwo(formno).setVisible(true);
                  }
              }catch (Exception e){
                  System.out.println(e);
              }
         }
    public static void main(String[] args) {
        new SignupOne();
    }

}
