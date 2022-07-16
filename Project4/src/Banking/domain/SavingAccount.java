package Banking.domain;

/**
 * @author vdsklnl
 * @create 2022-05-03 11:25
 * @Description
 */

public class SavingAccount extends Account {

    private double interestRate;

    public SavingAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

}
