package bank.entity;

import java.util.ArrayList;

public class Bank {
    Integer id;
    String name;
    ArrayList<BankOffice> offices;
    ArrayList<BankAtm> ATMs;
    ArrayList<Employee> employees;
    ArrayList<User> clients;
    Integer rating;
    Integer funds;
    Integer intRate;

    public Bank(String name, Integer id) {
        this.name = name; this.id = id;
        offices = new ArrayList<>();
        employees = new ArrayList<>();
        clients = new ArrayList<>();
        ATMs = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public ArrayList<BankOffice> getOffices() {
        return offices;
    }
    public ArrayList<BankAtm> getATMs() {
        return ATMs;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public ArrayList<User> getClients() {
        return clients;
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
    public void setOffices(ArrayList<BankOffice> offices) {
        this.offices = offices;
    }
    public void setATMs(ArrayList<BankAtm> ATMs) {
        this.ATMs = ATMs;
    }
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public void setClients(ArrayList<User> clients) {
        this.clients = clients;
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
        return "Bank " + name + ".\n Has " + ATMs + " ATMs, " + ATMs.size() + " employees and " + clients.size() + " clients.\n " +
                "Current funds: " + funds + "\n\n";
    }
}
