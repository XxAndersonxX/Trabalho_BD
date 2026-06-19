package com.soeu.entities;

public class Material {

    private Integer idMaterial;
    private String tipo;
    private String link;

    private Disciplina disciplina;

    public Material() {
    }

    public Material(String tipo, String link, Disciplina disciplina) {

        this.tipo = tipo;
        this.link = link;
        this.disciplina = disciplina;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(
            Disciplina disciplina) {

        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Material{" +
                "idMaterial=" + idMaterial +
                ", tipo='" + tipo + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}