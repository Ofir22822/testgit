package example;

import ocsf.client.AbstractClient;
import Users.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import Server.*;
import Users.IGeneralData.operations;

public class handlerController extends AbstractClient {

	private IGUIcontroller currentControllerGUIobj;
	private operations currentOp;
	
	
	public handlerController(String host, int port) {
		super(host, port);
		// TODO Auto-generated constructor stub
	}

	
	public void getUserFromServer(String ID, IGUIcontroller controllerGUI)
	{
		currentControllerGUIobj = controllerGUI;
		currentOp = IGeneralData.operations.getUser;
		ArrayList<Object> arrObj = new ArrayList<>();
		arrObj.add(ID);
		ServerData dataObj = new ServerData(arrObj, operations.getUser);
		try {
			sendToServer(dataObj);
		}
		catch (IOException e) {
		}
		
	}
	
	/**
	 * This method handles all data coming from the UI
	 *
	 * @param message The message from the UI.
	 */
	public void handleMessageFromGUI(Object data)
	{

	}
	
	/*
	 * how client respond to massage from server
	 */
	@Override
	protected void handleMessageFromServer(Object msg) {
		// TODO Auto-generated method stub
		switch(currentOp)
		{
			case getUser:
			{
				currentControllerGUIobj.receiveMassageFromServer(msg, currentOp);
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

