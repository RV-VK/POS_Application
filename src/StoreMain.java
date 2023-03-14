import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
public class StoreMain {
    static Connection conn;
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        Class.forName("org.postgresql.Driver");
        conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/POSDatabase","postgres","manikantan1205");
        Statement checkStatement=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet checkResultSet=checkStatement.executeQuery("select * from credentials");
            if (checkResultSet.next()) {
                System.out.println("WELCOME TO THE POS APPLICATION\n\n");
                System.out.println("LOOKS LIKE YOU ARE A REGISTERED USER\n\n");
                System.out.println("PLEASE ENTER THE CREDENTIALS TO LOG-IN\n");
                do {
                    System.out.println("Username : ");
                    String username = scanner.next();
                    System.out.println("Password : ");
                    String password = scanner.next();
                    String loginQuery = "SELECT PASSWORD FROM CREDENTIALS WHERE USERNAME=?";
                    PreparedStatement loginStatement = conn.prepareStatement(loginQuery);
                    loginStatement.setString(1, username);
                    ResultSet loginResultSet = loginStatement.executeQuery();
                    if (loginResultSet.next()) {
                        String actualPassword = loginResultSet.getString(1);
                        if (actualPassword.equals(password)) {
                            System.out.println("WELCOME HOME");
                            break;
                        } else {
                            System.out.println("INVALID PASSWORD!PLEASE TRY AGAIN");
                        }
                    } else {
                        System.out.println("INVALID USERNAME! PLEASE TRY AGAIN");
                    }
                }while(true);



            } else {
                System.out.println("WELCOME TO THE POS APPLICATION!\n\n");
                System.out.println("SEEMS LIKE YOU ARE NEW TO THE APPLICATION!\n\n");
                System.out.println("LETS GET YOU STARTED BY REGISTERING YOUR STORE\n\n");
                System.out.println("Enter the Store Name : ");
                String name = scanner.nextLine();
                System.out.println("Enter your PhoneNumber : ");
                long phoneNumber = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Enter the Address : ");
                String address = scanner.nextLine();
                System.out.println("Enter the GST Code : ");
                int GSTcode = scanner.nextInt();
                System.out.println("Enter the Amount of Investment : ");
                int investment = scanner.nextInt();
                Store store = new Store(name, phoneNumber, address, GSTcode, investment);
                System.out.println("Enter an Username to be created for the Shopkeeper");
                String username = scanner.next();
                System.out.println("Enter the password");
                String password = scanner.next();
                String Query = "INSERT INTO CREDENTIALS VALUES (?,?)";
                PreparedStatement credentialEntryStatement = conn.prepareStatement(Query);
                credentialEntryStatement.setString(1, username);
                credentialEntryStatement.setString(2, password);
                credentialEntryStatement.executeUpdate();


            }

    }
}
