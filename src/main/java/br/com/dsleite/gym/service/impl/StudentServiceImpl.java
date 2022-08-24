package br.com.dsleite.gym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Student> getAll(){
        return this.repository.findAll();
    }

    @Override
    public Student update(Long id, StudentFormUpdate formUpdate){
        return null;
    }

    @Override
    public void delete(Long id){
        
    }
}
