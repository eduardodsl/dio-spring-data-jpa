package br.com.dsleite.gym.service;

import java.util.List;

import br.com.dsleite.gym.entity.PhysicalEvaluation;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationForm;
import br.com.dsleite.gym.entity.form.PhysicalEvaluationFormUpdate;

public interface IPhysicalEvaluationService {
    public PhysicalEvaluation create(PhysicalEvaluationForm form);
    public PhysicalEvaluation get(Long id);
    public List<PhysicalEvaluation> getAll();
    public PhysicalEvaluation update(Long id, PhysicalEvaluationFormUpdate formUpdate);
    public void delete(Long id);
}
