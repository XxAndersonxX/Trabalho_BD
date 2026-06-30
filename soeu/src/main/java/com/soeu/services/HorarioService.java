package com.soeu.services;

import java.util.List;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.HorarioEstudoDAO;
import com.soeu.entities.HorarioEstudo;

public class HorarioService {
    private final HorarioEstudoDAO horaDAO;

    public HorarioService(){
        this.horaDAO = DaoFactory.createHorarioEstudoDAO();
    }
    
    public void createHorario(HorarioEstudo horario){
        horaDAO.insert(horario);
    }

    public List<HorarioEstudo> readHorario(){
        return horaDAO.findAll();
    }

    public void updateHorario(HorarioEstudo horario){
        horaDAO.update(horario);
    }

    public void deleteHorario(HorarioEstudo horario){
        horaDAO.deleteById(horario.getIdHorario());
    }
}
