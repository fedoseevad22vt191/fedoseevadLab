package bank.service.impl;

import bank.entity.*;
import bank.entity.enums.officeStatus;
import bank.service.PaymentAccountService;
import bank.service.UserService;
import bank.utils.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.random.RandomGenerator;

public class UserServiceImpl implements UserService {

    User user = null;

    // create
    public User create(String name, Integer id, LocalDate DOB, Bank bank) {
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
    public void changeRating(User user, Integer addRating) { user.setLoanRating(user.getLoanRating() + addRating);}

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

    public String UserAccounts(User client) {
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

    public void openCredit(User user, Integer amount, ArrayList<Bank> banks) throws CreditException {
        Bank pickedBank = null;
        int sumEntities = 0; int lowRate = 10; int lowestRate = 50;
        for (Bank bank: banks) {
            if (bank.getATMs().size() + bank.getOffices().size() + bank.getEmployees().size() > sumEntities && bank.getIntRate()<=lowRate) {
                if (bank.getIntRate() < lowestRate) {
                    lowestRate = bank.getIntRate();
                    pickedBank = bank;
                }
            }
            if (pickedBank == null) throw new NoBankException();
        }
        ArrayList<BankOffice> offices = pickedBank.getOffices();
        BankOffice pickedOffice = null;
        for (BankOffice office: offices) {
            if (office.getStatus() == officeStatus.WORKING && office.givesLoans() && office.givesCash())
                pickedOffice = office;
            if (pickedOffice == null) throw new NoOfficeException();
        }
        ArrayList<Employee> employees = pickedBank.getEmployees();
        Employee pickedEmployee = null;
        for (Employee emp: employees) {
            if (emp.isGivesLoans())
                pickedEmployee = emp;
            if (pickedEmployee == null) throw new NoEmployeeException();
        }
        ArrayList<PaymentAccount> payAccs = user.getPaymentAccs();
        PaymentAccount pickedPayAcc = null;
        ArrayList<CreditAccount> credAccs = user.getCreditAccs();
        CreditAccount pickedCredAcc = null;
        for (PaymentAccount pAcc: payAccs) {
            if (pAcc.getBank() == pickedBank)
                pickedPayAcc = pAcc;
        }
        if (pickedPayAcc == null) {
            PaymentAccountService PAS = new PaymentAccountServiceImpl();
            pickedPayAcc = PAS.create(1, user, pickedBank);
            payAccs.add(pickedPayAcc);
            user.setPaymentAccs(payAccs);
        }

        for (CreditAccount cAcc: credAccs) {
            if (Objects.equals(cAcc.getBankName(), pickedBank.getName()))
                pickedCredAcc = cAcc;
        }
        if (pickedCredAcc == null) {
            CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
            pickedCredAcc = creditAccountService.create(1, LocalDate.now(), 12, amount, user, pickedEmployee, pickedBank);
            credAccs.add(pickedCredAcc);
            user.setCreditAccs(credAccs);
        }

        if (!(user.getLoanRating() / pickedBank.getRating() < 10) ) {
            ArrayList<BankAtm> ATMs = pickedOffice.getAtms();
            BankAtm pickedATM = null;
            for (BankAtm atm : ATMs) {
                if (atm.getFunds() >= amount)
                    pickedATM = atm;
            }
            if (pickedATM == null)
                throw new NoOfficeFundsException();
        }
        else {
            throw new LowRatingException();
        }
    }
}
