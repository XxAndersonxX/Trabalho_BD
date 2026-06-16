package Trabalho_BD.entities;

import java.util.Date;

public class Prova {
    private Double peso;
    private Date data;

    public Prova(){
    }

    public Prova(Date data, Double peso) {
        this.data = data;
        this.peso = peso;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Prova [peso=" + peso + ", data=" + data + "]";
    }
}