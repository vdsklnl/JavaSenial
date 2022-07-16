package Banking.domain;

/**
 * @author vdsklnl
 * @create 2022-05-03 10:42
 * @Description  账户系统
 */

public class Account {

    protected double balance;

    public Account() {}

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amt) throws OverdraftException {
        if(balance >= amt) {
            balance -= amt;
        } else {
            throw new OverdraftException("no overdraft protection",(amt - balance));
        }
    }

    public boolean deposit(double amt) {
        balance += amt;
        return true;
    }

}
