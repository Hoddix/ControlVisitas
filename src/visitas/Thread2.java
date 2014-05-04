package visitas;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Thread2 extends JFrame implements Runnable{
	
	static int fileRow;
	static String [] date;
	static String [] id;
	static String [] firstname;
	static String [] lastname;
	static String [] company;
	static String [] email;
	static String [] mobile;
	static String [] address;
	static String [] visitor;
	static String [] boatsize;
	static String [] brand;
	static String [] model;
	static String [] year;
	static String [] saleassociate;
	static String [] vip;
	static String [] rate;
	static String [] aditionalinformation;
	 
	Thread2(){
		fileRow = MarineMassPro.emodeloTablaBuscar.getRowCount();
		date = new String[fileRow];
		id = new String[fileRow];
		firstname = new String[fileRow];
		lastname = new String[fileRow];
		company = new String[fileRow];
		email = new String[fileRow];
		mobile = new String[fileRow];
		address = new String[fileRow];
		visitor = new String[fileRow];
		boatsize = new String[fileRow];
		brand = new String[fileRow];
		model = new String[fileRow];
		year = new String[fileRow];
		saleassociate = new String[fileRow];
		vip = new String[fileRow];
		rate = new String[fileRow];
		aditionalinformation = new String[fileRow];
	}
	
	void arrayList(){
		 for(int x = 0 ; x < fileRow ;x++){
			 id[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 0).toString();
			 date[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 1).toString();
			 firstname[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 2).toString();
			 lastname[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 3).toString();
			 company[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 4).toString();
			 email[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 5).toString();
			 mobile[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 6).toString();
			 address[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 7).toString();
			 visitor[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 8).toString();
			 boatsize[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 9).toString();
			 brand[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 10).toString();
			 model[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 11).toString();
			 year[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 12).toString();
			 saleassociate[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 13).toString();
			 vip[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 14).toString();
			 rate[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 15).toString();
			 aditionalinformation[x] = MarineMassPro.emodeloTablaBuscar.getValueAt(x, 16).toString();
		 }

	}
	
	public void run(){
		Thread2 obj = new Thread2();
		obj.arrayList();
		new Thread ( new ImprimirListaVisitor(fileRow)).start();
	}

}
