package com.example.demo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;
public class Invoice
{
    private String invoiceNr;
    private String invoiceDate;
    private boolean vat;
    private String name;
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private String telephone;
    private String eMail;
    
    public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	private List<InvoicePositions> invoicePositions;

    public void setInvoiceNr(String invoiceNr){
        this.invoiceNr = invoiceNr;
    }
    public String getInvoiceNr(){
        return this.invoiceNr;
    }
    public void setInvoiceDate(String invoiceDate){
        this.invoiceDate = invoiceDate;
    }
    public String getInvoiceDate(){
        return this.invoiceDate;
    }
    public void setVat(boolean vat){
        this.vat = vat;
    }
    public boolean getVat(){
        return this.vat;
    }
    public void setInvoicePositions(List<InvoicePositions> invoicePositions){
        this.invoicePositions = invoicePositions;
    }
    public List<InvoicePositions> getInvoicePositions(){
        return this.invoicePositions;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
    public String getZipCode(){
        return this.zipCode;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public String getTelephone(){
        return this.telephone;
    }
    
    @Override
    public String toString() {
    	
    	String kopf = 	
    			"Rechnung \n" +
    			invoiceNr +"\n"+
    			invoiceDate +"\n";
    	
    	String empfaenger = 		
    			"Empfänger: "+ name+ "\n"+
    			"           "+ address+	"\n"+
    			"           "+ zipCode+ city +"\n"+
    			"           "+ country+  "\n"+
    			"           "+ telephone+ "\n"+
    			"           "+ eMail+"\n";
    	
    	String positionen = "";
    	double netto = 0;
    	for(InvoicePositions pos :invoicePositions) {
    		positionen += (pos.toString() + "\n");
    		netto += pos.getNetto();
    	}
    	positionen += "\n Gesamtpreis (netto): "+ netto + "€"; 
    	
    	String mwstString;
    	double mwst = 0; 
    	if(vat)
    		mwstString = "Keine Mehrwersteuer aufgrund gültiger VAT";
    	else {
    		mwst = 0.19;
			mwstString = "Berechnete Mehrwertsteuer von "+ mwst+ "%: " + (netto * mwst); 
		}
    	
    	String gesamtBrutto = "Gesamtpreis (Brutto): " + netto *  (mwst + 1)+"€";
    	
    	
    	return 	kopf+ 
    			"\n" +
    			"======================================\n" +
    			"\n" +
    			empfaenger +
    			"\n" +
    			"======================================\n" +
    			"\n" +
    			positionen+
    			"\n" +
    			"======================================\n" +
    			"\n" +
    			mwstString+
    			"\n" +
    			"======================================\n" +
    			"\n" +
    			gesamtBrutto;
    }
    
    
}