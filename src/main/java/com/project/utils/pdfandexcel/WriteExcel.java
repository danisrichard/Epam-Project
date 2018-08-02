package com.project.utils.pdfandexcel;

import com.project.repository.UserRepository;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.stream.StreamSupport;

@Component
public class WriteExcel {

    @Autowired
    private UserRepository userRepository;

    //method called isn't safe, but i just test implementations

    public void createExcel() throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("MyFirstExcel");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("First cell");

        cell = row.createCell(1);
        HSSFDataFormat format = hssfWorkbook.createDataFormat();
        CellStyle dateStyle = hssfWorkbook.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("YYYY.MM.DD"));
        cell.setCellStyle(dateStyle);
        cell.setCellValue(new Date(16));

        hssfWorkbook.write(new FileOutputStream("firstExcel.xls"));
        hssfWorkbook.close();
    }

    public void usersToExcel() throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("UserExcel");

        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);

        cell.setCellValue(StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .findFirst().get().getFirstName());

        hssfWorkbook.write(new FileOutputStream("userExcel.xls"));
        hssfWorkbook.close();
    }

    public void createPDF() throws IOException{


    }
}
