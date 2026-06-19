package com.soeu.entities;

public class MetasEstudo {

    private Integer idMetas;
    private Integer horaMeta;
    private String metasEstudo;

    private GrupoEstudo grupoEstudo;

    public MetasEstudo() {
    }

    public MetasEstudo(Integer horaMeta, String metasEstudo, GrupoEstudo grupoEstudo) {
        this.horaMeta = horaMeta;
        this.metasEstudo = metasEstudo;
        this.grupoEstudo = grupoEstudo;
    }

    public Integer getIdMetas() {
        return idMetas;
    }

    public void setIdMetas(Integer idMetas) {
        this.idMetas = idMetas;
    }

    public Integer getHoraMeta() {
        return horaMeta;
    }

    public void setHoraMeta(Integer horaMeta) {
        this.horaMeta = horaMeta;
    }

    public String getMetasEstudo() {
        return metasEstudo;
    }

    public void setMetasEstudo(String metasEstudo) {
        this.metasEstudo = metasEstudo;
    }

    public GrupoEstudo getGrupoEstudo() {
        return grupoEstudo;
    }

    public void setGrupoEstudo(
            GrupoEstudo grupoEstudo) {

        this.grupoEstudo = grupoEstudo;
    }

    @Override
    public String toString() {
        return "MetasEstudo{" +
                "idMetas=" + idMetas +
                ", horaMeta=" + horaMeta +
                ", metasEstudo='" + metasEstudo + '\'' +
                '}';
    }
}