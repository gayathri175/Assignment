package com.example.clientapp.controller;

import com.example.clientapp.model.Client;
import com.example.clientapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Get all clients
    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "client_list";  // Return Thymeleaf view name (client_list.html)
    }

    // Get form to add a new client
    @GetMapping("/add")
    public String addClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "add_client";  // Return Thymeleaf view name (add_client.html)
    }

    // Save the new client
    @PostMapping("/save")
    public String saveClient(@ModelAttribute Client client) {
        clientService.saveClient(client);
        return "redirect:/clients";  // Redirect back to list of clients
    }

    // Edit an existing client
    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id).orElseThrow();
        model.addAttribute("client", client);
        return "edit_client";  // Return Thymeleaf view name (edit_client.html)
    }

    // Update client information
    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client client) {
        client.setId(id);
        clientService.saveClient(client);
        return "redirect:/clients";
    }

    // Delete a client
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients";
    }
}
