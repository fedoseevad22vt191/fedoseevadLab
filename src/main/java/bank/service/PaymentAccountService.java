package bank.service;

import bank.entity.Bank;
import bank.entity.PaymentAccount;
import bank.entity.User;

public interface PaymentAccountService {

    // create
    public PaymentAccount create(Integer id, User user, Bank bank);
    // create-through-copy
    public PaymentAccount create(PaymentAccount acc);
    // read
    public PaymentAccount read();
    // set
    public void set(PaymentAccount acc);
    // delete
    public void delete(PaymentAccount acc);

    // updates
    public void addFunds(PaymentAccount acc, Integer cash);

}
