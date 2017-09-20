package game;

import com.sun.javafx.css.Rule;
import graphics.GameViewControl;
import graphics.MainApplication;

import java.util.Observable;

/**
 * Created by ol6803ax-s on 20/09/17.
 */
public class GameController extends Observable {

    Simulation simulation;
    Board board;
    Rules rules;


    public GameController(int side){
        simulation = new Simulation();
        board = new Board(side);
        rules = new Rules();
    }

    public void playSimulation(int delay){
        simulation.playSimulation(board, delay);
    }

    public void stopSimulation(){
        simulation.stopPlaying();
    }

}
