package com.soeu.entities;

public class Professor {
    private String nome;
    private Integer idProfessor;
    private String nomeProfessor;
    private String email;
    private String telefone;

    public Professor() {
    }

    public Professor(String nomeProfessor, String email, String telefone) {
        this.nomeProfessor = nomeProfessor;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nomeProfessor;
    }

    public void setNome(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
    
    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Professor: " + nomeProfessor + "\n" +
                "Email: " + email + "\n" +
                "Telefone: " + telefone + "\n";
    }
}