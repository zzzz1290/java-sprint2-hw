import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport01 = new MonthlyReport();
        MonthlyReport monthlyReport02 = new MonthlyReport();
        MonthlyReport monthlyReport03 = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Check check01 = new Check(monthlyReport01, yearlyReport);
        Check check02 = new Check(monthlyReport02, yearlyReport);
        Check check03 = new Check(monthlyReport03, yearlyReport);
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command > 6) {
                System.out.println("Введите команду с 1 по 6");
            }
            switch (command) {
                case 1:
                    monthlyReport01.cleans();
                    monthlyReport02.cleans();
                    monthlyReport03.cleans();
                    monthlyReport01.readMonthlyReport("01","m.202101.csv");
                    monthlyReport02.readMonthlyReport("02","m.202102.csv");
                    monthlyReport03.readMonthlyReport("03","m.202103.csv");
                    System.out.println("Месячные отчеты считаны");
                    break;
                case 2:
                    yearlyReport.cleans();
                    yearlyReport.readYearlyReport("y.2021.csv");
                    System.out.println("Годовой отчет считан");
                    break;
                case 3:
                    if (monthlyReport01.expenseMonthReport.isEmpty()) {
                        System.out.println("Месячный отчет не считан");
                    }
                    if (yearlyReport.expenseYearlyReport.isEmpty()) {
                        System.out.println("Годовой отчет не считан");
                    }
                    if (!check01.checks() & !check02.checks() & !check03.checks()) {
                        System.out.println("Ошибок между годовыми и месячными отчетами не обнаружено");
                        break;
                    }
                    break;
                case 4:
                    monthlyReport01.topItem("01");
                    System.out.println();
                    monthlyReport02.topItem("02");
                    System.out.println();
                    monthlyReport03.topItem("03");
                    break;
                case 5:
                    yearlyReport.yearReport("y.2021.csv");
                    System.out.println();
                    yearlyReport.cleans();
                    break;
                case 6:
                    System.out.println("Выход");
                    scanner.close();
                    return;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Меню");
        System.out.println("1. Считать все месячные отчёты");
        System.out.println("2. Считать годовой отчёт");
        System.out.println("3. Сверить отчёты");
        System.out.println("4. Вывести информацию обо всех месячных отчётах");
        System.out.println("5. Вывести информацию о годовом отчёте");
        System.out.println("6. Выход");
    }
}