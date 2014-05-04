package visitas;

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
import javax.swing.JFrame;

	@SuppressWarnings("serial")
	public class ImprimirListaVisitor extends JFrame implements Runnable {

		//--- Private instances declarations
		static PageFormat pForm;
		static Paper paper;
		
		static boolean salir;
		static int fileRow;

		public ImprimirListaVisitor(int fileRow) {

			 //--- Create a new PrinterJob object
			 PrinterJob printJob = PrinterJob.getPrinterJob();

			 //--- Create a new book to add pages to
			 Book document = new Book();

			 //--- Tell the printJob to use the book as the pageable object
			
			 printJob.setPageable((Pageable) document);

			 pForm = new PageFormat();
			 paper = new Paper();
			 paper.setSize(594.936, 841.536);
			 paper.setImageableArea(43, 43, 509, 756);

			 pForm.setPaper(paper);   

			 for(int x= 0; x < fileRow ;x++){
			     document.append(new IntroPage(x), pForm);
			 }
			 
			 //--- Show the print dialog box. If the user click the
			 //--- print button we then proceed to print else we cancel
			 //--- the process.

		    if(printJob.printDialog()) {
		      try {
		    	  salir = false;
		    	  new Thread(new Thread1(fileRow)).start();
		    	  printJob.print();  
		    	  salir = true;
		      }catch (Exception PrintException) {
		    	  PrintException.printStackTrace();
		      }
		    }

		}
		
		private static class IntroPage implements Printable {
			int x;	
			public IntroPage(int x) {
				this.x = x;
			}

	    @SuppressWarnings("unused")
		public int print(Graphics g, PageFormat pageFormat, int page) {
	    	Thread1.barra(x);
	        //--- Create the Graphics2D object
	        Graphics2D g2d = (Graphics2D) g;

	        //--- Translate the origin to 0,0 for the top left corner
	        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

	        //--- Set the default drawing color to black
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

	        Font titleFont = new Font("Arial", 0, 16);
	        g2d.setFont(titleFont);
	      
	        int posicionWidthtitle = (int) (ImprimirListaVisitor.paper.getImageableWidth()/2)-(title.length()*3);
	        int posicionWidthsubtitle = (int) (ImprimirListaVisitor.paper.getImageableWidth()/2)-(subtitle.length()*3);
		  
	        g2d.drawString(title, 140, 90);
	        
	        Font titleFont2 = new Font("Arial", 0, 11);
	        g2d.setFont(titleFont2);
	        
	        g2d.drawString(subtitle, posicionWidthsubtitle, 110);
	        
	        g2d.setPaint(Color.blue);
	        
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
	        
	        g2d.setPaint(Color.black);
	        
	        g2d.drawString(Thread2.date[x], 410, 150);
	        g2d.drawString(Thread2.id[x], 130, 150);
	        g2d.drawString(Thread2.firstname[x], 130, 170);
	        g2d.drawString(Thread2.lastname[x], 130, 190);
	        g2d.drawString(Thread2.company[x], 130, 210);
	        g2d.drawString(Thread2.email[x], 130, 230);
	        g2d.drawString(Thread2.mobile[x], 130, 250);
	        g2d.drawString(Thread2.address[x], 130, 270);
	        g2d.drawString(Thread2.visitor[x], 130, 290);
	        g2d.drawString(Thread2.boatsize[x], 130, 310);
	        g2d.drawString(Thread2.brand[x], 130, 330); 
	        g2d.drawString(Thread2.model[x], 130, 350); 
	        g2d.drawString(Thread2.year[x], 130, 370); 
	        g2d.drawString(Thread2.saleassociate[x], 130, 390); 
	        g2d.drawString(Thread2.vip[x], 130, 410); 
	        g2d.drawString(Thread2.rate[x], 130, 430);  

	        int inicio = 0;
	        int numlineas = 1;
	        int saltolinea = 0;	

	        for (int i = 0; i < Thread2.aditionalinformation[x].length();i++){
	        	if(saltolinea>60 && (int) Thread2.aditionalinformation[x].charAt(i) == 32 || (int) Thread2.aditionalinformation[x].charAt(i) == 10){
	        		g2d.drawString(Thread2.aditionalinformation[x].substring(inicio,i),30,460 + (15 * numlineas));
	        		inicio=i+1;
	        		numlineas++;
	        		
	        		if(saltolinea>60){
	        			saltolinea= -1;
	        		}
	        		if((int) Thread2.aditionalinformation[x].charAt(i) == 10){
	        			saltolinea= -1;
	        		}
	        	}	
	        	saltolinea++;
	        }
	        g2d.drawString (Thread2.aditionalinformation[x].substring(inicio, Thread2.aditionalinformation[x].length()),30,460 + (15 * numlineas));
			return (PAGE_EXISTS);	
	    }	    
	 }

	@Override
	public void run() {

	}
	
} // Example3