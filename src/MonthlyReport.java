import java.util.ArrayList;

public class MonthlyReport {
    FileReader fileReaderMonthly = new FileReader();

    public  MonthlyReport(String fileName) {
        String contentMonthly = String.valueOf(fileReaderMonthly.readFileContents(fileName));
        System.out.println(contentMonthly);
    }
}
