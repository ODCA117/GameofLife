package graphics;

import game.Board;
import game.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Observable;
import java.util.Observer;

public class MainApplication implements Observer{

    private GameController gameController;
    private TileBoard tileBoard;


    public void start(Stage stage, int height, int width) throws Exception {

        gameController = new GameController(height, width);
        gameController.addObserver(this);
        tileBoard = new TileBoard(height, width, this);

        //kanske skicka över till en annan metod
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GameView.fxml"));
        BorderPane root = loader.load();
        GameViewControl gameViewControl = loader.getController();
        gameViewControl.setModel(this);
        root.setCenter(tileBoard.getAsGridPane());

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

    public void changeTile(int x, int y){
        gameController.updateCellStatus(x,y);
    }

    //Send in the new Board
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Board){
            Color[][] cellColors = ((Board) arg).getCellColor();
            tileBoard.updateTilecolors(cellColors);
        }
    }
}
