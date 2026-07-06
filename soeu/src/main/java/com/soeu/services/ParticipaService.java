package com.soeu.services;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.ParticipaDAO;
import com.soeu.entities.GrupoEstudo;

public class ParticipaService {
    private final ParticipaDAO participaDAO;

    public ParticipaService(){
        this.participaDAO = DaoFactory.createParticipaDAO();
    }

    public void createParticipao(Integer matricula, GrupoEstudo grupo){ 
        participaDAO.insertParticipa(matricula, grupo.getIdGrupo());
    }
}
