public class Simulation{

  private boolean on;
  private Board board;

  Simulation(Board board){
    on = false;
    this.board = board;
  }

  //plays all steps in the animation
  public void playSimulation(){
    on = true;
    while(on){
      System.out.println("Running");
      board.calculateNextBoard();
      board.executeNextBoard();
    }
  }

  public void stopSimulation(){
    on = false;
  }
}
