package bank.service;

enum atmStatus {
    working,
    notworking,
    nomoney
}

public interface AtmService {

    public void setAtmStatus(atmStatus status);

    public atmStatus getStatus();

    public void setGivesCash(boolean status);

    public boolean givesCash();

    public void setReceivesCash(boolean status);

    public boolean receivesCash();

    public void print();
}
