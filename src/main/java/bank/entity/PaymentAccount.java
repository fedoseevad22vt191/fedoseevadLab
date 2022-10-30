package bank.entity;

import java.util.Date;

public class PaymentAccount{
    Integer id;
    User user;
    Bank bank;
    Integer paymentAccountFunds = 0;

    public PaymentAccount(Integer paymentAccountID) {
        this.id = paymentAccountID;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getPaymentAccountFunds() {
        return paymentAccountFunds;
    }
    public void setPaymentAccountFunds(Integer paymentAccountFunds) {
        this.paymentAccountFunds = paymentAccountFunds;
    }

    @Override
    public String toString() {
        return "Payment account " + id + " belongs to User #" + user.getId() + "\n" +
                "Current funds: " + paymentAccountFunds + "\n\n";
    }
}
