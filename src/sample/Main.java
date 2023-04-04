package sample;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//welcome to MAIN
//things to do:
//The Login Logic
//The Registration page and push logic
// add choice box to registration page with locations !!
//The main menu and accessing every part of it
//Allow users to set and access locations
//Allow closing program with logout button
//setting up meal descriptions and pictures
//letting people favorite and dislike meals
//allow users to check previous favorites and dislikes
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {


        // getting loader and a pane for the first scene.
        // loader will then give a possibility to get related controller
        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent loginPane = firstPaneLoader.load();
        Scene loginScene = new Scene(loginPane, 520, 400);




        primaryStage.setTitle("McDonald's Meal Generator");
        primaryStage.setScene(loginScene);
        primaryStage.show();


        //Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));


        //primaryStage.setTitle("McDonald's Meal Generator");
        //primaryStage.setScene(new Scene(root, 520, 400));
        //primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        DataHub.createUsers();
        DataHub.createMeals();
        DataHub.createDinnersAndBreakfasts();
        DataHub.createLocations();

        launch(args);

        ArrayList<User> users = DataHub.getUsers();
        DataHub.exportUsers(users);


    }
}