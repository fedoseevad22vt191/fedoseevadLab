package bank.exceptions;

public class NoEmployeeException extends CreditException {
    public NoEmployeeException (String error) {
        super(error);
    }
    public NoEmployeeException () {
        super("\nNo suitable employee found");
    }
}
