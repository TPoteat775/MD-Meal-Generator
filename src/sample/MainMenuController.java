package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController implements Initializable {


    @FXML
    private Label username;



    @Override
    public void initialize(URL url, ResourceBundle rb){
        int index = DataHub.getIndexOfCurrentUser();
        username.setText("User: " + DataHub.users.get(index).getUsername());
    }


    public void createRandomMealButtonOnAction(ActionEvent event) {
        try{
            Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("MealGen.fxml"));
            Scene newScene = new Scene(secondView);
            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
        }
        catch(IOException e){
            System.out.print(e);
        }

    }

    public void locationsButtonOnAction(ActionEvent event) throws IOException {
        Parent secondView;
	secondView = (Parent) FXMLLoader.load(getClass().getResource("Locations.fxml"));
		
	Scene newScene = new Scene(secondView);
		
	Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
	currentStage.setScene(newScene);

    }

    public void checkUserFavoritesButtonOnAction(ActionEvent event) throws IOException{
        Parent secondView;
	secondView = (Parent) FXMLLoader.load(getClass().getResource("Favorites.fxml"));
		
	Scene newScene = new Scene(secondView);
		
	Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
	currentStage.setScene(newScene);
    }

    public void logoutButtonOnAction(ActionEvent event) throws IOException {
        Parent secondView;
	secondView = (Parent) FXMLLoader.load(getClass().getResource("Login.fxml"));
	Scene newScene = new Scene(secondView);
	Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
	currentStage.setScene(newScene);
    }
    

}
