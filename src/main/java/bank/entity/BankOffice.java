package bank.entity;
import bank.entity.enums.officeStatus;
import bank.service.BankOfficeService;

public class BankOffice{
    String name;
    Integer id;
    String address;
    officeStatus status = officeStatus.working;
    boolean hasSpaceForAtm;
    Integer atmCount = 0;
    boolean givesLoans;
    boolean givesCash;
    boolean receivesCash;
    Integer funds;
    Integer rentCost;

    public BankOffice(String officeName, Integer officeID) {
        this.name = officeName; this.id = officeID;
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

    public Integer getAtmCount() {
        return atmCount;
    }
    public void setAtmCount(Integer atmCount) {
        this.atmCount = atmCount;
    }

    public officeStatus getStatus() {
        return status;
    }
    public void setStatus(officeStatus newstatus) {
        status = newstatus;
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
        if (status == officeStatus.working) st += "Working right now.\n";
        else st += "Currently closed.\n";
        st += "Current funds: " + funds + "\n\n";
        return st;
    }

}
