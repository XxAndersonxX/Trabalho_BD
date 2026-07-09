/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soeu.services;
import java.util.List;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.TarefaDAO;
import com.soeu.entities.Tarefa;
/**
 *
 * @author Anderson
 */
public class TarefaService {

    private final TarefaDAO tarefaDAO;

    public TarefaService() {
        this.tarefaDAO = DaoFactory.createTarefaDAO();
    }

    public void create(Tarefa tarefa) {
        tarefaDAO.insert(tarefa);
    }

    public List<Tarefa> readByAluno(Integer matricula) {
        return tarefaDAO.findAllById(matricula);
    }

    public void delete(Integer id) {
        tarefaDAO.deleteById(id);
    }
}
