package bank.service;

public interface BankOfficeService {

    public void setOfficeAddress(String address);

    public void setStatus(boolean status);

    boolean isWorking();

    public void setAtmSpace(boolean status);

    boolean hasSpaceForAtm();

    public void addATM();

    public void setLoans(boolean status);

    boolean givesLoans();

    public void setGivesCash(boolean status);

    boolean givesCash();

    public void setReceivesCash(boolean status);

    boolean receivesCash();

    public void print();
}
