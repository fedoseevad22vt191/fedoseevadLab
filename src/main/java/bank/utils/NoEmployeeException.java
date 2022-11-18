package bank.utils;

public class NoEmployeeException extends CreditException {
    public NoEmployeeException (String error) {
        super(error);
    }
    public NoEmployeeException () {
        super("No suitable employee found");
    }
}
