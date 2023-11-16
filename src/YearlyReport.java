import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

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
            if (!is_expense) {
                sales.add(yearExpense);
            } else {
                spending.add(yearExpense);
            }
        }
    }

    public String getExpense () {
        HashMap<Integer, Integer> expense = new HashMap<>();
        for (YearExpense sale : sales) {
            expense.put(sale.month, sale.amount);
        }
        return ;
    }




    public String readFileContentsOrNull (String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("не могу прочитать годовой отчет");
            return null;
        }
    }


}
