package br.com.dsleite.gym.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsleite.gym.entity.PhysicalEvaluation;
import br.com.dsleite.gym.entity.Student;
import br.com.dsleite.gym.entity.form.StudentForm;
import br.com.dsleite.gym.entity.form.StudentFormUpdate;
import br.com.dsleite.gym.repository.StudentRepository;
import br.com.dsleite.gym.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
    
    @Autowired
    private StudentRepository repository;

    @Override
    public Student create(StudentForm form){
        
        Student student = new Student();
        
        student.setName(form.getName());
        student.setCpf(form.getCpf());
        student.setBirthDate(form.getBirthDate());
        student.setDistrict(form.getDistrict());
        student.setCity(form.getCity());
        student.setState(form.getState());

        return this.repository.save(student);
    }

    @Override
    public Student get(Long id){
        return null;
    }

    @Override
    public List<Student> getAll(String birthDate){
        if(birthDate == null){
            return this.repository.findAll();
        }
        LocalDate bDate = LocalDate.parse(birthDate);
        return this.repository.findByBirthDate(bDate);
    }

    @Override
    public Student update(Long id, StudentFormUpdate formUpdate){
        return null;
    }

    @Override
    public void delete(Long id){
        
    }

    public List<PhysicalEvaluation> getStudentEvaluations(Long id) {
        Optional<Student> student = this.repository.findById(id);
        if(student.isPresent()){
            return student.get().getEvaluations();
        }
        return null;
    }
}
