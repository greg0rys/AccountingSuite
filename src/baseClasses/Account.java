package baseClasses;

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


}
