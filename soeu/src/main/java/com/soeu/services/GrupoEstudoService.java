package com.soeu.services;

import java.util.List;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.GrupoEstudoDAO;
import com.soeu.dao.impl.ParticipaDAO;
import com.soeu.entities.GrupoEstudo;
import com.soeu.services.interfaces.Service;

public class GrupoEstudoService implements Service<GrupoEstudo>{
    private final GrupoEstudoDAO grupoDAO;
    private final ParticipaDAO participaDAO;

    public GrupoEstudoService(){
        this.grupoDAO = DaoFactory.createGrupoEstudoDAO();
        this.participaDAO = DaoFactory.createParticipaDAO();
    }

    @Override
    public void create(GrupoEstudo grupo) {
        grupoDAO.insert(grupo);
    }

    @Override
    public List<GrupoEstudo> read(Integer id) {
        return participaDAO.findGruposByAluno(id);
    }

    @Override
    public void update(GrupoEstudo grupo) {
        grupoDAO.update(grupo);
    }

    @Override
    public void delete(GrupoEstudo grupo) {
        grupoDAO.deleteById(grupo.getIdGrupo());   
    }
}
