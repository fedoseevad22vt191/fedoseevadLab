package bank.service;

import bank.entity.*;

public interface BankService {

    // create
    public Bank create(String name, Integer id);
    // create-through-copy
    public Bank create(Bank bank);
    // set
    public void set(Bank bank);
    // read
    public Bank read();
    // delete
    public void delete(Bank bank);

    // updates
    public void addOffice(Bank bank, BankOffice office);
    public void addATM(Bank bank, BankAtm Atm);
    public void addEmployee(Bank bank, Employee employee);
    public void addClient(Bank bank, User client);
    public void removeOffice(Bank bank, BankOffice office);
    public void removeATM(Bank bank, BankAtm atm);
    public void removeEmployee(Bank bank, Employee employee);
    public void removeClient(Bank bank, User client);
}
