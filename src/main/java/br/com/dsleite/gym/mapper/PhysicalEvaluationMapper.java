package br.com.dsleite.gym.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.dsleite.gym.dto.PhysicalEvaluationDTO;
import br.com.dsleite.gym.entity.PhysicalEvaluation;

@Mapper
public interface PhysicalEvaluationMapper {
    PhysicalEvaluationMapper INSTANCE = Mappers.getMapper(PhysicalEvaluationMapper.class);
    PhysicalEvaluation toModel(PhysicalEvaluationDTO physicalEvaluationDTO);
    PhysicalEvaluationDTO toDTO(PhysicalEvaluation physicalEvaluation);
}
