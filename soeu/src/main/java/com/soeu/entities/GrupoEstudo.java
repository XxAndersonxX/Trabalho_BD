package com.soeu.entities;

public class GrupoEstudo {

    private Integer idGrupo;
    private String descricao;

    public GrupoEstudo() {
    }

    public GrupoEstudo(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "GrupoEstudo{" +
                "idGrupo=" + idGrupo +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}