package com.example.demo;


import java.io.FileOutputStream;
import java.io.IOException;


public class InvoiceCreator {
	public InvoiceCreator() {
		
	}
	
	public boolean createInvoice(Invoice invoice) {
		
		try{
           
            String fileData = invoice.toString();
            		
            FileOutputStream fos = new FileOutputStream("D:\\Invoice\\" + invoice.getInvoiceNr() + ".txt");
            fos.write(fileData.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
		return true;
	}
}
