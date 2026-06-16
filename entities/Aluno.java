package Trabalho_BD.entities;

import java.util.Date;

public class Aluno {
    private String email;
    private String curso;
    private String senha;
    private Double ira;
    private Integer periodo;
    private Date data_nascimento;

    public Aluno(){
    }
    
    public Aluno(String email, String curso, String senha, Double ira, Integer periodo, Date data_nascimento) {
        this.email = email;
        this.curso = curso;
        this.senha = senha;
        this.ira = ira;
        this.periodo = periodo;
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getIra() {
        return ira;
    }

    public void setIra(Double ira) {
        this.ira = ira;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @Override
    public String toString() {
        return "Aluno [email=" + email + ", curso=" + curso + ", senha=" + senha + ", ira=" + ira + ", periodo="
                + periodo + ", data_nascimento=" + data_nascimento + "]";
    }
}