package data;

import baseClasses.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DBManager
{

    private static final String DB_URL = "jdbc:sqlite:./src/data/accounts.db";
    private static final String GET_ACCOUNTS = "SELECT * FROM ACCOUNTS";
    private static final String GET_BALANCES = "SELECT AccountBalance FROM Accounts";
    private static final String GET_NAMES = "SELECT AccountName FROM Accounts";


    public DBManager()
    {}

    private static Connection getConnection() throws SQLException
    {
        Connection conn;
        return (conn = DriverManager.getConnection(DB_URL));
    }


    public static List<Account> getAllAccounts() throws ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");

        try(
                Connection conn = getConnection();
                PreparedStatement statement = conn.prepareStatement(GET_ACCOUNTS);
           )
        {
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Account temp = new Account();

                temp.setName(rs.getString("AccountName"));
                temp.setAccountType(rs.getString("AccountType"));
                temp.setAccountNum(rs.getInt("AccountNumber"));
                temp.setAccountBalance(rs.getDouble("AccountBalance"));

                if(temp.getAccountType().equals("Credit"))
                    temp.setAccountLimit(rs.getDouble("CreditLimit"));

                accounts.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accounts;
    }


    public static List<String> getBalance() throws ClassNotFoundException {
        List<String> balances = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");

        try
        (
            Connection conn = getConnection();
            PreparedStatement statment = conn.prepareStatement(GET_BALANCES);

        )
        {
            ResultSet rs = statment.executeQuery();

            while(rs.next())
            {
                balances.add(String.format("$%,.2f", rs.getDouble("AccountBalance")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return balances;
    }


    public static List<String> getNames()
    {
        List<String> names = new ArrayList<>();
        try(
                Connection conn = getConnection();
                PreparedStatement statement = conn.prepareStatement(GET_NAMES);
                )
        {

            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                String temp = rs.getString("AccountName");
                names.add(temp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return names;
    }


    public static String getFormattedBalance() throws SQLException {
        String formatted = new String();
        double tempBal = 0;

        try(
                Connection conn = getConnection();
                PreparedStatement statement = conn.prepareStatement(GET_BALANCES)
                )
        {
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                tempBal += rs.getDouble("AccountBalance");
            }
        }

        return String.format("$%,.2f", tempBal);
    }
}
