package JMlessous.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import JMlessous.entities.*;

public class ExcelImporter {
 public List<Devise> excelImport(){
	 List<Devise> listDevise = new ArrayList<>();
	  String Désignation="";
		 String Code="";
		 int Unité=0;
		 double Achat=0;
		 double Vente=0;
		 
		 String excelFilePath="C:\\Users\\Administrateur\\Desktop\\Roulette\\angular-10-spring-boot-jwt-authentication-master\\angular-10-client\\src\\assets\\testing.xlsx";
	
		 long start = System.currentTimeMillis();
		 
		 FileInputStream inputStream;
		 try {
			 inputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet= workbook.getSheetAt(0);
			Iterator<Row> rowIterator=firstSheet.iterator();
			rowIterator.next();
			
			while(rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator=nextRow.cellIterator();
				while(cellIterator.hasNext()) {
					Cell nextCell=cellIterator.next();
					int columnIndex=nextCell.getColumnIndex();
					switch (columnIndex) {
					case 0: 
						Désignation=nextCell.getStringCellValue();
						System.out.println(Désignation);
						break;
					case 1:
						Code=nextCell.getStringCellValue();
						System.out.println(Code);
						break;
					case 2:
						Unité=(int)nextCell.getNumericCellValue();
						System.out.println(Unité);
						break;
					case 3:
						Achat=(float)Float.parseFloat(nextCell.getStringCellValue());   
						System.out.println(Achat);
						break;
					case 4:
						Vente=(float)Float.parseFloat(nextCell.getStringCellValue());   
						System.out.println(Vente);
						break;

					}
					listDevise.add(new Devise(Désignation, Code, Unité, Achat, Vente));
				}
			}
			workbook.close();
			 long end = System.currentTimeMillis();
			 System.out.printf("Import done in %d ms\n", (end - start));
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 return listDevise;
 }
}
