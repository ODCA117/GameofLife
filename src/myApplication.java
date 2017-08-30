import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * Created by ol6803ax-s on 30/08/17.
 *
 * main application that handles graphical thing within the application
 */
public class myApplication extends Application {

    //setting up scene
    public void start(Stage stage){

        BorderPane root = new BorderPane();



        GridPane grid = new GridPane(); //grid filled with tiles;


        HBox botBox = new HBox(); // UI elements at the bottom of the scrren;

        root.setBottom(botBox);

        Scene scene = new Scene(root, 200,200);

        root.setCenter(grid);
        stage.setScene(scene);
        stage.show();


    }






}
