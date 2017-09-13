package game;

public class MainGameControl {


    Board board;
    Simulation simulation;


    public MainGameControl(){
        board = new Board(10);
        simulation = new Simulation(board);
    }

    public void playSimulation(int speed){
        //Not implemented yet
        //playSimulation(speed);
        System.out.println("Playing Simulation in speed: " + speed);
    }

    public void stopSimulation(){

        //not implemented yet
        //stopSimulation();
        System.out.println("Stop Simulation");
    }



}
