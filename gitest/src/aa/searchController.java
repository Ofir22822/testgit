package aa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class searchController {

    @FXML
    private Button btn1;

    @FXML
    private Label lbl1;

    @FXML
    void showHello(ActionEvent event) {
    	lbl1.setVisible(true);
    }

}

