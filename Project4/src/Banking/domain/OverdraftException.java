package Banking.domain;

/**
 * @author vdsklnl
 * @create 2022-05-03 19:21
 * @Description
 */

public class OverdraftException extends Exception {

    static final long serialVersionUID = -3387516993124229969L;

    private double deficit;

    public OverdraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }

}
