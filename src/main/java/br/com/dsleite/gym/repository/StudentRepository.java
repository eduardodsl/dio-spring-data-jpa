package br.com.dsleite.gym.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dsleite.gym.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findByBirthDate(LocalDate birthDate);

}
