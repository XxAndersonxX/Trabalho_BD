/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soeu.services;
import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.MaterialDAO;
import com.soeu.entities.Material;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class MaterialService {

    private final MaterialDAO materialDAO;

    public MaterialService() {
        materialDAO = DaoFactory.createMaterialDAO();
    }

    public void create(Material material) {

        materialDAO.insert(material);

    }

    public void update(Material material) {

        materialDAO.update(material);

    }

    public void delete(Integer id) {

        materialDAO.deleteById(id);

    }

    public Material read(Integer id) {

        return materialDAO.findById(id);

    }

    public List<Material> readByDisciplina(Integer codigoDisciplina) {

        return materialDAO.findAllById(codigoDisciplina);

    }

}