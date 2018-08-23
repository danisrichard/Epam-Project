package com.project.controller;

import com.project.utils.pdf.PdfCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/pdf")
public class PdfTestController{

    @Autowired
    private PdfCreator pdfCreator;

    @GetMapping
    public String createNewBasicPdf() throws IOException {
        pdfCreator.createNewBasicPdf("dsa");
        return "its finished";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileToPdf(@RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        pdfCreator.createPdfWithImage(file);
        //modelMap.addAttribute("file", file);
        return "uploaded";
    }

    @RequestMapping(value = "/multiUploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadMultipleFileToPdf(@RequestParam("file") MultipartFile[] file, ModelMap modelMap) throws IOException {
        // pdfCreator.createPdfWithImage(file);
        return "uploaded";
    }

    @GetMapping("/downloadStreamResource")
    public ResponseEntity<InputStreamResource> testDownloadFile() throws IOException {
        File file = new File("image.pdf");
        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
                .body(inputStreamResource);
    }

}
