package com.soeu.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.soeu.entities.GrupoEstudo;
import com.soeu.entities.MetasEstudo;
import com.soeu.services.MetaEstudoService;

public class MetaEstudoPanel {

    private final MetaEstudoService metaService;
    private final GrupoEstudo grupoAtual;

    public MetaEstudoPanel(GrupoEstudo grupo){
        this.grupoAtual = grupo;
        this.metaService = new MetaEstudoService();
    }

    public void abrirMenuMetas(){

        String[] opcoes = {
            "Criar meta",
            "Ver metas",
            "Alterar meta",
            "Apagar meta"
        };

        int escolha =
            JOptionPane.showOptionDialog(
                null,
                "Escolha:",
                "Metas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

        switch(escolha){
            case 0 -> criarMetas();
            case 1 -> listarMetas();
            case 2 -> alterarMetas();
            case 3 -> apagarMetas();
        }
    }

    private void criarMetas(){
        try{
            int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas meta:"));
            String descricao = JOptionPane.showInputDialog("Descrição:");

            MetasEstudo meta = new MetasEstudo(horas, descricao, grupoAtual);

            metaService.create(meta);

            JOptionPane.showMessageDialog(null, "Meta criada!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Valor inválido");
        }
    }

    private void listarMetas(){

        List<MetasEstudo> metas = metaService.read();
        StringBuilder texto = new StringBuilder();

        for(MetasEstudo m : metas){
            texto.append(
                "Horas: "
                + m.getHoraMeta()
                + "\nMeta: "
                + m.getMetasEstudo()
                + "\n\n"
            );
        }

        JOptionPane.showMessageDialog(null, texto.toString());
    }

    private void alterarMetas(){
        JOptionPane.showMessageDialog(null, "Implementar alteração");
    }

    private void apagarMetas(){
        JOptionPane.showMessageDialog(null, "Implementar exclusão");
    }
}