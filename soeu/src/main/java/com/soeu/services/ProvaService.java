package com.soeu.services;

import java.util.List;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.ProvaDAO;
import com.soeu.dao.impl.TemDAO;
import com.soeu.entities.Prova;
import com.soeu.services.interfaces.Service;

public class ProvaService implements Service<Prova>{
    private final ProvaDAO provaDAO;
    private final TemDAO temDAO;

    public ProvaService(){
        this.provaDAO = DaoFactory.createProvaDAO();
        this.temDAO = DaoFactory.createTemDAO();
    }

    @Override
    public void create(Prova prova) {
        provaDAO.insert(prova);
    }

    @Override
    public List<Prova> read(Integer id) {
        return temDAO.findTurma(id);
    }

    @Override
    public void update(Prova prova) {
        provaDAO.update(prova);
    }

    @Override
    public void delete(Prova prova) {
        provaDAO.deleteById(prova.getIdProva());
    }
    
}