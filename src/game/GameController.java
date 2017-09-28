package game;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ol6803ax-s on 20/09/17.
 */
public class GameController extends Observable implements Observer{

    Simulation simulation;
    Board board;
    Rules rules; //Eventuellt överflödig


    public GameController(int side){
        rules = new Rules();
        board = new Board(side, rules);
        simulation = new Simulation(board);
        simulation.addObserver(this);
    }

    public void playSimulation(int delay){

        if(!simulation.isPlaying()) {
            simulation.setSpeed(delay);
            new Thread(simulation).start();
            setChanged();
            notifyObservers();
        }

    }

    public void stopSimulation(){
        if(simulation.isPlaying()) {
            simulation.stopPlaying();
        }
    }

    public void updateCellStatus(int x, int y){
        board.changeCellStatus(x, y);
        setChanged();
        notifyObservers(board);
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(board);
    }
}
