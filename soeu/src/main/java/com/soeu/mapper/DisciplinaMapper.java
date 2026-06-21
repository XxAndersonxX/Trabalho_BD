package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Disciplina;

public class DisciplinaMapper {
    public static Disciplina createDisciplina(ResultSet rs) throws SQLException{
        Disciplina disciplina = new Disciplina();
        disciplina.setCodigo(rs.getInt("codigo"));
        disciplina.setCreditos(rs.getInt("creditos"));
        disciplina.setCurso(rs.getString("curso"));
        disciplina.setPeriodo(rs.getInt("periodo"));

        return disciplina;
    }
}
