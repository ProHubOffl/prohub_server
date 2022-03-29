package com.epicwin.prohub.service;

import com.epicwin.prohub.model.document.Document;
import com.epicwin.prohub.repo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
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
     * Used for showing all Documents based on email address.
     *
     * @param category email address
     * @return Documents list
     */
    public Stream<Document> getAllFiles(String category){
        return documentRepo.findDocumentByAuthor(category).stream();
    }

    /**
     * Used for showing all Documents based on Project name.
     *
     * @param project_name Project Name
     * @return Documents list
     */
    public Stream<Document> getAllFilesByProjectname(String project_name){
        return documentRepo.findDocumentByProjectName(project_name).stream();
    }

    /**
     * Used for showing all Document based on Document ID
     *
     * @param id document Id
     * @return Document Entity
     */
    public Document getDocumentByDocumentId(int id){
        return documentRepo.findById(id).get();
    }

    /**
     * Used for updating Document.
     *
     * @param documentId Document id
     * @param document updated Document entity
     * @return updated Document entity
     * @throws EntityNotFoundException when requested Document entity not found
     */
    public Document updateDocumentItem(int documentId, Document document) throws EntityNotFoundException {

        Document olddocument = getDocumentByDocumentId(documentId);
        if (Objects.isNull(olddocument)) {
            throw new EntityNotFoundException("Requested Document Entity Not Found");
        } else {
            document.setDocumentId(documentId);
            return documentRepo.save(document);
        }
    }

    /**
     * Used for deleting Document.
     *
     * @param documentId Document id
     * @throws EntityNotFoundException when requested Document entity not found
     */
    public void deleteDocumentItem(int documentId) throws EntityNotFoundException  {
        Document document = getDocumentByDocumentId(documentId);
        if (!Objects.isNull(document)) {
            documentRepo.delete(document);
        } else {
            throw new EntityNotFoundException ("Requested Document Entity Not Found");
        }
    }

}
