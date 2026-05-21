package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private Workbook workbook;
    private Sheet sheet;

    // constructor — opens the Excel file
    public ExcelReader(String filePath, String sheetName){

        try {
            FileInputStream file = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(file);     // opens .xlsx file
            sheet = workbook.getSheet(sheetName);  // opens specific sheet
        }
        catch (IOException e){
            throw new RuntimeException("Excel file not found: "+ filePath);
        }
    }

    // returns total number of data rows (excluding header row)
    public int getRowCount(){
        return  sheet.getLastRowNum();  // lastRowNum excludes header (row 0)
    }

    // returns total number of columns
    public int getColumnCount(){
        return sheet.getRow(0).getLastCellNum();
    }

    // returns cell value as String
    public String getCellData(int rowNum, int colNum){
        Row row = sheet.getRow(rowNum);
        if(row == null) return "";

        Cell cell = row.getCell(colNum);
        if (cell == null) return "";

        // handle different cell types
        switch (cell.getCellType()){
            case STRING:  return cell.getStringCellValue().trim();
            case NUMERIC: return String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            default:      return "";
        }
    }

    // close workbook after reading
    public void close(){
        try {
            workbook.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
