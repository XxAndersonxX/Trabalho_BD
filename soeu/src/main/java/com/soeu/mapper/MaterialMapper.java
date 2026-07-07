package com.soeu.mapper;

import com.soeu.entities.Disciplina;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.soeu.entities.Material;

public class MaterialMapper {
    public static Material createMaterial(ResultSet rs) throws SQLException{
        Material material = new Material();
        material.setIdMaterial(rs.getInt("id_material"));
        material.setTipo(rs.getString("tipo"));
        material.setLink(rs.getString("link"));
        material.setNomeArquivo(rs.getString("nome_arquivo"));
        material.setArquivo(rs.getBytes("arquivo"));
        
        Disciplina disciplina = new Disciplina();
        disciplina.setCodigo(rs.getInt("codigo_FK"));

        material.setDisciplina(disciplina);

        return material;
    }
}
