package bank.entity;
import java.util.Date;
import java.util.random.RandomGenerator;

public class User extends Employee {
    Integer userID;
    String userName;
    Date userDOB;
    String work;
    Integer monthlyIncome;
    String otherBanks;
    Integer creditAccountID;
    Integer paymentAccountID;
    Integer loanRating;

    public User(String userName, Integer userID, Date userDOB,
                String employeeName, Integer employeeID, Date employeeDOB,
                String atmName, Integer atmID,
                String officeName, Integer officeID,
                String bankName, Integer bankId) {
        super(employeeName, employeeID, employeeDOB, atmName, atmID, officeName, officeID, bankName, bankId);
        this.userName = userName; this.userID = userID; this.userDOB = userDOB;
        this.bankID = id;
        this.officeID = employeeOfficeID;
        RandomGenerator generator = RandomGenerator.getDefault();
        monthlyIncome = generator.nextInt(0,10000);
        loanRating = monthlyIncome/10-monthlyIncome%1000;
    }

    public void print() {
        super.print();
        System.out.print("User " + userName + "with income of " + monthlyIncome + "\n\n");
    }
}
