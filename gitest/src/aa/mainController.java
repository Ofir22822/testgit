package aa;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class mainController  {


    @FXML
    private Button btnStudent;

    @FXML
    private Button btnSearch;

    @FXML
    private AnchorPane anchor1;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private AnchorPane anchor3;
    @FXML
    private ButtonBar buttons;

	public void start(Stage primaryStage) throws Exception {	
		//SplitPane root = (SplitPane)FXMLLoader.load(getClass().getResource("main.fxml"));
		//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("main2.fxml"));	
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("main3.fxml"));	
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setTitle("Main");
		//primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		
		primaryStage.show();		
	}
    
    @FXML
    void loadSearchScreen(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root = (AnchorPane)loader.load(getClass().getResource("search.fxml").openStream());
		
		anchor1.getChildren().clear();
		anchor1.getChildren().add((AnchorPane)FXMLLoader.load(getClass().getResource("search.fxml")));
    }

    @FXML
    void loadStudentScreen(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root = (AnchorPane)loader.load(getClass().getResource("student.fxml").openStream());
		
		anchor1.getChildren().clear();
		anchor1.getChildren().add((AnchorPane)FXMLLoader.load(getClass().getResource("student.fxml")));
    }
    
    
    @FXML
    public void initialize()
    {
    }

}
