package visitas;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class DataBase {
	

	@SuppressWarnings({ "unused", "rawtypes" })
	public static boolean idRepeat(String id) throws Exception{
		boolean repetido = false;
		InputStream ExcelFileToRead = new FileInputStream("database/Data_base.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook(); 
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
 
		Iterator rows = sheet.rowIterator();

		while (rows.hasNext()){

			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext()){
				
				cell=(XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
					String dato = cell.getStringCellValue();
					if(id.equalsIgnoreCase(dato)){
						repetido = true;
					}
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
					int dato = (int)cell.getNumericCellValue();
				}		
			}
		}
		return repetido;
	}
	
	
	@SuppressWarnings({ "unused", "rawtypes" })
	public static void burcarCliente(String nombre, String vendedor, String rate) throws Exception{
		int contador=MarineMassPro.emodeloTablaBuscar.getRowCount();

		if(contador!=0){
			for(int x=0;x<contador;x++){
				MarineMassPro.emodeloTablaBuscar.removeRow(0);
			}
			contador=0;
		}
		
		InputStream ExcelFileToRead = new FileInputStream("database/Data_base.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook(); 
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
 
		Iterator rows = sheet.rowIterator();
		
		Object [] n = null;
		n = new Object[17];
		boolean fila = false;
			
		while (rows.hasNext()){
			int idx=0;
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();

			while (cells.hasNext()){
				cell=(XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
					n[idx] = cell.getStringCellValue();
				}else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){		
					n[idx] = (int)cell.getNumericCellValue();
				}	
				
				idx++;
			}
			
			if(nombre.equalsIgnoreCase((String) n[2]) && vendedor.equalsIgnoreCase("") && rate.equalsIgnoreCase("")){
				fila = true;
			}else if(nombre.equalsIgnoreCase("") && vendedor.equalsIgnoreCase((String) n[13]) && rate.equalsIgnoreCase("")){
				fila = true;
			}else if(nombre.equalsIgnoreCase("") && vendedor.equalsIgnoreCase("") && rate.equalsIgnoreCase((String) n[15])){
				fila = true;
			}else if(nombre.equalsIgnoreCase((String) n[2]) && vendedor.equalsIgnoreCase((String) n[13]) && rate.equalsIgnoreCase("")){
				fila = true;
			}else if(nombre.equalsIgnoreCase((String) n[2]) && vendedor.equalsIgnoreCase("") && rate.equalsIgnoreCase((String) n[15])){
				fila = true;
			}else if(nombre.equalsIgnoreCase("") && vendedor.equalsIgnoreCase((String) n[13]) && rate.equalsIgnoreCase((String) n[15])){
				fila = true;
			}else if(nombre.equalsIgnoreCase((String) n[2]) && vendedor.equalsIgnoreCase((String) n[13]) && rate.equalsIgnoreCase((String) n[15])){
				fila = true;
			}
			
			if(fila){
				Object nuevaFila[]= {n[0],n[1],n[2],n[3],n[4],n[5],n[6],n[7],n[8],n[9],n[10],n[11],n[12],n[13],n[14],n[15],n[16]};
				MarineMassPro.emodeloTablaBuscar.addRow(nuevaFila);
				fila = false;
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void readXLSXFile() throws Exception{
		InputStream ExcelFileToRead = new FileInputStream("database/Data_base.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
 
		Iterator rows = sheet.rowIterator();
		
		Object [] n = null;
		n = new Object[18];
		
		while (rows.hasNext()){
			int idx=0;
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext()){
				
				cell=(XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
					n[idx] = cell.getStringCellValue();
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
					n[idx] = (int)cell.getNumericCellValue();
				}
				idx++;
				
			}
			Object nuevaFila[]= {n[0],n[1],n[2],n[3],n[4],n[5],n[6],n[7],n[8],n[9],n[10],n[11],n[12],n[13],n[14],n[15],n[16]};
			MarineMassPro.amodeloTablaLista.addRow(nuevaFila);
	        int row4 =  MarineMassPro.atablaLista.getRowCount () - 1;
	        Rectangle rect = MarineMassPro.atablaLista.getCellRect(row4, 0, true);
	        MarineMassPro.atablaLista.scrollRectToVisible(rect);
	        MarineMassPro.atablaLista.clearSelection();
	        MarineMassPro.atablaLista.setRowSelectionInterval(row4, row4);
	        MarineMassPro.amodeloTablaLista = (DefaultTableModel)MarineMassPro.atablaLista.getModel();
	        MarineMassPro.amodeloTablaLista.fireTableDataChanged();
		}
		
		int fila = MarineMassPro.amodeloTablaLista.getRowCount();
		String campo = MarineMassPro.amodeloTablaLista.getValueAt(fila-1, 0).toString();
		if(MarineMassPro.fechaAnoIf.equalsIgnoreCase("2013")==true){
			MarineMassPro.atext1.setText("FL"+Integer.toString(Integer.parseInt(campo.substring(2))+1));
		}else if(MarineMassPro.fechaAnoIf.equalsIgnoreCase("2014")==true){
			if(campo.substring(0, 2).equalsIgnoreCase("FL")==true){
				MarineMassPro.atext1.setText("MIA"+Integer.toString(Integer.parseInt(campo.substring(2))+1));
			}else{
				MarineMassPro.atext1.setText("MIA"+Integer.toString(Integer.parseInt(campo.substring(3))+1));
			}
		}
	}
	
	
	@SuppressWarnings({ "unused", "rawtypes" })
	public static void readXLSXFileEditar() throws Exception{
		InputStream ExcelFileToRead = new FileInputStream("database/Data_base.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		XSSFWorkbook test = new XSSFWorkbook(); 
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
 
		Iterator rows = sheet.rowIterator();
		
		Object [] n = null;
		n = new Object[18];
		
		while (rows.hasNext()){
			int idx=0;
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext()){
				
				cell=(XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
					n[idx] = cell.getStringCellValue();
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
					n[idx] = (int)cell.getNumericCellValue();
				}
				idx++;
				
			}
			Object nuevaFila[]= {n[0],n[1],n[2],n[3],n[4],n[5],n[6],n[7],n[8],n[9],n[10],n[11],n[12],n[13],n[14],n[15],n[16]};
			MarineMassPro.emodeloTablaLista.addRow(nuevaFila);
	        int row2 =  MarineMassPro.etablaLista.getRowCount () - 1;
	        Rectangle rect = MarineMassPro.etablaLista.getCellRect(row2, 0, true);
	        MarineMassPro.etablaLista.scrollRectToVisible(rect);
	        MarineMassPro.etablaLista.clearSelection();
	        MarineMassPro.etablaLista.setRowSelectionInterval(row2, row2);
	        MarineMassPro.emodeloTablaLista = (DefaultTableModel)MarineMassPro.etablaLista.getModel();
	        MarineMassPro.emodeloTablaLista.fireTableDataChanged();
		}
		
	}
	
	public static void writeXLSXFile() throws IOException {
		
		String excelFileName = "database/Data_base.xlsx";//name of excel file
		String sheetName = "libro1";//name of sheet
 
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		int filas = MarineMassPro.amodeloTablaLista.getRowCount();
		for (int r = 0 ;r < filas; r++ ){
			XSSFRow row = sheet.createRow(r);
			XSSFCell cell0 = row.createCell(0);
			cell0.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 0).toString());
			XSSFCell cell1 = row.createCell(1);
			cell1.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 1).toString());
			XSSFCell cell2 = row.createCell(2);
			cell2.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 2).toString());
			XSSFCell cell3 = row.createCell(3);
			cell3.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 3).toString());
			XSSFCell cell4 = row.createCell(4);
			cell4.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 4).toString());
			XSSFCell cell5 = row.createCell(5);
			cell5.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 5).toString());
			XSSFCell cell6 = row.createCell(6);
			cell6.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 6).toString());
			XSSFCell cell7 = row.createCell(7);
			cell7.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 7).toString());
			XSSFCell cell8 = row.createCell(8);
			cell8.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 8).toString());
			XSSFCell cell9 = row.createCell(9);
			cell9.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 9).toString());
			XSSFCell cell10 = row.createCell(10);
			cell10.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 10).toString());
			XSSFCell cell11 = row.createCell(11);
			cell11.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 11).toString());
			XSSFCell cell12 = row.createCell(12);
			cell12.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 12).toString());
			XSSFCell cell13 = row.createCell(13);
			cell13.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 13).toString());
			XSSFCell cell14 = row.createCell(14);
			cell14.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 14).toString());
			XSSFCell cell15 = row.createCell(15);
			cell15.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 15).toString());
			XSSFCell cell16 = row.createCell(16);
			cell16.setCellValue(MarineMassPro.amodeloTablaLista.getValueAt(r, 16).toString());
		}
 
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	public static void writeXLSXFileEditarCliente() throws IOException {
		
		String excelFileName = "database/Data_base.xlsx";//name of excel file
		String sheetName = "libro1";//name of sheet
 
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		int filas = MarineMassPro.emodeloTablaLista.getRowCount();
		for (int r = 0 ;r < filas; r++ ){
			XSSFRow row = sheet.createRow(r);
			XSSFCell cell0 = row.createCell(0);
			cell0.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 0).toString());
			XSSFCell cell1 = row.createCell(1);
			cell1.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 1).toString());
			XSSFCell cell2 = row.createCell(2);
			cell2.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 2).toString());
			XSSFCell cell3 = row.createCell(3);
			cell3.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 3).toString());
			XSSFCell cell4 = row.createCell(4);
			cell4.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 4).toString());
			XSSFCell cell5 = row.createCell(5);
			cell5.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 5).toString());
			XSSFCell cell6 = row.createCell(6);
			cell6.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 6).toString());
			XSSFCell cell7 = row.createCell(7);
			cell7.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 7).toString());
			XSSFCell cell8 = row.createCell(8);
			cell8.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 8).toString());
			XSSFCell cell9 = row.createCell(9);
			cell9.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 9).toString());
			XSSFCell cell10 = row.createCell(10);
			cell10.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 10).toString());
			XSSFCell cell11 = row.createCell(11);
			cell11.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 11).toString());
			XSSFCell cell12 = row.createCell(12);
			cell12.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 12).toString());
			XSSFCell cell13 = row.createCell(13);
			cell13.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 13).toString());
			XSSFCell cell14 = row.createCell(14);
			cell14.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 14).toString());
			XSSFCell cell15 = row.createCell(15);
			cell15.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 15).toString());
			XSSFCell cell16 = row.createCell(16);
			cell16.setCellValue(MarineMassPro.emodeloTablaLista.getValueAt(r, 16).toString());
		}
 
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
}