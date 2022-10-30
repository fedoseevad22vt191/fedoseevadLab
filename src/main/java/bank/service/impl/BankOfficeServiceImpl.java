package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.enums.officeStatus;
import bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {

    // create
    public BankOffice create(String name, Integer id, Bank bank) {
        BankOffice office = new BankOffice(name, id);
        office.setFunds(bank.getFunds() /100);
        return office;
    }
    // create-through-copy
    public BankOffice create(BankOffice office) {
        return new BankOffice(office.getName(), office.getId()); //, office.getBank());
    }
    // read
    public BankOffice read() {
        return this.office;
    }
    // delete
    public void delete(BankOffice office) {
        if (this.office == office)
            this.office = null;
    }

    // updates
    public void changeStatus(BankOffice office, officeStatus status) {
        office.setStatus(status);
    }
    public void addATM(BankOffice office, BankAtm atm) {
        office.setAtmCount(office.getAtmCount() + 1);
        atm.setAddress(office.getAddress());
        //atm.setBank();
        atm.setOffice(office);
    }
    public void addCash(BankOffice office, Integer cash) {
        office.setFunds(office.getFunds() + cash);
    }
    public void removeCash(BankOffice office, Integer cash) {
        office.setFunds(office.getFunds() - cash);
    }
    public void changeRentCost(BankOffice office, Integer newCost) {
        office.setRentCost(newCost);
    }
}
