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
import org.springframework.web.bind.annotation.RestController;

import br.com.dsleite.gym.dto.DefaultResponseDTO;
import br.com.dsleite.gym.dto.PhysicalEvaluationDTO;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationForm;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationFormUpdate;
import br.com.dsleite.gym.exception.PhysicalEvaluationNotFoundException;
import br.com.dsleite.gym.exception.StudentNotFoundException;
import br.com.dsleite.gym.service.impl.PhysicalEvaluationServiceImpl;

@RestController
@RequestMapping("/physical-evaluation")
public class PhysicalEvaluationController {
    @Autowired
    private PhysicalEvaluationServiceImpl service;

    @GetMapping("{id}")
    public DefaultResponseDTO<PhysicalEvaluationDTO> get(@PathVariable Long id) throws PhysicalEvaluationNotFoundException {
        DefaultResponseDTO<PhysicalEvaluationDTO> response = new DefaultResponseDTO<>("EVALUATION_FETCHED", true, this.service.get(id));
        return response;
    }

    @GetMapping("all")
    public DefaultResponseDTO<List<PhysicalEvaluationDTO>> getAll() {
        DefaultResponseDTO<List<PhysicalEvaluationDTO>> response = new DefaultResponseDTO<>("EVALUATION_FETCHED", true, this.service.getAll());
        return response;
    }

    @PostMapping("create")
    public DefaultResponseDTO<PhysicalEvaluationDTO> create(@RequestBody PhysicalEvaluationForm form) throws StudentNotFoundException{
        DefaultResponseDTO<PhysicalEvaluationDTO> response = new DefaultResponseDTO<>("EVALUATION_CREATED", true, service.create(form));
        return response;
    }

    @PutMapping("{id}")
    public DefaultResponseDTO<PhysicalEvaluationDTO> update(@PathVariable Long id, @Valid @RequestBody PhysicalEvaluationFormUpdate form) throws PhysicalEvaluationNotFoundException {
        DefaultResponseDTO<PhysicalEvaluationDTO> response = new DefaultResponseDTO<>("EVALUATION_UPDATED", true, this.service.update(id, form));
        return response;
    }

    @DeleteMapping("{id}")
    public DefaultResponseDTO<PhysicalEvaluationDTO> delete(@PathVariable Long id) throws PhysicalEvaluationNotFoundException {
        DefaultResponseDTO<PhysicalEvaluationDTO> response = new DefaultResponseDTO<>("EVALUATION_DELETED", true, this.service.delete(id));
        return response;
    }

}
