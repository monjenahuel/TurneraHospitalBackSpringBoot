package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.entity.Paciente;
import com.monjenahuel.sweetmedical.repositorio.PacienteRepository;
import org.aspectj.bridge.Message;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public Paciente newPaciente(Paciente px) {
            return repositorio.save(px);
    }

    @Override
    public Paciente actualizarPaciente(Integer id, Paciente pxModificado) {
        if(repositorio.existsById(id)){
            pxModificado.setId(id);
            repositorio.save(pxModificado);
            return pxModificado;
        }else{
            throw new RuntimeException("Paciente con id " + id + " no existe");
        }
    }

    @Override
    public void eliminarPaciente(Integer id) {
        if(repositorio.existsById(id)){
            repositorio.deleteById(id);
        }else{
            throw new RuntimeException("Paciente con id " + id + " no existe");
        }
    }
}
