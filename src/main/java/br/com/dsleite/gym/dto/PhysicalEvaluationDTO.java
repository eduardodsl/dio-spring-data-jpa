package br.com.dsleite.gym.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Past;

import br.com.dsleite.gym.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalEvaluationDTO {
    private Long id;
    private Student student;
    @Past
    private LocalDateTime evaluationDate;
    private double currentWeight;
    private double currentHeight;
    
}
