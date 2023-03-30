package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.DTO.TurnoConIdDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.TurnoMapper;
import com.monjenahuel.sweetmedical.entity.Turno;
import com.monjenahuel.sweetmedical.exception.NotFoundException;
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
    public Turno crearNuevoTurno(TurnoDTO turno) {
        Turno turnoAGuardar = mapper.TurnoDTOATurno(turno);

        Turno turnoResponse = repositorio.save(turnoAGuardar);

        return turnoResponse;
    }

    @Transactional
    @Override
    public Turno actualizarTurno(Integer id, TurnoConIdDTO turnoActualizado) {
        if(repositorio.existsById(id)){

            Turno turnoAGuardar = mapper.TurnoDTOconIdATurno(turnoActualizado);

            turnoAGuardar.setId(id);

            return repositorio.save(turnoAGuardar);


        }else{
            throw new NotFoundException("El turno indicado no se encuentra");
        }


    }



}
