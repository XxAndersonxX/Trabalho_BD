package com.soeu.entities;

public class Disciplina {

    private Integer codigo;
    private Integer creditos;
    private String curso;
    private Integer periodo;

    public Disciplina() {
    }

    public Disciplina(Integer creditos, String curso, Integer periodo) {
        this.creditos = creditos;
        this.curso = curso;
        this.periodo = periodo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "codigo=" + codigo +
                ", creditos=" + creditos +
                ", curso='" + curso + '\'' +
                ", periodo=" + periodo +
                '}';
    }
}