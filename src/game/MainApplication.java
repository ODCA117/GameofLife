package game;

import graphics.GameViewControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApplication extends Application{

    Simulation simulation;
    Board board;


    public static void main(String[] args)  {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        simulation = new Simulation();
        int side = 10;
        board = new Board(side);

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
        simulation.playSimulation(board, delay);
    }

    public void stopSimulation(){
        simulation.stopPlaying();
    }

    public void changeCellStatus(){

    }
}
