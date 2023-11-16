import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    // Поехали!
    public static void main(String[] args) {
        //ileReader fileReader = new FileReader();
        YearlyReport yearlyReport = new YearlyReport("resources/y.2021.csv");

        MonthlyReport monthlyReport = new MonthlyReport();
        //monthlyReport.loadFile("resources/m.202101.csv");
        //monthlyReport.loadFile("resources/m.202102.csv");
        //monthlyReport.loadFile("resources/m.202103.csv");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Check");

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
                                monthlyReport.loadFile("resources/m.202101.csv");
                                System.out.println(monthlyReport.getTopProductIs());
                                System.out.println(monthlyReport.getTopExpense());
                                monthlyReport.clean();
                                break;
                            case 2:
                                System.out.println("m.202102.csv");
                                monthlyReport.loadFile("resources/m.202102.csv");
                                System.out.println(monthlyReport.getTopProductIs());
                                System.out.println(monthlyReport.getTopExpense());
                                monthlyReport.clean();
                                break;
                            case 3:
                                System.out.println("m.202103.csv");
                                monthlyReport.loadFile("resources/m.202103.csv");
                                System.out.println(monthlyReport.getTopProductIs());
                                System.out.println(monthlyReport.getTopExpense());
                                monthlyReport.clean();
                                break;
                        }
                    break;

                case 2:
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
        System.out.println("2- Сверка данных по месячным и годовому отчётам.");
        System.out.println("3- Вывод информации о месячных и годовом отчётах.");
        System.out.println("4- Выход");
    }


}




