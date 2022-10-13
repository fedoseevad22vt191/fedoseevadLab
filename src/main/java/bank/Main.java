package bank;

import bank.entity.PaymentAccount;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // this is an entry point
        Date startDate = new Date(112, Calendar.JUNE,20);
        Date user1dob = new Date(92, Calendar.MARCH,7);
        Date emp1dob = new Date(92, Calendar.MARCH,7);
        PaymentAccount payAcc1 = new PaymentAccount(0001,
                                                    0001, startDate, 6, 50000,
                                                    "Ivanov Ivan", 0001, user1dob,
                                                    "Fedorova Viktoriya", 0001, emp1dob,
                                                    "ATM01", 0001,
                                                    "Kostyukova", 0001,
                                                    "Sberbank", 0001);
        payAcc1.print();
    }
}
