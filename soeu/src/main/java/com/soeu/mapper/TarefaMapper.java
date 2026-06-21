package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Tarefa;

public class TarefaMapper {
    public static Tarefa createTarefa(ResultSet rs) throws SQLException{
        Tarefa tarefa = new Tarefa();
        tarefa.setIdTarefa(rs.getInt("id_tarefa"));
        tarefa.setPrazo(rs.getDate("prazo").toLocalDate());
        tarefa.setStatus(rs.getString("status"));

        return tarefa;
    }   
}