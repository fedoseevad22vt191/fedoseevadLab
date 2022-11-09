package bank.service;

import bank.entity.Bank;
import bank.entity.CreditAccount;
import bank.entity.Employee;
import bank.entity.User;

import java.util.Date;

public interface CreditAccountService {

    // create
    public CreditAccount create(Integer creditAccID, Date startDate, Integer months, Integer loanValue, User user, Employee employee, Bank bank);
    // create-through-copy
    public CreditAccount create(CreditAccount creditAcc);
    // read
    public CreditAccount read();
    // set
    public void set(CreditAccount creditAcc);
    // delete
    public void delete(CreditAccount creditAcc);

    // updates
    public void removeLoan(CreditAccount creditAcc, Integer sum);
}
