package br.com.dsleite.gym.service;

import java.util.List;

import br.com.dsleite.gym.entity.PhysicalEvaluation;
import br.com.dsleite.gym.entity.Student;
import br.com.dsleite.gym.entity.form.StudentForm;
import br.com.dsleite.gym.entity.form.StudentFormUpdate;

public interface IStudentService {
    public Student create(StudentForm form);
    public Student get(Long id);
    public List<Student> getAll();
    public Student update(Long id, StudentFormUpdate formUpdate);
    public void delete(Long id);
    public List<PhysicalEvaluation> getStudentEvaluations(Long id);
}
