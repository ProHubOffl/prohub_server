package com.epicwin.prohub.service;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.ticket.TicketComment;
import com.epicwin.prohub.repo.TicketCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service class for handling ticket comment operations.
 */
@Service
public class TicketCommentService {

    @Autowired
    TicketCommentRepo ticketCommentRepo;

    /**
     * Used to get a list of comments for a ticket.
     *
     * @param ticketId ticket id
     * @return a list of comments for a ticket
     */
    public List<TicketComment> getCommentsByTicketId(int ticketId) {
        return ticketCommentRepo.findAllByTicketId(ticketId);
    }

    /**
     * Used to get a ticket comment by ticket comment id.
     *
     * @param ticketCommentId ticket comment id
     * @return ticket comment entity
     * @throws EntityNotFoundException when requested ticket comment entity not found
     */
    public TicketComment getTicketCommentByTicketCommentId(int ticketCommentId) throws EntityNotFoundException {
        TicketComment ticketComment = ticketCommentRepo.findTicketCommentByCommentId(ticketCommentId);
        if (Objects.isNull(ticketComment)) {
            throw new EntityNotFoundException("Requested ticket comment entity not found");
        } else {
            return ticketComment;
        }
    }

    /**
     * Used to add a new comment to a ticket.
     *
     * @param ticketComment ticket comment
     * @return added ticket comment
     */
    public TicketComment addTicketComment(TicketComment ticketComment) {
        return ticketCommentRepo.save(ticketComment);
    }

    /**
     * Used to update a ticket comment.
     *
     * @param commentId     ticket comment id
     * @param ticketComment updated ticket comment
     * @return updated ticket comment
     * @throws EntityNotFoundException when when requested ticket comment entity not found
     */
    public TicketComment updateTicketComment(int commentId, TicketComment ticketComment)
            throws EntityNotFoundException {
        TicketComment oldComment = ticketCommentRepo.findTicketCommentByCommentId(commentId);
        if (Objects.isNull(oldComment)) {
            throw new EntityNotFoundException("Requested ticket comment entity not found");
        } else {
            ticketComment.setCommentId(commentId);
            return ticketCommentRepo.save(ticketComment);
        }
    }

    /**
     * Used to delete a comment for a ticket.
     *
     * @param commentId ticket comment id
     * @throws EntityNotFoundException when when requested ticket comment entity not found
     */
    public void deleteTicketComment(int commentId) throws EntityNotFoundException {
        TicketComment comment = ticketCommentRepo.findTicketCommentByCommentId(commentId);
        if (Objects.isNull(comment)) {
            throw new EntityNotFoundException("Requested ticket comment entity not found");
        } else {
            ticketCommentRepo.deleteByCommentId(commentId);
        }
    }
}
