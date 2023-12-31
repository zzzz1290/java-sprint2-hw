import java.util.HashMap;

public class Check {
    public MonthlyReport monthlyReport;
    public YearlyReport yearlyReport;

    public Check(MonthlyReport monthlyReport, YearlyReport yearlyReport) {
        this.monthlyReport = monthlyReport;
        this.yearlyReport = yearlyReport;
    }

    public boolean checks() {
        boolean error = false;
        int amountToMountTrue = 0;
        int amountToMountFalse = 0;
        HashMap<String, HashMap<Boolean, Integer>> expenseMonthByMonth = new HashMap<>(); // month -> -> (quantity * unit_price) -> is_expense
        for (ExpenseMonthly expenseMonthly : monthlyReport.expenseMonthReport) {
            if (!expenseMonthByMonth.containsKey(expenseMonthly.month)) {
                expenseMonthByMonth.put(expenseMonthly.month, new HashMap<>());
            }
            HashMap<Boolean, Integer> nameToQuanToPrice = expenseMonthByMonth.get(expenseMonthly.month);
            if (expenseMonthly.is_expense) {
                amountToMountTrue = (expenseMonthly.quantity * expenseMonthly.unit_price) + amountToMountTrue;
                //System.out.println(amountToMountTrue + " amountToMountTrue");
            } else if (!expenseMonthly.is_expense) {
                amountToMountFalse = (expenseMonthly.quantity * expenseMonthly.unit_price) + amountToMountFalse;
                //System.out.println(amountToMountFalse + " amountToMountFalse");
            }
            nameToQuanToPrice.put(!expenseMonthly.is_expense, amountToMountTrue);
            nameToQuanToPrice.put(expenseMonthly.is_expense, amountToMountFalse);
            //nameToQuanToPrice.put(expenseMonthly.is_expense, expenseMonthly.quantity * expenseMonthly.unit_price);
        }

        HashMap<String, HashMap<Boolean, Integer>> expenseYearsByMonth = new HashMap<>(); // month -> amount -> is_expense
        for (YearExpense yearExpense : yearlyReport.expenseYearlyReport) {
            if (!expenseYearsByMonth.containsKey(yearExpense.month)) {
                expenseYearsByMonth.put(yearExpense.month, new HashMap<>());
            }
            HashMap<Boolean, Integer> nameToAmount = expenseYearsByMonth.get(yearExpense.month);
            nameToAmount.put(yearExpense.is_expense, yearExpense.amount);
        }
        if (expenseYearsByMonth.isEmpty()) {
            error = true;
            //System.out.println("Годовой отчет не был считан");
        }
        if (expenseMonthByMonth.isEmpty()) {
            error = true;
            //System.out.println("Месячный отчет не был считан " + path );
        }

        for (String month : expenseYearsByMonth.keySet()) {
            if (expenseYearsByMonth.get(month) != null && expenseMonthByMonth.get(month) != null) {
                HashMap<Boolean, Integer> monthToIsExpByYear = expenseYearsByMonth.get(month);
                HashMap<Boolean, Integer> monthToIsExpByMont = expenseMonthByMonth.get(month);
                for (Boolean is_expense : monthToIsExpByMont.keySet()) {
                    int expenByYear = monthToIsExpByYear.get(is_expense);
                    int expenByMonth = monthToIsExpByMont.get(is_expense);
                    if (expenByYear != expenByMonth) {
                        System.out.println("Ошибка:");
                        System.out.println("Месяц " + month + " в годовом отчете " + expenByYear + " а в месячном отчете " + expenByMonth);
                        error = true;
                    }

                }
            }
        }
        return error;
    }
}
