import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BookSquareController {

    @FXML
    private Button searchButton;
    
    @FXML
    private ToggleGroup priceGroup;

    @FXML
    private ToggleGroup conditionGroup;

    @FXML
    private ToggleGroup timeGroup;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void searchButtonClicked(ActionEvent event) {
    	System.out.println("boo");
    }

}
