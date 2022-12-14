package bank.entity;

public class Bank {
    Integer id;
    String name;
    Integer officeCount = 0;
    Integer ATMs = 0;
    Integer employeeCount = 0;
    Integer clientCount = 0;
    Integer rating;
    Integer funds;
    Integer intRate;

    public Bank(String name, Integer id) {
        this.name = name; this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getOfficeCount() {
        return officeCount;
    }
    public Integer getATMs() {
        return ATMs;
    }
    public Integer getEmployeeCount() {
        return employeeCount;
    }
    public Integer getClientCount() {
        return clientCount;
    }
    public Integer getRating() {
        return rating;
    }
    public Integer getFunds() {
        return funds;
    }
    public Integer getIntRate() {
        return intRate;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOfficeCount(Integer officeCount) {
        this.officeCount = officeCount;
    }
    public void setATMs(Integer ATMs) {
        this.ATMs = ATMs;
    }
    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }
    public void setClientCount(Integer clientCount) {
        this.clientCount = clientCount;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public void setFunds(Integer funds) {
        this.funds = funds;
    }
    public void setIntRate(Integer intRate) {
        this.intRate = intRate;
    }

    @Override
    public String toString() {
        return "Bank " + name + ".\n Has " + ATMs + " ATMs, " + employeeCount + " employees and " + clientCount + " clients.\n " +
                "Current funds: " + funds + "\n\n";
    }
}
