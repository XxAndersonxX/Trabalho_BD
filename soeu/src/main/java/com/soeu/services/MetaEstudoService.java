package com.soeu.services;

import java.util.List;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.MetasEstudoDAO;
import com.soeu.entities.MetasEstudo;
import com.soeu.services.interfaces.Service;

public class MetaEstudoService implements Service<MetasEstudo>{
    private final MetasEstudoDAO metaDAO;

    public MetaEstudoService(){
        this.metaDAO = DaoFactory.createMetasEstudoDAO();
    }

    @Override
    public void create(MetasEstudo meta) {
        metaDAO.insert(meta);
    }

    @Override
    public List<MetasEstudo> read() {
        return metaDAO.findAll();
    }

    @Override
    public void update(MetasEstudo meta) {
        metaDAO.update(meta);
    }

    @Override
    public void delete(MetasEstudo meta) {
        metaDAO.deleteById(meta.getIdMetas());
    }
    
}
