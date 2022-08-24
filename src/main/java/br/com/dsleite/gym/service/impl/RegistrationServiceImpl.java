package br.com.dsleite.gym.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsleite.gym.entity.Registration;
import br.com.dsleite.gym.entity.Student;
import br.com.dsleite.gym.entity.form.RegistrationForm;
import br.com.dsleite.gym.entity.form.RegistrationFormUpdate;
import br.com.dsleite.gym.repository.RegistrationRepository;
import br.com.dsleite.gym.repository.StudentRepository;
import br.com.dsleite.gym.service.IRegistrationService;

@Service
public class RegistrationServiceImpl implements IRegistrationService {
    
    @Autowired
    private RegistrationRepository repository;

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public Registration create(RegistrationForm form){
        
        Registration Registration = new Registration();
        Optional<Student> student = studentRepo.findById(form.getStudentId());

        if(student.isPresent()){
            Registration.setStudent(student.get());
            return this.repository.save(Registration);
        }

        return new Registration();
    }

    @Override
    public Registration get(Long id){
        return null;
    }

    @Override
    public List<Registration> getAll(String studentDistrict){
        if(studentDistrict == null) return this.repository.findAll();
        return this.repository.findByStudentDistrict(studentDistrict);
    }

    @Override
    public Registration update(Long id, RegistrationFormUpdate formUpdate){
        return null;
    }

    @Override
    public void delete(Long id){
        
    }
}
