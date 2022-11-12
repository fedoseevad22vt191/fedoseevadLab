package bank.service.impl;

import bank.entity.*;
import bank.service.BankService;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.random.RandomGenerator;

public class BankServiceImpl implements BankService {

    Bank bank = null;

    public Bank create(String name, Integer id) {
        Bank bank = new Bank(name, id);
        RandomGenerator generator = RandomGenerator.getDefault();
        bank.setRating(generator.nextInt(0,100));
        bank.setFunds(generator.nextInt(0,1000000));
        bank.setIntRate(generator.nextInt(0,20));
        this.bank = bank;
        return bank;
    }

    @Override
    public Bank create(Bank bank) {
        return new Bank (bank.getName(), bank.getId());
    }
    @Override
    public Bank read() {
        return this.bank;
    }
    @Override
    public void set(Bank bank) { this.bank = bank; }
    @Override
    public void delete(Bank bank) {
        if (this.bank == bank)
            this.bank = null;
    }

    @Override
    public void addOffice(Bank bank, BankOffice office) {
        ArrayList<BankOffice> list = bank.getOffices();
        list.add(office);
        bank.setOffices(list);
    }
    @Override
    public void addATM(Bank bank, BankAtm atm) {
        ArrayList<BankAtm> list = bank.getATMs();
        atm.setBank(bank);
        list.add(atm);
        bank.setATMs(list);
    }
    @Override
    public void addEmployee(Bank bank, Employee employee) {
        ArrayList<Employee> list = bank.getEmployees();
        employee.setBank(bank);
        list.add(employee);
        bank.setEmployees(list);
    }
    @Override
    public void addClient(Bank bank, User client) {
        ArrayList<User> list = bank.getClients();
        ArrayList<Bank> banks = client.getBanks();
        if (!banks.contains(bank)) banks.add(bank);
        client.setBanks(banks);
        list.add(client);
        bank.setClients(list);
    }

    @Override
    public void removeOffice(Bank bank, BankOffice office) {
        ArrayList<BankOffice> list = bank.getOffices();
        if (!list.remove(office)) System.out.println("Item not found!");
        else bank.setOffices(list);
        // TODO: maybe this should be an exception?
    }
    @Override
    public void removeATM(Bank bank, BankAtm Atm) {
        ArrayList<BankAtm> list = bank.getATMs();
        if (!list.remove(Atm)) System.out.println("Item not found!");
        else bank.setATMs(list);
    }
    @Override
    public void removeEmployee(Bank bank, Employee employee) {
        ArrayList<Employee> list = bank.getEmployees();
        if (!list.remove(employee)) System.out.println("Item not found!");
        else bank.setEmployees(list);
    }
    @Override
    public void removeClient(Bank bank, User client) {
        ArrayList<User> list = bank.getClients();
        if (!list.remove(client)) System.out.println("Item not found!");
        else bank.setClients(list);
    }


    public String BankInfo(Bank bank) {
        ArrayList<BankAtm> atms = bank.getATMs();
        ArrayList<BankOffice> offices = bank.getOffices();
        ArrayList<Employee> employees = bank.getEmployees();
        ArrayList<User> clients = bank.getClients();
        String Info = "Bank " + bank.getName() + "\nOffices: \n";
        for (BankOffice office: offices) {
            Info += "\t" + office.getName() + "(" + office.getAddress() + ")\n";
        }
        Info += "ATMs: \n";
        for (BankAtm atm: atms) {
            Info += "\t" + atm.getName() + "(" + atm.getAddress() + ")\n";
        }
        Info += "Employees: \n";
        for (Employee emp: employees) {
            Info += "\t" + emp.getName() + ", " + emp.getPosition() + "\n";
        }
        Info += "Clients: \n";
        for (User client: clients) {
            Info += "\t" + client.getName() + ", DOB: " + client.getDOB() + "\n";
        }
        return Info;
    }
}
