package bank.exceptions;

public class NoOfficeFundsException extends CreditException {
    public NoOfficeFundsException (String officeAddress) {
        super("\nNo money in this office, go to " + officeAddress + " office");
    }
    public NoOfficeFundsException () {
        super("\nNo suitable office found");
    }
}
