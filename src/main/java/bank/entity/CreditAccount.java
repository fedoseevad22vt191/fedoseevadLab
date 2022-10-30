package bank.entity;
import java.util.Date;

public class CreditAccount{
    Integer id;
    User creditUser;
    String bankName;
    Date startDate;
    Date endDate;
    Integer months;
    Integer loanValue;
    Employee employee;
    Integer monthlyPayment;

    // TODO: тут всё поломается, если прибавив месяцы мы выйдем на следующий год
    public CreditAccount(Integer creditAccID, Date startDate, Integer months, Integer loanValue) {
        this.id = creditAccID;
        this.startDate = startDate; this.months = months;
        this.endDate = new Date(startDate.getYear(), startDate.getMonth()+months, startDate.getDay());
        this.loanValue = loanValue;
        this.monthlyPayment = loanValue/months;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public User getCreditUser() {
        return creditUser;
    }
    public void setCreditUser(User creditUser) {
        this.creditUser = creditUser;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMonths() {
        return months;
    }
    public void setMonths(Integer months) {
        this.months = months;
    }

    public Integer getLoanValue() {
        return loanValue;
    }
    public void setLoanValue(Integer loanValue) {
        this.loanValue = loanValue;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getMonthlyPayment() {
        return monthlyPayment;
    }
    public void setMonthlyPayment(Integer monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return "Credit account " + id + "belongs to user #" + creditUser.getId() + "\n" +
                "Start date: " + startDate + ". End date: " + endDate + ". Monthly payment: " + monthlyPayment + "\n\n";
    }
}
