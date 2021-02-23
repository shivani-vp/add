package program12;
import java.sql.*;
import java.util.*;

class Sample
{
    String usn,fname,lname;
    Scanner input = new Scanner(System.in);
    Connection con;
    Statement stmt;    
    ResultSet rs;
    Sample() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
        con = DriverManager.getConnection("jdbc:mysql://172.16.2.3/student","student","student");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs=stmt.executeQuery("select * from student170");
    }
    
    public void insert() throws SQLException
    {           
       String usn,fname,lname;
       
       System.out.println("Enter the usn");
       usn = input.next();
       
       System.out.println("Enter the fname");
       fname = input.next();
       
       System.out.println("Enter the lname");
       lname = input.next();
       
       rs.moveToInsertRow();
       rs.updateString("usn",usn);
       rs.updateString("fname",fname);
       rs.updateString("lname",lname);
       rs.insertRow();
     }
    void deleteRow(int row) throws SQLException
    {
        
        rs.absolute(row);
        rs.deleteRow();

    }
    void searchUSN(String usn) throws SQLException
    {        
        
        if( rs.first() )
        {
            if(usn.equals(rs.getString("usn")))
            {
               System.out.println("USN: " + usn + "is found");
               return;
            }
        }
        while(rs.next())
        {
            if(usn.equals(rs.getString("usn")))
            {
              System.out.println("USN: " + usn + " is found");            
              return;                
            }
                
        }     
        System.out.println("USN: " + usn + "is NOT found in the table...");
    }
    
    void updateRow(int row) throws SQLException
    {        
        System.out.println("Enter the new fname");
                
        String fname = input.next();
        System.out.println("Enter the new lname");
        String lname = input.next();
        rs.absolute(row);
        rs.updateString("fname",fname);
        rs.updateString("lname",lname);
        rs.updateRow();
     }

}

public class Experiment12
{
    public static void main(String args[]) throws Exception
    {
       Sample obj=new Sample();
       
       while(true)
       {
            System.out.println("1.Insert 2.Update 3.Search");
            Scanner s=new Scanner(System.in);
            int choice=s.nextInt();
            switch(choice)
            {
                case 1:
                    obj.insert();
                    break;
                case 2:
                    System.out.println("Enter the row no to be upadated");
                    int row=s.nextInt();
                    obj.updateRow(row);
                    break;
                case 3:
                    System.out.println("Enter the usn to be searched...");
                    String usn=s.next();
                    obj.searchUSN(usn);
                    break;
                default:
                System.exit(0);
                break;
            }
        }
     }
 }