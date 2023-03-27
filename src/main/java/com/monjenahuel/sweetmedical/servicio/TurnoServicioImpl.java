package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.TurnoMapper;
import com.monjenahuel.sweetmedical.entity.Turno;
import com.monjenahuel.sweetmedical.exepction.AlreadyExistException;
import com.monjenahuel.sweetmedical.exepction.NotFoundException;
import com.monjenahuel.sweetmedical.repositorio.TurnoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurnoServicioImpl implements TurnoServicio{


    private final TurnoMapper mapper;

    private final TurnoRepository repositorio;


    public TurnoServicioImpl(TurnoMapper mapper, TurnoRepository repositorio) {
        this.mapper = mapper;
        this.repositorio = repositorio;
    }

    @Override
    public List<Turno> getAllTurnos(){
        return repositorio.findAll();
    }

    @Override //Los trae ordenados de menor a mayor fecha
    public List<Turno> getAllTurnosOrderByDateASC(){
        return repositorio.findAll(Sort.by(Sort.Direction.ASC, "fechaHora"));
    }

    @Override //Los trae ordenados de menor a mayor fecha
    public List<Turno> getTurnosVigentesOrderByDateASC(){

        LocalDate fechaDeHoy = LocalDate.now();

        return repositorio.findAll(Sort.by(Sort.Direction.ASC, "fechaHora")).stream()
                .filter(t -> t.getFechaHora().isAfter(fechaDeHoy.atStartOfDay()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Turno> getTurnoByID(Integer id) {
        return repositorio.findById(id);
    }

    @Transactional
    @Override
    public Optional<Turno> eliminarTurnoByID(Integer id) throws NotFoundException{
        if (repositorio.existsById(id)) {
            Optional<Turno> turnoAEliminar = repositorio.findById(id);
            repositorio.deleteById(id);
            return turnoAEliminar;
        } else {
            throw new NotFoundException("Turno no encontrado");
        }
    }

    @Transactional
    @Override
    public TurnoCreableDTO crearNuevoTurno(TurnoCreableDTO turnoCreable) {

        Turno turno = mapper.TurnoCreableDTOATurno(turnoCreable);

        if (turno.getId() != null && repositorio.existsById(turno.getId()))  {
            throw new AlreadyExistException("Ya existe un turno con ese ID");
        }

        TurnoCreableDTO turnoResponse = mapper.TurnoATurnoCreableDTO(repositorio.save(turno));

        return turnoResponse;

    }
    @Transactional
    @Override
    public TurnoCreableDTO actualizarTurno(Integer id, TurnoCreableDTO turnoCreable) {
        if(repositorio.existsById(id)){

            Turno turno = mapper.TurnoCreableDTOATurno(turnoCreable);
            turno.setId(id);

            repositorio.save(turno);
            turnoCreable.setId_turno(id);
            return turnoCreable;


        }else{
            throw new NotFoundException("El turno indicado no se encuentra");
        }


    }



}
