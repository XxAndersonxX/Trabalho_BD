package com.soeu.view.Turma;

import java.awt.HeadlessException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.soeu.entities.Aluno;
import com.soeu.entities.Notificacoes;
import com.soeu.entities.Prova;
import com.soeu.entities.Turma;
import com.soeu.services.NotificacaoService;
import com.soeu.services.ProvaService;
import com.soeu.services.TemService;

public class ProvaPanel {

    private final ProvaService provaService;
    private final TemService temService;
    private final NotificacaoService notificacaoService;
    private final Turma turmaAtual;
    private final Aluno alunoLogado;

    public ProvaPanel(Turma turma, Aluno alunoLogado){
        this.turmaAtual = turma;
        this.alunoLogado = alunoLogado;
        this.provaService = new ProvaService();
        this.temService = new TemService();
        this.notificacaoService = new NotificacaoService();
    }

    public void abrirMenuProva(){

        String[] opcoes = {
            "Criar prova",
            "Ver provas",
            "Alterar prova",
            "Apagar prova"
        };

        int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha:",
                "Provas",
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
            case 0 -> criarProva();
            case 1 -> listarProvas();
            case 2 -> alterarProva();
            case 3 -> apagarProva();
        }
    }

    private void criarProva(){

        try{
            String pesoTexto = JOptionPane.showInputDialog("Peso:");

            if(pesoTexto == null){
                return;
            }

            String dataTexto = JOptionPane.showInputDialog("Data (AAAA-MM-DD):");

            if(dataTexto == null){
                return;
            }

            Double peso = Double.valueOf(pesoTexto);
            LocalDate data = LocalDate.parse(dataTexto);

            Prova prova = new Prova(peso, data);

            provaService.create(prova);

            temService.create(prova.getIdProva(), turmaAtual.getIdTurma());

            String status = "Lido ";
            String descricao = "Prova de " + turmaAtual.getDisciplina().getNome();
            Notificacoes not = new Notificacoes(data, status, descricao, alunoLogado);
            
            notificacaoService.create(not);

            JOptionPane.showMessageDialog(null, "Prova criada!");
        }
        catch(HeadlessException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Formato inválido");
        }
    }

    private void listarProvas(){

        List<Prova> provas = provaService.read(turmaAtual.getIdTurma());

        if(provas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma prova encontrada");

            return;
        }

        StringBuilder texto = new StringBuilder();

        for(Prova p : provas){
            texto.append(
                "Peso: "
                + p.getPeso()
                + "\nData: "
                + p.getData()
                + "\n\n"
            );
        }

        JOptionPane.showMessageDialog(null, texto.toString());
    }

    private void alterarProva(){

        List<Prova> provas = provaService.read(turmaAtual.getIdTurma());

        if(provas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma prova encontrada");

            return;
        }

        Prova[] vetor = provas.toArray(Prova[]::new);

        Prova prova = (Prova) JOptionPane.showInputDialog(
                null,
                "Escolha prova:",
                null,
                JOptionPane.PLAIN_MESSAGE,
                null,
                vetor,
                vetor[0]
            );

        if(prova == null){
            return;
        }

        try{

            String pesoTexto = JOptionPane.showInputDialog("Novo peso:");
            String dataTexto = JOptionPane.showInputDialog("Nova data (AAAA-MM-DD):");
            Double peso = Double.valueOf(pesoTexto);
            LocalDate data = LocalDate.parse(dataTexto);

            prova.setPeso(peso);

            prova.setData(data);

            provaService.update(prova);

            JOptionPane.showMessageDialog(null, "Prova alterada!");

        }
        catch(HeadlessException | NumberFormatException e){

            JOptionPane.showMessageDialog(null, "Formato inválido");
        }
    }

    private void apagarProva(){

        List<Prova> provas = provaService.read(turmaAtual.getIdTurma());

        if(provas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhuma prova encontrada");

            return;
        }

        Prova[] vetor = provas.toArray(Prova[]::new);

        Prova prova = (Prova) JOptionPane.showInputDialog(
                null,
                "Escolha prova:",
                null,
                JOptionPane.PLAIN_MESSAGE,
                null,
                vetor,
                vetor[0]
            );

        if(prova != null){

            provaService.delete(prova);

            JOptionPane.showMessageDialog(null, "Prova apagada!");
        }
    }
}