package br.com.dsleite.gym.service;

import java.util.List;

import br.com.dsleite.gym.entity.Registration;
import br.com.dsleite.gym.entity.form.RegistrationForm;
import br.com.dsleite.gym.entity.form.RegistrationFormUpdate;

public interface IRegistrationService {
    public Registration create(RegistrationForm form);
    public Registration get(Long id);
    public List<Registration> getAll(String studentDistrict);
    public Registration update(Long id, RegistrationFormUpdate formUpdate);
    public void delete(Long id);
}
