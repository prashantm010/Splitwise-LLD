package allocators;
import entity.User;

import java.util.HashMap;
import java.util.List;

public class RequirementBased {
    public void createExpenseMaps(HashMap<User, Double> map1, HashMap<User, Double> map2, List<User> userList) {
        ExpenseCalculator expenseCalculator = new ExpenseCalculator();
        for (User user: userList){
            if (!map2.containsKey(user)){
                map2.put(user, 0.0);
            }
        }
        expenseCalculator.calculateExpense(map1, map2);
    }
}
