package com.epicwin.prohub.service;

import com.epicwin.prohub.model.document.Document;
import com.epicwin.prohub.repo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * Service class for handling Document operations.
 */
@Service
public class DocumentService {
    @Autowired
    DocumentRepo documentRepo;

    public Document saveDocument(MultipartFile file, String projectName, String title, String description, String author, Date createdDate, Date updatedDate) throws IOException {
        String documentName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(projectName,title,description,author,documentName,file.getContentType(),file.getBytes(),createdDate,updatedDate);
        return documentRepo.save(document);
    }
}
