package bank.service.impl;

import bank.entity.Bank;
import bank.service.BankService;
import java.util.random.RandomGenerator;

public class BankServiceImpl implements BankService {

    public Bank create(String name, Integer id) {
        Bank bank = new Bank(name, id);
        RandomGenerator generator = RandomGenerator.getDefault();
        bank.setRating(generator.nextInt(0,100));
        bank.setFunds(generator.nextInt(0,1000000));
        bank.setIntRate(generator.nextInt(0,20));
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
    public void delete(Bank bank) {
        if (this.bank == bank)
            this.bank = null;
    }
    @Override
    public void addOffice(Bank bank) {
        bank.setOfficeCount(bank.getOfficeCount() + 1);
    }
    @Override
    public void addATM(Bank bank) {
        bank.setATMs(bank.getATMs() + 1);
    }
    @Override
    public void addEmployee(Bank bank) {
        bank.setEmployeeCount(bank.getEmployeeCount() + 1);
    }
    @Override
    public void addClient(Bank bank) {
        bank.setClientCount(bank.getClientCount() + 1);
    }
    @Override
    public void removeOffice(Bank bank) {
        bank.setOfficeCount(bank.getOfficeCount() - 1);
    }
    @Override
    public void removeATM(Bank bank) {
        bank.setATMs(bank.getATMs() - 1);
    }
    @Override
    public void removeEmployee(Bank bank) {
        bank.setEmployeeCount(bank.getEmployeeCount() - 1);
    }
    @Override
    public void removeClient(Bank bank) {
        bank.setClientCount(bank.getClientCount() - 1);
    }
}
