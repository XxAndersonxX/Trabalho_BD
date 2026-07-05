package com.soeu.view.Turma;

import java.util.List;

import javax.swing.JOptionPane;

import com.soeu.entities.Aluno;
import com.soeu.entities.Turma;
import com.soeu.services.TurmaService;

public class TurmaMenu {

    private final TurmaService turmaService;
    private final Aluno alunoLogado;

    public TurmaMenu(Aluno aluno){

        this.alunoLogado = aluno;
        this.turmaService = new TurmaService();
    }

    public void abrirMenuTurma(){

        String[] opcoes = {"Ver turmas"};

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha:",
                "Turmas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        if(escolha == -1){
            return;
        }

        switch(escolha){
            case 0 -> verTurmas();
        }
    }

    private void verTurmas(){

        List<Turma> turmas = turmaService.read(alunoLogado.getMatricula());

        if(turmas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma turma encontrada");

            return;
        }

        Turma[] vetor = turmas.toArray(Turma[]::new);

        Turma turma = (Turma)
                JOptionPane.showInputDialog(
                        null,
                        "Escolha a turma:",
                        "Turmas",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        vetor,
                        vetor[0]
                );

        if(turma != null){
            new TurmaTela(turma, alunoLogado).setVisible(true);
        }
    }
}