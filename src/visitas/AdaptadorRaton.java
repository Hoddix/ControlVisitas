package visitas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AdaptadorRaton {
 
	static int fila;
	
	static void iniciarFilas(){
		MarineMassPro.marcarFila();
	}
	
	
	static MouseAdapter adaptador = new MouseAdapter() { public void mouseClicked(MouseEvent evt) {
		int row = MarineMassPro.etablaLista.rowAtPoint(evt.getPoint());
		if (row >= 0) {
			MarineMassPro.ver(row);
			obtenerFila(row);
		}	
	}};
	
	static MouseAdapter adaptador2 = new MouseAdapter() { public void mouseClicked(MouseEvent evt) {
		int row = MarineMassPro.etablaBuscar.rowAtPoint(evt.getPoint());
		if (row >= 0) {
			MarineMassPro.verBusqueda(row);
			obtenerFila(row);
		}	
	}};
	
	static void obtenerFila(int row){
		fila = row;
	}
	
	static int mandarFila(){
		return fila;
	}
	

}
