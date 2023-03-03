import java.util.*;
import static java.lang.System.out;
public class itemEntry {
    String itemName;
    int itemNumber;
    float itemPrice;
    boolean isCredit;
    String paymentMethod;

    /**
     * Default class constructor all items set to null.
     */
    itemEntry()
    {
        this.itemName = null;
        this.itemNumber = Integer.parseInt(null);
        this.itemPrice = Float.parseFloat(null);
        this.isCredit = false;
        this.paymentMethod = null;
    }

    /**
     * object constructor
     * @param iName the name of the item
     * @param iNum the number of this transaction
     * @param iPrice the price of the item
     * @param isC true if the item was a credit, false if else.
     * @param pymntMethod the method payment used to make the purchase
     */
    public itemEntry(String iName, int iNum,
                     float iPrice, boolean isC,
                     String pymntMethod)
    {
        this.itemName = iName;
        this.itemNumber = iNum;
        this.itemPrice = iPrice;
        this.isCredit = isC;
        this.paymentMethod = pymntMethod;
    }


    /**
     * Setters
     */

    void setItemName(String itName)
    {
        this.itemName = itName;
    }


    void setItemNumber(int itNum)
    {
        this.itemNumber = itNum;
    }


    void setItemPrice(float itPrice)
    {
        this.itemPrice = itPrice;
    }


    void setCredit(boolean isC)
    {
        this.isCredit = isC;
    }


    /**
     * Getters
     */
    String getItemName()
    {
        return this.itemName;
    }


    int getItemNumber()
    {
        return this.itemNumber;
    }


    float getItemPrice()
    {
        return this.itemPrice;
    }


    boolean getCredit()
    {
        return this.isCredit;
    }



}
