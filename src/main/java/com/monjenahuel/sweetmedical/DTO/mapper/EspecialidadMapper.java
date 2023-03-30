package com.monjenahuel.sweetmedical.DTO.mapper;

import com.monjenahuel.sweetmedical.DTO.EspecialidadDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.entity.Turno;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EspecialidadMapper {
    Especialidad especialidadDTOAEspecialidad(EspecialidadDTO especialidadDTO);

    EspecialidadDTO especialidadAEspecialidadDTO (Especialidad especialidad);

    List<EspecialidadDTO> mapToDTOList(List<Especialidad> especialidades);

    List<Especialidad> mapToEntityList(List<EspecialidadDTO> especialidadesDTO);
}
