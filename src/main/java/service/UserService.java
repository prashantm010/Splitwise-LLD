package service;

import entity.User;
import storage.UserStorage;

public class UserService {

    public void AddUser(String name, String email){
        UserStorage.getInstance().addUser(new User(name, email));
    }

    public User getUser(String userId){
        return UserStorage.getInstance().getUser(userId);
    }

    public Boolean removeUser(String userId){
        UserStorage.getInstance().removeUser(userId);
        return true;
    }
}
