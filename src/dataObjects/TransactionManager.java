package dataObjects;
import static java.lang.System.out;

import java.util.HashSet;
import java.util.Set;

public class TransactionManager {

    private Set<itemEntry> transactions;    // a hashset of all transactions
    private int            transactionCount;// an int count of all transactions
    private Set<itemEntry> debits;          // a hashset containing a copy of all debits to the account.
    private Set<itemEntry> credits;         // a hashset containing a copy of all credits to the account.

    /**
     * Default constructor no params, all fields null, count = 0.
     */
    public TransactionManager()
    {
        transactions = debits = credits = null;
        transactionCount = 0;
    }


    /**
     * Add a transaction to a given set, before the item is passed here it will have been checked to make sure the
     * account either A) doesn't go negative if it's a bank account or B) doesn't go over limit if its a credit acct
     * @param it the item we want to add to the set
     * @param isDebit true if the item is a debit false if else, used to add to proper collection
     * @return true if item is added - false if else.
     */
    public boolean addItem(itemEntry it, boolean isDebit)
    {
        if(transactions == null)
            transactions = new HashSet<>();

        if(isDebit)
        {
            if(debits == null)
                debits = new HashSet<>();

            debits.add(it);
        }
        else
        {
            if(credits == null)
                credits = new HashSet<>();

            credits.add(it);
        }

        transactionCount++;
        return transactions.add(it);
    }


    /**
     * Get an array of itemEntry objects that gave a credit to an account.
     * @return an array representing all credits in the transaction manager
     */
    public itemEntry[] getCredits()
    {
        if(credits.isEmpty())
            return null;


        itemEntry[] it = new itemEntry[credits.size()];

        credits.toArray(it);
        return it;
    }


    /**
     * Get an array of itemEntry objects that caused a debit to an account
     * @return an array of all debits in the transaction manager.
     */
    public itemEntry[] getDebits()
    {
        if(debits.isEmpty())
            return null;
        itemEntry[] it = new itemEntry[debits.size()];
        debits.toArray(it);

        return it;
    }



    /**
     * Get the total number of transactions for an account
     * @return an integer representing the total number of items in the manager - 0 if none.
     */
    public int getTransactionCount()
    {
        return transactionCount;
    }




}
