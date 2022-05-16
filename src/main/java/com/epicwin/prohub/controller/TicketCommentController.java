package com.epicwin.prohub.controller;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.ticket.Ticket;
import com.epicwin.prohub.model.ticket.TicketComment;
import com.epicwin.prohub.service.TicketCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling ticket comment operations.
 */
@RestController
@Transactional
public class TicketCommentController {

    @Autowired
    TicketCommentService ticketCommentService;

    /**
     * Used to get a list of comments for a particular ticket.
     *
     * @param ticketId ticket id
     * @return list of comments for a particular ticket
     */
    @GetMapping("/ticket/ticketComment/{ticketId}")
    public List<TicketComment> getCommentsForATicket(@PathVariable("ticketId") int ticketId) {
        return ticketCommentService.getCommentsByTicketId(ticketId);
    }

    /**
     * Used to get a ticket comment by ticket comment id.
     *
     * @param ticketCommentId ticket comment id
     * @return ticket comment entity
     * @throws EntityNotFoundException when requested ticket comment entity not found
     */
    @GetMapping("/ticketComment/{ticketCommentId}")
    public TicketComment getCommentByTicketCommentId(
            @PathVariable("ticketCommentId") int ticketCommentId) throws EntityNotFoundException {
        return ticketCommentService.getTicketCommentByTicketCommentId(ticketCommentId);
    }

    /**
     * Used to add a new ticket comment.
     *
     * @param ticketComment new ticket comment entity
     * @return added ticket comment entity
     */
    @PostMapping("/ticketComment")
    public TicketComment addTicketComment(@RequestBody TicketComment ticketComment) {
        return ticketCommentService.addTicketComment(ticketComment);
    }

    /**
     * Used to update a ticket comment.
     *
     * @param ticketCommentId ticket comment id
     * @param ticketComment   updated ticket comment entity
     * @return updated ticket comment entity
     * @throws EntityNotFoundException when requested ticket comment entity not found
     */
    @PutMapping("/ticketComment/{ticketCommentId}")
    public TicketComment updateTicketComment(@PathVariable("ticketCommentId") int ticketCommentId,
                                         @RequestBody TicketComment ticketComment) throws EntityNotFoundException {
        return ticketCommentService.updateTicketComment(ticketCommentId, ticketComment);
    }

    /**
     * Used to delete a ticket comment.
     *
     * @param ticketCommentId ticket comment id
     * @throws EntityNotFoundException when requested ticket comment entity not found
     */
    @DeleteMapping("/ticketComment/{ticketCommentId}")
    public void deleteTicketComment(@PathVariable("ticketCommentId") int ticketCommentId)
                                                        throws EntityNotFoundException {
        ticketCommentService.deleteTicketComment(ticketCommentId);
    }
}

