package com.monjenahuel.sweetmedical.servicio;

import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.TurnoMapper;
import com.monjenahuel.sweetmedical.entity.*;
import com.monjenahuel.sweetmedical.exepction.NotFoundException;
import com.monjenahuel.sweetmedical.repositorio.TurnoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class TurnoServicioImplTest {


    @MockBean //Ya está testeado, no hace falta volver a hacerlo
    private TurnoRepository repositorio;
    @Autowired
    private TurnoServicio servicio;


    Turno turno;
    Turno turnoHoy;
    TurnoCreableDTO turnoCreableDTO;

    @BeforeEach
    void setUp() {

        repositorio = mock(TurnoRepository.class);

        servicio = new TurnoServicioImpl(repositorio);

        Paciente px = new Paciente(120,"Mariano","Mercedes","17.785.127","123123123123", "N456456456@gmail.com");
        Profesional prof = new Profesional("Dr Naranja","Yonatan","AH675JHJ65J");
        Especialidad esp = new Especialidad("Clinica");
        Especialidad_Profesional espProf = new Especialidad_Profesional(esp,prof);
        turno = new Turno(122,12,7, LocalDateTime.of(2023,03,5,15,55),px,espProf);
        turnoHoy = new Turno(123,13,8,LocalDateTime.now(),px,espProf);
        TurnoCreableDTO turnoCreableDTO = new TurnoCreableDTO(7,9,LocalDateTime.of(2012,12,12,12,12));
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

        assertThatThrownBy(() -> servicio.eliminarTurnoByID(999))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Turno no encontrado");
    }


    @Test
    void actualizarTurno() {

        assertThatThrownBy(() -> servicio.actualizarTurno(999,turnoCreableDTO))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("El turno indicado no se encuentra");
    }


    @Test
    void crearNuevoTurno() {

        when(repositorio.existsById(turno.getId())).thenReturn(true);

        assertThatThrownBy(() -> servicio.crearNuevoTurno(turnoCreableDTO))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Cannot invoke \"com.monjenahuel.sweetmedical.DTO.mapper.TurnoMapper.TurnoCreableDTOATurno(com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO)\" because \"this.mapper\" is null");
    }
}