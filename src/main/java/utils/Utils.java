package utils;

import entity.User;
import exception.InvalidExpenseException;

import java.util.HashMap;

public class Utils {
    private static Utils utils;

    public static Utils getInstance(){
        if (utils == null){
            utils = new Utils();
        }
        return utils;
    }

    public void validateInputs(HashMap<User, Double> map1, HashMap<User, Double> map2){
        int amountPaid = 0;
        for (User user: map1.keySet()){
            amountPaid += map1.get(user);
        }

        int amountToBePaid = 0;
        for (User user: map2.keySet()){
            amountToBePaid += map2.get(user);
        }

        if (amountPaid != amountToBePaid){
            throw new InvalidExpenseException();
        }
    }
}
