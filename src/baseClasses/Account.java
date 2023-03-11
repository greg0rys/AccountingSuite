/**
 * @author Greg Shenefelt
 * @date 03/01/23
 * @version 0.0.1
 * <p>
 * The account class is the super class for the classes listed:
 * *  ./derivedClasses/creditCard *
 * *  ./derivedClass/debitCard    *
 * *  ./derivedClass/bankAccount  *
 * * * * * * * * * * * * * * * * *
 * <p>
 * It creates the methods for setting and updating the balance and account information,
 * while its subclasses are more specialized versions of the class.
 */

package baseClasses;

import dataObjects.TransactionManager;
import dataObjects.itemEntry;
import derivedClasses.bankAccount;

import java.util.*;

import static java.lang.System.out; // shorthand System.out.println

public class Account {
    private String accountName;
    private String accountType;

    private int fullAcctNum;

    private double accountBalance;
    private double accountLimit;
    protected TransactionManager manager; // a hashset that manages all the transactions of a given account.

    public Account()
    {
        accountName = accountType = null;
        accountBalance = 0.00;
        fullAcctNum = 0;
        manager = null;
    }

    public Account(String name,
                   String type,
                   int acctNum,
                   double bal)
    {
        accountName = name;
        accountType = type;
        fullAcctNum = acctNum;
        accountBalance = bal;
        manager = null;
    }

    /**
     * get the name of a given account
     * @return the name of the account
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * get the type of this account object.
     *  EX: Bank, Credit, or Debit
     * @return the type of the account from the list above.
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * get the accounts number
     * @return the 16-digit account number.
     */
    public int getAccountNum() {
        return fullAcctNum;
    }



    /**
     * get the current balance of an account
     * @return the balance of an account.
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * set the name of the account
     * @param name the new name to be applied to the account.
     */
    public void setName(String name) {
        accountName = name;
    }

    /**
     * set the type of this account.
     * TODO: need to setup exceptions to stop them from entering something that isn't a credit, debit, or bank account
     * @param type
     */
    public void setAccountType(String type) {
        accountType = type;
    }


    /**
     * set the accounts number.
     * TODO: setup exception for accounts > 8 digits.
     * @param acctNum
     */
    public void setAccountNum(int acctNum) {
        fullAcctNum = acctNum;
    }


    /**
     * set the accounts balance
     * @param bal a double representing the accounts balance.
     *            TODO setup safegaurds for other data types being passed in.
     */
    public void setAccountBalance(double bal) {
        accountBalance = bal;
    }


    public void setAccountLimit(double bal)
    {
        accountLimit = bal;
    }
    /**
     * Split the full account number down to the last four digits.
     * @param num the number we wish to split down.
     * @return the last 4 digits of the accounts number.
     */
    private int split(int num) {
        ArrayList<Integer> temp = new ArrayList<>();
        int res = 0;

        while (num > 0) {
            temp.add((num % 10));
            num /= 10;
        }

        return getLastFour(temp);
    }


    /**
     * convert the last four numbers in the accountNum ArrayList back into a single
     * integer.
     * @return the last 4 digits of an account number.
     */
    private int getLastFour(ArrayList<Integer> list) {
        int x;       // loop variable saves the compiler some time declaring it ahead.
        int res = 0; // the result holding out last four.

        // get the last four of the acct num using base 10 tactics.
        for (x = list.size() - 4; x <= list.size(); x++) {
            res *= 10;
            res += list.get(x);
        }

        return res;
    }


    /**
     * Return the total number of transactions in the application.
     * @return a whole number representing the number of transactions.
     */
    public int getNumTransactions()
    {
        if(manager == null)
            return 0;

        return manager.getTransactionCount();
    }

    /**
     * display the accounts info in a formatted way.
     */
    public void display() {
        out.println(getFormattedInfo());
    }


    /**
     * Format the accounts info to display the account balance in proper format
     * @return a string containing all the account info in a formatted way.
     */
    private String getFormattedInfo() {
        String info = "Account: " + accountName
                + "\n\tType: " + accountType
                + "\n\tAccount Number: " + fullAcctNum
                + "\n\t";
        info += String.format("The account balance is: .2%f", accountBalance);
        return info;

    }

    /**
     * Add a transaction to the set while also keeping track of its type.
     * If it is a credit add it to credits set else add to debits set
     * This will allow quick sorting of the different types of transactions.
     * @param it an itemEntry object
     * @return true if the item was added, false if else.
     */
    public boolean addTransaction(itemEntry it)
    {
        // perform balance checks on the account to make sure we don't go over the credit limit or draw the account
        // negative.
        if(accountType.equals("Bank Account"))
        {
            if(checkNegative(it.getItemPrice()))
                return false;
        }
        else if(accountType.equals("Credit"))
        {
            // check over limit
            if(overLimit(it.getItemPrice()))
                return false;
        }

        if(manager == null)
            manager = new TransactionManager();

        return manager.addItem(it, it.getCredit());
    }


    protected boolean checkNegative(double amount)
    {
        return accountBalance == 0 || accountBalance - amount <= 0;
    }


    protected boolean overLimit(double amount)
    {
        return accountBalance > accountLimit || (accountBalance + amount) > accountLimit;
    }
    /**
     * Get an array of recent deposits to the account.
     * @return an array list of all deposits to this account
     *         if the deposit set is null or empty, returns null
     */
    public Set<itemEntry> getCredits()
    {
        if(manager == null)
            return null;

        return manager.getCredits();

    }

    /**
     * return an array of all debits to the account
     * @return a HashSet of all debits for an account - null if no transaction manager is active.
     */
    public Set<itemEntry> getDebits()
    {
        if(manager == null)
            return null;

        return manager.getDebits();
    }



}
