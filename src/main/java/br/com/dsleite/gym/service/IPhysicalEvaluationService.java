package br.com.dsleite.gym.service;

import java.util.List;

import br.com.dsleite.gym.dto.PhysicalEvaluationDTO;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationForm;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationFormUpdate;
import br.com.dsleite.gym.exception.PhysicalEvaluationNotFoundException;
import br.com.dsleite.gym.exception.StudentNotFoundException;

public interface IPhysicalEvaluationService {
    public PhysicalEvaluationDTO create(PhysicalEvaluationForm form) throws StudentNotFoundException;
    public PhysicalEvaluationDTO get(Long id) throws PhysicalEvaluationNotFoundException;
    public List<PhysicalEvaluationDTO> getAll();
    public PhysicalEvaluationDTO update(Long id, PhysicalEvaluationFormUpdate formUpdate)  throws PhysicalEvaluationNotFoundException;
    public PhysicalEvaluationDTO delete(Long id) throws PhysicalEvaluationNotFoundException;
}
