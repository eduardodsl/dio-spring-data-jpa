package br.com.dsleite.gym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(String studentName) {
        super(String.format("Student with name %s not found in the system.", studentName));
    }

    public StudentNotFoundException(Long id) {
        super(String.format("Student with id %s not found in the system.", id));
    }
}