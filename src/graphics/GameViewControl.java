package graphics;

import game.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class GameViewControl implements Initializable {

    private MainApplication model;

    @FXML
    private Slider slider_speed;

    public void setModel(MainApplication model) {
        this.model = model;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void start(){
        model.playSimulation((int) slider_speed.getValue());
    }

    @FXML
    private void nextGeneration(){

    }
    @FXML
    private void stop(){
        model.stopSimulation();
    }


}
