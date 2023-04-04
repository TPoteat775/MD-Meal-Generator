package sample;

// Course Code: CIS214-401 Computer Science III
// Submission Type: Implementation
// Due Date: November 24th, 2020
// Authors: Brandon, Mike, Enrich, Tiana
// Purpose: Create a class that can check a users login or sign up information

import java.util.ArrayList;

public class Login {
    /**Method to test a users login information to see if it is valid
     @param users, an array list of existing users
     @param username, a username to be tested
     @param password, a password to be tested*/

    public static boolean testLoginUser(ArrayList<User> users, String username, String password){
        //iterate through ArrayList of users with for loop
        for(int i = 0; i < users.size(); i++){
            User tempUser = users.get(i);//get user from arrayList
            //if username and password matches user object, return true
            if(tempUser.getUsername().equals(username) && tempUser.getPassword().equals(password) ){
                return true;
            }
        }
        //if username and password are not equal to any within the users arrayList, return false
        return false;
    }
    
    public static boolean testRegisterUser(ArrayList<User> users, String username, String password){
        //username must be less than 16 characters, password must be at least 8
        //Both password and username cannot be empty ensure username and password
        //are within length requirements
        if(username.length() == 0 || username.length() > 16 ||
                password.length() == 0 || password.length() < 8){
            return false;
        }
        //if length requirements are met, create user, then add user to users arrayList
        else{
            User newUser = new User(username, password);
            users.add(newUser);
            return true;
        }
    }
}
