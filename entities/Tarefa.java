package Trabalho_BD.entities;

import java.util.Date;

public class Tarefa {
    private Date prazo;
    private String status;

    public Tarefa(){
    }

    public Tarefa(Date prazo, String status) {
        this.prazo = prazo;
        this.status = status;
    }

    public Date getPrazo() {
        return prazo;
    }
    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tarefa [prazo=" + prazo + ", status=" + status + "]";
    }
}
