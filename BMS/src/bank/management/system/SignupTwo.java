package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener {

    JTextField pantf,adhartf ;
    JButton next ;
    JRadioButton syes,sno,eyes,eno ;
    JComboBox relegion ,catgry,incomecat,education,occupation;
    String formno;

    SignupTwo(String formno){
        this.formno = formno ;
        setLayout(null);

        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel( " Page 2 : Additinal Details");
        additionalDetails.setFont(new Font("raleway " , Font.BOLD , 22));
        additionalDetails.setBounds(290 , 80 , 400 , 30 );
        add(additionalDetails);

        JLabel rel = new JLabel("Relegion:");
        rel.setBounds(100,140,150,30);
        rel.setFont(new Font("raleway" , Font.BOLD, 22));
        add(rel);

        String varRelegion[] = {"Hindu" , "Katua" , "Sikh" , "Christian" , "Other"};
         relegion = new JComboBox(varRelegion);
        relegion.setBounds(300,140,400,30);
        relegion.setBackground(Color.WHITE);
        add(relegion);

        JLabel category = new JLabel("Category:");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("raleway" , Font.BOLD, 22));
        add(category);

        String varcatgry[] = {"SC" , "ST" ,"BC","OBC","GENERAL"};
         catgry = new JComboBox(varcatgry);
        catgry.setBounds(300,190,400,30);
        catgry.setBackground(Color.WHITE);
        add(catgry);

        JLabel income = new JLabel("Income:");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("raleway" , Font.BOLD, 22));
        add(income);

        String incomecatgry[] = {"0 - 1,00,000" , "Below 2.5 Lacs" ,"Below 5 Lacs","Below 10 Lacs ","Above 10 Lacs"};
        incomecat = new JComboBox(incomecatgry);
        incomecat.setBounds(300,240,400,30);
        incomecat.setBackground(Color.WHITE);
        add(incomecat);

        JLabel edu = new JLabel("Education");
        edu.setBounds(100,290,200,30);
        edu.setFont(new Font("raleway" , Font.BOLD, 22));
        add(edu);


        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(100,315,200,30);
        qualification.setFont(new Font("raleway" , Font.BOLD, 22));
        add(qualification);

        String educationValues[] = {"Non Graduate" , "Graduate " , "Under Graduate" , "Post Graduate","Doctrate", "Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.white);
        add(education);

        JLabel ocupt = new JLabel("Occupation:");
        ocupt.setBounds(100,390,200,30);
        ocupt.setFont(new Font("raleway" , Font.BOLD, 22));
        add(ocupt);

        String occupationValues[] = {"Salaried" , "Self Employed " , "Bussiness" , "Student","Retiered", "Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel pannum = new JLabel("PAN Number:");
        pannum.setBounds(100,440,200,30);
        pannum.setFont(new Font("raleway" , Font.BOLD, 22));
        add(pannum);

        pantf = new JTextField();
        pantf.setBounds(300,440,400,30);
        pantf.setFont(new Font("raleway",Font.BOLD,14));
        add(pantf);

        JLabel city = new JLabel("Aadhar Number:");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("raleway" , Font.BOLD, 22));
        add(city);

        adhartf = new JTextField();
        adhartf.setBounds(300,490,400,30);
        adhartf.setFont(new Font("raleway",Font.BOLD,14));
        add(adhartf);

        JLabel state = new JLabel("Senior Citizen:");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("raleway" , Font.BOLD, 22));
        add(state);


        syes = new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();  //it is used so that only one button can be selected at a time
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel pin = new JLabel("Existing Account:");
        pin.setBounds(100,590,200,30);
        pin.setFont(new Font("raleway" , Font.BOLD, 22));
        add(pin);


        eyes = new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();  //it is used so that only one button can be selected at a time
        existingGroup.add(eyes);
        existingGroup.add(eno);

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


    }

    public void actionPerformed(ActionEvent ae) {
        String srelegion = (String) relegion.getSelectedItem(); // this method returns object so need to convert to
        //  String expictily
        String scategory = (String) catgry.getSelectedItem();
        String sincome = (String) incomecat.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes ";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }
            String span = pantf.getText();
            String sadhar = adhartf.getText();

            try {
                    Conn c = new Conn();
                    String query = "Insert into signuptwo values('" + formno + "','" + srelegion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + sadhar + "','" + seniorcitizen + "','" + existingaccount+ "')";
                    //In the above line this is how we write a sql query in java
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
               } catch (Exception e) {
                System.out.println(e);
            }
        }

    public static void main(String[] args) {
        new SignupTwo("");
    }

}

