package bank.entity;
import bank.entity.enums.atmStatus;

public class BankAtm {
    Integer id;
    String name;
    String address;
    atmStatus status = atmStatus.working;
    Bank bank;
    BankOffice office;
    Employee maintenancePerson;
    boolean givesCash;
    boolean receivesCash;
    Integer funds;
    Integer maintenanceCost;

    public BankAtm(String atmName, Integer atmID) {
        this.name = atmName; this. id = atmID;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public atmStatus getStatus() {
        return status;
    }
    public void setStatus(atmStatus status) {
        this.status = status;
    }

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getOffice() {
        return office;
    }
    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public Employee getMaintenancePerson() {
        return maintenancePerson;
    }
    public void setMaintenancePerson(Employee maintenancePerson) {
        this.maintenancePerson = maintenancePerson;
    }

    public boolean isGivesCash() {
        return givesCash;
    }
    public void setGivesCash(boolean givesCash) {
        this.givesCash = givesCash;
    }

    public boolean isReceivesCash() {
        return receivesCash;
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

    public Integer getMaintenanceCost() {
        return maintenanceCost;
    }
    public void setMaintenanceCost(Integer maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    @Override
    public String toString() {
        return "ATM " + id + " in office " + office.getName() + ", " + office.getAddress() + "\n" + status +
        ", Maintenance person: " + maintenancePerson + "\n" + "Current funds: " + funds + "\n\n";
    }
}
