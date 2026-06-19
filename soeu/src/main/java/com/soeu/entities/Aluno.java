package com.soeu.entities;

import java.time.LocalDate;

public class Aluno {

    private Integer matricula;
    private String email;
    private String curso;
    private String senha;
    private Double ira;
    private Integer periodo;
    private LocalDate dataNascimento;

    public Aluno() {
    }

    public Aluno(String email, String curso, String senha, Double ira, Integer periodo, LocalDate dataNascimento) {
        this.email = email;
        this.curso = curso;
        this.senha = senha;
        this.ira = ira;
        this.periodo = periodo;
        this.dataNascimento = dataNascimento;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public Double getIra(){
        return ira;
    }

    public void setIra(Double ira){
        this.ira = ira;
    }

    public Integer getPeriodo(){
        return periodo;
    }

    public void setPeriodo(Integer periodo){
        this.periodo = periodo;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", email='" + email + '\'' +
                ", curso='" + curso + '\'' +
                ", ira=" + ira +
                ", periodo=" + periodo +
                '}';
    }
}