package bank.utils;

public class NoOfficeException extends CreditException {
    public NoOfficeException (String error) {
        super(error);
    }
    public NoOfficeException () {
        super("No suitable office found");
    }
}
