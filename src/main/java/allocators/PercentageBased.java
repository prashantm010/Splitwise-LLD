package allocators;

import entity.Expense;
import entity.User;

import java.util.HashMap;
import java.util.List;

public class PercentageBased{

    public void calculateExpense(HashMap<User, Double> map1, HashMap<User, Double> map2) {
        Double totalAmount = 0.0;
        for (User user: map1.keySet()){
            totalAmount += map1.get(user);
        }

        HashMap<User, Double> map3 = new HashMap<>();
        for (User user: map2.keySet()){
            map3.put(user, totalAmount*map2.get(user)/100);
        }

        ExpenseCalculator expenseCalculator = new ExpenseCalculator();
        expenseCalculator.calculateExpense(map1, map3);

    }
}
