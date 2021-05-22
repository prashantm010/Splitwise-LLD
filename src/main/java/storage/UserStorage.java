package storage;

import entity.User;
import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;

import java.util.HashMap;

public class UserStorage {
    private static UserStorage userStorage;
    private HashMap<String, User> userHashMap = new HashMap<>();

    public static UserStorage getInstance(){
        if (userStorage == null){
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public void addUser(User user){
        if (userHashMap.get(user.getId()) != null){
            throw new UserAlreadyExistsException("User already exists");
        }
        userHashMap.put(user.getId(), user);
    }

    public User getUser(String userId){
        if (userHashMap.get(userId) == null){
            throw new UserNotFoundException("User Not Found");
        }
        return userHashMap.get(userId);
    }

    public void removeUser(String userId){
        if (userHashMap.get(userId) == null){
            throw new UserNotFoundException("User Not Found");
        }
        userHashMap.remove(userId);
    }

}
