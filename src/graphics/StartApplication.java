package graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StartApplication extends Application{

    StartController sc;


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start (Stage stage) throws Exception {
        sc = new StartController();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("StartScene.fxml"));
        HBox root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}
