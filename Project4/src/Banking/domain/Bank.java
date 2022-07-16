package Banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author vdsklnl
 * @create 2022-05-03 11:10
 * @Description
 */

public class Bank {

    private static Bank bank = null;
    private List<Customer> customers;

    public static Bank getBank() {
        if(bank == null) {
            synchronized (Bank.class) {
                if(bank == null) {
                    bank = new Bank();
                }
            }
        }
        return bank;
    }

    private Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String f, String l) {
        customers.add(new Customer(f,l));
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    public Iterator getCustomers() {
        return customers.iterator();
    }

}
