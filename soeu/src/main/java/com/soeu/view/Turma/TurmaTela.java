package com.soeu.view.Turma;

import com.soeu.entities.Aluno;
import com.soeu.entities.Turma;

public class TurmaTela extends javax.swing.JFrame {

    private javax.swing.JLabel titulo;
    private javax.swing.JLabel lblTurma;

    private javax.swing.JButton btnProva;
    private javax.swing.JButton btnVoltar;

    private final Turma turmaAtual;
    private final Aluno alunoLogado;

    private final ProvaPanel provaPanel;

    public TurmaTela(Turma turma, Aluno aluno){

        this.turmaAtual = turma;
        this.alunoLogado = aluno;

        initComponents();

        provaPanel = new ProvaPanel(turmaAtual, alunoLogado);

        lblTurma.setText("Turma: ");
    }

    private void initComponents(){

        titulo = new javax.swing.JLabel();
        lblTurma = new javax.swing.JLabel();

        btnProva = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setText("Sistema de Estudos Universitário");

        btnProva.setText("Provas");

        btnVoltar.setText("Voltar");

        btnProva.addActionListener(evt -> {
            provaPanel.abrirMenuProva();
        });

        btnVoltar.addActionListener(evt -> {
            dispose();
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addComponent(titulo)
            .addComponent(lblTurma)
            .addComponent(btnProva, 150, 150, 150)
            .addComponent(btnVoltar)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(30)
            .addComponent(titulo)
            .addGap(20)
            .addComponent(lblTurma)
            .addGap(20)
            .addComponent(btnProva)
            .addGap(20)
            .addComponent(btnVoltar)
            .addGap(20)
        );

        pack();

        setLocationRelativeTo(null);
    }
}