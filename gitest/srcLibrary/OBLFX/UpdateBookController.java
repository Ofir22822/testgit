package OBLFX;

import java.io.IOException;
import java.text.SimpleDateFormat;

import Client.CommonHandler;
import Users.Book;
import Users.IGeneralData;
import Users.IGeneralData.operationsReturn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateBookController implements IGUIcontroller {
	
	private CommonHandler commonClient;
	
	@FXML
	public void initialize() {
		try {
			commonClient = new CommonHandler(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    @FXML
    private TextField BookNameTextField;

    @FXML
    private TextField AuthorTextField;

    @FXML
    private TextField SubjectTextField;

    @FXML
    private TextField PlaceOnShelfTextField;

    @FXML
    private TextField EditionNumberTextField;

    @FXML
    private TextField PurchaseDateTextField;

    @FXML
    private TextArea DescriptionTextField;

    @FXML
    private TextField txtCatalogNumber;

    @FXML
    private Button btnGetDetails;
    
    
    //search by catalog number in server
    @FXML
    void getBookDetails(ActionEvent event) {
		commonClient.searchInServer(txtCatalogNumber.getText(), IGeneralData.operations.searchByCatalogNumber);
    }
    
    //set text fields with info
	private void setBookToDisplay(Book bookToDisplay) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		BookNameTextField.setText(bookToDisplay.getBookName());
		AuthorTextField.setText(bookToDisplay.getAuthorName().toString());
	    SubjectTextField.setText(bookToDisplay.getSubject());
	    PlaceOnShelfTextField.setText(bookToDisplay.getShelfLoaction());
	    PurchaseDateTextField.setText(dateFormat.format(bookToDisplay.getPurchesDate()));
	    EditionNumberTextField.setText(bookToDisplay.getEditionNumber());
	    DescriptionTextField.setText(bookToDisplay.getDescription());
	}

	@Override
	public <T> void receiveMassageFromServer(T msg, operationsReturn op) {
		switch(op)
		{
			//returned one book
			case returnBook:
				setBookToDisplay((Book)msg);
				break;
		}
		
	}

}