import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    FileReader fileReader = new FileReader();
    public ArrayList<ExpenseMonthly> expenseMonthReport = new ArrayList<>();


    public void readMonthlyReport(String month, String path) {
        ArrayList<String> lines = fileReader.readFileContents(path);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i); //item_name,is_expense,quantity,unit_price
            String[] parts = line.split(","); // Коньки,TRUE,50,2000
            String item_name = parts[0];
            boolean is_expense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int unit_price = Integer.parseInt(parts[3]);

            ExpenseMonthly expenseMonthly = new ExpenseMonthly(item_name, is_expense, quantity, unit_price, month);
            expenseMonthReport.add(expenseMonthly);
        }
    }

    public String topItem(String month) {
        /*
        if (0 == expenseMonthReport.size()) {
            System.out.println("Небходимо считать файлы");
            return;
        }
         */
        System.out.println("Месяц "+ month);
        HashMap<String, Integer> profit = new HashMap<>();
        Integer sumProfit = 0;
        Integer sumExpense = 0;
        for (ExpenseMonthly sale : expenseMonthReport) {
            if (!sale.is_expense) {
                profit.put(sale.item_name, profit.getOrDefault(sale.item_name, 0) + (sale.quantity * sale.unit_price));
                sumProfit = sumProfit + (sale.quantity * sale.unit_price); // Поиск сумы прибыли
            }
        }
        String max_item_name = null;
        for (String item_name : profit.keySet()) {
            if (max_item_name == null) {
                max_item_name = item_name;
                continue;
            }
            if (profit.get(max_item_name) < profit.get(item_name)) {
                max_item_name = item_name;
            }
        }
        System.out.println("Сумма прибыли за месяц: " + sumProfit);
        System.out.println("Самый прибыльный товар: " + max_item_name + ", cтоимость товара: " + profit.get(max_item_name));
        HashMap<String, Integer> expense = new HashMap<>();
        for (ExpenseMonthly expen : expenseMonthReport) {
            if (expen.is_expense) {
                expense.put(expen.item_name, profit.getOrDefault(expen, 0) + (expen.quantity * expen.unit_price));
                sumExpense = sumExpense + (expen.quantity * expen.unit_price); // Поиск суммы трат
            }
        }
        String low_item_name = null;
        for (String item_name : expense.keySet()) {
            if (low_item_name == null) {
                low_item_name = item_name;
                continue;
                }
            if (expense.get(low_item_name) < expense.get(item_name)) {
                low_item_name = item_name;
            }
        }
        System.out.println("Сумма трат за месяц: " + sumExpense);
        return "Самая большая трата: " + low_item_name + ", cтоимость траты: " + expense.get(low_item_name);
    }

    public void cleans() {
        expenseMonthReport.clear();
    }
}


    /*

    public void getTopProductIs() {
        HashMap<String, Integer> freqs = new HashMap<>();
        for (ExpenseMonthly sale : expenses) {
            freqs.put(sale.item_name, freqs.getOrDefault(sale.item_name,0) + (sale.quantity * sale.unit_price));
        }
        //HashMap<String, Boolean> expense = new HashMap<>();

        String max_item_name = null;
        for (String item_name : freqs.keySet()) {
            if (max_item_name == null) {
                max_item_name = item_name;
                continue;
            }
            if (freqs.get(max_item_name) < freqs.get(item_name)) {
                max_item_name = item_name;
            }
        }
        freqs.get(max_item_name);
    }
    public void isExpen() {
        HashMap<String, Boolean> test = new HashMap<>();
        for (Boolean isExpense : test.keySet()) {

        }
    }

     */

/*
for (Boolean isExpense : monthData.keySet()){
                HashMap<String, Double> dataExpense = monthData.get(isExpense);
                String expense = isExpense ? "Самая большая трата: " : "Самый прибыльный товар: " ;
                for (String name : dataExpense.keySet()){
                    System.out.println(expense +  name + " - " + dataExpense.get(name));
                }
            }
 */