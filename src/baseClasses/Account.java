package baseClasses;

import java.util.ArrayList;

import static java.lang.System.out;

public class Account
{
    private String accountName;
    private String accountType;

    private int fullAcctNum;
    private ArrayList<Integer> accountNum; // split the account num into a dynamic array to output last 4 digits.

    private double accountBalance;

    public Account()
    {
        accountName = accountType = null;
        accountBalance = 0.00;
        accountNum = null;
        fullAcctNum = 0;
    }

    public Account(String name, String type,
                   int acctNum, double bal)
    {
        accountName = name;
        accountType = type;
        fullAcctNum = acctNum;
        // split the account number into a dynamic array
        // this way we can output just the last 4 digits in the jTable.
        accountNum = split(acctNum);
        accountBalance = bal;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public int getAccountNum()
    {
        return fullAcctNum;
    }

    public double getAccountBalance()
    {
        return accountBalance;
    }

    public void setName(String name)
    {
        accountName = name;
    }

    public void setAccountType(String type)
    {
        accountType = type;
    }

    public void setAccountNum(int acctNum)
    {
        fullAcctNum = acctNum;
        accountNum = split(acctNum);
    }

    private ArrayList<Integer> split(int num)
    {
        ArrayList<Integer> temp = new ArrayList<>();

        while(num > 0)
        {
            temp.add((num % 10));
            num /= 10;
        }

        return temp;
    }
    public void setAccountBalance(double bal)
    {
        accountBalance = bal;
    }

    public void display()
    {
        out.println(getFormattedInfo());
    }


    /**
     * Format the accounts info to display the account balance in proper format
     * @return a string containing all the account info in a formatted way.
     */
    private String getFormattedInfo()
    {
        String info = "Account: " + accountName
                       + "\n\tType: " + accountType
                       + "\n\tLast 4 of Account Number: " + getLastFour()
                       + "\n\t";
        info += String.format("The account balance is: .2%f", accountBalance);
        return info;

    }

    private int getLastFour()
    {
        int x;       // loop variable saves the compiler some time declaring it ahead.
        int res = 0; // the result holding out last four.

                     // get the last four of the acct num using base 10 tactics.
        for(x = accountNum.size() - 4; x < accountNum.size(); x++)
        {
            res *= 10;
            res += accountNum.get(x);
        }

        return res;
    }


}
