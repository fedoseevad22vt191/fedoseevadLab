package bank.entity;
import bank.entity.enums.OfficeStatus;

import java.util.ArrayList;

public class BankOffice {
    String name;
    Integer id;
    String address;
    OfficeStatus status = OfficeStatus.WORKING;
    boolean hasSpaceForAtm;
    ArrayList<BankAtm> ATMs;
    Bank bank;
    boolean givesLoans;
    boolean givesCash;
    boolean receivesCash;
    Integer funds;
    Integer rentCost;

    public BankOffice(String officeName, Integer officeID, String address, Bank bank) {
        this.name = officeName; this.id = officeID; this.address = address;
        this.givesCash = true; this.givesLoans = true; this.bank = bank;
        ATMs = new ArrayList<>();
    }

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<BankAtm> getAtms() {
        return ATMs;
    }
    public void setAtms(ArrayList<BankAtm> atms) {
        this.ATMs = atms;
    }

    public OfficeStatus getStatus() {
        return status;
    }
    public void setStatus(OfficeStatus newStatus) {
        status = newStatus;
    }

    public boolean hasSpaceForAtm() {
        return hasSpaceForAtm;
    }
    public boolean givesLoans() {
        return givesLoans;
    }
    public boolean givesCash() {
        return givesCash;
    }
    public boolean receivesCash() {
        return receivesCash;
    }

    public void setHasSpaceForAtm(boolean hasSpaceForAtm) {
        this.hasSpaceForAtm = hasSpaceForAtm;
    }
    public void setGivesLoans(boolean givesLoans) {
        this.givesLoans = givesLoans;
    }
    public void setGivesCash(boolean givesCash) {
        this.givesCash = givesCash;
    }
    public void setReceivesCash(boolean receivesCash) {
        this.receivesCash = receivesCash;
    }

    public Integer getFunds() {
        return funds;
    }
    public void setFunds(Integer funds) {
        this.funds = funds;
    }
    public Integer getRentCost() {
        return rentCost;
    }
    public void setRentCost(Integer rentCost) {
        this.rentCost = rentCost;
    }

    @Override
    public String toString() {
        String st = "Bank office " + name + " at " + address + '\n';
        if (status == OfficeStatus.WORKING) st += "Working right now.\n";
        else st += "Currently closed.\n";
        st += "ATMs: \n";
        for (BankAtm atm: ATMs) {
            st += "\t" + atm.toString();
        }
        st += "Current funds: " + funds + "\n\n";
        return st;
    }

}
