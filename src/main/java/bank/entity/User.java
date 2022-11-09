package bank.entity;
import java.util.ArrayList;
import java.util.Date;

public class User {
    Integer id;
    String name;
    Date DOB;
    String work;
    Integer monthlyIncome;
    ArrayList<Bank> banks;
    ArrayList<CreditAccount> creditAccs;
    ArrayList<PaymentAccount> paymentAccs;
    Integer loanRating;

    public User(String userName, Integer userID, Date userDOB) {
        this.name = userName; this.id = userID; this.DOB = userDOB;
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

    public Date getDOB() {
        return DOB;
    }
    public void setDOB(Date DOB) {
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
