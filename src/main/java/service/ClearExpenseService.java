package service;

import entity.Expense;
import entity.User;
import exception.InvalidSettlementRequestException;
import storage.UserExpenseStorage;

import java.util.List;

public class ClearExpenseService {
    private static ClearExpenseService expenseService;

    public static ClearExpenseService getInstance(){
        if (expenseService == null){
            expenseService = new ClearExpenseService();
        }
        return expenseService;
    }

    public Double getUserExpense(User user1, User user2){
        List<Expense> user1ExpenseList = UserExpenseStorage.getInstance().getUserExpense(user1);
        for (Expense expense: user1ExpenseList){
            if (expense.getUser().getId().equals(user2.getId())){
                return expense.getAmount();
            }
        }
        return 0.0;
    }

    public void settleExpense(User user1, User user2, Double amount){
        double expense = getUserExpense(user1, user2);
        if (expense != amount){
            throw new InvalidSettlementRequestException("Invalid Settle Expense Request");
        }

        List<Expense> user1Expenses = getUserExpenses(user1);
        List<Expense> user2Expenses = getUserExpenses(user2);
        SettleAmount(user1Expenses, user2, -amount);
        SettleAmount(user2Expenses, user1, amount);
    }

    private List<Expense> getUserExpenses(User user){
        return UserExpenseStorage.getInstance().getUserExpense(user);
    }

    private void SettleAmount(List<Expense> userExpensesList, User user, Double amount){
        Expense expense1 = null;
        for (Expense expense: userExpensesList){
            if (expense.getUser().getId().equals(user.getId())){
                double newAmount = expense.getAmount() + amount;
                if (newAmount != 0){
                    expense.setAmount(newAmount);
                } else {
                    expense.setAmount(newAmount);
                    expense1 = expense;
                }
            }
        }
        userExpensesList.remove(expense1);
    }
}
