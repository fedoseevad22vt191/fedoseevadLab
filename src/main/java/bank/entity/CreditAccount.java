package bank.entity;
import java.util.Date;

public class CreditAccount extends User {
    Integer creditAccID;
    Integer creditAccUserID;
    String bankName;
    Date startDate;
    Date endDate;
    Integer months;
    Integer loanValue;
    Integer monthlyPayment;

    public CreditAccount(Integer creditAccID, Date startDate, Integer months, Integer loanValue,
                String userName, Integer userID, Date userDOB,
                String employeeName, Integer employeeID, Date employeeDOB,
                String atmName, Integer atmID,
                String officeName, Integer officeID,
                String bankName, Integer bankId) {
        super(userName, userID, userDOB, employeeName, employeeID, employeeDOB, atmName, atmID, officeName, officeID, bankName, bankId);
        this.creditAccID = creditAccID; this.creditAccUserID = userID; this.bankName = bankName;
        this.startDate = startDate; this.months = months;
        this.endDate = new Date(startDate.getYear(), startDate.getMonth()+months, startDate.getDay());
        this.loanValue = loanValue;
        this.monthlyPayment = loanValue/months;
        this.creditAccountID = creditAccID;
    }

    public void print() {
        super.print();
        System.out.print("Credit account " + creditAccountID + "belongs to user #" + creditAccUserID + "\n" +
                "Start date: " + startDate + ". End date: " + endDate + ". Monthly payment: " + monthlyPayment + "\n\n");

    }
}
