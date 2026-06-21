package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Prova;

public class ProvaMapper {
    public static Prova createProva(ResultSet rs) throws SQLException{
        Prova prova = new Prova();
        prova.setIdProva(rs.getInt("id_prova"));
        prova.setPeso(rs.getDouble("peso"));
        prova.setData(rs.getDate("data").toLocalDate());

        return prova;
    }
}
