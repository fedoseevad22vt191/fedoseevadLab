package bank;

import bank.entity.*;
import bank.service.impl.*;

import java.util.Calendar;
import java.util.Date;

/*
    Q: геттеры и сеттеры паблик?
    Q: методы сервиса паблик?
    Q: как правильно сделать конструктор через копирование и нужен ли он вообще (у меня эти конструкторы пока сделаны неправильно намеренно)
    Q: надо ли хранить обрабатываемый обьект в сервисе??? если нет, то как должна работать операция delete, пока мы не подключили бд
    (потому что с подключением бд такого вопроса не было бы, рид забирает из бд и хранит в сервисе, делет убивает запись в бд)

    Связи между сущностями
    Q: почему у офиса нет связи с банком (создаёт проблемы при добавлении атм офису и т.д.)
    Q: у кредитного счёта только название банка или связь с банком? у платёжного счёта то же самое
 */

public class Main {
    public static void main(String[] args) {
        // this is an entry point
        Date startDate = new Date(112, Calendar.JUNE,20);
        Date user1dob = new Date(92, Calendar.MARCH,7);
        Date emp1dob = new Date(92, Calendar.MARCH,7);

        AtmServiceImpl atmService = new AtmServiceImpl();
        BankServiceImpl bankService = new BankServiceImpl();
        BankOfficeServiceImpl bankOfficeService = new BankOfficeServiceImpl();
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        Bank bank = bankService.create("Sberbank", 0001);
        BankOffice office = bankOfficeService.create("Kostyukova", 0001);
        BankAtm atm = atmService.create("ATM01", 0001, bank, office);
        Employee employee = employeeService.create("Fedorova Viktoriya", 0001, emp1dob, bank, office);
        User user = userService.create("Ivanov Ivan", 0001, user1dob, bank);
        CreditAccount crAcc = creditAccountService.create(0001, startDate, 6, 50000, user, employee, bank);
        PaymentAccount payAcc = paymentAccountService.create(0001, user, bank);

        System.out.print(bank);
        System.out.print(office);
        System.out.print(atm);
        System.out.print(employee);
        System.out.print(user);
        System.out.print(crAcc);
        System.out.print(payAcc);
    }
}
