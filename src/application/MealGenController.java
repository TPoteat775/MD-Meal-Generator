package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MealGenController {

    @FXML
    private ChoiceBox mealTypeChoiceBox;

    private Scene mealGenScene;

    public void setMealGenScene(Scene scene) {
        mealGenScene = scene;
    }
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


}
