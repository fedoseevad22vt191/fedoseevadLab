package bank.entity;
import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    Integer id;
    String name;
    LocalDate DOB;
    String work;
    Integer monthlyIncome;
    ArrayList<Bank> banks;
    ArrayList<CreditAccount> creditAccs;
    ArrayList<PaymentAccount> paymentAccs;
    Integer loanRating;

    public User(String userName, Integer userID, LocalDate userDOB) {
        this.name = userName; this.id = userID; this.DOB = userDOB;
        banks = new ArrayList<>();
        creditAccs = new ArrayList<>();
        paymentAccs = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getWork() {
        return work;
    }
    public void setWork(String work) {
        this.work = work;
    }

    public Integer getMonthlyIncome() {
        return monthlyIncome;
    }
    public void setMonthlyIncome(Integer monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }
    public void setBanks(ArrayList<Bank> banks) {
        this.banks = banks;
    }

    public ArrayList<CreditAccount> getCreditAccs() {
        return creditAccs;
    }
    public void setCreditAccs(ArrayList<CreditAccount> creditAccs) {
        this.creditAccs = creditAccs;
    }

    public ArrayList<PaymentAccount> getPaymentAccs() {
        return paymentAccs;
    }
    public void setPaymentAccs(ArrayList<PaymentAccount> paymentAccs) {
        this.paymentAccs = paymentAccs;
    }

    public Integer getLoanRating() {
        return loanRating;
    }
    public void setLoanRating(Integer loanRating) {
        this.loanRating = loanRating;
    }

    @Override
    public String toString() {
        return "User " + name + "with income of " + monthlyIncome + "\n\n";
    }
}
