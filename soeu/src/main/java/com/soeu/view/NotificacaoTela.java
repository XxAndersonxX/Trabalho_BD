package com.soeu.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.soeu.entities.Aluno;
import com.soeu.entities.Notificacoes;
import com.soeu.services.NotificacaoService;

public class NotificacaoTela {

    private final NotificacaoService notificacaoService;
    private final Aluno alunoLogado;

    public NotificacaoTela(Aluno aluno){
        this.alunoLogado = aluno;
        this.notificacaoService = new NotificacaoService();
    }

    public void listarNotificacoes(){

        List<Notificacoes> notificacoes = notificacaoService.read(alunoLogado.getMatricula());

        if(notificacoes.isEmpty()){
            JOptionPane.showMessageDialog(null, "Você não possui notificações");

            return;
        }

        StringBuilder texto = new StringBuilder();

        texto.append("===== Notificações =====\n\n");

        for(Notificacoes n : notificacoes){
            texto.append("- "+ n.toString() + "\n");
        }

        JOptionPane.showMessageDialog(null, texto.toString());
    }
}