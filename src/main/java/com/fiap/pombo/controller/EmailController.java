package com.fiap.pombo.controller;

import com.fiap.pombo.model.Email;
import com.fiap.pombo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Create a new email
    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody Email email) {
        Email createdEmail = emailService.saveEmail(email);
        return new ResponseEntity<>(createdEmail, HttpStatus.CREATED);
    }

    // Get a list of all emails
    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        List<Email> emails = emailService.getAllEmails();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    // Get a single email by ID
    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        Email email = emailService.getEmailById(id);
        if (email != null) {
            return new ResponseEntity<>(email, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing email
    @PutMapping("/{id}")
    public ResponseEntity<Email> updateEmail(@PathVariable Long id, @RequestBody Email emailDetails) {
        Email updatedEmail = emailService.updateEmail(id, emailDetails);
        if (updatedEmail != null) {
            return new ResponseEntity<>(updatedEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an email
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        boolean isDeleted = emailService.deleteEmail(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
