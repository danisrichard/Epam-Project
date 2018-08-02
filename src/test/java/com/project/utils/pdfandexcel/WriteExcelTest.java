package com.project.utils.pdfandexcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class WriteExcelTest {

    @Autowired
    private WriteExcel writeExcel;

    @Test
    public void createExcel() throws IOException {
        writeExcel.createExcel();
    }

    @Test
    public void createUserExcel() throws IOException{
        writeExcel.usersToExcel();
    }
}