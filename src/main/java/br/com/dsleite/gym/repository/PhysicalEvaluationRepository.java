package br.com.dsleite.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dsleite.gym.entity.PhysicalEvaluation;

public interface PhysicalEvaluationRepository extends JpaRepository<PhysicalEvaluation, Long> {
    
}
