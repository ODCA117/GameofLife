package game;

public class Simulation{

  private Boolean playing;

  public Simulation(){
    playing = false;
  }

  //plays all steps in the animation
  public void playSimulation(Board board, int delay){
      playing = true;
      while(playing){

          playStep(board);
          try {
              Thread.sleep(delay);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
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
}
