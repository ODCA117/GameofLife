package game;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ol6803ax-s on 20/09/17.
 */
public class GameController extends Observable implements Observer{

    Simulation simulation;
    Board board;
    Rules rules;


    public GameController(int side){
        board = new Board(side);
        rules = new Rules();
    }

    public void playSimulation(int delay){

        if(simulation == null) {
            simulation = new Simulation(board, delay);
            simulation.addObserver(this);
            new Thread(simulation).start();
            setChanged();
            notifyObservers();
        }
    }

    public void stopSimulation(){
        if(simulation != null) {
            simulation.stopPlaying();
            simulation = null;
        }
    }

    public void updateCellStatus(int x, int y){
        board.changeCellStatus(x, y);
        setChanged();
        notifyObservers(board);
        clearChanged();
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("GameController Notified about change");
        setChanged();
        notifyObservers(board);
        clearChanged();
    }
}
