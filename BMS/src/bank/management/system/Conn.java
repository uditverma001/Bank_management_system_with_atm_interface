package bank.management.system;
import java.sql.* ;


public class Conn {

     Connection c ; // Connection is an interface
     Statement s ;  // Statement is an interface

    public Conn(){
        try {
      //   Class.forName(com.mysql.cj.jdbc.Driver); //ab ye line likhne ki jrurat nhi h iske liye connector jar file use
                                                    //kri h ye apne aap driver ka path find kr leti h
         c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem" , "root" , "mysql");
         //DriverManager is a class in java.sql and we are using it's getConnection method is used to connect to the database
          s= c.createStatement(); // this method Creates a PreparedStatement object to send parameterized SQL statements to the database
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
