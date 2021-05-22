package entity;

import misc.ExpensesType;

import java.util.HashMap;

public class ExpensesMap {
    private HashMap<User, Double> type1;
    private HashMap<User, Double> type2;
    private ExpensesType type;

    public ExpensesMap(HashMap<User, Double> type1, HashMap<User, Double> type2, ExpensesType type) {
        this.type1 = type1;
        this.type2 = type2;
        this.type = type;
    }

    public HashMap<User, Double> getType1() {
        return type1;
    }

    public void setType1(HashMap<User, Double> type1) {
        this.type1 = type1;
    }

    public HashMap<User, Double> getType2() {
        return type2;
    }

    public void setType2(HashMap<User, Double> type2) {
        this.type2 = type2;
    }

    public ExpensesType getType() {
        return type;
    }

    public void setType(ExpensesType type) {
        this.type = type;
    }
}
