import java.util.ArrayList;

public class YearlyReport {
    FileReader fileReader = new FileReader();

    public YearlyReport(){
        ArrayList<String> contentYearly = fileReader.readFileContents(fileName);
        System.out.println(contentYearly);

    }

}
