package bank.entity;

enum atmStatus {
    working,
    notworking,
    nomoney
}

public class BankAtm extends BankOffice{
    Integer atmID;
    String atmName;
    String atmAddress;
    atmStatus atmStatus = bank.entity.atmStatus.working;
    Integer bankID;
    String maintenancePerson;
    boolean givesCash;
    boolean receivesCash;
    Integer atmFunds;
    Integer maintenanceCost;

    public BankAtm(String atmName, Integer atmID,
                   String officeName, Integer officeID,
                   String bankName, Integer bankId) {
        super(officeName, officeID, bankName, bankId);
        this.atmName = atmName; this. atmID = atmID;
        atmAddress = officeAddress;
        atmFunds = officeFunds/10;
        bankID = id;
    }

    public void setAtmStatus(atmStatus status) {
        atmStatus = status;
    }

    public atmStatus getStatus() {
        return atmStatus;
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
        System.out.print("ATM " + atmID + " in office " + officeID + ", " + officeAddress + "\n" + getStatus().toString());
        System.out.print(", Maintenance person: " + maintenancePerson + "\n");
        System.out.print("Current funds: " + atmFunds + "\n\n");
    }

}
