package allocators;

import entity.Expense;
import entity.User;
import storage.UserExpenseStorage;
import utils.Utils;

import java.util.HashMap;
import java.util.List;

public class ExpenseCalculator {
    public void calculateExpense(HashMap<User, Double> map1, HashMap<User, Double> map2){
        HashMap<User, Double> userExpensesMap = new HashMap<>();
        Utils.getInstance().validateInputs(map1, map2);

        for (User user1: map2.keySet()){
            Double amountToBePaid = map2.getOrDefault(user1, 0.0);
            Double amountPaid = map1.getOrDefault(user1, 0.0);
            Double extraPayment = amountPaid - amountToBePaid;
            userExpensesMap.put(user1, extraPayment);
        }
        HashMap<User, Double> lendorsMap = new HashMap<>();
        HashMap<User, Double> owersMap = new HashMap<>();
        for (User user: userExpensesMap.keySet()){
            if (userExpensesMap.get(user) > 0){
                lendorsMap.put(user, userExpensesMap.get(user));
            } else{
                owersMap.put(user, userExpensesMap.get(user));
            }
        }

        for (User user1 : lendorsMap.keySet()){
            for (User user2 : owersMap.keySet()){
                if (lendorsMap.get(user1) > 0 && owersMap.get(user2) < 0){
                    List<Expense> user1expenseList = UserExpenseStorage.getInstance().getUserExpense(user1);
                    List<Expense> user2expenseList = UserExpenseStorage.getInstance().getUserExpense(user2);
                    if (lendorsMap.get(user1) == -owersMap.get(user2)){
                        user1expenseList = updateUserRelatedInfo(user1expenseList, user2, lendorsMap.get(user1));
                        user2expenseList = updateUserRelatedInfo(user2expenseList, user1, -lendorsMap.get(user1));

                    } else if(lendorsMap.get(user1) > -owersMap.get(user2)) {
                        user1expenseList = updateUserRelatedInfo(user1expenseList, user2, -owersMap.get(user2));
                        user2expenseList = updateUserRelatedInfo(user2expenseList, user1, owersMap.get(user2));

                        lendorsMap.put(user1, lendorsMap.get(user1) + owersMap.get(user2));
                        owersMap.put(user2, 0.0);
                    } else{
                        user1expenseList = updateUserRelatedInfo(user1expenseList, user2, lendorsMap.get(user1));
                        user2expenseList = updateUserRelatedInfo(user2expenseList, user1, -lendorsMap.get(user1));

                        owersMap.put(user2, owersMap.get(user2) + lendorsMap.get(user1));
                        lendorsMap.put(user1, 0.0);
                    }
                    UserExpenseStorage.getInstance().addUserExpense(user1, user1expenseList);
                    UserExpenseStorage.getInstance().addUserExpense(user2, user2expenseList);
                }
            }
        }
    }

    public List<Expense> updateUserRelatedInfo(List<Expense> list, User user, Double amount){
        if (list.size() == 0){
            list.add(new Expense(user, amount));
        } else {
            boolean found = false;
            for (Expense expense : list){
                if (expense.getUser().getId().equals(user.getId())){
                    expense.setAmount(expense.getAmount() + amount);
                    found = true;
                    break;
                }
            }
            if (!found){
                list.add(new Expense(user, amount));
            }
        }
        return list;
    }
}
