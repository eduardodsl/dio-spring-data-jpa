package br.com.dsleite.gym.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDTO {
    
    private Long id;
    
    @NotNull
    private StudentDTO student;
    
    @NotNull
    @Past
    private LocalDateTime registrationDate;

}
