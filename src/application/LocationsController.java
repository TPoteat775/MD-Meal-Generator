package application;

//Course Code: CIS214-401 Computer Science III
//Submission Type: Implementation
//Due Date: November 24th, 2020
//Authors: Brandon, Mike, Enrich, Tiana
//Purpose: define all necessary data at runtime 

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LocationsController implements Initializable  {

	//Initialize necessary fields
	ArrayList<Location> locations = new ArrayList<>();
	MdMealGenerator mealLoc = new MdMealGenerator();
	LocateClosest closest = new LocateClosest();

	@FXML
	private Button backBtn;
	
	@FXML
	private AnchorPane rootScene, choiceScene;
	
	@FXML
	private Text text;
	
	@FXML
	private HBox navBar, hbox2;
	
	@FXML
	private ChoiceBox locationsChoiceBox = new ChoiceBox();
	
	@FXML
	private ListView locationsView;

	/**Method initializes controller: shifts navBar and loads choicebox*/ 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		navBar.setAlignment(Pos.CENTER);
		navBar.setHgrow(backBtn, Priority.ALWAYS);
		loadChoiceBox();
		
	}
	
	/**Method that defines what back button does when clicked */
	public void backBtnOnAction(ActionEvent event) throws IOException {
		Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		Parent secondView;
		secondView = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		
		Scene newScene = new Scene(secondView);
        primaryStage.setScene(newScene);
        
        locationsView.getItems().clear();
        locations.clear();
	}
	
	/**Method that loads in the cities for the choice box */
	public void loadChoiceBox() {
		String unformat ="Bear\n" +
                "Claymont\n" +
                "Glasgow\n" +
                "Harrington\n" +
                "Milford\n" +
                "Camden\n" +
                "Georgetown\n" +
                "Rehoboth Beach\n" +
                "Seaford\n" +
                "Smyrna\n" +
                "Delmar\n" +
                "Bethany\n" +
                "Stanton\n" +
                "Bridgeville\n" +
                "Dover\n" +
                "Millsboro\n" +
                "Selbyville\n" +
                "Wilmington\n" +
                "New Castle\n" +
                "Newark";
		
        List citiesList = new LinkedList<String>();
        citiesList = Arrays.asList(unformat.split("\\n"));

        locationsChoiceBox.getItems().setAll(FXCollections.observableList(citiesList));
	}

	/**Method that lists the results from the user's choice box selection */
	public void listResult() throws IOException {
		try {
			locations = mealLoc.createLocations();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		locationsView.setItems(FXCollections.observableArrayList(closest.getClosest(locations, locationsChoiceBox.getSelectionModel().getSelectedItem().toString())));
		
		if(closest.getClosest(locations, locationsChoiceBox.getSelectionModel().getSelectedItem().toString()).isEmpty()) {
			locationsView.setItems(FXCollections.observableArrayList("No Locations Found"));
		}
		locations.clear();
	}
	
}
