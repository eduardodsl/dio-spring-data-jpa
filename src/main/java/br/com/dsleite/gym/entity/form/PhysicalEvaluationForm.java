package br.com.dsleite.gym.entity.form;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhysicalEvaluationForm {
    
    private Long studentId;
    private LocalDateTime evaluationDate = LocalDateTime.now();
    private double currentWeight;
    private double currentHeight;
    
}
