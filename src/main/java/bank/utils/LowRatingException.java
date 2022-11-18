package bank.utils;

public class LowRatingException extends CreditException {
    public LowRatingException (String error) {
        super(error);
    }
    public LowRatingException () {
        super("Ur cringe, low elo");
    }
}
