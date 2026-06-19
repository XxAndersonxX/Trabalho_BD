package com.soeu.entities;

import java.time.LocalTime;

public class HorarioEstudo {

    private Integer idHorario;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    private GrupoEstudo grupoEstudo;

    public HorarioEstudo() {
    }

    public HorarioEstudo(LocalTime horaInicio, LocalTime horaFim, GrupoEstudo grupoEstudo) {
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.grupoEstudo = grupoEstudo;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public GrupoEstudo getGrupoEstudo() {
        return grupoEstudo;
    }

    public void setGrupoEstudo(GrupoEstudo grupoEstudo) {
        this.grupoEstudo = grupoEstudo;
    }

    @Override
    public String toString() {
        return "HorarioEstudo{" +
                "idHorario=" + idHorario +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                '}';
    }
}