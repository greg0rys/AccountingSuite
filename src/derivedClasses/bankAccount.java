package derivedClasses;
import baseClasses.Account;

public class bankAccount extends Account
{
    private String bankName;

    public bankAccount()
    {
        super(null,null,0,0.00,0);
        bankName = null;
    }

    public bankAccount(Account act, String name)
    {
        super(
                act.getAccountName(),
                act.getAccountType(),
                act.getAccountNum(),
                act.getAccountBalance(),
                act.getNumTransactions()
        );
        bankName = name;
    }

    /**
     * Make a withdrawl from the account, and set the base objects balance.
     * @param amount the amount we wish to detract from the account
     * @return true if account balance will still be >= 0 after the withdrawal, false if else.
     */
    public boolean withdrawl(double amount)
    {
        if(checkNegative(amount))
            return false;

        super.setAccountBalance(super.getAccountBalance() - amount);
        return true;
    }


    /**
     * Check to see if a withdrawal from this account will
     * @param amount the amount we wish to detract from this account
     * @return true if the account balance will fall below zero - false if else.
     */
    private boolean checkNegative(double amount)
    {
        // get the account balance to only call for it once, but perform two checks on it.
        double accountBalance = getAccountBalance();
        return accountBalance == 0 || accountBalance - amount <= 0;
    }



    public void deposit(double total)
    {
        super.setAccountBalance(super.getAccountBalance() + total);
    }




}
