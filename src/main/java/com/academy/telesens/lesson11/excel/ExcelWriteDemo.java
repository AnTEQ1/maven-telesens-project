package com.academy.telesens.lesson11.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelWriteDemo {
    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);
        Cell cell3 = row.createCell(2);

        cell1.setCellValue("Hello");
        cell2.setCellValue("World");
        cell3.setCellValue(25.0);

        Row row2 = sheet.createRow(1);
        Cell cell4 = row2.createCell(0);
        Cell cell5 = row2.createCell(1);
        Cell cell6 = row2.createCell(2);
        cell4.setCellValue("Last Row Data");
        cell5.setCellValue("!");
        cell6.setCellValue(36.0);

        //Запись на диск
        String path = "D:/Тестирование/TelesenseAcademy/demo.xlsx";
        try {
            OutputStream os = new FileOutputStream(path);
            workbook.write(os);
            workbook.close();
            os.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
