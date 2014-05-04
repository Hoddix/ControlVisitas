package visitas;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//import java.awt.geom.Rectangle2D;
//import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImageOp;
//import java.awt.image.ConvolveOp;
//import java.awt.image.Kernel;
//import java.awt.print.Book;
//import java.awt.print.PageFormat;
//import java.awt.print.Printable;
//import java.awt.print.PrinterJob;
//import java.io.File;
//
//import javax.imageio.ImageIO;
//
//	public class PrintTest {
//
//	  //--- Private instances declarations
//		private final static int POINTS_PER_INCH = 300;
//
//		public PrintTest() {
//
//	    //--- Create a new PrinterJob object
//			PrinterJob printJob = PrinterJob.getPrinterJob();
//
//	    //--- Create a new book to add pages to
//			Book book = new Book();
//
//	    //--- Add the document page using a landscape page format
//			PageFormat documentPageFormat = new PageFormat();
//			documentPageFormat.setOrientation(PageFormat.LANDSCAPE);
//			book.append(new Document(), documentPageFormat);
//
//	    //--- Tell the printJob to use the book as the pageable object
//			printJob.setPageable(book);
//
//	    //--- Show the print dialog box. If the user click the
//	    //--- print button we then proceed to print else we cancel
//	    //--- the process.
//			if (printJob.printDialog()) {
//				try {
//					printJob.print();
//				} catch (Exception PrintException) {
//					PrintException.printStackTrace();
//				}
//			}
//		}
//
//	private class Document implements Printable {
//
//		public int print(Graphics g, PageFormat pageFormat, int page) {
//
//	      //--- Create the Graphics2D object
//			Graphics2D g2d = (Graphics2D) g;
//
//	      //--- Translate the origin to 0,0 for the top left corner
//			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//
//	      //--- Set the drawing color to black
//			g2d.setPaint(Color.black);
//
//	      //--- Draw a border arround the page using a 12 point border
//			g2d.setStroke(new BasicStroke(12));
//			Rectangle2D.Double border = new Rectangle2D.Double(0, 0, pageFormat.getImageableWidth(), pageFormat.getImageableHeight());
//			g2d.draw(border);
//	     
//	      //OP
//			BufferedImage imagen = null;
//			try{
//				imagen= ImageIO.read(new File("foto.jpg"));
//			}catch(Exception e){}
//
//			float[] brightKernel = {1.0f};
//			RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//			BufferedImageOp bright = new ConvolveOp(new Kernel(1, 1, brightKernel),POINTS_PER_INCH, hints);
//	      
//	      //--- Print the text one inch from the top and laft margins
//			g2d.drawImage(imagen, 20, 100, 600, 300, null, null);
//
//	      //--- Validate the page
//			return (PAGE_EXISTS);
//		}
//	}
//} // Example3

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;

import javax.imageio.ImageIO;

public class ImprimirVisitor {

//	  public static void main(String[] args) {
//
//		  PrintTest example3 = new PrintTest("id", "nombre", "apellidos", "compani", "email", "direccion", "telefono", "date", "visitor", "boatsize", "brooker", "observations");
//		    System.exit(0);
//	  }
	
  //--- Private instances declarations
  @SuppressWarnings("unused")
private final static int POINTS_PER_INCH = 300;
  static PageFormat pForm;
  static Paper paper;

  public ImprimirVisitor(String id, String date, String firstname, String lastname, String company, String email, String mobile, String address, String visitor, String boatsize, String brand, String model, String year, String saleassociate, String vip, String rate, String aditionalinformation) {
	  
	 //--- Create a new PrinterJob object
	 PrinterJob printJob = PrinterJob.getPrinterJob();
	
	 //--- Create a new book to add pages to
	 Book document = new Book();
	
	 //--- Add the cover page using the default page format for this print
	 // job
	
	 //--- Tell the printJob to use the book as the pageable object
	
	 printJob.setPageable((Pageable) document);
 
	 pForm = new PageFormat();
	 paper = new Paper();
	 paper.setSize(594.936, 841.536);
	 paper.setImageableArea(43, 43, 509, 756);
	 
	 pForm.setPaper(paper);
	// printJob.setPrintable(document.getPrintable(0), pForm);      
	 
//	 for(int x= 0 ; x<5;x++){
//	     document.append(new IntroPage(id, nombre, apellidos, compani, email, direccion, telefono, modelobarco, c1, t1), pForm);
//	 }
	 document.append(new IntroPage(id, date, firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation), pForm);
	 
	 //--- Show the print dialog box. If the user click the
	 //--- print button we then proceed to print else we cancel
	 //--- the process.
    if (printJob.printDialog()) {
      try {
        printJob.print();
      } catch (Exception PrintException) {
        PrintException.printStackTrace();
      }
    }

  }

  private class IntroPage implements Printable {
	  
		String date;
		String id;
		String firstname;
		String lastname;
		String company;
		String email;
		String mobile;
		String address;
		String visitor;
		String boatsize;
		String brand;
		String model;
		String year;
		String saleassociate;
		String vip;
		String rate;
		String aditionalinformation;
		
