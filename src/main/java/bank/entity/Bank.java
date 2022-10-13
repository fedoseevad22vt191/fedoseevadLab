package bank.entity;
import bank.service.BankService;

import java.util.random.RandomGenerator;

public class Bank implements BankService {
    Integer id;
    String name;
    Integer offices = 0;
    Integer bankATMs = 0;
    Integer employees = 0;
    Integer clients = 0;
    Integer rating;
    Integer funds;
    Integer intRate;

    public Bank(String name, Integer id) {
        this.name = name; this.id = id;
        RandomGenerator generator = RandomGenerator.getDefault();
        rating = generator.nextInt(0,100);
        funds = generator.nextInt(0,1000000);
        intRate = generator.nextInt(0,20);
    }

    public void addEmployee() { employees++; }

    public void addClient() {
        clients++;
    }

    public void addATM() {
        bankATMs++;
    }

    public void addOffice() {
        offices++;
    }

    public void print() {
        System.out.print("Bank " + name + ".\n Has " + bankATMs + " ATMs, " + employees + " employees and " + clients + " clients.\n " +
                "Current funds: " + funds + "\n\n");
    }
}
