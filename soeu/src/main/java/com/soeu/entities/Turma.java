package com.soeu.entities;

import java.time.LocalTime;

public class Turma {

    private Integer idTurma;
    private Integer semestre;
    private LocalTime horario;

    private Disciplina disciplina;
    private Professor professor;

    public Turma() {
    }

    public Turma(Integer semestre, LocalTime horario, Disciplina disciplina, Professor professor) {
        this.semestre = semestre;
        this.horario = horario;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "idTurma=" + idTurma +
                ", semestre=" + semestre +
                ", horario=" + horario +
                '}';
    }
}