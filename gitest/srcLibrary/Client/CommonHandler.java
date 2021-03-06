package Client;

import Users.ServerData;
import java.io.IOException;
import java.util.ArrayList;

import OBLFX.IGUIcontroller;
import Users.IGeneralData;
import Users.IGeneralData.operations;

public class CommonHandler extends IHandler{
	
	public CommonHandler(IGUIcontroller guiController) throws IOException {
		super();
		//currentControllerGUIobj defined in IHandler interface, will save the GUI controller input was sent from
		currentControllerGUIobj = guiController;	 
	}

	/**
	 * method to send search book request to server
	 * @param searchInput the input text in search
	 * @param searchType what kind of search the server will do
	 */
	public void searchInServer(String searchInput, operations searchType) {
		ServerData serverData = new ServerData(searchType, searchInput);
		try {
			sendToServer(serverData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loginUser(String ID, String Password)
	{
		ArrayList<Object> List = new ArrayList<Object>();
    	List.add(ID);
    	List.add(Password);
		ServerData loginInfo = new ServerData(IGeneralData.operations.Login,List);
		try
		{
			//sending serverData to server, checking it's not null
			if(loginInfo!=null)
				sendToServer(loginInfo);
			else
				throw new Exception("loginInfo is null");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
