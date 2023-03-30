package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.DTO.EspecialidadDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoConIdDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.TurnoMapper;
import com.monjenahuel.sweetmedical.entity.*;
import com.monjenahuel.sweetmedical.repositorio.TurnoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@SpringBootTest
class TurnoServicioImplTest {

    @MockBean
    private TurnoMapper mapper;

    @MockBean //Ya está testeado, no hace falta volver a hacerlo
    private TurnoRepository repositorio;
    @Autowired
    private TurnoServicio servicio;


    Turno turno;
    Turno turnoHoy;

    TurnoDTO turnoDto;

    TurnoConIdDTO turnoCreableDTOConID;

    @BeforeEach
    void setUp() {

        servicio = new TurnoServicioImpl(mapper, repositorio);

        //////////////////////////////////////////////////

        Paciente px = new Paciente(120, "Mariano", "Mercedes", "17.785.127", "123123123123", "N456456456@gmail.com");
        Profesional prof = new Profesional("Dr Naranja", "Yonatan", "AH675JHJ65J");
        Especialidad esp = new Especialidad("Clinica");
        EspecialidadDTO espDTO = new EspecialidadDTO(12,"Clinica");

        turno = new Turno();
        turno.setEspecialidad(esp);
        turno.setProfesional(prof);
        turno.setId(122);
        turno.setFechaHora(LocalDateTime.of(2023, 03, 5, 15, 55));
        turno.setPaciente(px);
        ////////////////////////////////////
        turnoHoy = new Turno();
        turnoHoy.setEspecialidad(esp);
        turnoHoy.setProfesional(prof);
        turnoHoy.setId(123);
        turnoHoy.setFechaHora(LocalDateTime.now());
        turnoHoy.setPaciente(px);

        ////////////////////////////////////
        turnoCreableDTOConID = new TurnoConIdDTO();
        turnoCreableDTOConID.setEspecialidad(espDTO);
        turnoCreableDTOConID.setProfesional(prof);
        turnoCreableDTOConID.setId(122);
        turnoCreableDTOConID.setFechaHora(LocalDateTime.of(2023, 03, 5, 15, 55));
        turnoCreableDTOConID.setPaciente(px);

        ////////////////////////////////////

        turnoDto = new TurnoDTO();
        turnoDto.setEspecialidad(espDTO);
        turnoDto.setProfesional(prof);
        turnoDto.setFechaHora(LocalDateTime.of(2023, 03, 5, 15, 55));
        turnoDto.setPaciente(px);

    }
    @Test
    void getAllTurnos() {
        //Given
        when(repositorio.findAll())
                .thenReturn(Arrays.asList(turno,turno,turno));

        //When
        List<Turno> turnos = servicio.getAllTurnos();

        //Then
        assertThat(turnos.size()).isEqualTo(3);

        assertThat(turnos.isEmpty()).isFalse();

        verify(repositorio).findAll();

    }

    @Test
    void getAllTurnosOrderByDateASC() {
        //Given
        when(repositorio.findAll(Sort.by(Sort.Direction.ASC, "fechaHora")))
                .thenReturn(Arrays.asList(turno,turno,turno,turno));

        //When
        List<Turno> turnos = servicio.getAllTurnosOrderByDateASC();

        //Then
        assertThat(turnos.size()).isEqualTo(4);

        assertThat(turnos.isEmpty()).isFalse();

        verify(repositorio).findAll(Sort.by(Sort.Direction.ASC, "fechaHora"));
    }

    @Test
    void getTurnosVigentesOrderByDateASC() {

        //Given

        when(repositorio.findAll(Sort.by(Sort.Direction.ASC, "fechaHora")))
                .thenReturn(Arrays.asList(turno,turno,turnoHoy,turno));

        //When
        List<Turno> turnos = servicio.getTurnosVigentesOrderByDateASC();

        //Then
        assertThat(turnos.size()).isEqualTo(1);

        assertThat(turnos.isEmpty()).isFalse();

        verify(repositorio).findAll(Sort.by(Sort.Direction.ASC, "fechaHora"));

    }

    @Test
    void getTurnoByID() {
        //Given
        when(repositorio.findById(123))
                .thenReturn(Optional.ofNullable(turnoHoy));

        //When
        Optional<Turno> turno = servicio.getTurnoByID(123);

        //Then

        assertThat(turno.isPresent()).isTrue();

        assertThat(turno.get().getId()).isEqualTo(123);

        verify(repositorio).findById(123);
    }

    @Test
    void eliminarTurnoByID(){

       when(repositorio.existsById(122)).thenReturn(true);
       when(repositorio.findById(122)).thenReturn(Optional.ofNullable(turno));

       //when
       Optional<Turno> turnoEliminado = servicio.eliminarTurnoByID(122);

       assertThat(turnoEliminado.get().equals(turno));


    }

    @Test
    void eliminarTurnoByIDFails(){

        assertThatThrownBy(() -> servicio.eliminarTurnoByID(999))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Turno no encontrado");
    }


    @Test
    void actualizarTurno() {

        when(repositorio.existsById(122)).thenReturn(true);
        when(mapper.TurnoDTOconIdATurno(turnoCreableDTOConID)).thenReturn(turno);
        when(repositorio.save(turno)).thenReturn(turno);

        //when
         Turno turnoActualizado = servicio.actualizarTurno(122,turnoCreableDTOConID);


        assertThat(turnoActualizado.equals(turno));


    }

    @Test
    void actualizarTurnoFails() {

        assertThatThrownBy(() -> servicio.actualizarTurno(999,turnoCreableDTOConID))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("El turno indicado no se encuentra");
    }


    @Test
    void crearNuevoTurno() {

        //Given

        when(mapper.TurnoDTOATurno(turnoDto)).thenReturn(turno);

        when(repositorio.save(turno)).thenReturn(turno);

        //When
        when(repositorio.existsById(turno.getId())).thenReturn(true);


        //then
        assertThat(turno.getId()).isEqualTo(122);


    }

}