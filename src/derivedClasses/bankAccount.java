package derivedClasses;
import baseClasses.Account;

public class bankAccount extends Account
{
    private String bankName;

    public bankAccount()
    {
        super(null,null,0,0.00);
        bankName = null;
    }

    public bankAccount(Account act, String name)
    {
        super(
                act.getAccountName(),
                act.getAccountType(),
                act.getAccountNum(),
                act.getAccountBalance()
        );
        bankName = name;
    }

    public boolean withdrawl(double amount)
    {
        if(checkNegative(amount))
            return false;

        super.setAccountBalance(super.getAccountBalance() - amount);
        return true;
    }


    private boolean checkNegative(double amount)
    {
        double currentBalance = getAccountBalance();
        if(currentBalance == 0 || currentBalance - amount <= 0)
            return true;
        return false;
    }



    public void deposit(double total)
    {
        super.setAccountBalance(super.getAccountBalance() + total);
    }




}
