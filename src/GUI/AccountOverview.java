/**
 * The GUI for account overviews.
 *
 * Displays info about either all accounts || about an individual account.
 */
package GUI;

import javax.swing.*;

import baseClasses.Account;
import dataObjects.AccountManager;
import data.DBManager;

import java.awt.*;

public class AccountOverview extends JFrame{
    private JPanel root;
    private JButton viewAcct;
    private JButton addTransaction;
    private JButton addAccount;
    private JList<Account> AccountList;
    private JList<Double> AccountBalances;
    private JPanel buttonContainer;
    private JButton searchTransactions;

    public AccountOverview() throws ClassNotFoundException {
        super("Account Overview");
        super.add(root);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500,900));
        generateView();
        pack();

    }


    private void generateView() throws ClassNotFoundException {
        DefaultListModel<Account> accounts = new DefaultListModel<>();
        DefaultListModel<Double>  balance  = new DefaultListModel<>();

        accounts.addAll(DBManager.getAllAccounts());
        balance.addAll(DBManager.getBalance());

        AccountList.setModel(accounts);
        AccountBalances.setModel(balance);
    }
}
