package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Aluno;

public class AlunoMapper {
    public static Aluno createAluno(ResultSet rs)throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setMatricula(rs.getInt("matricula"));
        aluno.setEmail(rs.getString("email"));
        aluno.setCurso(rs.getString("curso"));
        aluno.setSenha(rs.getString("senha"));
        aluno.setIra(rs.getDouble("ira"));
        aluno.setPeriodo(rs.getInt("periodo"));
        aluno.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());

        return aluno;
    }
}
