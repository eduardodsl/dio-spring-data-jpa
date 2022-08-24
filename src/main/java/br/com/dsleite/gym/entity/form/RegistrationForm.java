package br.com.dsleite.gym.entity.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationForm {
    
    @NotBlank
    private Long studentId;

    @Past(message = "'${validatedValue}' is an invalid date")
    private LocalDateTime registrationDate;
    
}
