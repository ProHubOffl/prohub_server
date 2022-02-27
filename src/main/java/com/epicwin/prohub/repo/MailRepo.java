package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.email.Mail;

/**
 * Interface for handling email sending operations.
 */
public interface MailRepo {

    public void sendEmail(Mail mail);
}
