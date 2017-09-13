package graphics;

import game.Board;
import game.Simulation;

public class MainGameControl {


    Board board;
    Simulation simulation;

    public MainGameControl(){
        board = new Board(10);
        simulation = new Simulation(board);
    }

    public void playSimulation(){
        System.out.println("Playing Simulation");
    }
}
