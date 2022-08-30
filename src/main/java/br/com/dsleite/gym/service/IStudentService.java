package br.com.dsleite.gym.service;

import java.util.List;

import br.com.dsleite.gym.dto.PhysicalEvaluationDTO;
import br.com.dsleite.gym.dto.StudentDTO;
import br.com.dsleite.gym.entity.form.StudentForm;
import br.com.dsleite.gym.entity.form.StudentFormUpdate;
import br.com.dsleite.gym.exception.StudentNotFoundException;

public interface IStudentService {
    public StudentDTO create(StudentForm form);
    public StudentDTO get(Long id) throws StudentNotFoundException;
    public List<StudentDTO> getAll(String birthDate);
    public StudentDTO update(Long id, StudentFormUpdate form) throws StudentNotFoundException;
    public StudentDTO delete(Long id) throws StudentNotFoundException;
    public List<PhysicalEvaluationDTO> getStudentEvaluations(Long id) throws StudentNotFoundException;
}
