package br.com.dsleite.gym.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dsleite.gym.dto.RegistrationDTO;
import br.com.dsleite.gym.entity.Registration;
import br.com.dsleite.gym.entity.Student;
import br.com.dsleite.gym.entity.form.RegistrationForm;
import br.com.dsleite.gym.entity.form.RegistrationFormUpdate;
import br.com.dsleite.gym.exception.RegistrationNotFoundException;
import br.com.dsleite.gym.exception.StudentNotFoundException;
import br.com.dsleite.gym.mapper.RegistrationMapper;
import br.com.dsleite.gym.repository.RegistrationRepository;
import br.com.dsleite.gym.repository.StudentRepository;
import br.com.dsleite.gym.service.IRegistrationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationServiceImpl implements IRegistrationService {
    
    private final RegistrationRepository repository;
    private final RegistrationMapper registrationMapper = RegistrationMapper.INSTANCE;
    private final StudentRepository studentRepo;

    @Override
    public RegistrationDTO create(RegistrationForm form) throws StudentNotFoundException {
        
        Registration registration = new Registration();
        Optional<Student> student = studentRepo.findById(form.getStudentId());

        if(student.isPresent()){
            registration.setStudent(student.get());
            RegistrationDTO dto = registrationMapper.toDTO(this.repository.save(registration));
            return dto;
        }

        throw new StudentNotFoundException(form.getStudentId());
    }

    @Override
    public RegistrationDTO get(Long id) throws RegistrationNotFoundException{
        Optional<Registration> registration = this.repository.findById(id);
        if(registration.isPresent()){
            RegistrationDTO dto = this.registrationMapper.toDTO(registration.get());
            return dto;
        }
        throw new RegistrationNotFoundException(id);
    }

    @Override
    public List<RegistrationDTO> getAll(String studentDistrict){
        if(studentDistrict == null){
            return this.repository
            .findAll()
            .stream()
            .map(registrationMapper::toDTO)
            .collect(Collectors.toList());
        }
        return this.repository
        .findByStudentDistrict(studentDistrict)
        .stream()
        .map(registrationMapper::toDTO)
        .collect(Collectors.toList());
    }

    @Override
    public RegistrationDTO update(Long id, RegistrationFormUpdate form) throws RegistrationNotFoundException{
        Optional<Registration> registration = this.repository.findById(id);
        if(registration.isPresent()){
            Registration registrationToUpdate = registration.get();
            registrationToUpdate.setRegistrationDate(form.getRegistrationDate());
            Registration result = this.repository.save(registrationToUpdate);
            return this.registrationMapper.toDTO(result);
        }
        throw new RegistrationNotFoundException(id);
    }

    @Override
    public RegistrationDTO delete(Long id) throws RegistrationNotFoundException {
        Optional<Registration> registration = this.repository.findById(id);
        if(registration.isPresent()){
            Registration registrationToDelete = registration.get();
            this.repository.delete(registrationToDelete);
            return this.registrationMapper.toDTO(registrationToDelete);
        }
        throw new RegistrationNotFoundException(id);
    }
}
