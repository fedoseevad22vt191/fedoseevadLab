package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.enums.OfficeStatus;
import bank.service.BankOfficeService;

import java.util.ArrayList;

public class BankOfficeServiceImpl implements BankOfficeService {

    BankOffice office = null;

    // create
    public BankOffice create(String name, Integer id, String address, Bank bank) {
        BankOffice office = new BankOffice(name, id, address, bank);
        office.setFunds(bank.getFunds() /100);
        this.office = office;
        return office;
    }
    // create-through-copy
    public BankOffice create(BankOffice office) {
        return new BankOffice(office.getName(), office.getId(), office.getAddress(), office.getBank()); //, office.getBank());
    }
    // read
    public BankOffice read() {
        return this.office;
    }

    // set
    public void set(BankOffice office) {
        this.office = office;
    }

    // delete
    public void delete(BankOffice office) {
        if (this.office == office)
            this.office = null;
    }

    // updates
    public void changeStatus(BankOffice office, OfficeStatus status) {
        office.setStatus(status);
    }
    public void addATM(BankOffice office, Bank bank, BankAtm atm) {
        ArrayList<BankAtm> offlist = office.getAtms();
        ArrayList<BankAtm> banklist = bank.getATMs();
        atm.setAddress(office.getAddress());
        atm.setBank(bank);
        atm.setOffice(office);

        offlist.add(atm);
        office.setAtms(offlist);
        banklist.add(atm);
        bank.setATMs(banklist);
    }
    public void addCash(BankOffice office, Integer cash) {
        office.setFunds(office.getFunds() + cash);
    }

    @Override
    public void removeATM(BankOffice office, BankAtm atm) {
        ArrayList<BankAtm> list = office.getAtms();
        if (!list.remove(atm)) System.out.println("Item not found!");
        else office.setAtms(list);
    }

    public void removeCash(BankOffice office, Integer cash) {
        office.setFunds(office.getFunds() - cash);
    }
    public void changeRentCost(BankOffice office, Integer newCost) {
        office.setRentCost(newCost);
    }
}
