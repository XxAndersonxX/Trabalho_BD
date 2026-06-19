package com.soeu.entities;

public class Matricula {

    private Turma turma;
    private Aluno aluno;

    public Matricula() {
    }

    public Matricula(Turma turma, Aluno aluno) {
        this.turma = turma;
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "turma=" + turma +
                ", aluno=" + aluno +
                '}';
    }
}