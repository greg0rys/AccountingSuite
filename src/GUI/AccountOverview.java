/**
 * The GUI for account overviews.
 *
 * Displays info about either all accounts || about an individual account.
 */
package GUI;

import javax.swing.*;

import data.DBManager;

import java.awt.*;
import java.sql.SQLException;

public class AccountOverview extends JFrame{
    private JPanel root;
    private JButton viewAcct;
    private JButton addTransaction;
    private JButton addAccount;
    private JList<String> AccountList;
    private JList<String> AccountBalances;
    private JPanel buttonContainer;
    private JButton searchTransactions;
    private JTextArea BalanceTotal;
    private JTextArea AccountTotal;

    public AccountOverview() throws ClassNotFoundException, SQLException {
        super("Account Overview");
        super.add(root);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(650,450));
        generateView();
        setEvents();
        pack();

    }


    private void generateView() throws ClassNotFoundException, SQLException {
        DefaultListModel<String> accounts = new DefaultListModel<>();
        DefaultListModel<String>  balance  = new DefaultListModel<>();

        accounts.addAll(DBManager.getNames());
        balance.addAll(DBManager.getBalance());

        int totalAccounts = accounts.size();
        AccountTotal.append("\t" + totalAccounts);
        BalanceTotal.append(" " + DBManager.getFormattedBalance());
        AccountList.setModel(accounts);
        AccountBalances.setModel(balance);
    }

    private void setEvents()
    {
        viewAcct.addActionListener(e ->{
            JOptionPane.showMessageDialog(
                    this, "GREG", "HO",JOptionPane.ERROR_MESSAGE
            );
        });
    }
}
