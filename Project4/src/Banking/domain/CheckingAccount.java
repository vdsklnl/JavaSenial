package Banking.domain;

/**
 * @author vdsklnl
 * @create 2022-05-03 11:26
 * @Description
 */

public class CheckingAccount extends Account {

    private SavingAccount protectBy;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, SavingAccount protectBy) {
        super(balance);
        this.protectBy = protectBy;
    }

    @Override
    public void withdraw(double amt) throws OverdraftException {
        if(balance >= amt) {
            balance -= amt;
        } else if(balance < amt && protectBy == null) {
            throw new OverdraftException("no overdraft protection", (amt - balance));
        }

        if(protectBy != null) {
            if((balance + protectBy.balance) >= amt) {
                protectBy.balance -= (amt - balance);
                balance = 0;
            } else {
                throw new OverdraftException("Insufficient funds for overdraft protection", amt);
            }
        }
    }

}
