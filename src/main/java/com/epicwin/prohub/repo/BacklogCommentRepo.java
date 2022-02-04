package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.backlog.BacklogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for handllng backlog comment operations.
 */
@Repository
public interface BacklogCommentRepo extends JpaRepository<BacklogComment, Integer> {

    List<BacklogComment> findAllByBacklogId(int backlogId);

    BacklogComment findBacklogCommentByCommentId(int commentId);
}
