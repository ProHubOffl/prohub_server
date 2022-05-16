package com.epicwin.prohub.service;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.ticket.Ticket;
import com.epicwin.prohub.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service class for handling ticket operations.
 */
@Service
public class TicketService {

    @Autowired
    TicketRepo ticketRepo;

    /**
     * Used to get the list of tickets by project name.
     *
     * @param projectName project name
     * @return a list of tickets belong to a particular project
     */
    public List<Ticket> getTicketsByProjectName(String projectName) {
        return ticketRepo.findAllByProjectName(projectName);
    }

    /**
     * Used to get a ticket entity by ticket id.
     *
     * @param ticketId ticket id
     * @return ticket entity
     * @throws EntityNotFoundException when Requested Ticket Entity Not Found
     */
    public Ticket getTicketByTicketId(int ticketId) throws EntityNotFoundException {
        Ticket ticket = ticketRepo.findByTicketId(ticketId);
        if (Objects.isNull(ticket)) {
            throw new EntityNotFoundException("Requested Ticket Entity Not Found");
        } else {
            return ticket;
        }
    }

    /**
     * Used to get a ticket entity by ticket id and project name.
     *
     * @param ticketId    ticket id
     * @param projectName project name
     * @return ticket entity
     * @throws EntityNotFoundException when requested Ticket entity not found
     */
    public Ticket getTicketByTicketIdAndProject(int ticketId, String projectName) throws EntityNotFoundException {
        Ticket ticket = ticketRepo.findTicketByTicketIdAndProjectName(ticketId, projectName);
        if (Objects.isNull(ticket)) {
            throw new EntityNotFoundException("Requested Ticket entity not found");
        } else {
            return ticket;
        }
    }

    /**
     * Used to add a new ticket.
     *
     * @param ticket new ticket entity
     * @return newly added ticket entity
     */
    public Ticket createTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    /**
     * Used to update a ticket entity.
     *
     * @param ticketId ticket id
     * @param ticket   updated ticket entity
     * @return updated ticket entity
     * @throws EntityNotFoundException when requested Ticket entity not found
     */
    public Ticket updateTicket(int ticketId, Ticket ticket) throws EntityNotFoundException {
        Ticket oldTicket = ticketRepo.findByTicketId(ticketId);
        if (Objects.isNull(oldTicket)) {
            throw new EntityNotFoundException("Requested Ticket entity not found");
        } else {
            ticket.setTicketId(ticketId);
            return ticketRepo.save(ticket);
        }
    }

    /**
     * Used to delete a particular ticket.
     *
     * @param ticketId ticket
     * @throws EntityNotFoundException when requested Ticket entity not found
     */
    public void deleteTicket(int ticketId) throws EntityNotFoundException {
        Ticket ticket = ticketRepo.findByTicketId(ticketId);
        if (Objects.isNull(ticket)) {
            throw new EntityNotFoundException("Requested Ticket entity not found");
        } else {
            ticketRepo.deleteByTicketId(ticketId);
        }
    }
}
