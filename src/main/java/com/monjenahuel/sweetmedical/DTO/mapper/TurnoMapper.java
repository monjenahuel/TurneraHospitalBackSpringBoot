package com.monjenahuel.sweetmedical.DTO.mapper;

import com.monjenahuel.sweetmedical.DTO.EspecialidadDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoConIdDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.entity.Especialidad;
import com.monjenahuel.sweetmedical.entity.Turno;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurnoMapper {

    Turno TurnoDTOATurno(TurnoDTO turnoDTO);

    TurnoDTO TurnoATurnoDTO(Turno turno);

    List<TurnoDTO> mapToDTOList(List<Turno> turnos);

    List<Turno> mapToEntityList(List<TurnoDTO> turnosDTO);

    Turno TurnoDTOconIdATurno(TurnoConIdDTO turnoConIdDTO);

    TurnoConIdDTO TurnoATurnoDTOconId(Turno turno);

    List<TurnoConIdDTO> mapToDTOwithIDList(List<Turno> turnos);

    List<Turno> mapwithIDToEntityList(List<TurnoConIdDTO> turnosConIdDTO);

}
