import java.util.HashMap;

public class Checker {
    public MonthlyReport monthlyReport;
    public YearlyReport yearlyReport;

    public Checker(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }
/*
    public boolean check() {
        HashMap<Integer,HashMap<Integer,Boolean>> yearlyReporByYearly = new HashMap<>(); // amount  -> month -> is_expense
        for (YearExpense sale : yearlyReport.sales) {
            if (sale.amount) {
                continue;
            }
            if (!yearlyReporByYearly.containsKey(sale.amount)) {
                yearlyReporByYearly.put(sale.amount,  new HashMap<>());
            }
            HashMap<Integer,Boolean> sums = yearlyReporByYearly.get(sale.amount);
            sums.put(sale.month, sums.getOrDefault(sale.is_expense, true)); {

            }
        }
        return false;
    }


 */

/*
    public void checks() {
        HashMap<String, HashMap<Boolean, Integer>> monthlyReportByYearly = new HashMap<>(); //item_name -> quantity -> is_expense
        int sum = 0;
        for (Expense sale : monthlyReport.sales) {
            if (!sale.is_expense) {
                continue;
            }
            if (!monthlyReportByYearly.containsKey(sale.item_name)) {
                monthlyReportByYearly.put(sale.item_name, new HashMap<>());
            }
            HashMap<Boolean, Integer> sums = monthlyReportByYearly.get(sale.item_name);
            sums.put(sale.is_expense, sale.quantity * sale.unit_price);
            System.out.println(sums);
            for (int maxSum : sums.values()) {
                sum = maxSum + sum;
                System.out.println(sum);
            }
            HashMap<Integer,Boolean> result = new HashMap<>();
            result.put(sum,sale.is_expense); // amounth true

        }

        System.out.println(monthlyReportByYearly.size());
    }

 */
}
