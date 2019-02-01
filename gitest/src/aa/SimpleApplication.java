package aa;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.qoppa.pdf.source.ByteArrayPDFSource;
import com.qoppa.pdf.source.PDFContent;
import com.qoppa.pdfViewerFX.PDFViewer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleApplication extends Application {
	private PDFViewer mPDFViewer;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception
	{
		/*
		File newFile = new File("testpdf.pdf");

		byte[] mybytearray = new byte[(int) newFile.length()]; // byte array of file
		FileInputStream fis = new FileInputStream(newFile); // input from file
		BufferedInputStream bis = new BufferedInputStream(fis); // buffer input
		 */
		
		File newFile = new File("lab8read.txt");
		byte[] mybytearray = new byte[(int) newFile.length()*2]; // byte array of file
	    FileInputStream fis = null;		//input from file
	    BufferedInputStream bis;	//buffer input		  
	    try {
	    	bis = new BufferedInputStream(fis);
	    	fis = new FileInputStream(newFile);
			bis.read(mybytearray,0,mybytearray.length);		//read from file to byte array
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		//File newFile2 = new File("output.pdf");
	      File outputFile = new File ("lab8write2.txt");
	      
	      FileOutputStream fos;
	      BufferedOutputStream bos;
	      
	      try
			{
			fos = new FileOutputStream(outputFile);
			bos = new BufferedOutputStream(fos);	
			bos.write(mybytearray,0,mybytearray.length);
			bos.flush();
			fos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    
		//mPDFViewer.loadPDF("output.pdf");

		BorderPane borderPane = new BorderPane(mPDFViewer);
		Scene scene = new Scene(borderPane);
		stage.setTitle("JavaFX PDFViewer - Qoppa Software");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
}
