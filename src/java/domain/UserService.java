/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.Date;
import java.util.ArrayList;

public class UserService {

    private UserDAO userDataAccess;

    public UserService() {
        userDataAccess = new UserDAO();
    }
    
    public ArrayList<User> getAllUser() {
        ArrayList<User> users = null;
        try {
            users = userDataAccess.allUserRetrieve();
        } catch (Exception e) {
            users = null;
        }
        return users;
    }
    
    public User getUser(String usertype, String userID, String password) {
        User user = null;
        try {
            user = userDataAccess.userRetrieve(usertype, userID, password);
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public void userCreate(String userID, String usertype, String username, String password, String phoneNum, String address) {
        userDataAccess.userCreate(userID, usertype, username, password, phoneNum, address);
    }
}

