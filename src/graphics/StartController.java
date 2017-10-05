package graphics;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class StartController {

    @FXML
    private Label lbl_Heigth_Value;

    @FXML
    private Label lbl_Width_Value;

    @FXML
    private Slider slider_Height;

    @FXML
    private Slider slider_Width;

    @FXML
    private void UpdateSliderLabel(){
        lbl_Heigth_Value.setText(Double.toString(Math.round(slider_Height.getValue())));
        lbl_Width_Value.setText(Double.toString(Math.round(slider_Width.getValue())));

    }

    @FXML
    private void start(){
        new MainApplication((int) slider_Height.getValue(), (int) slider_Width.getValue());
    }



}

