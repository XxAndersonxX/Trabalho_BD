package com.soeu.entities;

public class Tem {

    private Turma turma;
    private Prova prova;

    public Tem() {
    }

    public Tem(Turma turma, Prova prova) {
        this.turma = turma;
        this.prova = prova;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    @Override
    public String toString() {
        return "Tem{" +
                "turma=" + turma +
                ", prova=" + prova +
                '}';
    }
}