package bank;

import bank.entity.*;
import bank.service.impl.*;

import java.io.IOException;
import java.util.*;

/*
    Q: геттеры и сеттеры паблик?
    Q: методы сервиса паблик?
    Q: как правильно сделать конструктор через копирование и нужен ли он вообще (у меня эти конструкторы пока сделаны неправильно намеренно)
    Q: надо ли хранить обрабатываемый обьект в сервисе??? если нет, то как должна работать операция delete, пока мы не подключили бд
    (потому что с подключением бд такого вопроса не было бы, рид забирает из бд и хранит в сервисе, делет убивает запись в бд)

    Q: реализация функции set - правильно ли? надо ли?

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

        List<String> names = Arrays.asList("Sberbank", "VTB", "Privatbank", "Tinkoff", "Alphabank");
        // Список банков - и погнали создавать
        ArrayList<Bank> banks = new ArrayList<>();
        try {
            int ct = 0;
            for (String name : names) {
                Bank bank = bankService.create(name, ++ct);
                for (int i = 0; i < 3; i++) {
                    BankOffice office = bankOfficeService.create("address" + i + 1, i + 1, bank);
                    bankService.addOffice(bankService.read(), office);
                    BankAtm atm = atmService.create("ATM" + i + 1, i + 1, bank, office);
                    bankOfficeService.addATM(bankOfficeService.read(), atm);
                    bankService.addATM(bankService.read(), atm);
                    for (int j = 0; j < 5; j++) {
                        Employee employee = employeeService.create("name" + j + 1, j + 1, emp1dob, bank, office);
                        bankService.addEmployee(bankService.read(), employee);
                        User client = userService.create("clientName" + j + 1, j + 1, user1dob, bank);
                        bankService.addClient(bankService.read(), client);
                        for (int z = 0; z < 2; z++) {
                            CreditAccount crAcc = creditAccountService.create(z + 1, startDate, 6, 50000, client, employee, bank);
                            PaymentAccount payAcc = paymentAccountService.create(z + 1, client, bank);
                        }
                    }
                }
                banks.add(bank);
            }
        }
        catch (IOException e) {
            System.out.println("Smth wrong with file creation\n");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
