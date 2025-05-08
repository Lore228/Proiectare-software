package ro.ulbs.paradigme.lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class GenerareExcel {
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("First Sheet");
        Map<String, Object[]> data=new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"Name","Surname","Grade 1","Grade 2","Grade 3","Grade 4","Max","Average"});
        data.put("2", new Object[]{"Amit","Shukla",9,8,7,5});
        data.put("3", new Object[]{"Lokesh","Gupta",8,9,6,7});
        data.put("4", new Object[]{"John","Adwards",8,8,7,6});
        data.put("5", new Object[]{"Brian","Schultz",7,6,8,9});

        XSSFCellStyle headerStyle = workbook.createCellStyle();
        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFCellStyle yellowStyle = workbook.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        int rowNum = 0;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row = sheet.createRow(rowNum);
            Object[] rowData = entry.getValue();
            int colNum = 0;

            for (Object field : rowData) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String)
                    cell.setCellValue((String) field);
                else if (field instanceof Integer)
                    cell.setCellValue((Integer) field);
            }
            if (rowNum == 0) {
                for (int i = 0; i < rowData.length; i++) {
                    row.getCell(i).setCellStyle(headerStyle);
                }
            } else {
                Cell maxCell = row.createCell(6);
                String rowIndex = String.valueOf(rowNum + 1);
                maxCell.setCellFormula("MAX(C" + rowIndex + ":F" + rowIndex + ")");
                maxCell.setCellStyle(yellowStyle);

                Cell avgCell = row.createCell(7);
                avgCell.setCellFormula("AVERAGE(C" + rowIndex + ":F" + rowIndex + ")");
                avgCell.setCellStyle(yellowStyle);
            }
            rowNum++;
        }
        for (int i = 0; i <= 7; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream out = new FileOutputStream("output8.xlsx")) {
            workbook.write(out);
            workbook.close();
            System.out.println("Fișierul output8.xlsx a fost generat cu succes!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}
