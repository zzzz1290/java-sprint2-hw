import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    public  ArrayList<Expense> sales = new ArrayList<>();
    public  ArrayList<Expense> spending = new ArrayList<>();


    public void loadFile(String path) {

        String content = readFileContentsOrNull(path);
        String[] lines = content.split("\r?\n"); // разбивка по строкам

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i]; //item_name,is_expense,quantity,unit_price
            String[] parts = line.split(","); // Коньки,TRUE,50,2000
            String item_name = parts[0];
            boolean is_expense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int unit_price = Integer.parseInt(parts[3]);

            Expense expense = new Expense(item_name, is_expense, quantity, unit_price);
            if (is_expense) {
                sales.add(expense);
            } else {
                spending.add(expense);
            }
        }
    }

    public String getTopProductIs() {
        HashMap<String, Integer> freqs = new HashMap<>();
        for (Expense sale : sales) {
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
        return "Самый прибыльный товар '" + max_item_name + "' прибыль " + freqs.get(max_item_name) + " рублей";
    }

    public String getTopExpense() {
        HashMap<String, Integer> freqs = new HashMap<>();
        for (Expense spend : spending) {
            freqs.put(spend.item_name, freqs.getOrDefault(spend.item_name,0) + (spend.quantity * spend.unit_price));
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
        return "Самая большая трата '" + max_item_name + "' трата " + freqs.get(max_item_name) + " рублей";
    }
/*
    public String totalReport() {

    }

 */
    void clean() {
        sales.clear();
        spending.clear();
    }


    public String readFileContentsOrNull (String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("не могу прочитать месячный отчет отчет");
            return null;
        }
    }

}

