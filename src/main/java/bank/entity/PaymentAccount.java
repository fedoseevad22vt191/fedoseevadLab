package bank.entity;

import java.util.Date;

public class PaymentAccount extends CreditAccount {
    Integer paymentAccID;
    Integer paymentUserID;
    Integer paymentBankID;
    Integer paymentAccountFunds = 0;

    public PaymentAccount(Integer paymentAccountID,
                        Integer creditAccID, Date startDate, Integer months, Integer loanValue,
                        String userName, Integer userID, Date userDOB,
                        String employeeName, Integer employeeID, Date employeeDOB,
                        String atmName, Integer atmID,
                        String officeName, Integer officeID,
                        String bankName, Integer bankId) {
        super(creditAccID, startDate, months, loanValue, userName, userID, userDOB, employeeName, employeeID, employeeDOB, atmName, atmID, officeName, officeID, bankName, bankId);
        this.paymentAccountID = paymentAccountID; this.paymentUserID = userID;
        this.paymentAccID = paymentAccountID; this.paymentBankID = bankId;
    }

    public void addFunds(Integer value) {
        paymentAccountFunds += value;
    }

    public void print() {
        super.print();
        System.out.print("Payment account " + paymentAccID + " belongs to User #" + paymentUserID + "\n" +
                "Current funds: " + paymentAccountFunds + "\n\n");
    }
}
