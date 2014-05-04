
	package visitas;
	import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	 
	public class DataBaseBackUp {
		
		public static void writeXLSXFile() throws IOException {
			
			String excelFileName = "database/Data_base_Backup.xlsx";//name of excel file
			String sheetName = "libroBackup";//name of sheet
	 
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
			
			String excelFileName = "database/Data_base_Backup.xlsx";//name of excel file
			String sheetName = "libroBackup";//name of sheet
	 
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