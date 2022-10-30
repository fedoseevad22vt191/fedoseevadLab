package bank.service.impl;

import bank.entity.Bank;
import bank.entity.CreditAccount;
import bank.entity.Employee;
import bank.entity.User;
import bank.service.CreditAccountService;

import java.util.Date;

public class CreditAccountServiceImpl implements CreditAccountService {

    // create
    public CreditAccount create(Integer creditAccID, Date startDate, Integer months, Integer loanValue, User user, Employee employee, Bank bank) {
        CreditAccount crAcc = new CreditAccount(creditAccID, startDate, months, loanValue);
        crAcc.setCreditUser(user); crAcc.setEmployee(employee); crAcc.setBankName(bank.getName()); // <---- связь с банком и юзером
        return crAcc;
    }
    // create-through-copy
    public CreditAccount create(CreditAccount creditAcc) {
        return new CreditAccount(creditAcc.getId(), creditAcc.getStartDate(), creditAcc.getMonths(), creditAcc.getLoanValue());
    }
    // read
    public CreditAccount read(){
        return this.creditAcc;
    }
    // delete
    public void delete(CreditAccount creditAcc) {
        if (this.creditAcc == creditAcc)
            this.creditAcc = null;
    }

    // updates
    public void removeLoan(CreditAccount creditAcc, Integer sum) {
        creditAcc.setLoanValue(creditAcc.getLoanValue() - sum);
    }
}
