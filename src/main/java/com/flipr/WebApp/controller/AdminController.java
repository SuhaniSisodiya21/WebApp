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
@RequestMapping("/api/admin")
public class AdminController {

    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;
    private final ContactMessageRepository contactMessageRepository;
    private final SubscriberRepository subscriberRepository;

    public AdminController(ProjectRepository projectRepository,
                           ClientRepository clientRepository,
                           ContactMessageRepository contactMessageRepository,
                           SubscriberRepository subscriberRepository) {
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
        this.contactMessageRepository = contactMessageRepository;
        this.subscriberRepository = subscriberRepository;
    }

    // -------- PROJECTS --------

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        if (!projectRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        projectRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // -------- CLIENTS --------

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // -------- CONTACTS --------

    @GetMapping("/contacts")
    public List<ContactMessage> getAllContacts() {
        return contactMessageRepository.findAll();
    }

    // -------- SUBSCRIBERS --------

    @GetMapping("/subscribers")
    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }
}
