import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    // Поехали!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileReader fileReader = new FileReader();
        YearlyReport yearlyReport = new YearlyReport("resources/y.2021.csv");

        MonthlyReport monthlyReport = new MonthlyReport();
        //fileReader.readFileContents("m.202101.csv");
        monthlyReport.readMonthlyReport("m.202101.csv");
        monthlyReport.getTopProductIs();

        //monthlyReport.loadFile("resources/m.202101.csv");
        //monthlyReport.loadFile("resources/m.202102.csv");
        //monthlyReport.loadFile("resources/m.202103.csv");
        //Checker checker = new Checker(monthlyReport, yearlyReport);

        System.out.println("Check");
        //monthlyReport.getTopExpense();
        //checker.checks();
        //
        //System.out.println(yearlyReport.averExpanse());
        //System.out.println(yearlyReport.getIsExpencse());
        //System.out.println(monthlyReport.getTopProductIs());

        //System.out.println(monthlyReport.getTopExpense());

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command > 4) {
                System.out.println("Введите команду с 1 по 4");
            }
            switch (command) {
                case 1:
                    System.out.println("Выберите месяц");
                    System.out.println("1 - m.2021.01");
                    System.out.println("2 - m.2021.02");
                    System.out.println("3 - m.2021.03");
                    System.out.println("4 - Выйти");
                    int command_menu_1 = scanner.nextInt();
                    if (command_menu_1 > 4) {
                        System.out.println("Введите команду с 1 по 4");
                    }
                        switch (command_menu_1) {
                            case 1:
                                System.out.println("m.202101.csv");
                                //monthlyReport.loadFile("resources/m.202101.csv");
                                System.out.println(monthlyReport.getTopProductIs());
                                //System.out.println(monthlyReport.getTopExpense());
                                monthlyReport.clean();
                                break;
                            case 2:
                                System.out.println("m.202102.csv");
                                //monthlyReport.loadFile("resources/m.202102.csv");
                                System.out.println(monthlyReport.getTopProductIs());
                                //System.out.println(monthlyReport.getTopExpense());
                                monthlyReport.clean();
                                break;
                            case 3:
                                System.out.println("m.202103.csv");
                                //monthlyReport.loadFile("resources/m.202103.csv");
                                System.out.println(monthlyReport.getTopProductIs());
                                //System.out.println(monthlyReport.getTopExpense());
                                monthlyReport.clean();
                                break;
                        }
                    break;

                case 2:
                    System.out.println("Выберите пунтк меню");
                    System.out.println("1 - Прибыль за год");
                    System.out.println("2 - Трата за год");
                    System.out.println("5 - Выход");
                    int command_menu_2 = scanner.nextInt();
                    if (command_menu_2 > 8) {
                        System.out.println("Введите команду с 1 по 5");
                    }
                        switch (command_menu_2) {
                            case 1:
                                System.out.println(yearlyReport.getExpense());
                                break;
                            case 2:
                                System.out.println(yearlyReport.getIsExpencse());
                                break;
                            case 3:
                                System.out.println();

                        }

                    /*

                     */
                    break;
                case 3:
                    /*

                     */
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
        System.out.println("1- Считывание месячного отчета");
        System.out.println("2- Информация по готовому отчету");
        System.out.println("3- Вывод информации о месячных и годовом отчётах.");
        System.out.println("4- Выход");
    }


}
------------------------------------------------------------------------------
/*

/*
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,MonthlyReport> monthlyReports = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        /*
        String monthNumb = "01";
        monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
        //monthlyReport.topItem(monthNumb);
        monthlyReports.put(monthNumb,monthlyReport);
        System.out.println(monthlyReports.get(monthNumb).topItem(monthNumb));
        //System.out.println(monthlyReport.expenses);


         */
String monthNumbs = "00";
    Integer num = Integer.parseInt(monthNumbs);
        for (int i = 0; i < 3; i++) {
        num = num + 1;
        String monthNumb = "0" + String.valueOf(num);
        monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
        //monthlyReport.topItem(monthNumb);
        monthlyReports.put(monthNumb,monthlyReport);
        System.out.println(monthlyReports.get(monthNumb).topItem(monthNumb));
        monthlyReport.cleans();
        }
        }
        }

        /*
        //Считывание всех отчетов

        //конец
         */
 */

