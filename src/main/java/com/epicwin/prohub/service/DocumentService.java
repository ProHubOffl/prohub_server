package com.epicwin.prohub.service;

import com.epicwin.prohub.model.document.Document;
import com.epicwin.prohub.repo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Service class for handling Document operations.
 */
@Service
public class DocumentService {
    @Autowired
    DocumentRepo documentRepo;

    /**
     * Used for creating new Document item.
     *
     * @param file file information
     * @param projectName Project Name
     * @param title Title
     * @param description Description
     * @param author Author
     * @param createdDate Created Date
     * @param updatedDate Last Updated Date
     * @return created Document entity
     * @throws IOException
     */
    public Document saveDocument(MultipartFile file, String projectName, String title, String description, String author, Date createdDate, Date updatedDate) throws IOException {
        String documentName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(projectName,title,description,author,documentName,file.getContentType(),file.getBytes(),createdDate,updatedDate);
        return documentRepo.save(document);
    }

    /**
     *
     * @param category email address
     * @return Documents list
     */
    public Stream<Document> getAllFiles(String category){
        return documentRepo.findDocumentByAuthor(category).stream();
    }

}
