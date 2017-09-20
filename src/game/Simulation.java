package game;

import java.util.Observable;

public class Simulation extends Observable implements Runnable{

  private Boolean playing;
  private Board board;
  private int delay;

  public Simulation(Board board, int delay){
    playing = false;
    this.board = board;
    this.delay = delay;
  }

  //plays all steps in the animation
  private void playSimulation(){
      playing = true;
      while(playing){

          playStep(board);
          try {
              Thread.sleep(delay);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          setChanged();
          notifyObservers();
          clearChanged();
      }
  }

  private void playStep(Board board){
    System.out.println("Running");
    board.calculateNextBoard();
    board.executeNextBoard();

  }

  public void stopPlaying(){
      playing = false;
  }

  @Override

  public void run() {
      playSimulation();
  }
}
