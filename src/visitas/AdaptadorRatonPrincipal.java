	package visitas;

	import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


	public class AdaptadorRatonPrincipal {
	 
		static int fila;
		
		static void iniciarFilas(){
			MarineMassPro.marcarFilaPrincipal();
		}
		
		
		static MouseAdapter adaptadorTablaLista = new MouseAdapter() { public void mouseClicked(MouseEvent evt) {
			int row = MarineMassPro.atablaLista.rowAtPoint(evt.getPoint());
			if (row >= 0) {
				MarineMassPro.verAnadir(row);
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