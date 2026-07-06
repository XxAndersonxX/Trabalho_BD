package com.soeu.view.GrupoEstudo;

import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JOptionPane;

import com.soeu.entities.Aluno;
import com.soeu.entities.GrupoEstudo;
import com.soeu.services.GrupoEstudoService;
import com.soeu.services.ParticipaService;

public class GrupoEstudoMenu {

    private final GrupoEstudoService grupoService;
    private final ParticipaService participaService;
    private final Aluno alunoLogado;

    public GrupoEstudoMenu(Aluno aluno){
        this.alunoLogado = aluno;
        this.grupoService = new GrupoEstudoService();
        this.participaService = new ParticipaService();
    }

    public void abrirMenuGrupo(){

        String[] opcoes = {
            "Criar grupo",
            "Mudar descrição",
            "Escolher grupo",
            "Apagar grupo"
        };

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha:",
                "Grupo de Estudos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

        switch(escolha){
            case 0 -> criarGrupo();
            case 1 -> alterarGrupo();
            case 2 -> escolherGrupo();
            case 3 -> apagarGrupo();
        }
    }

    private void criarGrupo(){
        
        try{
            String descricao = JOptionPane.showInputDialog("Descrição do grupo:");
            GrupoEstudo grupo = new GrupoEstudo();
    
            descricao = descricao.trim();
    
            if(descricao.isEmpty()){return;}

            grupo.setDescricao(descricao);

            grupoService.create(grupo);

            participaService.createParticipao(alunoLogado.getMatricula(), grupo);

            JOptionPane.showMessageDialog(null, "Grupo criado!");

        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, "Erro ao criar grupo");
        }
    }

    private void alterarGrupo(){
        List<GrupoEstudo> grupos = grupoService.read(alunoLogado.getMatricula());

        GrupoEstudo[] vetor = grupos.toArray(GrupoEstudo[]::new);

        GrupoEstudo grupo = (GrupoEstudo) JOptionPane.showInputDialog(
                null,
                "Escolha grupo:",
                null,
                JOptionPane.PLAIN_MESSAGE,
                null,
                vetor,
                vetor[0]
            );

        if(grupo == null){
            return;
        }

        String descricaoNova = JOptionPane.showInputDialog("Nova descrição:");

        grupo.setDescricao(descricaoNova);

        grupoService.update(grupo);

        JOptionPane.showMessageDialog(null, "Grupo alterado!");
    }

    private void escolherGrupo(){

        List<GrupoEstudo> grupos = grupoService.read(alunoLogado.getMatricula());

        GrupoEstudo[] vetor = grupos.toArray(GrupoEstudo[]::new);

        GrupoEstudo grupo = (GrupoEstudo) JOptionPane.showInputDialog(
                null,
                "Escolha grupo:",
                null,
                JOptionPane.PLAIN_MESSAGE,
                null,
                vetor,
                vetor[0]
            );

        if(grupo != null){
            new GrupoEstudoTela(grupo).setVisible(true);
        }
    }

    private void apagarGrupo(){

        List<GrupoEstudo> grupos = grupoService.read(alunoLogado.getMatricula());

        GrupoEstudo[] vetor = grupos.toArray(GrupoEstudo[]::new);

        GrupoEstudo grupo = (GrupoEstudo) JOptionPane.showInputDialog(
                null,
                "Escolha grupo:",
                null,
                JOptionPane.PLAIN_MESSAGE,
                null,
                vetor,
                vetor[0]
            );

        if(grupo != null){
            grupoService.delete(grupo);

            JOptionPane.showMessageDialog(null, "Grupo apagado!");
        }
    }
}