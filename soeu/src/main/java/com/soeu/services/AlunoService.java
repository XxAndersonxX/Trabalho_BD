/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soeu.services;

/**
 *
 * @author Anderson
 */

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.AlunoDAO;
import com.soeu.entities.Aluno;

public class AlunoService {

    private final AlunoDAO alunoDAO = DaoFactory.createAlunoDAO();

    public void atualizar(Aluno aluno) {
        alunoDAO.update(aluno);
    }

    public void excluir(Integer matricula) {
    try {
        alunoDAO.deleteById(matricula);
    } catch (RuntimeException e) {
        throw new RuntimeException(
            "Não é possível excluir este aluno porque ele possui vínculos no sistema."
        );
    }
}

    public Aluno buscarPorId(Integer matricula) {
        return alunoDAO.findById(matricula);
    }
    
    public Aluno buscarNaViewPorId(Integer matricula) {
        return alunoDAO.buscarNaViewPorId(matricula);
    }
    
}
