package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Turma;

public class TurmaMapper {
    public static Turma createTurma(ResultSet rs) throws SQLException{
        Turma turma = new Turma();
        turma.setIdTurma(rs.getInt("idTurma"));
        turma.setSemestre(rs.getInt("semestre"));
        turma.setHorario(rs.getTime("horario").toLocalTime());

        return turma;
    }
}
