package com.rent.flow.notification.controller;

import com.rent.flow.notification.EmailRequest;
import com.rent.flow.notification.Utils.UserRegisteredEvent;
import com.rent.flow.notification.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("*")
public class EmailController {

    private final ApplicationEventPublisher publisher;
    private final MailService mailService;
    public EmailController(ApplicationEventPublisher publisher, MailService mailService) {
        this.publisher = publisher;
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public String sendContact(@RequestBody EmailRequest request) throws Exception {

        String html = "<h2>New Contact Message</h2>"
                + "<p><b>User Email:</b> " + request.getEmail() + "</p>";

        mailService.sendHtml(
                "ayoub.chakir0926@gmail.com",
                "New Contact From Cinecrewstaffing",
                html
        );

        return "Message sent to owner";
    }
}