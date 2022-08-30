package br.com.dsleite.gym.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalEvaluationFormUpdate {
    private double currentWeight;
    private double currentHeight;
}
