package br.com.dsleite.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dsleite.gym.entity.PhysicalEvaluation;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationForm;
import br.com.dsleite.gym.service.impl.PhysicalEvaluationServiceImpl;

@RestController
@RequestMapping("/physical-evaluation")
public class PhysicalEvaluationController {
    @Autowired
    private PhysicalEvaluationServiceImpl service;

    @GetMapping("all")
    public List<PhysicalEvaluation> getAll() {
        return this.service.getAll();
    }

    @PostMapping("create")
    public PhysicalEvaluation create(@RequestBody PhysicalEvaluationForm form){
        return service.create(form);
    }
}
