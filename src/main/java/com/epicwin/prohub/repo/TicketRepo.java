package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Repository for handling ticket operations.
 */
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllByProjectName(String projectName);

    Ticket findTicketByTicketIdAndProjectName(int ticketId, String projectName);

    Ticket findByTicketId(int ticketId);

    @Transactional
    void deleteByTicketId(int ticketId);
}
