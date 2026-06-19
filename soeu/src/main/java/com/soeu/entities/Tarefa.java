package com.soeu.entities;

import java.time.LocalDate;

public class Tarefa {

    private Integer idTarefa;
    private LocalDate prazo;
    private String status;

    private Aluno aluno;

    public Tarefa() {
    }

    public Tarefa(LocalDate prazo, String status, Aluno aluno) {
        this.prazo = prazo;
        this.status = status;
        this.aluno = aluno;
    }

    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "idTarefa=" + idTarefa +
                ", prazo=" + prazo +
                ", status='" + status + '\'' +
                '}';
    }
}