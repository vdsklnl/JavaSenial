package Banking.reports;

import Banking.domain.*;

import java.util.Iterator;

/**
 * @author vdsklnl
 * @create 2022-05-03 18:43
 * @Description
 */

public class CustomerReport {

    private Bank bank;

    public CustomerReport() {
        this.bank = Bank.getBank();
    }

    public void generateReport() {
        // Generate a report
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");
        Iterator customers = bank.getCustomers();
        Customer customer;
        Account account;
        String account_type = "";
        while (customers.hasNext()) {
            customer = (Customer) customers.next();
            System.out.println();
            System.out.println("Customer: "
                    + customer.getLastName() + ", "
                    + customer.getFirstName());
            Iterator accounts = customer.getAccounts();
            while (accounts.hasNext()) {
                account = (Account) accounts.next();
                if(account instanceof SavingAccount) {
                    account_type = "Savings Account";
                } else if(account instanceof CheckingAccount) {
                    account_type = "Checking Account";
                }
                System.out.println("\t" + account_type + ": current balance is ￥" + account.getBalance());
            }
        }
    }

}
