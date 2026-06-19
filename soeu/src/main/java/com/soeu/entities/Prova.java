package com.soeu.entities;

import java.time.LocalDate;

public class Prova {

    private Integer idProva;
    private Double peso;
    private LocalDate data;

    public Prova() {
    }

    public Prova(Double peso, LocalDate data) {
        this.peso = peso;
        this.data = data;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Prova{" +
                "idProva=" + idProva +
                ", peso=" + peso +
                ", data=" + data +
                '}';
    }
}