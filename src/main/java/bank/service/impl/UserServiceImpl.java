package bank.service.impl;

import bank.entity.*;
import bank.service.UserService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.random.RandomGenerator;

public class UserServiceImpl implements UserService {

    User user = null;

    // create
    public User create(String name, Integer id, Date DOB, Bank bank) {
        User user = new User(name, id, DOB);
        ArrayList<Bank> banks = user.getBanks();
        banks.add(bank);
        user.setBanks(banks);
        RandomGenerator generator = RandomGenerator.getDefault();
        user.setMonthlyIncome(generator.nextInt(0,10000));
        user.setLoanRating(user.getMonthlyIncome()/10-user.getMonthlyIncome()%1000);
        this.user = user;
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
    // set
    public void set(User user) {
        this.user = user;
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

    public void addBank(User user, Bank bank) {
        ArrayList<Bank> banks = user.getBanks();
        banks.add(bank);
        user.setBanks(banks);
    }
    public void removeBank(User user, Bank bank) {
        ArrayList<Bank> banks = user.getBanks();
        if (!banks.remove(bank)) System.out.println("Item not found!");
        else user.setBanks(banks);
    }

    public void addCreditAccount(User user, CreditAccount creditAccount) {
        ArrayList<CreditAccount> list = user.getCreditAccs();
        list.add(creditAccount);
        user.setCreditAccs(list);
    }
    public void removeCreditAccount(User user, CreditAccount creditAccount) {
        ArrayList<CreditAccount> list = user.getCreditAccs();
        if (!list.remove(creditAccount)) System.out.println("Item not found!");
        else user.setCreditAccs(list);
    }

    public void addPaymentAccount(User user, PaymentAccount paymentAccount) {
        ArrayList<PaymentAccount> list = user.getPaymentAccs();
        list.add(paymentAccount);
        user.setPaymentAccs(list);
    }
    public void removePaymentAccount(User user, PaymentAccount paymentAccount) {
        ArrayList<PaymentAccount> list = user.getPaymentAccs();
        if (!list.remove(paymentAccount)) System.out.println("Item not found!");
        else user.setPaymentAccs(list);
    }

    public String UserInfo(User client) {
        ArrayList<PaymentAccount> paymentAccounts = client.getPaymentAccs();
        ArrayList<CreditAccount> creditAccounts = client.getCreditAccs();

        String info = "Payment accounts: \n";
        for (PaymentAccount acc: paymentAccounts) {
            info += "\t PayAcc" + acc.getId() + ", funds: " + acc.getPaymentAccountFunds() + "\n";
        }
        info += "Credit accounts: \n";
        for (CreditAccount acc: creditAccounts) {
            info += "\t PayAcc" + acc.getId() + ", loan: " + acc.getLoanValue() + "monthly: " + acc.getMonthlyPayment() + "\n";
        }
        return info;
    }
}
