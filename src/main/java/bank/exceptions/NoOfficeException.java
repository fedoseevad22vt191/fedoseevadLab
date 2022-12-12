package bank.exceptions;

public class NoOfficeException extends CreditException {
    public NoOfficeException (String error) {
        super(error);
    }
    public NoOfficeException () {
        super("\nNo suitable office found");
    }
}
