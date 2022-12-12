package bank.exceptions;

public class NoBankException extends CreditException {
    public NoBankException (String error) {
        super(error);
    }
    public NoBankException () {
        super("\nNo suitable bank found");
    }
}
