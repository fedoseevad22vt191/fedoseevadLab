package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankOffice;
import bank.entity.Employee;
import bank.service.EmployeeService;

import java.util.Date;

public class EmployeeServiceImpl implements EmployeeService {

    Employee employee = null;

    // create
    public Employee create(String name, Integer id, Date DOB, Bank bank, BankOffice bankOffice) {
        Employee employee = new Employee(name,id, DOB);
        employee.setBank(bank); employee.setOffice(bankOffice);
        this.employee = employee;
        return employee;
    }
    // create-through-copy
    public Employee create(Employee employee) {
        return new Employee(employee.getName(), employee.getId(), employee.getDOB());
    }
    // read
    public Employee read() {
        return this.employee;
    }
    // set
    public void set(Employee employee) {
        this.employee = employee;
    }
    // delete
    public void delete(Employee employee) {
        if (this.employee == employee)
            this.employee = null;
    }

    // updates
    public void changeSalary(Employee employee, Integer newSalary) {
        employee.setSalary(newSalary);
    }
    public void changeOffice(Employee employee, BankOffice office) {
        employee.setOffice(office);
    }
    public void promote(Employee employee, String newPosition) {
        employee.setPosition(newPosition);
    }
}
