package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import com.soeu.dao.interfaces.AbstractDAO;
import com.soeu.entities.Disciplina;
import com.soeu.entities.Material;
import com.soeu.mapper.DisciplinaMapper;
import com.soeu.mapper.MaterialMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class MaterialDAO extends AbstractDAO<Material>{

    public MaterialDAO(Connection conn){
        super(conn);
    }

@Override
public void insert(Material material) {
    CallableStatement cs = null;

    try {
        cs = conn.prepareCall(
            "{CALL sp_cadastrar_material(?, ?, ?, ?, ?)}"
        );

        cs.setString(1, material.getTipo());
        cs.setString(2, material.getLink());
        cs.setString(3, material.getNomeArquivo());
        cs.setBytes(4, material.getArquivo());
        cs.setInt(5, material.getDisciplina().getCodigo());
        cs.execute();

    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closeStatement(cs);
    }
}

    @Override
    public void update(Material material) {
        PreparedStatement ps = null;

        try {
        ps = conn.prepareStatement(
            "UPDATE Material " +
            "SET tipo = ?, " +
            "link = ?, " +
            "nome_arquivo = ?, " +
            "arquivo = ?, " +
            "codigo_FK = ? " +
            "WHERE id_material = ?"
);
            

        ps.setString(1, material.getTipo());
        ps.setString(2, material.getLink());
        ps.setString(3, material.getNomeArquivo());
        ps.setBytes(4, material.getArquivo());
        ps.setInt(5, material.getDisciplina().getCodigo());
        ps.setInt(6, material.getIdMaterial());

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
    public List<Material> findAllById(Integer codigoDisciplina) {
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = conn.prepareStatement(
            "SELECT * FROM Material WHERE codigo_FK = ?"
        );

        ps.setInt(1, codigoDisciplina);

        rs = ps.executeQuery();

        List<Material> materiais = new ArrayList<>();

        while (rs.next()) {
            Material material = MaterialMapper.createMaterial(rs);
            materiais.add(material);
        }

        return materiais;

    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closeResultSet(rs);
        DB.closeStatement(ps);
    }
}
}