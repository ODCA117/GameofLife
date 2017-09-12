public class Simulation{

  private Board board;

  Simulation(Board board){
    this.board = board;
  }

  //plays all steps in the animation
  //Some more comments about playsimulation
  public void playSimulation(int runs, int speed){

    for (int i = 0; i < runs; i++) {
        playStep();

        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  }

  //Some more comments on playstep
  public void playStep(){
    System.out.println("Running");
    board.calculateNextBoard();
    board.executeNextBoard();

  }
}
