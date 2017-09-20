package graphics;

import game.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Observable;

public class MainApplication extends Application{

    GameController gameController;

    public static void main(String[] args)  {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        gameController = new GameController(10);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GameView.fxml"));
        BorderPane root = loader.load();
        GameViewControl gameViewControl = loader.getController();
        gameViewControl.setModel(this);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void playSimulation(int delay){
        gameController.playSimulation(delay);
    }

    public void stopSimulation(){
        gameController.stopSimulation();
    }

    public void changeCellStatus(){

    }
}
