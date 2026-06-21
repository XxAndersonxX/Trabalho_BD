package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.GrupoEstudo;

public class GrupoEstudoMapper {
    public static GrupoEstudo createGrupoEstudo(ResultSet rs) throws SQLException{
        GrupoEstudo grupoEstudo = new GrupoEstudo();
        grupoEstudo.setIdGrupo(rs.getInt("id_grupo"));
        grupoEstudo.setDescricao(rs.getString("descricao"));

        return grupoEstudo;
    }
}
