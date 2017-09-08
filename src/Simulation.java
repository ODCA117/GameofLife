public class Simulation{

  private boolean on;
  private Board board;

  Simulation(Board board){
    on = false;
    this.board = board;
  }

  //plays all steps in the animation
  public void playSimulation(int runs, int speed){
    on = true;

    for (int i = 0; i < runs; i++) {
      System.out.println("Running");
      board.calculateNextBoard();
      board.executeNextBoard();
      try {
        Thread.sleep(speed);

      }
      catch (InterruptedException e){
        Thread.currentThread().interrupt();
      }
    }
  }

  public void stopSimulation(){
    on = false;
  }
}
