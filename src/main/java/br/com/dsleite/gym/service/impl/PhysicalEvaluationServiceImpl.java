package br.com.dsleite.gym.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsleite.gym.entity.PhysicalEvaluation;
import br.com.dsleite.gym.entity.Student;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationForm;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationFormUpdate;
import br.com.dsleite.gym.repository.PhysicalEvaluationRepository;
import br.com.dsleite.gym.repository.StudentRepository;
import br.com.dsleite.gym.service.IPhysicalEvaluationService;

@Service
public class PhysicalEvaluationServiceImpl implements IPhysicalEvaluationService {
    
    @Autowired
    private PhysicalEvaluationRepository repository;

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public PhysicalEvaluation create(PhysicalEvaluationForm form){
        
        PhysicalEvaluation physicalEvaluation = new PhysicalEvaluation();
        Optional<Student> student = studentRepo.findById(form.getStudentId());

        if(student.isPresent()){
            physicalEvaluation.setStudent(student.get());
            physicalEvaluation.setCurrentHeight(form.getCurrentHeight());
            physicalEvaluation.setCurrentWeight(form.getCurrentWeight());
            return this.repository.save(physicalEvaluation);
        }

        return new PhysicalEvaluation();
    }

    @Override
    public PhysicalEvaluation get(Long id){
        return null;
    }

    @Override
    public List<PhysicalEvaluation> getAll(){
        return this.repository.findAll();
    }

    @Override
    public PhysicalEvaluation update(Long id, PhysicalEvaluationFormUpdate formUpdate){
        return null;
    }

    @Override
    public void delete(Long id){
        
    }
}
