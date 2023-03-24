package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.entity.Turno;
import com.monjenahuel.sweetmedical.repositorio.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoServicioImpl implements TurnoServicio{

    @Autowired
    private TurnoRepository repositorio;


    @Override
    public List<Turno> getAllTurnos(){
        return repositorio.findAll();
    }


    @Override
    public Optional<Turno> getTurnoByID(Integer id) {
        return repositorio.findById(id);
    }


    public Optional<Turno> eliminarTurnoByID(Integer id) {
        if (repositorio.existsById(id)) {
            Optional<Turno> turnoAEliminar = repositorio.findById(id);

            repositorio.deleteById(id);

            return turnoAEliminar;
        } else {
            return null;
        }
    }

    @Override
    public TurnoCreableDTO crearNuevoTurno(TurnoCreableDTO turnoCreable) {

        Integer id = turnoCreable.getId_paciente();
        Integer idEspProf = turnoCreable.getId_especialidad_profesional();
        LocalDateTime fechaHora = turnoCreable.getFecha_hora();

        Turno turno = new Turno(id,idEspProf,fechaHora);

       try {
           Integer newID = repositorio.save(turno).getId();
           turnoCreable.setId_turno(newID);

           return turnoCreable;

       }catch (Exception e){
           System.out.println(e);

           return null;
       }

    }


    @Override
    public Turno actualizarTurno() {
        return null;
    }



}
