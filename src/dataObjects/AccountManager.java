package dataObjects;
import baseClasses.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountManager
{
    private List<Account> accountList;
    private int           totalAccounts;


    public AccountManager()
    {
        accountList = null;
        totalAccounts = 0;
    }


    /**
     * Set up an account manager with a list of accounts. This constructor safeguards against null implicit null assignment
     * @param accounts the List containing the accounts to add to the manager.
     */
    public AccountManager(List<Account> accounts)
    {

        accountList = (accounts != null) ? new ArrayList<>(accounts) : null;
        totalAccounts = (accountList != null) ? accountList.size() : 0;

    }


    public boolean addAccount(Account acct)
    {
        if(accountList == null)
            accountList = new ArrayList<>();

        return accountList.add(acct);
    }


    /**
     * Search for a given account in the account list.
     * @param acctName the name of the account we wish to find.
     * @return true if the account is found, false if else.
     *
     * For all remove operations, we will first perform a search and see if it exists
     */
    public boolean search(String acctName, boolean remove)
    {
        boolean found = false;

        for(Account ax: accountList)
        {
            found = ax.getAccountName().equals(acctName);

            // if the current account meets the search, and we have flagged remove, delete it
            if(found && remove)
                removeAccount(ax);
        }

        return found;
    }


    private void removeAccount(Account acct)
    {
        accountList.remove(acct);
    }
}
