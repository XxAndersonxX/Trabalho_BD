package Trabalho_BD.entities;

import java.sql.Time;

public class HorarioEstudo {
    private Time horarioInicio;
    private Time horarioFim;

    public HorarioEstudo(){
    }

    public HorarioEstudo(Time horarioInicio, Time horarioFim) {
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public Time getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Time getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Time horarioFim) {
        this.horarioFim = horarioFim;
    }

    @Override
    public String toString() {
        return "HorarioEstudo [horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim + "]";
    }
}