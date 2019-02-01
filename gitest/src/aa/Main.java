package aa;
	
import java.util.ArrayList;

import javax.management.OperationsException;

import Users.Book;
import Users.ServerData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import Users.IGeneralData.operations;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*try {
			TabPane root = (TabPane) FXMLLoader.load(getClass().getResource("main.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		
		mainController mainCon = new mainController();
		mainCon.start(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
		/*Object b = new Book();
		Book result = convertMsgFromServer(b, Book.class);
		System.out.println(result);*/
		/*Class<int[]> intArrayType = int[].class;
		Object someObject = new int[]{1,2,3};
		int[] instance = convertMsgFromServer(someObject, intArrayType);*/
		
		/*ServerData obj = new ServerData(operations.CreateNewLoan, new Book(),new Book());
		ArrayList<Book> arr = createArray(obj.getDataMsg(), Book.class);
		System.out.println(arr);*/
	}
	
	//private static Object parseMsgFromServer(Object msg, Class classType)
	public static <T> T convertMsgFromServer(Object msg, Class<T> classType) {
	    if(classType.isInstance(msg))
	    	return classType.cast(msg);
	    return null;
	}
	
	private static <T> ArrayList<T> createArray(ArrayList<Object> arrayMsg, Class<T> classType) {
		ArrayList<T> array = new ArrayList<>();
		T temp;
		for(Object dataMsgi: arrayMsg)
		{
			temp = convertMsgFromServer(dataMsgi, classType);
			if(temp!=null)
				array.add(temp);
			else
				return null;
		}
		return array;
	}
}

/*branch2*/
/*master*/