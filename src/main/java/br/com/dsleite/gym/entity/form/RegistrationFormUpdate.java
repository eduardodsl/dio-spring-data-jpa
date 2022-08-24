package br.com.dsleite.gym.entity.form;

import java.time.LocalDateTime;

import br.com.dsleite.gym.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationFormUpdate {
    
    private Long id;
    private Student student;
    private LocalDateTime registrationDate;
    
}
