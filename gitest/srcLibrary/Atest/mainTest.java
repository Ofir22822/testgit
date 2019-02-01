package Atest;
	
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javax.management.OperationsException;

import OBLFX.SearchPagesController;
import OBLFX.UserDetailsController;
import Users.Book;
import Users.ServerData;
import Users.Subscriber;
import Users.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TabPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import Users.IGeneralData.operations;
import Users.*;

public class mainTest extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			/*
			Subscriber currentUser = new Subscriber("first", "lastName", "email", "123", "123", "status", "phoneNumber", "1234");
			
			ArrayList<Loan> listLoan = new ArrayList<>();
			listLoan.add(new Loan(new Date("10/10/2018"), new Date("10/11/2018"), "loanID", "subscriberID", "bookCatalogNumber", "copyID", "loanStatus"));
			listLoan.add(new Loan(new Date("10/10/2018"), new Date("10/11/2018"), "loanID", "subscriberID", "bookCatalogNumber", "copyID", "loanStatus"));
			listLoan.add(new Loan(new Date("10/10/2018"), new Date("10/11/2018"), "loanID", "subscriberID", "bookCatalogNumber", "copyID", "loanStatus"));
			listLoan.add(new Loan(new Date("10/10/2018"), new Date("10/11/2018"), "loanID", "subscriberID", "bookCatalogNumber", "copyID", "loanStatus"));
			listLoan.add(new Loan(new Date("10/10/2018"), new Date("10/11/2018"), "loanID", "subscriberID", "bookCatalogNumber", "copyID", "loanStatus"));
			listLoan.add(new Loan(new Date("10/10/2018"), new Date("10/11/2018"), "loanID", "subscriberID", "bookCatalogNumber", "copyID", "loanStatus"));
			listLoan.add(new Loan(new Date("10/10/2018"), new Date("10/11/2018"), "loanID", "subscriberID", "bookCatalogNumber", "copyID", "loanStatus"));
			listLoan.add(new Loan(new Date("10/10/2018"), new Date("10/11/2018"), "loanID", "subscriberID", "bookCatalogNumber", "copyID", "loanStatus"));
			currentUser.setActiveLoans(listLoan);
			
			ArrayList<Order> listOrder = new ArrayList<>();
			listOrder.add(new Order(new Date("12/12/2018"), new Date("1/12/2018"), "subscriberID", "bookCatalogNumber"));
			//currentUser.setActiveOrders(listOrder);
			*/
			User currentUser = new Librarian("firstName", "lastName", "email", "iD", "password", "affiliation");
			
			FXMLLoader fxmlLoader = new FXMLLoader();
			AnchorPane root = (AnchorPane) fxmlLoader.load(getClass().getResource("../FXML/UserDetails.fxml").openStream());
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			UserDetailsController searchPagesController = (UserDetailsController) fxmlLoader.getController();
				
			if(currentUser instanceof Librarian)
			{
				searchPagesController.setLabelsLibrarian();
				searchPagesController.setUserToDisplay(currentUser);
			}
			if(currentUser instanceof Subscriber)
			{
				searchPagesController.setLabelsSubscriber();
				searchPagesController.setUserToDisplay(currentUser);
			}
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent t) {
					t.consume();
					Platform.exit();
					System.exit(0);
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("a");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
