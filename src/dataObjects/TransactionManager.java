package dataObjects;
import static java.lang.System.out;

import java.util.HashSet;
import java.util.Set;

public class TransactionManager {
    private class node
    {
        itemEntry data;

    }
    private Set<itemEntry> transactions;
    private int            transactionCount;

    public TransactionManager()
    {
        transactions = null;
        transactionCount = 0;
    }

    public TransactionManager(Set<itemEntry> trans, int count)
    {
        // use HashSet copy constructor
        transactions = new HashSet<>(trans);
        transactionCount = count;
    }


    public boolean addTransaction(itemEntry it)
    {
        if(transactions == null)
            transactions = new HashSet<>();

        transactions.add(it);
        return true;
    }
}
