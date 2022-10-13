package bank.entity;
import bank.service.BankOfficeService;

public class BankOffice extends Bank implements BankOfficeService {
    String officeName;
    Integer officeID;
    String officeAddress;
    boolean isWorking;
    boolean hasSpaceForAtm;
    Integer atmOfficeCount;
    boolean givesLoans;
    boolean givesCash;
    boolean receivesCash;
    Integer officeFunds;
    Integer rentCost;

    public BankOffice(String officeName, Integer officeID,
                      String bankName, Integer bankId) {
        super(bankName, bankId);
        this.officeName = officeName; this.officeID = officeID;
        officeFunds = funds/100;
    }

    public void setOfficeAddress(String address) {
        this.officeAddress = address;
    }

    public void setStatus(boolean status) {
        isWorking = status;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setAtmSpace(boolean status) {
        hasSpaceForAtm = status;
    }

    public boolean hasSpaceForAtm() {
        return hasSpaceForAtm;
    }

    public void addATM() {
        atmOfficeCount++;
        bankATMs++;
    }

    public void setLoans(boolean status) {
        givesLoans = status;
    }

    public boolean givesLoans() {
        return givesLoans;
    }

    public void setGivesCash(boolean status) {
        givesCash = status;
    }

    public boolean givesCash() {
        return givesCash;
    }

    public void setReceivesCash(boolean status) {
        receivesCash = status;
    }

    public boolean receivesCash() {
        return receivesCash;
    }

    public void print() {
        super.print();
        System.out.print("Bank office " + officeName + " at " + officeAddress + '\n');
        if (isWorking()) System.out.print("Working right now.\n");
        else System.out.print("Currently closed.\n");
        System.out.print("Current funds: " + officeFunds + "\n\n");
    }
}
