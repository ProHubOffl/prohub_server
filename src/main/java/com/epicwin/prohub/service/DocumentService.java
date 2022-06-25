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
     * @return created Document entity
     * @throws IOException
     */
    public Document saveDocument(MultipartFile file, String projectName, String title, String description, String author, Date createdDate) throws IOException {
        String documentName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(projectName,title,description,author,documentName,file.getContentType(),file.getBytes(),createdDate);
        return documentRepo.save(document);
    }

    /**
     * Used for showing all Documents based on email address.
     *
     * @param category email address
     * @return Documents list
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    public Stream<Document> getDocumentByAuthor(String category) throws EntityNotFoundException {
        return documentRepo.findDocumentByAuthor(category).stream();
    }

    /**
     * Used for showing all Documents based on Project name.
     *
     * @param project_name Project Name
     * @return Documents list
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    public Stream<Document> getAllFilesByProjectname(String project_name) throws EntityNotFoundException {
        return documentRepo.findDocumentByProjectName(project_name).stream();
    }

    /**
     * Used for showing all Document based on Document ID
     *
     * @param id document Id
     * @return Document Entity
     * @throws EntityNotFoundException when requested Announcement entity not found
     */
    public Document getDocumentByDocumentId(int id) throws EntityNotFoundException {
        return documentRepo.findById(id).get();
    }

    /**
     * Used for updating Document.
     *
     * @param file file information
     * @param projectName Project Name
     * @param title Title
     * @param description Description
     * @param author Author
     * @param updatedDate Last Updated Date
     * @param documentId document Id
     * @return updated Document entity
     * @throws EntityNotFoundException when requested Document entity not found
     */
    public Document updateDocumentItem(MultipartFile file, String projectName, String title, String description, String author, Date updatedDate, int documentId) throws EntityNotFoundException, IOException {
        Document document = getDocumentByDocumentId(documentId);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (Objects.isNull(document)) {
            throw new EntityNotFoundException("Requested Document Entity Not Found");
        } else {
            document.setDocumentId(documentId);
            document.setDescription(description);
            document.setTitle(title);
            document.setAuthor(author);
            document.setUpdatedDate(updatedDate);
            //document.setCreatedDate(createdDate);
            document.setProjectName(projectName);
            document.setData(file.getBytes());
            document.setType(file.getContentType());
            document.setName(fileName);
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
