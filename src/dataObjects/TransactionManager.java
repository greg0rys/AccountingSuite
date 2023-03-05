package dataObjects;
import static java.lang.System.out;
import java.util.Set;

public class TransactionManager {
    private Set<itemEntry> transactions;
    private int            transactionCount;

    public TransactionManager()
    {
        transactions = null;
        transactionCount = 0;
    }

    public TransactionManager(Set<itemEntry> trans, int count)
    {
        transactions = trans;
        transactionCount = count;
    }


    public boolean addTransaction(itemEntry it)
    {
        if(transactions == null)
            transactions = new Set();
    }
}
