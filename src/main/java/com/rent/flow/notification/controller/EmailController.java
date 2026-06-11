package com.rent.flow.notification.controller;

import com.rent.flow.notification.EmailRequest;
import com.rent.flow.notification.Utils.UserRegisteredEvent;
import com.rent.flow.notification.dto.ContactFormDto;
import com.rent.flow.notification.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "https://cinecrewstaffing.com")
@Slf4j
public class EmailController {

    private final ApplicationEventPublisher publisher;
    private final MailService mailService;
    public EmailController(ApplicationEventPublisher publisher, MailService mailService) {
        this.publisher = publisher;
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public String sendContact(@RequestBody EmailRequest request) throws Exception {
        log.info("Sending contact email request: {}", request.getEmail());
        String html = "<h2>New Contact Message</h2>"
                + "<p><b>User Email:</b> " + request.getEmail() + "</p>";
        try {
            mailService.sendHtml(
                    "mikeb75@gmail.com",
                    "New Contact From Cinecrewstaffing",
                    html
            );
            log.info("Mail sent successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return "Message sent to owner";
    }

    @PostMapping("/send/form")
    public String sendContactform(@RequestBody EmailRequest request) throws Exception {
        log.info("Sending contact email request: {}", request.toString());
        String html = "<h2>New Contact Form</h2>"
                + "<p><b>FullName :</b> " + request.getFullName() + "</p>"
                + "<p><b>User Email:</b> " + request.getEmail() + "</p>"
                + "<p><b>Message :</b> " + request.getMessage() + "</p>";
        try {
            mailService.sendHtml(
                    "mikeb75@gmail.com",
                    "New Contact From Blue Jade Ventures",
                    html
            );
            log.info("Mail sent successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return "Message sent to owner";
    }

    @PostMapping("/send/ubik")
    public String ubik(@RequestBody ContactFormDto request) throws Exception {
        log.info("Sending contact email request: {}", request.toString());
        String html = "<h2>New Contact Form</h2>"
                + "<p><b>Name :</b> " + request.getName() + "</p>"
                + "<p><b>Company :</b> " + request.getCompany() + "</p>"
                + "<p><b>Email :</b> " + request.getEmail() + "</p>"
                + "<p><b>Message :</b> " + request.getMessage() + "</p>";
        try {
            mailService.sendHtml(
                    "mikeb75@gmail.com",
                    "New Contact Ubik",
                    html
            );
            log.info("Mail sent successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return "Message sent to owner";
    }
}