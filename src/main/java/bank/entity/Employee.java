package bank.entity;

import java.time.LocalDate;

public class Employee {
    Integer id;
    String name;
    LocalDate DOB;
    String position;
    Bank bank;
    boolean isRemote;
    BankOffice office;
    boolean givesLoans;
    Integer salary;

    public Employee(String employeeName, Integer employeeID, LocalDate employeeDOB) {
        this.name = employeeName; this.id = employeeID; this.DOB = employeeDOB;
        this.position = "universal worker";
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean isRemote() {
        return isRemote;
    }
    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public BankOffice getOffice() {
        return office;
    }
    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public boolean isGivesLoans() {
        return givesLoans;
    }
    public void setGivesLoans(boolean givesLoans) {
        this.givesLoans = givesLoans;
    }

    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String st =  "Employee " + name + ", " + position + "\n";
        if (isRemote) st += "Works from home.\n\n";
        else st += "Is at office.\n\n";
        return st;
    }

}
