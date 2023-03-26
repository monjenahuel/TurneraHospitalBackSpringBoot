package com.monjenahuel.sweetmedical.test;


import com.monjenahuel.sweetmedical.DTO.TurnoCreableDTO;
import com.monjenahuel.sweetmedical.DTO.TurnoDTO;
import com.monjenahuel.sweetmedical.DTO.mapper.TurnoMapper;
import com.monjenahuel.sweetmedical.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDateTime;



@SpringBootTest
class TurnoMapperTest {

    @Autowired
    TurnoMapper mapper;

    Paciente px = new Paciente(120,"Mariano","Mercedes","17.785.127","123123123123", "N456456456@gmail.com");
    Profesional prof = new Profesional("Dr Naranja","Yonatan","AH675JHJ65J");
    Especialidad esp = new Especialidad("Clinica");
    Especialidad_Profesional espProf = new Especialidad_Profesional(esp,prof);
    Turno turnoPrueba = new Turno(122,12,7, LocalDateTime.of(2023,03,27,15,55),px,espProf);

    /////////////////////////////////////////////////////////
    TurnoCreableDTO turnoCreableDTOPrueba = new TurnoCreableDTO(7,9,LocalDateTime.of(2012,12,12,12,12));

    //////////////////////////////////////////////////////

    Paciente px2 = new Paciente(120,"Marcelo","Del Monje","16.185.122","No gracias", "NoGracias@gmail.com");
    Profesional prof2 = new Profesional("Dr Mandarina","Jorge","A574GfT72");
    Especialidad esp2 = new Especialidad("Cardiologia");
    Especialidad_Profesional espProf2 = new Especialidad_Profesional(esp2,prof2);
    TurnoDTO turnoDTOPrueba = new TurnoDTO(17,LocalDateTime.of(2012,12,12,12,12),px2,espProf2);

    @Test
    void TurnoToCreableDTO() {
        TurnoCreableDTO turnoDTOSalida = mapper.TurnoATurnoCreableDTO(turnoPrueba);

        assertThat(turnoDTOSalida.getId_paciente()).isEqualTo(turnoPrueba.getIdPaciente());

    }

    @Test
    void CreableDTOToTurno() {
        Turno turnoSalida = mapper.TurnoCreableDTOATurno(turnoCreableDTOPrueba);

        assertThat(turnoSalida.getIdPaciente()).isEqualTo(turnoCreableDTOPrueba.getId_paciente());

    }

    @Test
    void TurnoToTurnoDTO() {
        TurnoDTO turnoDTOSalida = mapper.TurnoATurnoDTO(turnoPrueba);

        assertThat(turnoDTOSalida.getPaciente().getEmail()).isEqualTo(turnoPrueba.getPaciente().getEmail());
        assertThat(turnoDTOSalida.getEspecialidad_profesional().getProfesional().getMatricula()).isEqualTo(turnoPrueba.getEspecialidad_profesional().getProfesional().getMatricula());
        assertThat(turnoDTOSalida.getEspecialidad_profesional().getEspecialidad().getNombre()).isEqualTo(turnoPrueba.getEspecialidad_profesional().getEspecialidad().getNombre());

        System.out.println(turnoPrueba);
        System.out.println(turnoDTOSalida);

    }

    @Test
    void TurnoDTOTOTurno() {
        Turno turnoSalida = mapper.TurnoDTOATurno(turnoDTOPrueba);

        assertThat(turnoSalida.getPaciente().getEmail()).isEqualTo(turnoDTOPrueba.getPaciente().getEmail());
        assertThat(turnoSalida.getEspecialidad_profesional().getProfesional().getMatricula()).isEqualTo(turnoDTOPrueba.getEspecialidad_profesional().getProfesional().getMatricula());
        assertThat(turnoSalida.getEspecialidad_profesional().getEspecialidad().getNombre()).isEqualTo(turnoDTOPrueba.getEspecialidad_profesional().getEspecialidad().getNombre());

    }
}