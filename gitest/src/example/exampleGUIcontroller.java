package example;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ocsf.client.AbstractClient;

import java.io.IOException;

import Users.*;
import Users.IGeneralData.operations;
import Users.IGeneralData.operationsReturn;
import Users.IGeneralData.subscriberSearchFields;

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
	    void disconnect(ActionEvent event) {
	    	client.quit();
	    }
	    
	    /*
	     * prepare details from GUI to handler
	     * use function from handler to send details for server
	     */
	    @FXML
	    void getSubscriberInfo(ActionEvent event) {
	    	String inputText = txtID.getText();
	    	//client.getSubscriberFromServer(inputText, subscriberSearchFields.IDField, this);
	    }
	    
	    /*
	     * function to display subscriber details in GUI 
	     */
	    void displaySubscriberDetails(Subscriber sub)
	    {
	    	txtName.setText(sub.getFirstName());
	    	txtPass.setText(sub.getPassword());
	    }

	    /*
	     * how object massage from server is handled in GUI
	     */
		@Override
		public void receiveMassageFromServer(Object msg, operationsReturn op) {
			switch(op)
			{
				case returnSubscriber:
				{
					if(msg instanceof Subscriber)
						displaySubscriberDetails((Subscriber)msg);
					else
						txtName.setText(msg.toString());
					break;
				}
				default:;
			}
		}
		
		@FXML
	    public void initialize() {
			try {
				client = new handlerController("localhost", 5555);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }
}
