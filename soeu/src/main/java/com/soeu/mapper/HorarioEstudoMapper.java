package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.HorarioEstudo;

public class HorarioEstudoMapper {
    public static HorarioEstudo createHorarioEstudo(ResultSet rs) throws SQLException{
        HorarioEstudo horarioEstudo = new HorarioEstudo();
        horarioEstudo.setIdHorario(rs.getInt("id_horario"));
        horarioEstudo.setHoraInicio(rs.getTime("hora_inicio").toLocalTime());
        horarioEstudo.setHoraFim(rs.getTime("hora_fim").toLocalTime());

        return horarioEstudo;
    }
}