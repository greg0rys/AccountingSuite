package derivedClasses;
import baseClasses.Account;
import static java.lang.System.out;

public class creditCard extends Account
{
    private String cardType;
    private double cardLimit;
    public creditCard()
    {
        super(null,null,0,0);
        cardType = null;
        cardLimit = 0.00;
    }
   public creditCard(Account acct, String type, double lim)
    {
        super(
                acct.getAccountName(),
                acct.getAccountType(),
                acct.getAccountNum(),
                acct.getAccountBalance()
        ); // init the base classes fields

        cardType = type;
        cardLimit = lim;
    }

    public creditCard(String name, String type, double ... nums)
    {
        super(name,type,nums[0],nums[1]);

    }

    @Override
    public void display()
    {
        String bal,lim;
        bal = String.format("The account balance is: .2%f",getAccountBalance());
        lim = String.format("This cards limit is: .2%f", cardLimit);

        out.println(
                ""
        )

    }
}