package bank.service;

public interface EmployeeService {

    public void setPosition(String position);

    public void setRemote(boolean status);

    public boolean isRemote();

    public void setGivesLoans(boolean status);

    public boolean givesLoans();

    public void print();
}
