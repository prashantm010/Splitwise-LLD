import entity.Expense;
import entity.User;
import service.AddExpenseService;
import service.ClearExpenseService;
import storage.UserExpenseStorage;
import storage.UserStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        User user1 = new User("Prashant", "prashant");
        User user2 = new User("Akshay", "Akshay");
        User user3 = new User("Sid", "Sid");

        UserStorage.getInstance().addUser(user1);
        UserStorage.getInstance().addUser(user2);
        UserStorage.getInstance().addUser(user3);

        // Equality Based Expense Calculator
        HashMap<User, Double> paidMap = new HashMap<>();
        paidMap.put(user1, 100.00);
        paidMap.put(user2, 50.00);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        AddExpenseService addExpenseService1 = new AddExpenseService(paidMap, userList);
        addExpenseService1.addExpense();

        // Percentage Based Expense Calculator
        HashMap<User, Double> paidMap2 = new HashMap<>();
        paidMap2.put(user1, 120.00);
        HashMap<User, Double> percentageMap = new HashMap<>();
        percentageMap.put(user1, 50.0);
        percentageMap.put(user2, 30.0);
        percentageMap.put(user3, 20.0);
        AddExpenseService addExpenseService2 = new AddExpenseService(paidMap2, percentageMap);
        addExpenseService2.addExpense();

        // Percentage Based Expense Calculator
        HashMap<User, Double> paidMap3 = new HashMap<>();
        paidMap3.put(user1, 100.00);
        paidMap3.put(user2, 50.00);
        HashMap<User, Double> requirementMap = new HashMap<>();
        requirementMap.put(user1, 75.0);
        requirementMap.put(user3, 75.0);
        AddExpenseService addExpenseService3 = new AddExpenseService(paidMap3, requirementMap, userList);
        addExpenseService3.addExpense();
        Double amount = ClearExpenseService.getInstance().getUserExpense(user1, user2);
        ClearExpenseService.getInstance().settleExpense(user1, user2, amount);
    }
}
