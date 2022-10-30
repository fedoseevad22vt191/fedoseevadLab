package bank.service;

import bank.entity.Bank;

public interface BankService {

    // create
    public Bank create(String name, Integer id);
    // create-through-copy
    public Bank create(Bank bank);
    // read
    public Bank read();
    // delete
    public void delete(Bank bank);

    // updates
    public void addOffice(Bank bank);
    public void addATM(Bank bank);
    public void addEmployee(Bank bank);
    public void addClient(Bank bank);
    public void removeOffice(Bank bank);
    public void removeATM(Bank bank);
    public void removeEmployee(Bank bank);
    public void removeClient(Bank bank);
}
