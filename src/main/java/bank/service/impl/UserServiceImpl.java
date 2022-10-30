package bank.service.impl;

import bank.entity.*;
import bank.service.UserService;

import java.util.Date;
import java.util.random.RandomGenerator;

public class UserServiceImpl implements UserService {

    // create
    public User create(String name, Integer id, Date DOB, Bank bank) {
        User user = new User(name, id, DOB);
        user.setBanks(bank);
        RandomGenerator generator = RandomGenerator.getDefault();
        user.setMonthlyIncome(generator.nextInt(0,10000));
        user.setLoanRating(user.getMonthlyIncome()/10-user.getMonthlyIncome()%1000);
        return user;
    }
    // create-through-copy
    public User create(User user) {
        return new User(user.getName(), user.getId(), user.getDOB());
    }
    // read
    public User read() {
        return this.user;
    }
    // delete
    public void delete(User user) {
        if (this.user == user)
            this.user = null;
    }

    // updates
    public void changeWork(User user, String work) {
        user.setWork(work);
    }
    public void changeIncome(User user, Integer income) {
        user.setMonthlyIncome(income);
    }
    public void addCreditAccount(User user, CreditAccount creditAccount) {
        user.setCreditAcc(creditAccount);
    }
    public void addPaymentAccount(User user, PaymentAccount paymentAccount) {
        user.setPaymentAcc(paymentAccount);
    }
}
