package com.soeu.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.NotificacoesDAO;
import com.soeu.entities.Notificacoes;

public class NotificacaoService {
    private final NotificacoesDAO notificacaoDAO;

    public NotificacaoService(){
        this.notificacaoDAO = DaoFactory.createNotificacoesDAO();
    }

    public void create(Notificacoes not){
        notificacaoDAO.insert(not);
    } 

    public List<Notificacoes> read(Integer id){
        List<Notificacoes> notificacoes = notificacaoDAO.findAllById(id);

        return notificacoes.stream()
                    .filter(not -> {
                        long dias = ChronoUnit.DAYS.between(LocalDate.now(), not.getData());

                        return dias > 0 && dias <= 7;
                    })
                    .collect(Collectors.toList());
    }
}
