package bank.service.impl;

import bank.entity.Bank;
import bank.entity.BankAtm;
import bank.entity.BankOffice;
import bank.entity.enums.atmStatus;
import bank.service.AtmService;

public class AtmServiceImpl implements AtmService {

    // create
    public BankAtm create(String name, Integer id, Bank bank, BankOffice office) {
        BankAtm atm = new BankAtm(name, id);
        atm.setBank(bank);
        atm.setOffice(office); atm.setAddress(office.getAddress());
        atm.setFunds(office.getFunds() / 10);
        return atm;
    }
    // create-through-copy
    public BankAtm create(BankAtm atm) {
        return new BankAtm(atm.getName(), atm.getId());
    }
    // read
    public BankAtm read() {
        return this.atm;
    }
    // delete
    public void delete(BankAtm atm) {
        if (this.atm == atm)
            this.atm = null;
    }

    // updates
    public void changeStatus(BankAtm atm, atmStatus newStatus) {
        atm.setStatus(newStatus);
    }
    public void addCash(BankAtm atm, Integer cash) {
        atm.setFunds(atm.getFunds() + cash);
    }
    public void removeCash(BankAtm atm, Integer cash) {
        atm.setFunds(atm.getFunds() - cash);
    }
    public void changeMtCost(BankAtm atm, Integer newCost) {
        atm.setMaintenanceCost(newCost);
    }
}
