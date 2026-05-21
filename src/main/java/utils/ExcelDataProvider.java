package utils;

// reads Excel and converts to Object[][] for @DataProvider
public class ExcelDataProvider {

    private static final String FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\LoginData.xlsx";

    public static Object[][] getLoginData() {
        ExcelReader reader = new ExcelReader(FILE_PATH, "Sheet1"); //opens Sheet1 from Excel file

        int rows = reader.getRowCount();    // total data rows (no header)
        int cols = reader.getColumnCount(); // total columns

        Object[][] data = new Object[rows][cols]; //Creates 2D array.

        for (int i = 1; i <=rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = reader.getCellData(i, j);
            }
        }

        reader.close();
        return data;
    }
}