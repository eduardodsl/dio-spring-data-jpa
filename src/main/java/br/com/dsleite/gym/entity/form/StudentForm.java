package br.com.dsleite.gym.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentForm {
    
    @NotBlank(message = "Field name cannot be empty")
    @Size(min = 3, max = 100, message = "${validatedValue} needs to be between {min} and {max} characters long")
    private String name;
    
    @NotBlank(message = "CPF cannot be empty")
    @CPF(message = "o cpf '${validatedValue}' é inválido")
    private String cpf;

    @NotBlank(message = "Field district cannbot be empty")
    @Size(min = 3, max = 20, message = "${validatedValue} needs to be between {min} and {max} characters long")
    private String district;
    
    @NotBlank(message = "Field city cannbot be empty")
    @Size(min = 3, max = 20, message = "${validatedValue} needs to be between {min} and {max} characters long")
    private String city;
    
    @NotBlank(message = "Field state cannbot be empty")
    @Size(min = 2, max = 2, message = "${validatedValue} needs to have 2 characters")
    private String state;
    
    @Past(message = "'${validatedValue}' is an invalid date")
    private LocalDate birthDate;
    
}
