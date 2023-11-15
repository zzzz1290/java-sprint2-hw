import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {


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
        }
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

