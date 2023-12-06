import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,MonthlyReport> monthlyReports = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Check check = new Check(monthlyReport, yearlyReport);
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command > 4) {
                System.out.println("Введите команду с 1 по 4");
            }
            switch (command) {
                case 1:
                    String monthNumbs = "00";
                    Integer num = Integer.parseInt(monthNumbs);
                    for (int i = 0; i < 3; i++) {
                        num = num + 1;
                        String monthNumb = "0" + String.valueOf(num);
                        monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
                        monthlyReports.put(monthNumb,monthlyReport);
                        System.out.println(monthlyReports.get(monthNumb).topItem(monthNumb));
                        monthlyReport.cleans();
                        System.out.println();
                    }
                    break;
                case 2:
                    yearlyReport.readYearlyReport("y.2021.csv");
                    yearlyReport.yearReport("y.2021.csv");
                    yearlyReport.cleans();
                    break;
                case 3:
                    yearlyReport.readYearlyReport("y.2021.csv");
                    String monthNumbss = "00";
                    Integer numm = Integer.parseInt(monthNumbss);
                    for (int i = 0; i < 3; i++) {
                        numm = numm + 1;
                        String monthNumb = "0" + String.valueOf(numm);
                        monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
                        monthlyReports.put(monthNumb,monthlyReport);
                        check.checks();
                        monthlyReport.cleans();
                    }
                    System.out.println("Сверка отчета завершена");
                    break;
                case 4:
                    System.out.println("Выход");
                    scanner.close();
                    return;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Меню");
        System.out.println("1 - Информация из месячных отчетах");
        System.out.println("2 - Информация из готового отчета");
        System.out.println("3 - Сверка годового и месячного отчета");
        System.out.println("4 - Выход");
    }
}


        /*
        //Считывание всех отчетов
        yearlyReport.readYearlyReport("y.2021.csv");
        yearlyReport.yearReport("y.2021.csv");


        //конец
         */

        /*
        String monthNumb = "01";
        monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
        //monthlyReport.topItem(monthNumb);
        monthlyReports.put(monthNumb,monthlyReport);
        System.out.println(monthlyReports.get(monthNumb).topItem(monthNumb));
        //System.out.println(monthlyReport.expenses);
         */

        /*
                    if (num < 10) {
                String monthNumb = "0" + String.valueOf(num);
                monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
                //monthlyReport.topItem(monthNumb);
                monthlyReports.put(monthNumb,monthlyReport);
                System.out.println(monthlyReports.get(monthNumb).topItem(monthNumb));
                //check.checks();
                monthlyReport.cleans();
                System.out.println("\n");

            } else if (num > 10) {
                String monthNumb = String.valueOf(num);
                monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
                //monthlyReport.topItem(monthNumb);
                monthlyReports.put(monthNumb,monthlyReport);
                System.out.println(monthlyReports.get(monthNumb).topItem(monthNumb));
                monthlyReport.cleans();
            }
         */