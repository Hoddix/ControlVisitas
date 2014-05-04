	package visitas;
//Import packages
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

//The thread
@SuppressWarnings("serial")
public class Thread1 extends JFrame implements Runnable{
	
	static int fileRow;
	static JPanel pane;
	static JLabel label;
	static JProgressBar barDo;
	static int x;
	
	@SuppressWarnings("static-access")
	Thread1(int fileRow){ //Main void
		this.fileRow = fileRow;
		//Set Look and Feel
		//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceSaharaLookAndFeel");
//		try {UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceSaharaLookAndFeel");}
//		catch (Exception e) {}

		//Create all components
		pane = new JPanel();
		label= new JLabel("");
		barDo = new JProgressBar(0, fileRow); //Min value: 0 Max value: 100	

	}

	void ventana(){
		pane.setLayout(null);
		pane.setVisible(false);
		//Add components to pane
		pane.setBounds(0, 0, 300, 200);add(pane);pane.setVisible(true);pane.setBackground(Color.WHITE);
		label.setBounds(20, 20, 225, 30);pane.add(label);label.setVisible(true);
		barDo.setBounds(10, 100, 280, 20);pane.add(barDo);barDo.setVisible(true);
	}
	
	static void barra(int i){
		x = i;
		label.setText("Procesado hoja " + (i+1) + " de " + fileRow);
		barDo.setValue(i); //Set value
		barDo.setStringPainted(true);
		barDo.setBorderPainted(true);
		barDo.repaint(); //Refresh graphics
	}

	public void run(){
		Thread1 ventana = new Thread1(fileRow);
		ventana.setBounds(10, 10, 300, 200);
		ventana.setResizable(false);
		ventana.setTitle("Print queue");
		ventana.setVisible(true);
		ventana.ventana();
		
		while(1<5){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ImprimirListaVisitor.salir == true){
//				System.out.println("");
				ventana.dispose();
				break;
			}
		}
		
		
	}

}
