package com.flipr.WebApp.controller;

import com.flipr.WebApp.model.Client;
import com.flipr.WebApp.model.ContactMessage;
import com.flipr.WebApp.model.Project;
import com.flipr.WebApp.model.Subscriber;
import com.flipr.WebApp.repository.ClientRepository;
import com.flipr.WebApp.repository.ContactMessageRepository;
import com.flipr.WebApp.repository.ProjectRepository;
import com.flipr.WebApp.repository.SubscriberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PublicController {

    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;
    private final ContactMessageRepository contactMessageRepository;
    private final SubscriberRepository subscriberRepository;

    public PublicController(ProjectRepository projectRepository,
                            ClientRepository clientRepository,
                            ContactMessageRepository contactMessageRepository,
                            SubscriberRepository subscriberRepository) {
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
        this.contactMessageRepository = contactMessageRepository;
        this.subscriberRepository = subscriberRepository;
    }

    // --- public data for landing page ---

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    // --- contact form ---

    @PostMapping("/contact")
    public ResponseEntity<String> createContact(@RequestBody ContactMessage request) {
        ContactMessage saved = contactMessageRepository.save(request);
        return ResponseEntity.ok("Contact saved with id: " + saved.getId());
    }

    // --- newsletter subscribe ---

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribe(@RequestBody Subscriber request) {
        if (subscriberRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.ok("Already subscribed");
        }
        Subscriber saved = subscriberRepository.save(request);
        return ResponseEntity.ok("Subscribed with id: " + saved.getId());
    }
}
