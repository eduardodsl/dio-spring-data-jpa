package br.com.dsleite.gym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PhysicalEvaluationNotFoundException extends Exception {
    public PhysicalEvaluationNotFoundException(Long id) {
        super(String.format("Evaluation with id %s not found in the system.", id));
    }
}