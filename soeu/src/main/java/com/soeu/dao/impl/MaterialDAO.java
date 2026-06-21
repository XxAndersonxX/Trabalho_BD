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
import com.soeu.entities.Disciplina;
import com.soeu.entities.Material;
import com.soeu.mapper.DisciplinaMapper;
import com.soeu.mapper.MaterialMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class MaterialDAO implements EntityDAO<Material>{
    private Connection conn;

    public MaterialDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Material material) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO material " +
                "(tipo, link, codigo_FK) " +
                "VALUES " +
                "(?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, material.getTipo());
            ps.setString(2, material.getLink());
            ps.setInt(3, material.getDisciplina().getCodigo());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();

                if(rs.next()){
                    int id = rs.getInt(1);
                    material.setIdMaterial(id);
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
    public void update(Material material) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Material " + 
                "SET tipo = ?, link = ?, codigo_FK = ? " +
                "WHERE id_material = ?"
            );

            ps.setString(1, material.getTipo());
            ps.setString(2, material.getLink());
            ps.setInt(3, material.getDisciplina().getCodigo());
            ps.setInt(4, material.getIdMaterial());

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
                "DELETE FROM Material WHERE id_material = ?"
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
    public Material findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Material.*, Disciplina.* " +
                "FROM Material " +
                "INNER JOIN Disciplina " +
                "ON Material.codigo_FK = Disciplina.codigo " +
                "WHERE id_material = ?"
            );

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Disciplina disciplina = DisciplinaMapper.createDisciplina(rs);
                Material material = MaterialMapper.createMaterial(rs);
                material.setDisciplina(disciplina);

                return material;
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
    public List<Material> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Material.*, Disciplina.* " +
                "FROM Material " +
                "INNER JOIN Disciplina " +
                "ON Material.codigo_FK = Disciplina.codigo " 
            );
            
            rs = ps.executeQuery();

            List<Material> materiais = new ArrayList<>();
            Map<Integer, Disciplina> disMap = new HashMap<>();
            
            while(rs.next()){
                Integer key = rs.getInt("codigo_FK");

                if(!disMap.containsKey(key)){
                    Disciplina disciplina = DisciplinaMapper.createDisciplina(rs);
                    disMap.put(key, disciplina);
                }

                Material material = MaterialMapper.createMaterial(rs);
                material.setDisciplina(disMap.get(key));

                materiais.add(material);
            }
            return materiais;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}