package allocators;
import entity.User;

import java.util.HashMap;
import java.util.List;

public class EqualityBased{

    public void calculateExpense(HashMap<User, Double> map1, List<User> userList) {
        int n = userList.size();
        Double totalAmount = 0.0;
        for (User user: map1.keySet()){
            totalAmount += map1.get(user);
        }

        HashMap<User, Double> map2 = new HashMap<>();
        for (User user: userList){
            map2.put(user, totalAmount/n);
        }
        ExpenseCalculator expenseCalculator = new ExpenseCalculator();
        expenseCalculator.calculateExpense(map1, map2);
    }
}
