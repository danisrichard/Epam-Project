package com.project.utils.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Component
public class PdfCreator {

    public void createNewBasicPdf(String pdfName) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.showText("Hello World");
        contentStream.endText();
        contentStream.close();

        document.save("pdfName.pdf");
        document.close();
    }

    public void createPdfWithImage(MultipartFile file) throws IOException {
//        File convertFile = multipartFileToFile(file);
        File convertFile = multiPartFileConverterToFile(file);
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDImageXObject image = PDImageXObject.createFromFileByContent(convertFile, document);

        contentStream.drawImage(image, 0, 0);
        contentStream.close();

        document.save("image.pdf");
        document.close();
    }

    private File multipartFileToFile(MultipartFile file) throws IllegalStateException, IOException {
        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        file.transferTo(convertFile);
        return convertFile;
    }

    private File multiPartFileConverterToFile(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
