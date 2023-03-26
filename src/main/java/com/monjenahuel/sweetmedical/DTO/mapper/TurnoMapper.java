package com.monjenahuel.sweetmedical.DTO.mapper;

import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.entity.Turno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TurnoMapper {

    @Mappings({
            @Mapping(source = "id", target = "id_turno"),
            @Mapping(source = "idPaciente", target = "id_paciente"),
            @Mapping(source = "idEspProf", target = "id_especialidad_profesional"),
            @Mapping(source = "fechaHora", target = "fecha_hora"),
    })

    TurnoCreableDTO TurnoATurnoCreableDTO(Turno turno);

    @Mappings({
            @Mapping(source = "id_turno", target = "id"),
            @Mapping(source = "id_paciente", target = "idPaciente"),
            @Mapping(source = "id_especialidad_profesional", target = "idEspProf"),
            @Mapping(source = "fecha_hora", target = "fechaHora")
    })
    Turno TurnoCreableDTOATurno(TurnoCreableDTO turnoCreableDTO);

    Turno TurnoDTOATurno(TurnoDTO turnoDTO);

    TurnoDTO TurnoATurnoDTO(Turno turno);
}
