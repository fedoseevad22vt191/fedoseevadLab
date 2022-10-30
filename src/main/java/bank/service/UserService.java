package bank.service;

import bank.entity.*;
import java.util.Date;

public interface UserService {

    // create
    public User create(String name, Integer id, Date DOB, Bank bank);
    // create-through-copy
    public User create(User user);
    // read
    public User read();
    // delete
    public void delete(User user);

    // updates
    public void changeWork(User user, String work);
    public void changeIncome(User user, Integer income);
    public void addCreditAccount(User user, CreditAccount creditAccount);
    public void addPaymentAccount(User user, PaymentAccount paymentAccount);
}
