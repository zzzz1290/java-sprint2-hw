import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String,MonthlyReport> monthlyReports = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        /*
        String monthNumb = "01";
        monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
        //monthlyReport.topItem(monthNumb);
        monthlyReports.put(monthNumb,monthlyReport);
        System.out.println(monthlyReports.get(monthNumb).topItem(monthNumb));
        //System.out.println(monthlyReport.expenses);
         */

        yearlyReport.readYearlyReport("y.2021.csv");
        yearlyReport.yearReport("y.2021.csv");

        Check check = new Check(monthlyReport, yearlyReport);

        String monthNumbs = "00";
        Integer num = Integer.parseInt(monthNumbs);
        for (int i = 0; i < 3; i++) {
            num = num + 1;
            if (num < 10) {
                String monthNumb = "0" + String.valueOf(num);
                monthlyReport.readMonthlyReport(monthNumb,"m.2021"+ monthNumb +".csv");
                //monthlyReport.topItem(monthNumb);
                monthlyReports.put(monthNumb,monthlyReport);
                System.out.println(monthlyReports.get(monthNumb).topItem(monthNumb));
                check.checks();
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
        }



        boolean answer = check.checks();
        //System.out.println(answer);
    }
}

        /*
        //Считывание всех отчетов
        yearlyReport.readYearlyReport("y.2021.csv");
        yearlyReport.yearReport("y.2021.csv");


        //конец
         */