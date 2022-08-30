package br.com.dsleite.gym.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.dsleite.gym.dto.StudentDTO;
import br.com.dsleite.gym.entity.Student;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    Student toModel(StudentDTO studentDTO);
    StudentDTO toDTO(Student student);
}
