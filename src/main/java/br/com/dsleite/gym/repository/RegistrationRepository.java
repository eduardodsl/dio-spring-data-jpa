package br.com.dsleite.gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsleite.gym.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    
    public List<Registration> findByStudentDistrict(String studentDistrict);

}
