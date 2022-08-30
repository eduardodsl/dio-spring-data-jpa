package br.com.dsleite.gym.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.dsleite.gym.dto.RegistrationDTO;
import br.com.dsleite.gym.entity.Registration;

@Mapper
public interface RegistrationMapper {
    RegistrationMapper INSTANCE = Mappers.getMapper(RegistrationMapper.class);
    Registration toModel(RegistrationDTO physicalEvaluationDTO);
    RegistrationDTO toDTO(Registration physicalEvaluation);
}
