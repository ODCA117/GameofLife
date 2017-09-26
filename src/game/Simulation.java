package game;

import java.util.Observable;

public class Simulation extends Observable implements Runnable{

  private Boolean playing;
  private Board board;
  private int speed;

  public Simulation(Board board){
    playing = false;
    this.board = board;
    speed = 100;
  }

  //plays all steps in the animation
  private void playSimulation(){
      playing = true;
      while(playing){
          playStep(board);
          try {
              Thread.sleep(speed);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          setChanged();
          notifyObservers();
      }
  }

  private void playStep(Board board){
    board.calculateNextBoard();
    board.executeNextBoard();
  }

  public void stopPlaying(){
      playing = false;
  }

  public boolean isPlaying(){
      return playing;
  }

  public void setSpeed(int speed){
      this.speed = speed;
  }

  @Override
  public void run() {
      playSimulation();
  }
}
