import javax.swing.*;
import java.sql.*;
import java.util.Scanner;
public class StoreMain {
    static Connection mainConnector;
    static void userScreen() throws SQLException, ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        Statement storeDisplayStatement=mainConnector.createStatement();
        ResultSet storeDisplayResult=storeDisplayStatement.executeQuery("SELECT * FROM STORE");
        Store store=new Store();
        while(storeDisplayResult.next())
        {
            store.setName(storeDisplayResult.getString(1));
            store.setPhoneNumber(storeDisplayResult.getLong(2));
            store.setAddress(storeDisplayResult.getString(3));
            store.setGSTCode(storeDisplayResult.getInt(4));
            store.setInvestment(storeDisplayResult.getDouble(5));
            store.setCurrentBalance(storeDisplayResult.getDouble(6));
        }
        System.out.println("WELCOME TO "+store.getName()+"\n");
        System.out.print("PHONE : "+store.getPhoneNumber()+"\t\t"+"ADDRESS : "+store.getAddress()+"\n");
        System.out.println("GST CODE : "+store.getGSTCode()+"\t\t\t"+"CURRENT BALANCE : "+store.getCurrentBalance());
        System.out.println();
        do {
            System.out.println("P-PURCHASE\nS-SELL\nV-VIEW INVENTORY");
            String storeOption = scanner.next();
            switch (storeOption)
            {
                case "P":
                    Purchase.purchase();
                    break;
                case "S":

                    break;
                case "V":
                    break;
                default:
                    System.out.println("INVALID OPTION! PLEASE ENTER A VALID OPTION.");
            }
        }while(true);

    }
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        Scanner scanner=new Scanner(System.in);
        Class.forName("org.postgresql.Driver");
        mainConnector= DriverManager.getConnection("jdbc:postgresql://localhost:5432/POSDatabase","postgres","manikantan1205");
        Statement checkStatement=mainConnector.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
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
                    PreparedStatement loginStatement = mainConnector.prepareStatement(loginQuery);
                    loginStatement.setString(1, username);
                    ResultSet loginResultSet = loginStatement.executeQuery();
                    if (loginResultSet.next()) {
                        String actualPassword = loginResultSet.getString(1);
                        if (actualPassword.equals(password)) {
                            userScreen();
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
                PreparedStatement credentialEntryStatement = mainConnector.prepareStatement(Query);
                credentialEntryStatement.setString(1, username);
                credentialEntryStatement.setString(2, password);
                credentialEntryStatement.executeUpdate();
                PreparedStatement storeInsertStatement=mainConnector.prepareStatement("INSERT INTO STORE VALUES(?,?,?,?,?,?)");
                storeInsertStatement.setString(1,store.getName());
                storeInsertStatement.setLong(2,store.getPhoneNumber());
                storeInsertStatement.setString(3,store.getAddress());
                storeInsertStatement.setInt(4,store.getGSTCode());
                storeInsertStatement.setDouble(5,store.getInvestment());
                storeInsertStatement.setDouble(6,store.getCurrentBalance());
                storeInsertStatement.executeUpdate();
                userScreen();


            }

    }
}
