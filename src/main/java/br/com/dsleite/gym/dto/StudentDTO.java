package br.com.dsleite.gym.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    
    private long id;

    @NotNull
    @Length(min = 2, max = 100)
    private String name;
    
    @NotNull
    @CPF
    private String cpf;
    
    @NotNull
    private String district;
    
    @NotNull
    private String city;
    
    @NotNull
    @Length(min = 2, max = 2)
    private String state;
    
    @NotNull
    private LocalDate birthDate;

}
