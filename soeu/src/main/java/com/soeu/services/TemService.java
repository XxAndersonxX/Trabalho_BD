package com.soeu.services;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.TemDAO;

public class TemService {
    private final TemDAO temDAO;

    public TemService(){
        this.temDAO = DaoFactory.createTemDAO();
    }

    public void create(Integer idProva,Integer idTurma){
        temDAO.insertTurma(idProva, idTurma);
    }
}
