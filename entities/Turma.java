package Trabalho_BD.entities;

import java.sql.Time;

public class Turma {
    private Integer semestre;
    private Time horario;

    public Turma(){
    }

    public Turma(Integer semestre, Time horario) {
        this.semestre = semestre;
        this.horario = horario;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Turma [semestre=" + semestre + ", horario=" + horario + "]";
    }
}