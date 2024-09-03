package com.fiap.pombo.service;

import com.fiap.pombo.model.Email;
import com.fiap.pombo.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    // Salva um novo email no banco de dados
    public Email saveEmail(Email email) {
        return emailRepository.save(email);
    }

    // Retorna todos os emails cadastrados
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    // Retorna um email pelo ID
    public Email getEmailById(Long id) {
        Optional<Email> email = emailRepository.findById(id);
        return email.orElse(null); // Retorna null se não encontrar o email
    }

    // Atualiza um email existente pelo ID
    public Email updateEmail(Long id, Email emailDetails) {
        Optional<Email> optionalEmail = emailRepository.findById(id);
        if (optionalEmail.isPresent()) {
            Email existingEmail = optionalEmail.get();
            existingEmail.setDeEmail(emailDetails.getDeEmail());
            existingEmail.setParaEmail(emailDetails.getParaEmail());
            existingEmail.setAssunto(emailDetails.getAssunto());
//            existingEmail.setCorpo(emailDetails.getCorpo());
            existingEmail.setDataEmail(emailDetails.getDataEmail());
            existingEmail.setSpam(emailDetails.isSpam());
//            existingEmail.setImagens(emailDetails.getImagens());
            existingEmail.setEventos(emailDetails.getEventos());
            return emailRepository.save(existingEmail);
        } else {
            return null; // Retorna null se o email não for encontrado
        }
    }

    // Deleta um email pelo ID
    public boolean deleteEmail(Long id) {
        if (emailRepository.existsById(id)) {
            emailRepository.deleteById(id);
            return true;
        } else {
            return false; // Retorna false se o email não for encontrado
        }
    }
}
