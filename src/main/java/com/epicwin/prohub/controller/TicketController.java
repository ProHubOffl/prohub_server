package com.epicwin.prohub.controller;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.ticket.Ticket;
import com.epicwin.prohub.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling ticket operations.
 */
@RestController
@Transactional
public class TicketController {

    @Autowired
    TicketService ticketService;

    /**
     * Used to get a list of tickets for a project.
     *
     * @param projectName project name
     * @return list of tickets for the project
     */
    @GetMapping("/{projectName}/ticket")
    public List<Ticket> getTicketsByProject(@PathVariable("projectName") String projectName) {
        return ticketService.getTicketsByProjectName(projectName);
    }

    /**
     * Used to get a ticket by ticket id.
     *
     * @param ticketId ticket id
     * @return ticket entity
     * @throws EntityNotFoundException when requested ticket entity not found
     */
    @GetMapping("/ticket/{ticketId}")
    public Ticket getTicketByTicketId(@PathVariable("ticketId") int ticketId) throws EntityNotFoundException {
        return ticketService.getTicketByTicketId(ticketId);
    }

    /**
     * Used to get a ticket by ticket id and project name.
     *
     * @param projectName project name
     * @param ticketId    ticket id
     * @return ticket entity
     * @throws EntityNotFoundException when requested ticket entity not found
     */
    @GetMapping("/{projectName}/ticket/{ticketId}")
    public Ticket getTicketByProjectAndTicketId(@PathVariable("projectName") String projectName,
                                                @PathVariable int ticketId) throws EntityNotFoundException {
        return ticketService.getTicketByTicketIdAndProject(ticketId, projectName);
    }

    /**
     * Used to add a new ticket.
     *
     * @param ticket new ticket entity
     * @return added ticket entity
     */
    @PostMapping("/ticket")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    /**
     * Used to update a ticket.
     *
     * @param ticketId ticket id
     * @param ticket   updated ticket entity
     * @return updated ticket entity
     * @throws EntityNotFoundException when requested ticket entity not found
     */
    @PutMapping("/ticket/{ticketId}")
    public Ticket updateTicket(@PathVariable("ticketId") int ticketId,
                               @RequestBody Ticket ticket) throws EntityNotFoundException {
        return ticketService.updateTicket(ticketId, ticket);
    }

    /**
     * Used to delete a ticket.
     *
     * @param ticketId ticket id
     * @throws EntityNotFoundException when requested ticket entity not found
     */
    @DeleteMapping("/ticket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId") int ticketId) throws EntityNotFoundException {
        ticketService.deleteTicket(ticketId);
    }
}
