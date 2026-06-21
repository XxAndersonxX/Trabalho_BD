package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soeu.entities.GrupoEstudo;
import com.soeu.mapper.GrupoEstudoMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class ParticipaDAO {
    private Connection conn;

    public ParticipaDAO(Connection conn){
        this.conn = conn;
    }

    public void insertParticipa(Integer matricula, Integer id_grupo){
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Participa " +
                "(matricula, id_grupo) " +
                "VALUES " +
                "(?, ?)"
            );

            ps.setInt(1, matricula);
            ps.setInt(2, id_grupo);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    public void deleteParticipa(Integer matricula, Integer id_grupo){
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "DELETE FROM Participa " +
                "WHERE matricula = ? " +
                "AND id_grupo = ?"
            );

            ps.setInt(1, matricula);
            ps.setInt(2, id_grupo);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    public List<GrupoEstudo> findGruposByAluno(Integer matricula){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Grupo_Estudo.* " +
                "FROM Grupo_Estudo " +
                "INNER JOIN Participa " +
                "ON Grupo_Estudo.id_grupo = Participa.id_grupo "+
                "WHERE Participa.matricula = ?"
            );

            ps.setInt(1, matricula);

            rs = ps.executeQuery();
            
            List<GrupoEstudo> grupos = new ArrayList<>();

            while(rs.next()){
                GrupoEstudo grupo = GrupoEstudoMapper.createGrupoEstudo(rs);

                grupos.add(grupo);
            }

            return grupos;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}