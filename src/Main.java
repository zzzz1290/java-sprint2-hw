import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    // Поехали!
    public static void main(String[] args) {
        //ileReader fileReader = new FileReader();
        YearlyReport yearlyReport = new YearlyReport("resources/y.2021.csv");

        MonthlyReport monthlyReport = new MonthlyReport();
        monthlyReport.loadFile("resources/m.202101.csv");
        monthlyReport.loadFile("resources/m.202102.csv");
        monthlyReport.loadFile("resources/m.202103.csv");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Check");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command > 4) {
                System.out.println("Введите команду с 1 по 4");
            }
            switch (command) {
                case 1:

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
        System.out.println("1- Считывание месячных и годового отчётов бухгалтерии из файлов");
        System.out.println("2- Сверка данных по месячным и годовому отчётам.");
        System.out.println("3- Вывод информации о месячных и годовом отчётах.");
        System.out.println("4- Выход");
    }


}




