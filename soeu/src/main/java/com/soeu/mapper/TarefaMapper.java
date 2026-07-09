package com.soeu.mapper;

import com.soeu.entities.Aluno;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Tarefa;

public class TarefaMapper {
    public static Tarefa createTarefa(ResultSet rs) throws SQLException{
        Tarefa tarefa = new Tarefa();
        
        tarefa.setIdTarefa(rs.getInt("id_tarefa"));
        tarefa.setDescricao(rs.getString("descricao"));
        tarefa.setPrazo(rs.getDate("prazo").toLocalDate());
        tarefa.setStatus(rs.getString("status"));

        Aluno aluno = new Aluno();
        aluno.setMatricula(rs.getInt("matricula_FK"));
        tarefa.setAluno(aluno);

        
        return tarefa;
    }   
}