		public IntroPage(String id, String date, String firstname, String lastname, String company, String email, String mobile, String address, String visitor, String boatsize, String brand, String model, String year, String saleassociate, String vip, String rate, String aditionalinformation) {
			this.date = date;
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.company = company;
			this.email = email;
			this.mobile = mobile;
			this.address = address;
			this.visitor = visitor;
			this.boatsize = boatsize;
			this.brand = brand;
			this.model = model;
			this.year = year;
			this.saleassociate = saleassociate;
			this.vip = vip;
			this.rate = rate;
			this.aditionalinformation = aditionalinformation;
		}

    @SuppressWarnings("unused")
	public int print(Graphics g, PageFormat pageFormat, int page) {

      //--- Create the Graphics2D object
      Graphics2D g2d = (Graphics2D) g;

//      Graphics2D g2dColoAzul = (Graphics2D) g;

      
      //--- Translate the origin to 0,0 for the top left corner
      g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

      //--- Set the default drawing color to black
      //g2d.setPaint(Color.BLUE);
      g2d.setPaint(Color.black);
      
      //--- Draw a border arround the page
      Rectangle2D.Double border = new Rectangle2D.Double(0, 0, pageFormat.getImageableWidth(), pageFormat.getImageableHeight());
      g2d.draw(border);

      //--- Print the title
      //Imagen 2
      BufferedImage imagen3 = null;
      try{
    	  imagen3 = ImageIO.read(new File("img/confidencial.png"));
    	  g2d.drawImage(imagen3, 0, 60, 500, 707, null, null);
      }catch(Exception e){}
    		
//Imagen 1
		BufferedImage imagen = null;
		try{
			imagen = ImageIO.read(new File("img/astondoalogo.jpg"));
			g2d.drawImage(imagen, 10, 20, 150, 47, null, null);
		}catch(Exception e){}
		
//Imagen 2
		BufferedImage imagen2 = null;
		try{
			imagen2 = ImageIO.read(new File("img/flagshiplogo.jpg"));
			g2d.drawImage(imagen2, 350, 10, 150, 57, null, null);
		}catch(Exception e){}
		
//Cabecera
		String title = "Fort Lauderdale Boat Show 2013";
		String subtitle = "Visitor Report";

//Contenido pagina

      Font titleFont = new Font("Arial", 0, 16);
      g2d.setFont(titleFont);

      //cabecera

      int posicionWidthtitle = (int) (ImprimirVisitor.paper.getImageableWidth()/2)-(title.length()*3);
      int posicionWidthsubtitle = (int) (ImprimirVisitor.paper.getImageableWidth()/2)-(subtitle.length()*3);

      g2d.drawString(title, 140, 90);
      
      Font titleFont2 = new Font("Arial", 0, 11);
      g2d.setFont(titleFont2);
      
      g2d.drawString(subtitle, posicionWidthsubtitle, 110);
      g2d.setPaint(Color.BLUE);
      g2d.drawString("Date: ", 375, 150);
      g2d.drawString("Id: ", 30, 150);
      g2d.drawString("First name: ", 30, 170);
      g2d.drawString("Last name: ", 30, 190);
      g2d.drawString("Company Name: ", 30, 210);
      g2d.drawString("Email: ", 30, 230);
      g2d.drawString("Mobile phone: ", 30, 250);
      g2d.drawString("Address: ", 30, 270);
      g2d.drawString("Type of visitor: ", 30, 290);
      g2d.drawString("Boat size: ", 30, 310);
      g2d.drawString("Brand: ", 30, 330); 
      g2d.drawString("Model: ", 30, 350); 
      g2d.drawString("Year: ", 30, 370); 
      g2d.drawString("Sale Associate: ", 30, 390); 
      g2d.drawString("VIP: ", 30, 410); 
      g2d.drawString("Rate : ", 30, 430); 
      g2d.drawString("Aditional information: ", 30, 450);  
      
      g2d.setPaint(Color.BLACK);
      
      g2d.drawString(date, 410, 150);
      g2d.drawString(id, 130, 150);
      g2d.drawString(firstname, 130, 170);
      g2d.drawString(lastname, 130, 190);
      g2d.drawString(company, 130, 210);
      g2d.drawString(email, 130, 230);
      g2d.drawString(mobile, 130, 250);
      g2d.drawString(address, 130, 270);
      g2d.drawString(visitor, 130, 290);
      g2d.drawString(boatsize, 130, 310);
      g2d.drawString(brand, 130, 330); 
      g2d.drawString(model, 130, 350); 
      g2d.drawString(year, 130, 370); 
      g2d.drawString(saleassociate, 130, 390); 
      g2d.drawString(vip, 130, 410); 
      g2d.drawString(rate, 130, 430);  
      
      int inicio = 0;
      int numlineas = 1;
      int saltolinea = 0;
      for (int i = 0; i < aditionalinformation.length();i++){
    	  
    	  if(saltolinea>60 && (int) aditionalinformation.charAt(i) == 32 || (int) aditionalinformation.charAt(i) == 10){

    		  g2d.drawString(aditionalinformation.substring(inicio,i),30,460 + (15 * numlineas));
    		  inicio=i+1;
    		  numlineas++;
    		  if(saltolinea>60){
    			  saltolinea= -1;
    		  }
    		  if((int) aditionalinformation.charAt(i) == 10){
    			  saltolinea= -1;
    		  }
    	  }	
    	  saltolinea++;
      }
		
      g2d.drawString (aditionalinformation.substring(inicio,aditionalinformation.length()),30,460 + (15 * numlineas));
      
      return (PAGE_EXISTS);
    }
    
  }

} // Example3