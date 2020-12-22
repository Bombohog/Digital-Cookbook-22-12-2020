package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainGUI.fxml"));
        primaryStage.setTitle("Cookbook");
        primaryStage.setScene(new Scene(root, 1000, 650));
        primaryStage.setResizable(false);
        primaryStage.show();
        Controller.loadArchive();
    }

    @Override
    public void stop() {
        Controller.saveArchive();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
