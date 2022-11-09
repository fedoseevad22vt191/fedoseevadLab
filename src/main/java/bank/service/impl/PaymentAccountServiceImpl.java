package bank.service.impl;

import bank.entity.Bank;
import bank.entity.PaymentAccount;
import bank.entity.User;
import bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    PaymentAccount paymentAcc = null;

    // create
    public PaymentAccount create(Integer id, User user, Bank bank) {
        PaymentAccount paymentAccount = new PaymentAccount(id);
        paymentAccount.setUser(user); paymentAccount.setBank(bank);
        this.paymentAcc = paymentAccount;
        return paymentAccount;
    }
    // create-through-copy
    public PaymentAccount create(PaymentAccount acc) {
        return new PaymentAccount(acc.getId());
    }
    // read
    public PaymentAccount read() {
        return this.paymentAcc;
    }
    // set
    public void set(PaymentAccount acc) {
        this.paymentAcc = acc;
    }
    // delete
    public void delete(PaymentAccount acc) {
        if (this.paymentAcc == acc)
            this.paymentAcc = null;
    }

    // updates
    public void addFunds(PaymentAccount acc, Integer cash) {
        acc.setPaymentAccountFunds(acc.getPaymentAccountFunds() + cash);
    }
}
