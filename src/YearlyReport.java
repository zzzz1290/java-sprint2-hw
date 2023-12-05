import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YearlyReport {
    FileReader fileReader = new FileReader();

    public ArrayList<YearExpense> expenseYearlyReport = new ArrayList<>();
    public void readYearlyReport(String path) {
        ArrayList<String> lines = fileReader.readFileContents(path);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i); //item_name,is_expense,quantity,unit_price
            String[] parts = line.split(","); // Коньки,TRUE,50,2000
            String month = parts[0];
            int amount = Integer.parseInt(parts[1]);
            boolean is_expense = Boolean.parseBoolean(parts[2]);
            YearExpense yearExpense = new YearExpense(month,amount,is_expense);
            expenseYearlyReport.add(yearExpense);
        }
    }
/*
    public String yearReport(String path) {
        System.out.println("Год отчета " + path);
        HashMap<Integer,Integer> yearExpense = new HashMap<>();
        //HashMap<Integer,Integer> mounthProfit = new HashMap<>();
        Integer sumProfitYear = 0;
        Integer sumMounthProfitYear = 0;
        for (YearExpense profit : expenseYearlyReport) {
            if (profit.is_expense) {
                yearExpense.put(profit.month,profit.month);
                for (Integer maxSum : yearExpense.values()) {
                    sumProfitYear = sumMounthProfitYear + maxSum;
                }
                sumMounthProfitYear = sumMounthProfitYear + 1;
            }
        }
        for (Map.Entry<Integer,Integer> mounth : yearExpense.entrySet()) {
            System.out.println("Месяц " +  mounth.getKey() + " Прибыль " + mounth.getValue());
        }
        System.out.println("Cердняя прибыль за год " + sumProfitYear / sumMounthProfitYear);
        return "Сумма прибыли за год " + sumProfitYear;
    }

 */
public String yearReport (String path) {
    System.out.println("Год " + path);
    HashMap<String, Integer> profitsYear = new HashMap<>();
    int sumProfitYear = 0;
    int sumMounthProfitYear = 0;
    for (YearExpense profitYear : expenseYearlyReport) {
        if (!profitYear.is_expense) {
            profitsYear.put(profitYear.month, profitYear.amount);
        }
    }
    //Заполнение HashMap profitsYear
    for (int maxsum : profitsYear.values()) {
        sumProfitYear = +sumProfitYear + maxsum;
        sumMounthProfitYear = sumMounthProfitYear + 1;
    }
    //Поиск суммы прибыли и кол-ва месяцев
    for (Map.Entry<String, Integer> mounth : profitsYear.entrySet()) {
        System.out.println("Месяц " +  mounth.getKey() + " Прибыль " + mounth.getValue());
    }
    //Вывод по месяцам
    int sumExpensYear = 0;
    int sumMounthExpensYear = 0;
    HashMap<String,Integer> expense = new HashMap<>();
    for (YearExpense expenseYear : expenseYearlyReport) {
        if (expenseYear.is_expense) {
            expense.put(expenseYear.month, expenseYear.amount);
        }
    }
    //Заполнение HashMap expense
    for (int maxsumm : expense.values()) {
        sumExpensYear = sumExpensYear + maxsumm;
        sumMounthExpensYear = sumMounthExpensYear + 1;
    }
    //Поиск суммы траты и кол-ва месяцев

    System.out.println("Средняя прибыль за год " + sumProfitYear / sumMounthProfitYear);
    System.out.println("Средняя трата за год " + sumExpensYear / sumMounthExpensYear);
    return null;
    }
}
