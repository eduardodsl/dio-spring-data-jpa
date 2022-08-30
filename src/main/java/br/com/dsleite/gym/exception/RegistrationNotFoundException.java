package br.com.dsleite.gym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistrationNotFoundException extends Exception {

    public RegistrationNotFoundException(Long id) {
        super(String.format("Registration with id %s not found in the system.", id));
    }
}