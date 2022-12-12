package bank.service;

import bank.entity.*;
import bank.exceptions.CreditException;

import java.util.ArrayList;

import java.time.LocalDate;

public interface UserService {

    // create
    public User create(String name, Integer id, LocalDate DOB, Bank bank);
    // create-through-copy
    public User create(User user);
    // read
    public User read();
    // set
    public void set(User user);
    // delete
    public void delete(User user);

    // updates
    public void changeWork(User user, String work);
    public void changeIncome(User user, Integer income);
    public void changeRating(User user, Integer addRating);
    public void addBank(User user, Bank bank);
    public void removeBank(User user, Bank bank);
    public void addCreditAccount(User user, CreditAccount creditAccount);
    public void removeCreditAccount(User user, CreditAccount creditAccount);
    public void addPaymentAccount(User user, PaymentAccount paymentAccount);
    public void removePaymentAccount(User user, PaymentAccount paymentAccount);

    public void openCredit(User user, Integer amount, ArrayList<Bank> banks) throws CreditException;

    public String UserAccounts(User client);
}
