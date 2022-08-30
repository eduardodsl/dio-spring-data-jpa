package br.com.dsleite.gym.entity.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Past;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationFormUpdate {
    
    @Past(message = "'${validatedValue}' is an invalid date")
    private LocalDateTime registrationDate;
    
}
