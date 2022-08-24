package br.com.dsleite.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dsleite.gym.entity.PhysicalEvaluation;
import br.com.dsleite.gym.entity.Student;
import br.com.dsleite.gym.entity.form.StudentForm;
import br.com.dsleite.gym.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentServiceImpl service;

    @GetMapping("all")
    public List<Student> getAll() {
        return this.service.getAll();
    }

    @PostMapping("create")
    public Student create(@RequestBody StudentForm form){
        return service.create(form);
    }
    
    @GetMapping("evaluations/{id}")
    public List<PhysicalEvaluation> evaluations(@PathVariable Long id){
        List<PhysicalEvaluation> evaluations = this.service.getStudentEvaluations(id);
        return evaluations;
    }

}
