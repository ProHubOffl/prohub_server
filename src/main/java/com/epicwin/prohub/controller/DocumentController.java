package com.epicwin.prohub.controller;

import com.epicwin.prohub.model.document.Document;
import com.epicwin.prohub.response.ResponseFile;
import com.epicwin.prohub.response.ResponseMessage;
import com.epicwin.prohub.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
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
@Transactional
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
     * @return created Document entity
     */
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadDocument
            (@RequestParam("file") MultipartFile file,
             @RequestParam("project_name") String projectName,
             @RequestParam("title") String title,
             @RequestParam("description") String description,
             @RequestParam("author") String author) throws ParseException {

        String message = "";
        Date createdDate =new Date();
        try {
            documentService.saveDocument(file,projectName,title,description,author,createdDate);

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
     * @throws EntityNotFoundException when requested Document entity not found
     */
    @GetMapping("/{author}/documents")
    public ResponseEntity<List<ResponseFile>> getListFiles(@PathVariable String author) throws EntityNotFoundException {
        List<ResponseFile> files = documentService.getDocumentByAuthor(author).map(dbFile -> {
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

    /**
     * Used for showing all Documents based on Project name.
     *
     * @param project_name Project Name
     * @return Documents list
     * @throws EntityNotFoundException when requested Document entity not found
     */
    @GetMapping("/documents/project/{project_name}")
    public ResponseEntity<List<ResponseFile>> getAllFilesByProjectname(@PathVariable String project_name) throws EntityNotFoundException {
        List<ResponseFile> files = documentService.getAllFilesByProjectname(project_name).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documents/")
                    .path(String.valueOf(dbFile.getDocumentId()))
                    .toUriString();

            return new ResponseFile(
                    dbFile.getDocumentId(),
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

    /**
     * Used for showing all Document based on Document ID
     *
     * @param id document Id
     * @return Document Entity
     * @throws EntityNotFoundException when requested Document entity not found
     */
    @GetMapping("/documents/{id}")
    public ResponseEntity<byte[]> getSingleDocument(@PathVariable int id) throws EntityNotFoundException {
        Document document = documentService.getDocumentByDocumentId(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getName() + "\"")
                .body(document.getData());
    }

    /**
     * Used for updating a Document item.
     *
     * @param documentId Document id
     * @return updated Document entity
     * @throws EntityNotFoundException when requested Document entity not found
     */
    @PutMapping("/documents/update/{documentId}")
    public Document updateDocumentItem(
            @RequestParam("file") MultipartFile file,
            @RequestParam("project_name") String projectName,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("author") String author,
            @PathVariable("documentId") int documentId) throws EntityNotFoundException, ParseException, IOException {

        Date updatedDate =new Date();
        return documentService.updateDocumentItem(file,projectName,title,description,author,updatedDate,documentId);
    }

    /**
     * Used for deleting an Document item.
     *
     * @param documentId Document id
     * @throws EntityNotFoundException when requested Document entity not found
     */
    @DeleteMapping("/documents/remove/{documentId}")
    public void deleteDocumentItem(@PathVariable("documentId") int documentId) throws EntityNotFoundException {
        documentService.deleteDocumentItem(documentId);
    }

}
