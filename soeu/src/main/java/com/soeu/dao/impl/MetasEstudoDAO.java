package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soeu.dao.interfaces.EntityDAO;
import com.soeu.entities.GrupoEstudo;
import com.soeu.entities.MetasEstudo;
import com.soeu.mapper.GrupoEstudoMapper;
import com.soeu.mapper.MetasEstudoMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class MetasEstudoDAO implements EntityDAO<MetasEstudo>{
    private Connection conn;

    public MetasEstudoDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(MetasEstudo meta) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Metas_Estudo " +
                "(hora_meta, metas_estudo, id_grupo_FK) " +
                "VALUES " +
                "(?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, meta.getHoraMeta());
            ps.setString(2, meta.getMetasEstudo());
            ps.setInt(3, meta.getGrupoEstudo().getIdGrupo());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();

                if(rs.next()){
                    int id = rs.getInt(1);
                    meta.setIdMetas(id);
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
    public void update(MetasEstudo meta) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Metas_Estudo " + 
                "SET hora_meta = ?, metas_estudo = ?, id_grupo_FK = ? " +
                "WHERE id_metas = ?"
            );

            ps.setInt(1, meta.getHoraMeta());
            ps.setString(2, meta.getMetasEstudo());
            ps.setInt(3, meta.getGrupoEstudo().getIdGrupo());
            ps.setInt(4, meta.getIdMetas());

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
                "DELETE FROM Metas_Estudo WHERE id_metas = ?"
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
    public MetasEstudo findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Metas_Estudo.*, Grupo_Estudo.* " +
                "FROM Metas_Estudo " +
                "INNER JOIN Grupo_Estudo " +
                "ON Metas_Estudo.id_grupo_FK = Grupo_Estudo.id_grupo " +
                "WHERE id_metas = ?"
            );
            
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                GrupoEstudo grupoEstudo = GrupoEstudoMapper.createGrupoEstudo(rs);
                MetasEstudo meta = MetasEstudoMapper.createMetas(rs);
                meta.setGrupoEstudo(grupoEstudo);

                return meta;
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
    public List<MetasEstudo> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Metas_Estudo.*, Grupo_Estudo.* " +
                "FROM Metas_Estudo " +
                "INNER JOIN Grupo_Estudo " +
                "ON Metas_Estudo.id_grupo_FK = Grupo_Estudo.id_grupo "
            );

            rs = ps.executeQuery();

            List<MetasEstudo> metas = new ArrayList<>();
            Map<Integer, GrupoEstudo> grupoMap = new HashMap<>();

            while(rs.next()){
                Integer key = rs.getInt("id_grupo_FK");

                if(!grupoMap.containsKey(key)){
                    GrupoEstudo grupo = GrupoEstudoMapper.createGrupoEstudo(rs);
                    grupoMap.put(key, grupo);
                }

                MetasEstudo meta = MetasEstudoMapper.createMetas(rs);
                meta.setGrupoEstudo(grupoMap.get(key));

                metas.add(meta);
            }

            return metas;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
    
}