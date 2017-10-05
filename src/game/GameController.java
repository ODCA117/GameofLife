package game;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ol6803ax-s on 20/09/17.
 */
public class GameController extends Observable implements Observer{

    private Simulation simulation;
    private Board board;


    public GameController(int height, int width){
        board = new Board(height, width, new Rules());
        simulation = new Simulation(board);
        simulation.addObserver(this);
    }

    public void playSimulation(int delay){

        if(!simulation.isPlaying()) {
            simulation.setSpeed(delay);
            Thread simThread = new Thread(simulation);
            simThread.setDaemon(true);
            simThread.start();
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
