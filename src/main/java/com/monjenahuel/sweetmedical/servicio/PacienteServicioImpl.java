package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Paciente;
import com.monjenahuel.sweetmedical.exception.AlreadyExistException;
import com.monjenahuel.sweetmedical.exception.NotFoundException;
import com.monjenahuel.sweetmedical.repositorio.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PacienteServicioImpl implements PacienteServicio{

    @Autowired
    private PacienteRepository repositorio;

    @Override
    public List<Paciente> getAllPacientes() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteByID(Integer id) {
        return repositorio.findById(id);
    }

    @Transactional
    @Override
    public Paciente newPaciente(Paciente px) {

        if(px.getId() != null && repositorio.existsById(px.getId())){
            throw new AlreadyExistException("El paciente con ID " + px.getId() + " ya existe. No necesitas indicar un ID");
        }

        if(repositorio.existsByDni(px.getDni())){
            throw new AlreadyExistException("Paciente con DNI " + px.getDni() + " ya existe");
        }

        Paciente pacienteCreado = repositorio.save(px);

        return pacienteCreado;
    }

    @Transactional
    @Override
    public Paciente actualizarPaciente(Integer id, Paciente pxModificado) {

        Optional<Paciente> pacienteConMismoDNI = repositorio.findByDni(pxModificado.getDni());

        if(pacienteConMismoDNI.isPresent() && !Objects.equals(pacienteConMismoDNI.get().getId(),id)){
            throw new AlreadyExistException("Paciente con DNI " + pxModificado.getDni() + " ya existe");
        }
        if(repositorio.existsById(id)){
            pxModificado.setId(id);
            repositorio.save(pxModificado);
            return pxModificado;
        }else{
            throw new NotFoundException("Paciente con id " + id + " no existe");
        }
    }

    @Transactional
    @Override
    public void eliminarPaciente(Integer id) {
        if(repositorio.existsById(id)){
            repositorio.deleteById(id);
        }else{
            throw new RuntimeException("Paciente con id " + id + " no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return repositorio.existsById(id);
    }

    @Override
    public boolean existsByDni(String dni) {
        return repositorio.existsByDni(dni);
    }
}
