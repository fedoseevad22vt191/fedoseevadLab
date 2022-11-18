package bank.utils;

public class NoOfficeFundsException extends CreditException {
    public NoOfficeFundsException (String officeAddress) {
        super("No money in this office, go to " + officeAddress + " office");
    }
    public NoOfficeFundsException () {
        super("No suitable office found");
    }
}
