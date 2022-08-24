package br.com.dsleite.gym.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsleite.gym.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findByBirthDate(LocalDate birthDate);

}
