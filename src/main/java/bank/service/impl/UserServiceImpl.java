package bank.service.impl;

import bank.entity.*;
import bank.entity.enums.officeStatus;
import bank.service.BankService;
import bank.service.PaymentAccountService;
import bank.service.UserService;
import bank.utils.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
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
        for (PaymentAccount acc : paymentAccounts) {
            info += "\t PayAcc" + acc.getId() + ", funds: " + acc.getPaymentAccountFunds() + "\n";
        }
        info += "Credit accounts: \n";
        for (CreditAccount acc : creditAccounts) {
            info += "\t PayAcc" + acc.getId() + ", loan: " + acc.getLoanValue() + "monthly: " + acc.getMonthlyPayment() + "\n";
        }
        return info;
    }

    public void openCredit(User user, Integer amount, ArrayList<Bank> banks) throws CreditException {
        Bank pickedBank = null;
        int sumEntities = 0; int lowRate = 10; int lowestRate = 50;
        for (Bank bank: banks) {
            System.out.println(bank.getName());
            // auto bank pick
            /*if (bank.getATMs().size() + bank.getOffices().size() + bank.getEmployees().size() > sumEntities && bank.getIntRate()<=lowRate) {
                if (bank.getIntRate() < lowestRate) {
                    lowestRate = bank.getIntRate();
                    pickedBank = bank;
                }
            }*/
        }
        //if (pickedBank == null) throw new NoBankException();
        System.out.println("Write bank number you want to get a loan from: ");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        pickedBank = banks.get(x);
        ArrayList<BankOffice> offices = pickedBank.getOffices();
        BankOffice pickedOffice = null;
        for (BankOffice office: offices) {
            System.out.println("\tOffice " + office.getId() + ", " + office.getStatus() + ", Loan: " + office.givesLoans());
            if (office.getStatus() == officeStatus.WORKING && office.givesLoans() && office.givesCash()) {
                pickedOffice = office;
                break;
            }
        }
        if (pickedOffice == null) throw new NoOfficeException();
        System.out.println("Picked office " + pickedOffice.getId());
        ArrayList<Employee> employees = pickedBank.getEmployees();
        Employee pickedEmployee = null;
        for (Employee emp: employees) {
            if (emp.getOffice() == pickedOffice) {
                System.out.println("\tEmployee " + emp.getId() + ", Loan: " + emp.isGivesLoans());
                if (emp.isGivesLoans()) {
                    pickedEmployee = emp;
                    break;
                }
            }
        }
        if (pickedEmployee == null) throw new NoEmployeeException();
        System.out.println("Picked employee " + pickedEmployee.getId());
        ArrayList<PaymentAccount> payAccs = user.getPaymentAccs();
        PaymentAccount pickedPayAcc = null;
        ArrayList<CreditAccount> credAccs = user.getCreditAccs();
        CreditAccount pickedCredAcc = null;
        for (PaymentAccount pAcc: payAccs) {
            if (pAcc.getBank() == pickedBank)
                pickedPayAcc = pAcc;
        }
        if (pickedPayAcc == null) {
            System.out.println("Payment account not found. Creating new one...");
            PaymentAccountService PAS = new PaymentAccountServiceImpl();
            pickedPayAcc = PAS.create(1, user, pickedBank);
            payAccs.add(pickedPayAcc);
            user.setPaymentAccs(payAccs);
            System.out.println("Payment account created!");
        }
        else System.out.println("Payment account: " + pickedPayAcc.getId() + ", Funds: " + pickedPayAcc.getPaymentAccountFunds());
        for (CreditAccount cAcc: credAccs) {
            if (Objects.equals(cAcc.getBankName(), pickedBank.getName()))
                pickedCredAcc = cAcc;
        }
        if (pickedCredAcc == null) {
            System.out.println("Credit account not found. Creating new one...");
            CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
            pickedCredAcc = creditAccountService.create(1, LocalDate.now(), 12, amount, user, pickedEmployee, pickedBank);
            credAccs.add(pickedCredAcc);
            user.setCreditAccs(credAccs);
            System.out.println("Credit account created!");
        }
        else System.out.println("Credit account: " + pickedCredAcc.getId() + ", Accepted loan: " + pickedCredAcc.getLoanValue());
        if (!(user.getLoanRating() / pickedBank.getRating() < 10) ) {
            ArrayList<BankAtm> ATMs = pickedOffice.getAtms();
            BankAtm pickedATM = null;
            for (BankAtm atm : ATMs) {
                if (atm.getFunds() >= amount)
                    pickedATM = atm;
            }
            if (pickedATM == null)
                throw new NoOfficeFundsException();
            else System.out.println("Get your money in ATM " + pickedATM.getId());
        }
        else {
            throw new LowRatingException();
        }
    }

    public String exportAccounts(User user, String bankName) throws IOException {
        ArrayList<PaymentAccount> pAccs = user.getPaymentAccs();
        ArrayList<CreditAccount> cAccs = user.getCreditAccs();
        int accountCount = 0;

        String fileName = LocalDate.now().toString() + "_" + user.getId() + user.getName() + "_" + bankName + ".txt";
        System.out.println("Creating " + fileName);
        FileWriter FW = new FileWriter(fileName);
        for (PaymentAccount acc: pAccs) {
            if (bankName.equals(acc.getBank().getName())) {
                accountCount++;
                FW.write("p" + acc.getId() + "_" + acc.getPaymentAccountFunds() + "\n");
            }
        }
        if (accountCount == 0) return "No accounts found";
        for (CreditAccount acc: cAccs) {
            if (bankName.equals(acc.getBankName())) {
                accountCount++;
                FW.write("c" + acc.getId() + "_" + acc.getLoanValue() + "_" + acc.getMonthlyPayment() + "_" + acc.getStartDate() + "_" + acc.getMonths() + "\n");
            }
        }
        FW.close();

        return accountCount + " accounts exported";
    }

    public String importAccounts(User user, Bank bank, File file) throws IOException {
        //FW.write("p" + acc.getId() + "_" + acc.getPaymentAccountFunds() + "\n");
        //FW.write("c" + acc.getId() + "_" + acc.getLoanValue() + "_" + acc.getMonthlyPayment() + "_" + acc.getStartDate() + "_" + acc.getMonths() + "\n");
        ArrayList<User> clients = bank.getClients();
        ArrayList<PaymentAccount> pAccs = user.getPaymentAccs();
        ArrayList<CreditAccount> cAccs = user.getCreditAccs();

        User accountOwner = null;
        for (User client: clients) {
            if (client == user)
                accountOwner = client;
        }
        if (accountOwner == null) {
            BankService BS = new BankServiceImpl();
            BS.addClient(bank, user);
            accountOwner = user;
        }
        int accountCount = 0;
        FileReader FR = new FileReader(file);
        BufferedReader BR = new BufferedReader(FR);
        String line = BR.readLine();
        while (line != null) {
            String line2 = line.substring(1);
            String[] account = line2.split("_");

            if (line.startsWith("p")) {
                for (PaymentAccount acc: pAccs) {
                    if (account[0].equals(acc.getId().toString()) && account[1].equals(acc.getPaymentAccountFunds().toString())) {
                        acc.setBank(bank);
                        accountCount++;
                    }
                }
            }
            else if (line.startsWith("c")) {
                for (CreditAccount acc: cAccs) {
                    if (account[0].equals(acc.getId().toString()) && account[1].equals(acc.getLoanValue().toString()) && account[2].equals(acc.getMonthlyPayment().toString())) {
                        acc.setBankName(bank.getName());
                        accountCount++;
                    }
                }
            }
            else throw new IOException("file corrupted!");
            line = BR.readLine();
        }
        BR.close();
        FR.close();

        return accountCount + " accounts imported";
    }
}
