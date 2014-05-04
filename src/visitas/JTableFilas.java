package visitas;
import java.awt.Rectangle;

import javax.swing.table.DefaultTableModel;

public class JTableFilas {
	//"Id", "Date", "First name", "Last name", "Company Name", "Email", "Mobile Phone", "Full Address", "Type of visitor", "Boat size", "Brand", "Model", "Year", "Sale Associate", "VIP", "Rate", "Aditional information"
	//String id, String date, String firstname, String lastname, String company, String email, String mobile, String address, String visitor, String boatsize, String brand, String model, String year, String saleassociate, String vip, String rate, String aditionalinformation
	// id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation
	static void colTablaAnadirVisitante(String id, String date, String firstname, String lastname, String company, String email, String mobile, String address, String visitor, String boatsize, String brand, String model, String year, String saleassociate, String vip, String rate, String aditionalinformation){
        Object nuevaFila[]= {id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation};
        MarineMassPro.amodeloTablaLista.addRow(nuevaFila);

        int row =  MarineMassPro.atablaLista.getRowCount () - 1;
        Rectangle rect = MarineMassPro.atablaLista.getCellRect(row, 0, true);
        MarineMassPro.atablaLista.scrollRectToVisible(rect);
        MarineMassPro.atablaLista.clearSelection();
        MarineMassPro.atablaLista.setRowSelectionInterval(row, row);
        MarineMassPro.amodeloTablaLista = (DefaultTableModel)MarineMassPro.atablaLista.getModel();
        MarineMassPro.amodeloTablaLista.fireTableDataChanged();
    }

    static void colTablaEditarVisitante(int fila, String id, String date, String firstname, String lastname, String company, String email, String mobile, String address, String visitor, String boatsize, String brand, String model, String year, String saleassociate, String vip, String rate, String aditionalinformation){
    Object nuevaFila[]= {id,  date,  firstname,  lastname,  company,  email,  mobile,  address,  visitor,  boatsize,  brand,  model,  year,  saleassociate,  vip,  rate,  aditionalinformation};
    
	    for(int x = 0; x < MarineMassPro.emodeloTablaLista.getRowCount(); x++){
	    	if(id.equalsIgnoreCase(MarineMassPro.emodeloTablaLista.getValueAt(x, 0).toString())){
	    	    MarineMassPro.emodeloTablaLista.removeRow(x);
	    	    MarineMassPro.emodeloTablaLista.insertRow(x, nuevaFila);
	    	}
	    }
    }
    static void colTablaEliminarVisitante(int fila, String id){
	    for(int x = 0; x < MarineMassPro.emodeloTablaLista.getRowCount(); x++){
	    	if(id.equalsIgnoreCase(MarineMassPro.emodeloTablaLista.getValueAt(x, 0).toString())){
	    	    MarineMassPro.emodeloTablaLista.removeRow(x);
	    	}
	    }
    }
}
