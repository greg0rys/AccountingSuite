import GUI.AccountOverview;
import dataObjects.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.IntStream;

import static java.lang.System.out;
public class Main {
    public static void main(String[] args)
    {
//        List<itemEntry> it = new ArrayList<>();
//        itemEntry item = new itemEntry();
//
//        String[] vals = {"Greg","Marcos","Rocko","Dex","Mc"};
//        String[] payTypes = {"cc","cash","debit","cc","cash"};
//
//        IntStream.range(0, 5).forEach(i -> {
//            item.setItemName(vals[i]);
//            item.setItemNumber(i + 1);
//            item.setItemPrice(i * 3);
//            item.setCredit(true);
//            item.setPaymentMethod(payTypes[i]);
//            //if we don't call new on the itemEntry it will add the item via reference, so each loop iteration will just chhange the value to the new value for all items in list
//            // so when adding to the list it treats objects as a reference.
//            it.add(new itemEntry(item));
//        });
//
//        for(itemEntry x: it)
//        {
//            x.display();
//        }

        javax.swing.SwingUtilities.invokeLater(()->{
            try {
                JFrame overview = new AccountOverview();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
   }
}