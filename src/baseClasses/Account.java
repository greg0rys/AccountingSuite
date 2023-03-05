package baseClasses;

import static java.lang.System.out;

public class Account
{
    private String accountName;
    private double accountNum;
    private String accountType;
    private double accountBalance;

    public Account()
    {
        accountName = accountType = null;
        accountNum = accountBalance = 0.00;
    }

    public Account(String name, String type, double ... nums)
    {
        accountName = name;
        accountType = type;
        accountNum = nums[0];
        accountBalance = nums[1];

    }

    public String getAccountName()
    {
        return accountName;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public double getAccountNum()
    {
        return accountNum;
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

    public void setAccountNum(double acctNum)
    {
        accountNum = acctNum;
    }

    public void setAccountBalance(double bal)
    {
        accountBalance = bal;
    }

    public void display()
    {
        out.format(
                accountName + "\n\tAccount Type: " + accountType
                + "\n\tAccount number: " + accountNum + "\n\tAccount Balance: %d",
                accountBalance
        );
    }


}
