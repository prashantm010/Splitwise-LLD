package storage;

import entity.Expense;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserExpenseStorage {
    private static UserExpenseStorage userExpenseStorage;
    private HashMap<User, List<Expense>> userExpenses = new HashMap<>();

    public static UserExpenseStorage getInstance(){
        if (userExpenseStorage == null){
            userExpenseStorage = new UserExpenseStorage();
        }
        return userExpenseStorage;
    }

    public HashMap<User, List<Expense>> getUserExpensesMap(){
        return userExpenses;
    }

    public void addUserExpense(User user, List<Expense> list){
        userExpenses.put(user, list);
    }

    public List<Expense> getUserExpense(User user){
        return userExpenses.getOrDefault(user, new ArrayList<>());
    }

    public void clearUserExpense(User user1, User user2, Double amount, String status){

    }
}
