package br.com.dsleite.gym.entity.form;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class StudentForm {
    
    private String name;
    private String cpf;
    private String district;
    private String city;
    private String state;
    private LocalDate birthDate;
    
}
