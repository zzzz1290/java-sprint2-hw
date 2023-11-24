import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YearlyReport {

    public ArrayList<YearExpense> sales = new ArrayList<>();
    public ArrayList<YearExpense> spending = new ArrayList<>();

    public YearlyReport (String path) {
        String content = readFileContentsOrNull(path);
        String[] lines = content.split("\r?\n"); // разбивка по строкам

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i]; //month,amount,is_expense
            String[] parts = line.split(","); // 01,1593150,false
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean is_expense = Boolean.parseBoolean(parts[2]);
            YearExpense yearExpense = new YearExpense(month,amount,is_expense);
            if (is_expense) {
                sales.add(yearExpense);
            } else {
                spending.add(yearExpense);
            }
        }
    }

    public String getExpense () {
        HashMap<Integer, Integer> expense = new HashMap<>();
        int sum = 0;
        int sumMount = 0;

        for (YearExpense sale : sales) {
            expense.put(sale.month, sale.amount);
             for (int maxsum : expense.values()) {
                 sum = + sum + maxsum;
             }
            sumMount = sumMount + 1;
        }
        for (Map.Entry<Integer, Integer> mounth : expense.entrySet()) {
            System.out.println("Месяц " +  mounth.getKey() + " Прибыль " + mounth.getValue());
        }
        System.out.println("Cердняя прибыль за год " + sum / sumMount);
        return "Сумма прибыли за год " + sum;
    }

    public String getIsExpencse () {
        HashMap<Integer, Integer> isExpense = new HashMap<>();
        int sum = 0;
        int sumMountSpend = 0;
        for (YearExpense spend : spending) {
            isExpense.put(spend.month, spend.amount);
            for (int maxSumSend : isExpense.values()) {
                sum = + sum + maxSumSend;
            }
            sumMountSpend = sumMountSpend + 1;
        }
        for (Map.Entry<Integer, Integer> mounth : isExpense.entrySet()) {
            System.out.println("Месяц " +  mounth.getKey() + " трата " + mounth.getValue());
        }
        System.out.println("Cердняя трата за год " + (sum / sumMountSpend));
        return "Сумма трат за год " + sum;
    }
/*
    public String averExpanse () {
        HashMap<Integer, Integer> avereExpanse = new HashMap<>();
        Integer averSum = 0;
        Integer i = 0;
        for (YearExpense sale : sales) {
            avereExpanse.put(sale.month, sale.amount);
            for (int averSums : avereExpanse.values()) {
                averSum = +averSum + averSums;
            }
            i = i + 1;
        }
        return "aver " + averSum / i;
    }

 */

    public String readFileContentsOrNull (String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("не могу прочитать годовой отчет");
            return null;
        }
    }


    void clean() {
        sales.clear();
        spending.clear();
    }


}
