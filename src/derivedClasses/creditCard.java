import java.lang.System.out;
import baseClasses.Account;

public class creditCard extends Account
{
    creditCard()
    {
        super(); // init the base classes fields

    }

    public creditCard(String name, String type, double ... nums)
    {
        super(name,type,nums[0],nums[1]);

    }
}