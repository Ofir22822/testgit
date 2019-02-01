package Client;


import java.io.IOException;
import java.util.Date;

import OBLFX.IGUIcontroller;
import Users.Book;
import Users.ServerData;
import Users.Subscriber;
import Users.IGeneralData.operations;

public class SubscriberHandler extends IHandler{
	
	public SubscriberHandler(IGUIcontroller guiController) throws IOException {
		super();
		currentControllerGUIobj = guiController;
	}
	
	public void updateDetails() {}
	
	public void extendLoad() {}
	
	public void orderBook(Subscriber subscriberOrdered, Book orderedBook, String orderDate) {
		ServerData serverData = new ServerData(operations.orderBook, subscriberOrdered, orderedBook, orderDate);
		try {
			sendToServer(serverData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
