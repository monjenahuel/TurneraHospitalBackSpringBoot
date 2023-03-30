package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.DTO.TurnoConIdDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoServicio {

    List<Turno> getAllTurnos();

    Optional<Turno> getTurnoByID(Integer id);

     Optional<Turno> eliminarTurnoByID(Integer id);
    Turno crearNuevoTurno(TurnoDTO turno);

    Turno actualizarTurno(Integer id, TurnoConIdDTO turnoActualizado);

    List<Turno> getAllTurnosOrderByDateASC();

    List<Turno> getTurnosVigentesOrderByDateASC();
}
