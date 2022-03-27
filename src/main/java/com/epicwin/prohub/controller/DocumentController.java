package com.epicwin.prohub.controller;

import com.epicwin.prohub.response.ResponseFile;
import com.epicwin.prohub.response.ResponseMessage;
import com.epicwin.prohub.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Controller class for handling document operations.
 */
@RestController
@CrossOrigin
public class DocumentController {
    @Autowired
    DocumentService documentService;

    /**
     * Used for creating new Document item.
     *
     * @param file file information
     * @param projectName Project Name
     * @param title Title
     * @param description Description
     * @param author Author
     * @param created_Date Created Date
     * @param updated_Date Last Updated Date
     * @return created Document entity
     */
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadDocument
            (@RequestParam("file") MultipartFile file,
             @RequestParam("project_name") String projectName,
             @RequestParam("title") String title,
             @RequestParam("description") String description,
             @RequestParam("author") String author,
             @RequestParam("created_date") String created_Date,
             @RequestParam("last_updated_at") String updated_Date) throws ParseException {

        String message = "";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date createdDate = format.parse(created_Date);
        Date updatedDate = format.parse(updated_Date);
        try {
            documentService.saveDocument(file,projectName,title,description,author,createdDate,updatedDate);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    /**
     * Used for getting Documents List based on email address.
     *
     * @param author email address
     * @return Documents entity
     */
    @GetMapping("/{author}/documents")
    public ResponseEntity<List<ResponseFile>> getListFiles(@PathVariable String author) {
        List<ResponseFile> files = documentService.getAllFiles(author).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documents/")
                    .path(String.valueOf(dbFile.getDocumentId()))
                    .toUriString();

            return new ResponseFile(
                    dbFile.getProjectName(),
                    dbFile.getTitle(),
                    dbFile.getDescription(),
                    dbFile.getAuthor(),
                    dbFile.getName(),
                    dbFile.getType(),
                    fileDownloadUri,
                    dbFile.getCreatedDate(),
                    dbFile.getUpdatedDate(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }


}
