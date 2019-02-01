package example;

import ocsf.client.AbstractClient;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Server.*;
import Users2.IGeneralData.operations;
import Users2.IGeneralData.operationsReturn;
import Users2.IGeneralData.subscriberSearchFields;
import Users2.*;

public class handlerController extends AbstractClient {

	/*
	 * Variables
	 * IGUIcontroller - controller input was sent from
	 * currentOp - which operation to perform
	 */
	private IGUIcontroller currentControllerGUIobj;
	private operations currentOp;
	
	public handlerController(String host, int port) throws IOException {
		super(host, port);
		openConnection();
	}

	/*
	 * function to prepare ServerData object, with command to get subscriber
	 * and sending ServerData to server
	 */
	public void getSubscriberFromServer(String fieldInput,subscriberSearchFields fieldType, IGUIcontroller controllerGUI)
	{
		currentControllerGUIobj = controllerGUI;
		//ArrayList<Object> arrObj = new ArrayList<>();
		ServerData dataObj = null;
		
		switch(fieldType)
		{
			case IDField:
			{
				//currentOp = operations.getSubscriberByID;
				Subscriber subData = new Subscriber("", "", "", fieldInput, "", "", "", "");
				//arrObj.add(subData);
				//dataObj = new ServerData(operations.getSubscriberByID, subData);
			}
		}
		
		try {
			if(dataObj!=null)
				sendToServer(dataObj);
			else
				throw new Exception("dataObj is null");
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("error");
			quit();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
			quit();		//disconnect and close client
		}
	}
	
	/*
	 * how this controller respond to massage from server
	 * will send massage from server to controller that called
	 */
	@Override
	protected void handleMessageFromServer(Object msg) {

		ServerData serverMsg = (ServerData)msg;
		
		switch(serverMsg.getOperationReturn())
		{
			case returnSubscriber:
			{
				/*if(serverMsg.getDataMsg().get(0) instanceof Subscriber)
					currentControllerGUIobj.receiveMassageFromServer(serverMsg.getDataMsg().get(0), operationsReturn.returnSubscriber);
				else
					System.out.println("error msg object not subsriber object");*/
				break;
			}
			default:;
		}
	}
	
	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}

}

