package bank.service;

import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.enums.officeStatus;

public interface BankOfficeService {

    // create
    public BankOffice create(String name, Integer id);
    // create-through-copy
    public BankOffice create(BankOffice office);
    // read
    public BankOffice read();
    // delete
    public void delete(BankOffice office);

    // updates
    public void changeStatus(BankOffice office, officeStatus status);
    public void addATM(BankOffice office, BankAtm atm);
    public void addCash(BankOffice office, Integer cash);
    public void removeCash(BankOffice office, Integer cash);
    public void changeRentCost(BankOffice office, Integer newCost);
}
