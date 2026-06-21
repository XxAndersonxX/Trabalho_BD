package com.soeu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Material;

public class MaterialMapper {
    public static Material createMaterial(ResultSet rs) throws SQLException{
        Material material = new Material();
        material.setIdMaterial(rs.getInt("id_material"));
        material.setTipo(rs.getString("tipo"));
        material.setLink(rs.getString("link"));

        return material;
    }
}
