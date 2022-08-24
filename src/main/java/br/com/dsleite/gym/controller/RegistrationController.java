package br.com.dsleite.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dsleite.gym.entity.Registration;
import br.com.dsleite.gym.entity.form.RegistrationForm;
import br.com.dsleite.gym.service.impl.RegistrationServiceImpl;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private RegistrationServiceImpl service;

    @GetMapping("all")
    public List<Registration> getAll(@RequestParam(value = "student_district", required = false) String studentDistrict) {
        return this.service.getAll(studentDistrict);
    }

    @PostMapping("create")
    public Registration create(@RequestBody RegistrationForm form){
        return service.create(form);
    }

}
