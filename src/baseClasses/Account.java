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

import java.util.ArrayList;

import static java.lang.System.out; // shorthand System.out.println

public class Account {
    private String accountName;
    private String accountType;

    private int fullAcctNum;
    private int last4Acct;
    private double accountBalance;

    public Account() {
        accountName = accountType = null;
        accountBalance = 0.00;
        last4Acct = 0;
        fullAcctNum = 0;
    }

    public Account(String name, String type,
                   int acctNum, double bal) {
        accountName = name;
        accountType = type;
        fullAcctNum = acctNum;
        last4Acct = split(acctNum);
        accountBalance = bal;
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
     * get the last for digits of the accounts number.
     * @return the last four digits of the account number.
     */
    public int getLast4() {
        return last4Acct;
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
        last4Acct = split(acctNum);
    }


    /**
     * set the accounts balance
     * @param bal a double representing the accounts balance.
     *            TODO setup safegaurds for other data types being passed in.
     */
    public void setAccountBalance(double bal) {
        accountBalance = bal;
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
        for (x = list.size() - 4; x < list.size(); x++) {
            res *= 10;
            res += list.get(x);
        }

        return res;
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
                + "\n\tLast 4 of Account Number: " + last4Acct
                + "\n\t";
        info += String.format("The account balance is: .2%f", accountBalance);
        return info;

    }


}
