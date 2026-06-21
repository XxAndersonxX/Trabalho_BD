package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soeu.dao.interfaces.EntityDAO;
import com.soeu.entities.GrupoEstudo;
import com.soeu.mapper.GrupoEstudoMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class GrupoEstudoDAO implements EntityDAO<GrupoEstudo>{
    private Connection conn;

    public GrupoEstudoDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(GrupoEstudo grupoEstudo) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Grupo_Estudo " +
                "(descricao) " +
                "VALUES " +
                "(?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, grupoEstudo.getDescricao());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    grupoEstudo.setIdGrupo(id);
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(GrupoEstudo grupoEstudo) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Grupo_Estudo " + 
                "SET descricao = ? " +
                "WHERE id_grupo = ?"
            );

            ps.setString(1, grupoEstudo.getDescricao());
            ps.setInt(2, grupoEstudo.getIdGrupo());

            ps.executeUpdate();  
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "DELETE FROM Grupo_Estudo WHERE id_grupo = ?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    @Override
    public GrupoEstudo findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Grupo_Estudo " +
                "WHERE id_grupo = ?"
            );
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                GrupoEstudo grupoEstudo = GrupoEstudoMapper.createGrupoEstudo(rs);
                return grupoEstudo;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage()); 
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public List<GrupoEstudo> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Grupo_Estudo"
            );
            rs = ps.executeQuery();

            List<GrupoEstudo> grupos = new ArrayList<>();
            while(rs.next()){
                GrupoEstudo grupoEstudo = GrupoEstudoMapper.createGrupoEstudo(rs);
                grupos.add(grupoEstudo);
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