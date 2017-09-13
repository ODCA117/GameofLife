package graphics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;

public class MainApplication extends Application{

    public static void main(String[] args)  {
        launch(args);

    }


    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = FXMLLoader.load(getClass().getResource("/GameView.fxml"));
        System.out.println(root);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
