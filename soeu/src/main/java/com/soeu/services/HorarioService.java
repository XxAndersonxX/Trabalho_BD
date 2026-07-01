package com.soeu.services;

import java.util.List;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.HorarioEstudoDAO;
import com.soeu.entities.HorarioEstudo;
import com.soeu.services.interfaces.Service;

public class HorarioService implements Service<HorarioEstudo>{
    private final HorarioEstudoDAO horaDAO;

    public HorarioService(){
        this.horaDAO = DaoFactory.createHorarioEstudoDAO();
    }

    @Override
    public void create(HorarioEstudo horario) {
        horaDAO.insert(horario);
    }

    @Override
    public List<HorarioEstudo> read() {
        return horaDAO.findAll();
    }

    @Override
    public void update(HorarioEstudo horario) {
        horaDAO.update(horario);
    }

    @Override
    public void delete(HorarioEstudo horario) {
        horaDAO.deleteById(horario.getIdHorario());
    }
}
