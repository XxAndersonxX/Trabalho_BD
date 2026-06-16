package Trabalho_BD.entities;

public class GrupoEstudo {
    private String descricao;

    public GrupoEstudo(){
    }

    public GrupoEstudo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "GrupoEstudo [descricao=" + descricao + "]";
    }
}