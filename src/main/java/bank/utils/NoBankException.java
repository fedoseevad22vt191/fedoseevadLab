package bank.utils;

public class NoBankException extends CreditException {
    public NoBankException (String error) {
        super(error);
    }
    public NoBankException () {
        super("No suitable bank found");
    }
}
