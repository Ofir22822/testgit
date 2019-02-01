package example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ocsf.client.AbstractClient;
import Users.*;
import Users.IGeneralData.operations;

public class exampleGUIcontroller implements IGUIcontroller {

		private handlerController client;
	
		@FXML
	    private TextField txtID;

	    @FXML
	    private Button btnShowInfo;

	    @FXML
	    private TextField txtName;

	    @FXML
	    private TextField txtPass;

	    @FXML
	    void getUserInfo(ActionEvent event) {
	    	String inputText = txtID.getText();
	    	client.getUserFromServer(inputText, this);
	    }
	    
	    void displayUserDetails(User user)
	    {
	    	txtName.setText(user.getFirstName());
	    	txtPass.setText(user.getPassword());
	    }

		@Override
		public void receiveMassageFromServer(Object msg, operations op) {
			switch(op)
			{
				case getUser:
				{
					displayUserDetails((User)msg);
					break;
				}
				default:;
			}
		}
		
		@FXML
	    public void initialize() {
			client = new handlerController("localhost", 5555);
			
	    }
}
