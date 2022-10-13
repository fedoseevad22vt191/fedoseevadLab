package bank.entity;
import bank.service.EmployeeService;

import java.util.Date;

public class Employee extends BankAtm implements EmployeeService {
    Integer employeeID;
    String employeeName;
    Date employeeDOB;
    String position;
    Integer bankID;
    boolean isRemote;
    Integer employeeOfficeID;
    boolean givesLoans;
    Integer salary;

    public Employee(String employeeName, Integer employeeID, Date employeeDOB,
                    String atmName, Integer atmID,
                    String officeName, Integer officeID,
                    String bankName, Integer bankId) {
        super(atmName, atmID, officeName, officeID, bankName, bankId);
        this.employeeName = employeeName; this.employeeID = employeeID; this.employeeDOB = employeeDOB;
        this.bankID = id;
        this.employeeOfficeID = officeID;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRemote(boolean status) {
        isRemote = status;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setGivesLoans(boolean status) { givesLoans = status; }

    public boolean givesLoans() {
        return givesLoans;
    }

    public void print() {
        super.print();
        System.out.print("Employee " + employeeName + ", " + position + "\n");
        if (isRemote()) System.out.print("Works from home.\n\n");
        else System.out.print("Is at office.\n\n");
    }

}
