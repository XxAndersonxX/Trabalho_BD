package com.soeu.entities;



public class Material {
    

    private Integer idMaterial;
    private String tipo;
    private String link;
    private String nomeArquivo;
    private byte[] arquivo;


    private Disciplina disciplina;

    
    public Material() {
    }

    public Material(String tipo, String link,String nomeArquivo, byte[] arquivo,
 Disciplina disciplina) {

        this.tipo = tipo;
        this.nomeArquivo = nomeArquivo;
        this.arquivo = arquivo;
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
    
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
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