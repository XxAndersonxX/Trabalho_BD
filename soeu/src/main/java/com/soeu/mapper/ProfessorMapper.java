package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Professor;

public class ProfessorMapper {
    public static Professor createProfessor(ResultSet rs) throws SQLException {
        Professor professor = new Professor();
        professor.setIdProfessor(rs.getInt("id_professor"));
        professor.setEmail(rs.getString("email"));
        professor.setTelefone(rs.getString("telefone"));

        return professor;
    }
}
