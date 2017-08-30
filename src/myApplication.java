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

        HBox topBox = new HBox(); //UI elements at the top of the screen;
        HBox botBox = new HBox(); // UI elements at the bottom of the scrren;
        VBox leftBox = new VBox(); // Ui elements at the left of the screen;
        VBox rightBox = new VBox(); // UI elements at the left of the scree;

        root.setTop(topBox);
        root.setBottom(botBox);
        root.setLeft(leftBox);
        root.setRight(rightBox);

        Scene scene = new Scene(root, 200,200);

        root.setCenter(grid);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }


}
