package graphics;

import game.MainGameControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class MainApplication extends Application{

    MainGameControl mainGameControl;


    public static void main(String[] args)  {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        mainGameControl = new MainGameControl();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GameView.fxml"));
        BorderPane root = loader.load();
        GameViewControl gameViewControl = loader.getController();
        gameViewControl.setModel(this);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void playSimulation(int speed){
        mainGameControl.playSimulation(speed);
    }

    public void stopSimulation(){
        mainGameControl.stopSimulation();
    }

    public void changeCellStatus(){

    }
}
