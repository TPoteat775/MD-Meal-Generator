package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class MealGenController implements Initializable {

    @FXML
    private ChoiceBox<String> mealTypeChoiceBox;
    
    @FXML
    private Label invalidSelection;

    @FXML
    private Slider numberSelect;

    @FXML
    private Button goButton, BackToMenuButton;
    
    @FXML
    public void loadChoiceBox(){
        String unformat = "Breakfast Meals\n" +
                            "Dinner Meals\n" +
                            "Favorite Meals\n" +
                            "Exclude Dislikes\n" +
                            "All Meals";
        List mealTypeChoiceList = new LinkedList<String>();
        mealTypeChoiceList = Arrays.asList(unformat.split("\\n"));

        mealTypeChoiceBox.getItems().setAll(FXCollections.observableList(mealTypeChoiceList));
    }
    
    @FXML
    public void goOnAction(ActionEvent event) throws IOException{
        String selection = mealTypeChoiceBox.getSelectionModel().getSelectedItem();
        ArrayList<Meal> toGenerateFrom = null;
        int index = DataHub.getIndexOfCurrentUser();
        User tempUser = DataHub.users.get(index);
        DataHub.createFavorites(tempUser);
        DataHub.createMealsExcludingDislikes(tempUser);
        boolean validChoice = false;
        
        switch(selection){
            case "Breakfast Meals": toGenerateFrom = DataHub.getBreakfasts();
            validChoice = true;
                break;
            case "Dinner Meals": toGenerateFrom = DataHub.getDinners();
                validChoice = true;
                break;
            case "Favorite Meals": 
                ArrayList<Meal> tempFav = DataHub.getFavoriteMeals();
                if(tempFav.size() > 0){
                    toGenerateFrom = tempFav;
                    validChoice = true;
                }
                else{
                    invalidSelection.setText("No Favorites to generate from, Select new option");
                }
                break;
            case "Exclude Dislikes":
                ArrayList<Meal> tempDis = DataHub.getExcludeDislikes();
                 if (tempDis.size() <= 0){
                    invalidSelection.setText("No dislikes to exclude, choose new option");
                }
                else{
                    toGenerateFrom = tempDis;
                    validChoice = true;
                }
                break;
            case "All Meals": toGenerateFrom = DataHub.getMeals();
                validChoice = true;
                break;
            default:
                break;
        }
        
        if(validChoice){
            DataHub.generatedMeals = GenerateMeal.genearateMultipleMeals(toGenerateFrom, 
                    (int)numberSelect.getValue());
            switchToGeneratedMealScene(event);
        }
        else {
        	System.out.println("Error");
        }
    }
    
    @FXML
    public void switchToGeneratedMealScene(ActionEvent event) throws IOException{     
        Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("GeneratedMeal.fxml"));
        Scene newScene = new Scene(secondView);
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(newScene);
    }
    
    @FXML
    public void backToMenuOnAction(ActionEvent event) throws IOException{
        Parent secondView = (Parent) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene newScene = new Scene(secondView);
        Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentStage.setScene(newScene);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadChoiceBox();
    }
}
