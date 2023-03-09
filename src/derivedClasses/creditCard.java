package derivedClasses;
import baseClasses.Account;
import static java.lang.System.out;

public class creditCard extends Account {
    private String cardType;


    public creditCard() {
        super(null, null, 0, 0);
        cardType = null;

    }

    public creditCard(Account acct, String type) {
        super(
                acct.getAccountName(),
                acct.getAccountType(),
                acct.getAccountNum(),
                acct.getAccountBalance()
        ); // init the base classes fields

        cardType = type;
    }

    public creditCard(String name, String type, int acctNum, double bal) {
        super(name, type, acctNum, bal);
        getCardData(); // let the gui prompt the user for the account's info.

    }

    private void getCardData()
    {
        out.println("gui will handle this");
    }
}