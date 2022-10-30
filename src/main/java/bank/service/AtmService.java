package bank.service;
import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.enums.atmStatus;

public interface AtmService {

    // create
    public BankAtm create(String name, Integer id, Bank bank, BankOffice office);
    // create-through-copy
    public BankAtm create(BankAtm atm);
    // read
    public BankAtm read();
    // delete
    public void delete(BankAtm atm);

    // updates
    public void changeStatus(BankAtm atm, atmStatus newStatus);
    public void addCash(BankAtm atm, Integer cash);
    public void removeCash(BankAtm atm, Integer cash);
    public void changeMtCost(BankAtm atm, Integer newCost);
}
