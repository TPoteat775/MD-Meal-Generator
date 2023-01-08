package application;

//import MdMealGeneratorApp.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {


    private Scene MainMenuScene;

    public void setMainMenuScene(Scene scene) {
        MainMenuScene = scene;
    }

    public void openMainMenuScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(MainMenuScene);
    }



    @Override
    public void initialize(URL url, ResourceBundle rb){

    }


    public void createRandomMealButtonOnAction(ActionEvent event) {
        

    }

    public void locationsButtonOnAction(ActionEvent event) throws IOException {
    Parent secondView;
	secondView = (Parent) FXMLLoader.load(getClass().getResource("/application/Locations.fxml"));
		
	Scene newScene = new Scene(secondView);
		
	Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
	currentStage.setScene(newScene);

    }

    public void checkUserFavoritesButtonOnAction(ActionEvent event) throws IOException  {


    }

    public void logoutButtonOnAction(ActionEvent event) throws IOException {
	Parent secondView;
	secondView = (Parent) FXMLLoader.load(getClass().getResource("Login.fxml"));
		
	Scene newScene = new Scene(secondView);
		
	Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
	currentStage.setScene(newScene);

    }
}
