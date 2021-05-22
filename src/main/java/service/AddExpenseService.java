package service;

import allocators.EqualityBased;
import allocators.PercentageBased;
import allocators.RequirementBased;
import entity.User;
import misc.ExpensesType;

import java.util.HashMap;
import java.util.List;

public class AddExpenseService {
    private HashMap<User, Double> map1;
    private HashMap<User, Double> map2;
    private List<User> userList;
    private ExpensesType type;

    public AddExpenseService(HashMap<User, Double> map1, List<User> userList) {
        this.map1 = map1;
        this.userList = userList;
        this.type = ExpensesType.EQUAL;
    }

    public AddExpenseService(HashMap<User, Double> map1, HashMap<User, Double> map2) {
        this.map1 = map1;
        this.map2 = map2;
        this.type = ExpensesType.PERCENTAGE;
    }

    public AddExpenseService(HashMap<User, Double> map1, HashMap<User, Double> map2, List<User> userList) {
        this.map1 = map1;
        this.map2 = map2;
        this.type = ExpensesType.REQUIREMENT;
        this.userList = userList;
    }

    public void addExpense(){
        if (this.type == ExpensesType.EQUAL){
            EqualityBased equalityBased = new EqualityBased();
            equalityBased.calculateExpense(map1, userList);
        } else if (this.type == ExpensesType.REQUIREMENT){
            RequirementBased requirementBased = new RequirementBased();
            requirementBased.createExpenseMaps(map1, map2, userList);
        } else{
            PercentageBased percentageBased = new PercentageBased();
            percentageBased.calculateExpense(map1, map2);
        }
    }
}
