package com.soeu.entities;

public class Participa {

    private Aluno aluno;
    private GrupoEstudo grupoEstudo;

    public Participa() {
    }

    public Participa(Aluno aluno, GrupoEstudo grupoEstudo) {
        this.aluno = aluno;
        this.grupoEstudo = grupoEstudo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public GrupoEstudo getGrupoEstudo() {
        return grupoEstudo;
    }

    public void setGrupoEstudo(GrupoEstudo grupoEstudo) {
        this.grupoEstudo = grupoEstudo;
    }

    @Override
    public String toString() {
        return "Participa{" +
                "aluno=" + aluno +
                ", grupoEstudo=" + grupoEstudo +
                '}';
    }
}