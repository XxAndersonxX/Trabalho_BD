package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Notificacoes;

public class NotificacoesMapper {
     public static Notificacoes createNotificacao(ResultSet rs) throws SQLException{
        Notificacoes notificacoes = new Notificacoes();
        notificacoes.setIdNotificacao(rs.getInt("id_notificacao"));
        notificacoes.setData(rs.getDate("data").toLocalDate());
        notificacoes.setStatus(rs.getString("status"));
        notificacoes.setDescricao(rs.getString("descricao"));
        
        return notificacoes;
    }
}
