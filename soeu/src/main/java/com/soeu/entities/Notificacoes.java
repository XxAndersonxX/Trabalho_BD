package com.soeu.entities;

import java.time.LocalDate;

public class Notificacoes {

    private Integer idNotificacao;
    private LocalDate data;
    private String status;
    private String descricao;

    private Aluno aluno;

    public Notificacoes() {
    }

    public Notificacoes(LocalDate data, String status, String descricao,Aluno aluno) {
        this.data = data;
        this.status = status;
        this.descricao = descricao;
        this.aluno = aluno;
    }

    public Integer getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(Integer idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Notificacao{" +
                "idNotificacao=" + idNotificacao +
                ", data=" + data +
                ", status='" + status + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}