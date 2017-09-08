import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;




/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * main application that handles graphical thing within the application
 */
public class MyApplication extends Application {

    private Board board;
    private Simulation simulation;

    //setting up scene
    public void start(Stage stage){

        BorderPane root = new BorderPane(); // root

        board = new Board(10);
        GridPane grid = addBoard(board); //Central space the grid
        root.setCenter(grid);


        HBox botBox = setBottomUI();

        root.setBottom(botBox);

        Scene scene = new Scene(root,500,500);

        stage.setScene(scene);
        stage.show();

        simulation = new Simulation(board);
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Add board to gridpane
     * @param board
     * @return
     */
    private GridPane addBoard(Board board){
        GridPane grid = new GridPane();

        for( int i = 0; i < board.side(); i++) {
            for (int j = 0; j < board.side(); j++) {
                grid.add(board.getTile(i, j), i, j); //GridPane have to have nodes that implements node
            }
        }

        grid.setGridLinesVisible(true);

        return grid;
    }

    /**
     * Set up bottom UI Different class with only this UI??
     * @return
     */
    private HBox setBottomUI(){

        HBox bottomUI = new HBox();

        TextField tf = new TextField();
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*")){
                    tf.setText(newValue.replaceAll("\\D+", ""));
                }
            }
        });

        Button startSimulation = new Button("Start Simulation");
        startSimulation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              System.out.println("start Simulation");
              int nbrOfRuns = getValues(tf.getText());
              simulation.playSimulation(nbrOfRuns,500);
            }
        });
        Button stopSimulation = new Button("Stop Simulation");
        stopSimulation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              System.out.println("stopSimulation");
              simulation.stopSimulation();
            }
        });



        bottomUI.setSpacing(10.0);
        bottomUI.getChildren().addAll(startSimulation,stopSimulation, tf);

        return bottomUI;
    }

    private int getValues(String string){
        int i = Integer.parseInt(string);
        return i;
    }
}
