package bank.service;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;

import java.util.Date;

public interface EmployeeService {

    // create
    public Employee create(String name, Integer id, Date DOB, Bank bank, BankOffice bankOffice);
    // create-through-copy
    public Employee create(Employee employee);
    // read
    public Employee read();
    // set
    public void set(Employee employee);
    // delete
    public void delete(Employee employee);

    // updates
    public void changeSalary(Employee employee, Integer newSalary);
    public void changeOffice(Employee employee, BankOffice office);
    public void promote(Employee employee, String newPosition);

}
