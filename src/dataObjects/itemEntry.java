package dataObjects;

import java.util.*;
import static java.lang.System.out;
public class itemEntry {
    String itemName;
    int itemNumber;
    double itemPrice;
    boolean isCredit;
    String paymentMethod;

    /**
     * Default class constructor all items set to null.
     */
    public itemEntry()
    {
        this.itemName = null;
        this.itemNumber = 0;
        this.itemPrice =  0.00;
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
                     double iPrice, boolean isC,
                     String pymntMethod)
    {
        this.itemName = iName;
        this.itemNumber = iNum;
        this.itemPrice = iPrice;
        this.isCredit = isC;
        this.paymentMethod = pymntMethod;
    }

    /**
     * Copy constructor, pass in an item of the class type
     * to copy its values.
     * @param item the item we wish to copy.
     */
    public itemEntry(itemEntry item) {
        this.itemName = item.itemName;
        this.itemNumber = item.itemNumber;
        this.itemPrice = item.itemPrice;
        this.isCredit = item.isCredit;
        this.paymentMethod = item.paymentMethod;
    }


    /**
     * Setters
     */

    public void setItemName(String itName)
    {
        this.itemName = itName;
    }


    public void setItemNumber(int itNum)
    {
        this.itemNumber = itNum;
    }


   public void setItemPrice(double itPrice)
    {
        this.itemPrice = itPrice;
    }


    public void setCredit(boolean isC)
    {
        this.isCredit = isC;
    }


    public void setPaymentMethod(String payment)
    {
        this.paymentMethod = payment;
    }
    /**
     * Getters
     */
    public String getItemName()
    {
        return this.itemName;
    }


    public int getItemNumber()
    {
        return this.itemNumber;
    }


    public double getItemPrice()
    {
        return this.itemPrice;
    }


    public boolean getCredit()
    {
        return this.isCredit;
    }


    /**
     * helpers
     */

    /**
     * Have an itemEntry object display its data values.
     */
    public void display()
    {
        out.println(
                this.itemName + "\t" + this.itemNumber + "\t" + this.itemPrice
                + "\t" + this.paymentMethod + "\t" + (this.isCredit ? "(+)" : "(-)")
        );
    }



}
