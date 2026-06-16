package Trabalho_BD.entities;

public class Material {
    private String tipo;
    private String link;

    public Material(){
    }

    public Material(String tipo, String link) {
        this.tipo = tipo;
        this.link = link;
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

    @Override
    public String toString() {
        return "Material [tipo=" + tipo + ", link=" + link + "]";
    }
}