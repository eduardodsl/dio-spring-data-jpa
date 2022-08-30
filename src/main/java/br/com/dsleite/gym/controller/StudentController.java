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
import br.com.dsleite.gym.dto.PhysicalEvaluationDTO;
import br.com.dsleite.gym.dto.StudentDTO;
import br.com.dsleite.gym.entity.form.StudentForm;
import br.com.dsleite.gym.entity.form.StudentFormUpdate;
import br.com.dsleite.gym.exception.StudentNotFoundException;
import br.com.dsleite.gym.service.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
    
    @Autowired
    private final StudentServiceImpl service;

    @GetMapping("all")
    public DefaultResponseDTO<List<StudentDTO>> getAll(@RequestParam(value = "birth_date", required = false) String birthDate) {
        DefaultResponseDTO<List<StudentDTO>> response = new DefaultResponseDTO<List<StudentDTO>>("STUDENT_FECHED", true, this.service.getAll(birthDate));
        return response;
    }

    @GetMapping("{id}")
    public DefaultResponseDTO<StudentDTO> student(@PathVariable Long id) throws StudentNotFoundException {
        DefaultResponseDTO<StudentDTO> response = new DefaultResponseDTO<>("STUDENT_FETCHED", true, this.service.get(id));
        return response;
    }

    @PostMapping("create")
    public DefaultResponseDTO<StudentDTO> create(@Valid @RequestBody StudentForm form){
        DefaultResponseDTO<StudentDTO> response = new DefaultResponseDTO<>("STUDENT_CREATED", true, service.create(form));
        return response;
    }

    @PutMapping("{id}")
    public DefaultResponseDTO<StudentDTO> update(@PathVariable Long id, @Valid @RequestBody StudentFormUpdate form) throws StudentNotFoundException {
        DefaultResponseDTO<StudentDTO> response = new DefaultResponseDTO<>("SUTDENT_UPDATED", true, service.update(id, form));
        return response;
    }

    @DeleteMapping("{id}")
    public DefaultResponseDTO<StudentDTO> delete(@PathVariable Long id) throws StudentNotFoundException {
        DefaultResponseDTO<StudentDTO> response = new DefaultResponseDTO<>("STUDENT_DELETED", true, service.delete(id));
        return response;
    }

    @GetMapping("{id}/evaluations")
    public DefaultResponseDTO<List<PhysicalEvaluationDTO>> evaluations(@PathVariable Long id) throws StudentNotFoundException {
        DefaultResponseDTO<List<PhysicalEvaluationDTO>> response = new DefaultResponseDTO<>("STUDENT_EVALUATIONS_FETCHED", true, this.service.getStudentEvaluations(id));
        return response;
    }

}
