package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**Class to control register scene*/
public class RegisterController implements Initializable {
    
    //Define necessary fields
    @FXML
    private Label invalidLoginLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    /**Initialize override for scene*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**Method to define how pressing register button should react
     @param event, the event of pushing a button*/
    public void registerButtonOnAction(ActionEvent event) throws IOException{
        //Get users
        ArrayList<User> users = MdMealGenerator.getUsers();
        
        //Get user inputs
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        //check if username already exists
        if(checkIfUsernameExists(username, users) == true){
            //if username already exists show error
            invalidLoginLabel.setText("Username Already Taken");
        }
        //Check if username and password are correct lengths
        else if(username.length() <= 16 && password.length() >= 8){
            //if username and password are correct lengths, create new user
            //and display the main menu
            User user = new User(username, password);
            MdMealGenerator.addUser(user);
            MdMealGenerator.setCurrentUser(user);
            openMainMenuScene(event);
            
        }
        //If username is too long show error
        else if (username.length() > 16)
        {
            invalidLoginLabel.setText("Username must be less than 16 characters");
        }
        //If password is too short show error
        else
        {
            invalidLoginLabel.setText("Password must be at least 8 characters");
        }
    }
    
    /**Method to define what back button does
     @param event, action of clicking button*/
    public void backButtonOnAction(ActionEvent event){
        //go to login screen if back button is clicked
        openLoginScene(event);
    }
    
    /**Method to determine if username is already taken
     @param username, user input
     @param users, array list of existing users
     @return true if username taken, false otherwise*/
    public boolean checkIfUsernameExists(String username, ArrayList<User> users){
        //increment through users and test if username and items from users have same name
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(username)){
                //if username is found, return true
                return true;
            }
        }
        //if for loop completes, return false
        return false;
    }

    //get login scene
    private Scene LoginScene;

    public void setLoginScene(Scene scene) {
        LoginScene = scene;

    }

    public void openLoginScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(LoginScene);
    }

    //get main menu scene
    public void openMainMenuScene(ActionEvent actionEvent) throws IOException{
        try{
            Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene newScene = new Scene(secondView);
            Stage currentStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        catch(IOException e){
            System.out.println("Main Menu Scene not found");
        }
    }

}



