package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for handling Document operations.
 */
@Repository
public interface DocumentRepo extends JpaRepository<Document, Integer> {

    List<Document> findDocumentByProjectName(String projectName);

    List<Document> findDocumentByAuthor(String Author);

    Document findDocumentByDocumentIdAndAuthor(int id, String Author);

    Document findDocumentByDocumentIdAndProjectName(int id, String projectName);

}
