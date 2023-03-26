package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Paciente;
import com.monjenahuel.sweetmedical.entity.Profesional;

import java.util.List;
import java.util.Optional;

public interface PacienteServicio {
    public List<Paciente> getAllPacientes();

    public Optional<Paciente> getPacienteByID(Integer id);

    public Paciente newPaciente(Paciente px);

    public Paciente actualizarPaciente(Integer id, Paciente pxModificado);

    public void eliminarPaciente(Integer id);

    boolean existsById(Integer id);

    boolean existsByDni(String dni);
}
