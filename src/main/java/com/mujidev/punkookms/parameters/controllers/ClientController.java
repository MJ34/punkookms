package com.mujidev.punkookms.parameters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mujidev.punkookms.parameters.models.Client;
import com.mujidev.punkookms.parameters.services.ClientService;
import com.mujidev.punkookms.parameters.services.CountryService;
import com.mujidev.punkookms.parameters.services.StateService;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;

    public Model addModelAttributes(Model model) {
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("states", stateService.findAll());
        return model;
    }

    @GetMapping("/parameters/clients")
    public String findAll(Model model) {
        addModelAttributes(model);
        return "/parameters/clients";
    }

    @GetMapping("/parameters/clientAdd")
    public String addClient(Model model) {
        model.addAttribute("countries", countryService.findAll());
        return "parameters/clientAdd";
    }

    // The op parameter is either Edit or Details
    @GetMapping("/parameters/client/Edit/{id}")
    public String editClient(@PathVariable("id") Long id, Model model) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        addModelAttributes(model);
        return "/parameters/clientEdit"; // returns clientEdit or clientDetails
    }

    @PostMapping("/parameters/clients")
    public String save(Client client) {
        clientService.save(client);
        return "redirect:/parameters/clients";
    }

    @RequestMapping(value = "/parameters/clients/delete/{id}", method = { RequestMethod.DELETE, RequestMethod.GET })
    public String deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
        return "redirect:/parameters/clients";
    }
}
