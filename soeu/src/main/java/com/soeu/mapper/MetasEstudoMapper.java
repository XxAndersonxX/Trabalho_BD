package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.MetasEstudo;

public class MetasEstudoMapper {
    public static MetasEstudo createMetas(ResultSet rs) throws SQLException{
        MetasEstudo meta = new MetasEstudo();
        meta.setIdMetas(rs.getInt("id_metas"));
        meta.setHoraMeta(rs.getInt("hora_meta"));
        meta.setMetasEstudo(rs.getString("metas_estudo"));

        return meta;
    }
}
