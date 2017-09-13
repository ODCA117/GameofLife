package game;

public class Simulation{

  private Board board;
  private Boolean playing;

  public Simulation(Board board){
    this.board = board;
    playing = false;
  }

  //plays all steps in the animation
  public void playSimulation(int speed){
      playing = true;
      while(playing){
          playStep();

          try {
              Thread.sleep(speed);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }

  public void playStep(){
    System.out.println("Running");
    board.calculateNextBoard();
    board.executeNextBoard();

  }

  public void stopPlaying(){
      playing = false;
  }
}
