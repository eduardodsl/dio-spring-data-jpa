package br.com.dsleite.gym.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsleite.gym.dto.PhysicalEvaluationDTO;
import br.com.dsleite.gym.entity.PhysicalEvaluation;
import br.com.dsleite.gym.entity.Student;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationForm;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationFormUpdate;
import br.com.dsleite.gym.exception.PhysicalEvaluationNotFoundException;
import br.com.dsleite.gym.exception.StudentNotFoundException;
import br.com.dsleite.gym.mapper.PhysicalEvaluationMapper;
import br.com.dsleite.gym.repository.PhysicalEvaluationRepository;
import br.com.dsleite.gym.repository.StudentRepository;
import br.com.dsleite.gym.service.IPhysicalEvaluationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PhysicalEvaluationServiceImpl implements IPhysicalEvaluationService {
    
    private final PhysicalEvaluationRepository repository;
    private final PhysicalEvaluationMapper evaluationMapper = PhysicalEvaluationMapper.INSTANCE;
    private final StudentRepository studentRepo;

    @Override
    public PhysicalEvaluationDTO create(PhysicalEvaluationForm form) throws StudentNotFoundException {
        
        PhysicalEvaluation physicalEvaluation = new PhysicalEvaluation();
        Optional<Student> student = studentRepo.findById(form.getStudentId());

        if(student.isPresent()){
            physicalEvaluation.setStudent(student.get());
            physicalEvaluation.setCurrentHeight(form.getCurrentHeight());
            physicalEvaluation.setCurrentWeight(form.getCurrentWeight());
            PhysicalEvaluationDTO dto = evaluationMapper.toDTO(this.repository.save(physicalEvaluation));
            return dto;
        }

        throw new StudentNotFoundException(form.getStudentId());
    }

    @Override
    public PhysicalEvaluationDTO get(Long id) throws PhysicalEvaluationNotFoundException {
        Optional<PhysicalEvaluation> evaluation = this.repository.findById(id);
        if(evaluation.isPresent()){
            PhysicalEvaluationDTO dto = this.evaluationMapper.toDTO(evaluation.get());
            return dto;
        }
        throw new PhysicalEvaluationNotFoundException(id);
    }

    @Override
    public List<PhysicalEvaluationDTO> getAll(){
        return this.repository
            .findAll()
            .stream()
            .map(evaluationMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public PhysicalEvaluationDTO update(Long id, PhysicalEvaluationFormUpdate form) throws PhysicalEvaluationNotFoundException {
        
        Optional<PhysicalEvaluation> physicalEvaluation = this.repository.findById(id);
        if(physicalEvaluation.isPresent()){
            PhysicalEvaluation physicalEvaluationToUpdate = physicalEvaluation.get();
            physicalEvaluationToUpdate.setCurrentHeight(form.getCurrentHeight());
            physicalEvaluationToUpdate.setCurrentWeight(form.getCurrentWeight());
            PhysicalEvaluation result = this.repository.save(physicalEvaluation.get());
            return this.evaluationMapper.toDTO(result);
        }
        throw new PhysicalEvaluationNotFoundException(id);

    }

    @Override
    public PhysicalEvaluationDTO delete(Long id) throws PhysicalEvaluationNotFoundException{
        Optional<PhysicalEvaluation> physicalEvaluation = this.repository.findById(id);
        if(physicalEvaluation.isPresent()){
            this.repository.delete(physicalEvaluation.get());
            return this.evaluationMapper.toDTO(physicalEvaluation.get());
        }
        throw new PhysicalEvaluationNotFoundException(id);
    }

}
