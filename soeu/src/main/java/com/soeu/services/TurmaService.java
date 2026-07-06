package com.soeu.services;

import java.util.List;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.MatriculaDAO;
import com.soeu.entities.Turma;

public class TurmaService {
    private final MatriculaDAO matriculaDAO;

    public TurmaService(){
        this.matriculaDAO = DaoFactory.createMatriculaDAO();
    }

    public List<Turma> read(Integer id){
        return matriculaDAO.findTurmasByAluno(id);
    }
}