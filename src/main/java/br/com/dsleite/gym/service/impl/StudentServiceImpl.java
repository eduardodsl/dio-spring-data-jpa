package br.com.dsleite.gym.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsleite.gym.dto.PhysicalEvaluationDTO;
import br.com.dsleite.gym.dto.StudentDTO;
import br.com.dsleite.gym.entity.Student;
import br.com.dsleite.gym.entity.form.StudentForm;
import br.com.dsleite.gym.entity.form.StudentFormUpdate;
import br.com.dsleite.gym.exception.StudentNotFoundException;
import br.com.dsleite.gym.mapper.PhysicalEvaluationMapper;
import br.com.dsleite.gym.mapper.StudentMapper;
import br.com.dsleite.gym.repository.StudentRepository;
import br.com.dsleite.gym.service.IStudentService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImpl implements IStudentService {
    
    private final StudentRepository repository;
    private final StudentMapper studentMapper = StudentMapper.INSTANCE;
    private final PhysicalEvaluationMapper evaluationMapper = PhysicalEvaluationMapper.INSTANCE;

    @Override
    public StudentDTO create(StudentForm form){
        
        Student student = new Student();
        
        student.setName(form.getName());
        student.setCpf(form.getCpf());
        student.setBirthDate(form.getBirthDate());
        student.setDistrict(form.getDistrict());
        student.setCity(form.getCity());
        student.setState(form.getState());

        return studentMapper.toDTO(this.repository.save(student));

    }

    @Override
    public StudentDTO get(Long id) throws StudentNotFoundException{
        Optional<Student> student = this.repository.findById(id);
        if(student.isPresent()){
            return studentMapper.toDTO(student.get());
        }
        throw new StudentNotFoundException(id);
    }

    @Override
    public List<StudentDTO> getAll(String birthDate){
        if(birthDate == null){
            return this.repository
            .findAll()
            .stream()
            .map(studentMapper::toDTO)
            .collect(Collectors.toList());
        }
        LocalDate bDate = LocalDate.parse(birthDate);
        return this.repository
            .findByBirthDate(bDate)
            .stream()
            .map(studentMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public StudentDTO update(Long id, StudentFormUpdate form) throws StudentNotFoundException {
        
        Optional<Student> student = this.repository.findById(id);
        if(student.isPresent()){
            Student studentToUpdate = student.get();
            studentToUpdate.setName(form.getName());
            studentToUpdate.setCpf(form.getCpf());
            studentToUpdate.setBirthDate(form.getBirthDate());
            studentToUpdate.setDistrict(form.getDistrict());
            studentToUpdate.setCity(form.getCity());
            studentToUpdate.setState(form.getState());
            Student result = this.repository.save(student.get());
            return this.studentMapper.toDTO(result);
        }
        throw new StudentNotFoundException(id);

    }

    @Override
    public StudentDTO delete(Long id) throws StudentNotFoundException {
        Optional<Student> student = this.repository.findById(id);
        if(student.isPresent()){
            Student studentToDelete = student.get();
            this.repository.delete(studentToDelete);
            return this.studentMapper.toDTO(studentToDelete);
        }
        throw new StudentNotFoundException(id);
    }

    public List<PhysicalEvaluationDTO> getStudentEvaluations(Long id) throws StudentNotFoundException {
        Optional<Student> student = this.repository.findById(id);
        if(student.isPresent()){
            return student.get().getEvaluations().stream().map(evaluationMapper::toDTO).collect(Collectors.toList());
        }
        throw new StudentNotFoundException(id);
    }
}
