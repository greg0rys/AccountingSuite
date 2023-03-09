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

    public boolean deposit(double amount)
    {
        super.setAccountBalance(getAccountBalance() + amount);
        return true;
    }

    /**
     * Make a withdrawal from the account, check that the transaction doesn't make it negative.
     * @param amount the amount to take out of the bank
     * @return true if the user can withdraw false if else
     */
    public boolean withdraw(double amount)
    {
        if(checkNegative(amount))
            return false;

        super.setAccountBalance(getAccountBalance() - amount);
        return true;
    }


    /**
     * Get the name of the bank that hosts this account
     * @return a String representing the banks name.
     */
    public String getBankName()
    {
        return bankName;
    }


    public void getLastFive()
    {

    }
}
