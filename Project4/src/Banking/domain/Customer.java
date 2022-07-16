package Banking.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author vdsklnl
 * @create 2022-05-03 10:53
 * @Description  用户类
 */

public class Customer {

    private String f_n;
    private String l_n;
    private List<Account> account;
    private SavingAccount savingAccount;
    private CheckingAccount checkingAccount;

    public Customer() {}

    public Customer(String f_n, String l_n) {
        this.f_n = f_n;
        this.l_n = l_n;
        this.account = new ArrayList<>();
    }

    public String getFirstName() {
        return f_n;
    }

    public String getLastName() {
        return l_n;
    }

    public SavingAccount getSavings() {
        return savingAccount;
    }

    public void setSavings(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
        account.add(savingAccount);
    }

    public CheckingAccount getChecking() {
        return checkingAccount;
    }

    public void setChecking(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
        account.add(checkingAccount);
    }

    public void addAccount(Account acc) {
        account.add(acc);
    }

    public Account getAccount(int index) {
        return account.get(index);
    }

    public void setAccount(Account acc, int index) {
        account.add(acc);;
    }

    public int getNumOfAccounts() {
        return account.size();
    }

    public Iterator getAccounts() {
        return account.iterator();
    }

}
