package allocators;

import misc.ExpensesType;

public class ExpenseCalculatorFactory {
    private static ExpenseCalculatorFactory expenseCalculatorFactory;

    public static ExpenseCalculatorFactory getInstance(){
        if (expenseCalculatorFactory == null){
            expenseCalculatorFactory = new ExpenseCalculatorFactory();
        }
        return expenseCalculatorFactory;
    }

    private EqualityBased equalityBased = new EqualityBased();
    private PercentageBased percentageBased = new PercentageBased();
    private RequirementBased requirementBased = new RequirementBased();

//    public ExpenseCalculator expenseCalculatorSelector(ExpensesType type){
//        if (type == ExpensesType.EQUAL){
//            return equalityBased;
//        } else if (type == ExpensesType.REQUIREMENT){
//            return requirementBased;
//        } else{
//            return percentageBased;
//        }
//    }

}
