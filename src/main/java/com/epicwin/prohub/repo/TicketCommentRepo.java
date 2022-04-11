package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.ticket.TicketComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Repository for handling ticket comment operations.
 */
@Repository
public interface TicketCommentRepo extends JpaRepository<TicketComment, Integer> {

    List<TicketComment> findAllByTicketId(int ticketId);

    TicketComment findTicketCommentByCommentIdAndTicketId(int commentId, int ticketId);

    TicketComment findTicketCommentByCommentId(int commentId);

    @Transactional
    void deleteByCommentId(int commentId);
}
