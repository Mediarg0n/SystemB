package com.example.demo;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InvoiceController {

  //private static final String template = "Hello, %s!";
  //private final AtomicLong counter = new AtomicLong();
  private InvoiceCreator creator = new InvoiceCreator();
	
  @PostMapping(path = "/invoice")
  public String customerInformation(@RequestBody Invoice invoice) {
	  
      /* You can write your DAO logic here.
       * For time being I am printing the customer data just to show the POST call is working.
       */
	  creator.createInvoice(invoice);
	  
      return "Rechnung wurde erstellt";
  }
}