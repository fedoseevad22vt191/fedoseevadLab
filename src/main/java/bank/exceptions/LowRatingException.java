package bank.exceptions;

public class LowRatingException extends CreditException {
    public LowRatingException (String error) {
        super(error);
    }
    public LowRatingException () {
        super("\nLow user credit rating!");
    }
}
