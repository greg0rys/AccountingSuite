package derivedClasses;
import baseClasses.Account;
import dataObjects.itemEntry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    /**
     * Get a hash set of the last five transactions in this account
     * @return a hashset containing the last 5 transactions.
     */
    public List<itemEntry> getLastFive()
    {
        if(manager == null)
            return null;

        // turn the set into a list to quickly grab members
        List<itemEntry> temp = new ArrayList<>(manager.getTransactions());
        List<itemEntry> collection = new ArrayList<>();

        // get the index of the start of the last five items in this list.
        int idx = (temp.size() - 5);
        for(; idx < temp.size(); idx++)
        {
            collection.add(temp.get(idx)); // add to the collection
        }

        return collection;
    }
}
