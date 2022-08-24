package br.com.dsleite.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsleite.gym.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
