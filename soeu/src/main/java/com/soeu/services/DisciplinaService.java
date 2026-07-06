/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soeu.services;

import java.util.List;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.DisciplinaDAO;
import com.soeu.entities.Disciplina;
/**
 *
 * @author Anderson
 */
public class DisciplinaService {
    
    

    private final DisciplinaDAO disciplinaDAO;

    public DisciplinaService() {
        this.disciplinaDAO = DaoFactory.createDisciplinaDAO();
    }

    public List<Disciplina> listarTodas() {
        return disciplinaDAO.findAllById(null);
    }

    public Disciplina buscarPorId(Integer codigo) {
        return disciplinaDAO.findById(codigo);
    }
}

