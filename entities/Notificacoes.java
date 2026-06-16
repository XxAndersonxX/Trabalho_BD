package Trabalho_BD.entities;

import java.util.Date;

public class Notificacoes {
    private Date data;
    private String status;
    private String descricao;

    public Notificacoes(){
    }

    public Notificacoes(Date data, String status, String descricao) {
        this.data = data;
        this.status = status;
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    @Override
    public String toString() {
        return "Notificacoes [data=" + data + ", status=" + status + ", descricao=" + descricao + "]";
    }
}