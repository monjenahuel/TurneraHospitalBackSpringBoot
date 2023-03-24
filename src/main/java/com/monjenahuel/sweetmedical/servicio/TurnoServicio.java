package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoServicio {

    public List<Turno> getAllTurnos();

    public Optional<Turno> getTurnoByID(Integer id);

    public Turno actualizarTurno();

    public Optional<Turno> eliminarTurnoByID(Integer id);

    public TurnoCreableDTO crearNuevoTurno(TurnoCreableDTO turno);

}
