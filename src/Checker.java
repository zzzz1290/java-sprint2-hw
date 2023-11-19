import java.util.HashMap;

public class Checker {
    public MonthlyReport monthlyReport;
    public YearlyReport yearlyReport;

    public Checker(MonthlyReport monthlyReport, YearlyReport yearlyReport){
       this.monthlyReport = monthlyReport;
       this.yearlyReport = yearlyReport;
    }

    public boolean check() {
        HashMap<Integer,HashMap<Integer,Boolean>> yearlyReporByYearly = new HashMap<>(); // mounth -> amounth -> is_expense
        for (YearExpense sale : yearlyReport.sales) {
            if (!sale.is_expense) {
                continue;
        }
            if (!yearlyReporByYearly.containsKey(sale.month)) {
                yearlyReporByYearly.put(sale.month,  new HashMap<>());
            }
            HashMap<Integer,Boolean> sums = yearlyReporByYearly.get(sale.month);
            sums.put(sale.amount, sums.getOrDefault(sums., 0))
        }
        return false;
    }

}
