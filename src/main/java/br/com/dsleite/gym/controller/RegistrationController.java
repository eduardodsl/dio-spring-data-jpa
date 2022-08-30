package br.com.dsleite.gym.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dsleite.gym.dto.DefaultResponseDTO;
import br.com.dsleite.gym.dto.RegistrationDTO;
import br.com.dsleite.gym.entity.form.RegistrationForm;
import br.com.dsleite.gym.entity.form.RegistrationFormUpdate;
import br.com.dsleite.gym.exception.RegistrationNotFoundException;
import br.com.dsleite.gym.exception.StudentNotFoundException;
import br.com.dsleite.gym.service.impl.RegistrationServiceImpl;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private RegistrationServiceImpl service;

    @GetMapping("all")
    public DefaultResponseDTO<List<RegistrationDTO>> getAll(@RequestParam(value = "student_district", required = false) String studentDistrict) throws RegistrationNotFoundException {
        DefaultResponseDTO<List<RegistrationDTO>> response = new DefaultResponseDTO<>("REGISTRATION_FETCHED", true, this.service.getAll(studentDistrict));
        return response;
    }

    @GetMapping("{id}")
    public DefaultResponseDTO<RegistrationDTO> get(@PathVariable Long id) throws RegistrationNotFoundException {
        DefaultResponseDTO<RegistrationDTO> response = new DefaultResponseDTO<>("REGISTRATION_FETCHED", true, this.service.get(id));
        return response;
    }
    
    @PostMapping("create")
    public DefaultResponseDTO<RegistrationDTO> create(@RequestBody RegistrationForm form) throws StudentNotFoundException{
        DefaultResponseDTO<RegistrationDTO> response = new DefaultResponseDTO<>("REGISTRATION_CREATED", true, this.service.create(form));
        return response;
    }

    @PutMapping("{id}")
    public DefaultResponseDTO<RegistrationDTO> update(@PathVariable Long id, @Valid @RequestBody RegistrationFormUpdate form) throws RegistrationNotFoundException {
        DefaultResponseDTO<RegistrationDTO> response = new DefaultResponseDTO<>("REGISTRATION_UPDATED", true, service.update(id, form));
        return response;
    }

    @DeleteMapping("{id}")
    public DefaultResponseDTO<RegistrationDTO> delete(@PathVariable Long id) throws RegistrationNotFoundException {
        DefaultResponseDTO<RegistrationDTO> response = new DefaultResponseDTO<>("REGISTRATION_DELETED", true, service.delete(id));
        return response;
    }

}
