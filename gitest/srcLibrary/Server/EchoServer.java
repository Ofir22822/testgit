package Server;

import java.io.IOException;
import java.util.ArrayList;

import Users.Book;
import Users.ServerData;
import Users.IGeneralData.operationsReturn;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 * @param <Student>
 */

public class EchoServer extends AbstractServer {

	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 */
	public EchoServer(int port) {
		super(port);

	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		ServerController.updateLog("Request from:\n" +client.getInetAddress().getHostName() + "\nCommand: " + ((ServerData)msg).getOperation());
		ServerData dataClient = (ServerData)msg;
		
		switch(((ServerData)msg).getOperation()) {
		case Login:
			break;
		case searchByBookName:
			//Book bookData = (Book)dataClient.getDataMsg().get(0);
			String data = (String)dataClient.getDataMsg().get(0);
			ArrayList<Object> dataFromDB = mysqlConnection.searchBookByName(data);
			ServerData msgToClient = new ServerData(dataFromDB, operationsReturn.returnBookArray);
			try {
				client.sendToClient(msgToClient);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case searchByBookAuthor:
			break;
		case searchByBookSubject:
			break;
		case searchByBookDescription:
			break;
		case updatePersonalDetails:
			break;
		case orderBook:
			ServerData msgToClient2 = new ServerData(operationsReturn.returnSuccessMsg, "AAAAAAAAAAAAAA");
			try {
				client.sendToClient(msgToClient2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case extandLoan:
			break;
		case viewActiveLoans:
			break;
		case viewActivityHistory:
			break;
		case updateReturnDateManualy:
			break;
		case returnBook:
			break;
		case watchReadersCard:
			break;
		case CreateNewSubscriber:
			break;
		case ManageCatalog:
			break;
		case changeSubscriberStatus:
			break;
		case watchEmployeesData:
			break;
		case createReports:
			break;
		default:
			break;
		
		}
	}
	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}

	// Class methods ***************************************************

	/**
	 * This method is responsible for the creation of the server instance (there is
	 * no UI in this phase).
	 *
	 * @param args[0] The port number to listen on. Defaults to 5555 if no argument
	 *        is entered.
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		EchoServer sv = new EchoServer(port);

		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}
}
//End of EchoServer class
