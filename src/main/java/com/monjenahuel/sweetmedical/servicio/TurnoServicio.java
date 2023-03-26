package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoServicio {

    List<Turno> getAllTurnos();

    Optional<Turno> getTurnoByID(Integer id);

     Optional<Turno> eliminarTurnoByID(Integer id);

    TurnoCreableDTO crearNuevoTurno(TurnoCreableDTO turno);

    TurnoCreableDTO actualizarTurno(Integer id, TurnoCreableDTO turnoCreable);

    List<Turno> getAllTurnosOrderByDateASC();

    List<Turno> getTurnosVigentesOrderByDateASC();
}
