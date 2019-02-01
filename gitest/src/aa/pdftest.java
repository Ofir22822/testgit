
/*
 * Copyright (c) 1997-2018 IDRsolutions (https://www.idrsolutions.com)
 */

package aa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.accessibility.Accessible;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import org.jpedal.PdfDecoder;
import org.jpedal.examples.viewer.Commands;
import org.jpedal.examples.viewer.Viewer;
import org.jpedal.exception.PdfException;

import javafx.scene.layout.AnchorPane;

public class pdftest {

    /**
     * @param args is of type String[]
     */
    @SuppressWarnings("unused")
    public static void main(final String[] args) {


        
//      Open file by passing in the filename and a byte array
        
    	File pdfFile = new File("D:/testpdf.pdf");
		byte [] mybytearray  = new byte [(int)pdfFile.length()];	//byte array of file
		FileInputStream fis;			//input from file
		BufferedInputStream bis;		//buffer input		  
		  
		try {
			fis = new FileInputStream(pdfFile);
			bis = new BufferedInputStream(fis);
			bis.read(mybytearray,0,mybytearray.length);				//read from file to byte array
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		
		
    	//File pdfoutFile = new File("out.pdf");
		File pdfoutFile;

		FileOutputStream fos;			//input from file
		BufferedOutputStream bos;		//buffer input		  
		  
		try {
			pdfoutFile = new File("src/PDFBook/outTemp2.pdf");//File.createTempFile("outTemp", ".pdf");
			System.out.println(pdfoutFile.getAbsolutePath());
			fos = new FileOutputStream(pdfoutFile);
			bos = new BufferedOutputStream(fos);
			bos.write(mybytearray,0,mybytearray.length);				//read from file to byte array
			bos.flush();
			fos.flush();
			fos.close();
	    	if (Desktop.isDesktopSupported()) {
    	        File myFile = new File("out.pdf");
    	        Desktop.getDesktop().open(pdfoutFile);
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}

        

    }

}