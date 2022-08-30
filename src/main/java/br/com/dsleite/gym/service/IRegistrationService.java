package br.com.dsleite.gym.service;

import java.util.List;

import br.com.dsleite.gym.dto.RegistrationDTO;
import br.com.dsleite.gym.entity.form.RegistrationForm;
import br.com.dsleite.gym.entity.form.RegistrationFormUpdate;
import br.com.dsleite.gym.exception.RegistrationNotFoundException;
import br.com.dsleite.gym.exception.StudentNotFoundException;

public interface IRegistrationService {
    public RegistrationDTO create(RegistrationForm form) throws StudentNotFoundException;
    public RegistrationDTO get(Long id) throws RegistrationNotFoundException;
    public List<RegistrationDTO> getAll(String studentDistrict);
    public RegistrationDTO update(Long id, RegistrationFormUpdate formUpdate) throws RegistrationNotFoundException;
    public RegistrationDTO delete(Long id) throws RegistrationNotFoundException;
}
