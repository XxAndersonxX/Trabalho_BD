package com.soeu.view;

import com.soeu.entities.GrupoEstudo;

public class GrupoEstudoTela extends javax.swing.JFrame {

    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnMetas;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel lblGrupo;

    private GrupoEstudo grupoAtual;

    private HorarioEstudoPanel horarioPanel;
    private MetaEstudoPanel metaPanel;

    public GrupoEstudoTela(GrupoEstudo grupo) {

        this.grupoAtual = grupo;

        initComponents();

        horarioPanel =
            new HorarioEstudoPanel(grupoAtual);

        metaPanel =
            new MetaEstudoPanel(grupoAtual);

        lblGrupo.setText(
            "Grupo: "
            + grupoAtual.getDescricao()
        );
    }

    private void initComponents() {

        titulo = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();

        btnHorario = new javax.swing.JButton();
        btnMetas = new javax.swing.JButton();

        setDefaultCloseOperation(
            javax.swing.WindowConstants.EXIT_ON_CLOSE
        );

        titulo.setText(
            "Sistema de Estudos Universitário"
        );

        btnHorario.setText(
            "Horário de Estudo"
        );

        btnMetas.setText(
            "Metas de Estudo"
        );

        btnHorario.addActionListener(evt -> {
            horarioPanel.abrirMenuHorario();
        });

        btnMetas.addActionListener(evt -> {
            metaPanel.abrirMenuMetas();
        });

        javax.swing.GroupLayout layout =
            new javax.swing.GroupLayout(
                getContentPane()
            );

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.CENTER
            )
            .addComponent(titulo)
            .addComponent(lblGrupo)
            .addComponent(btnHorario,150,150,150)
            .addComponent(btnMetas,150,150,150)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGap(30)
            .addComponent(titulo)
            .addGap(20)
            .addComponent(lblGrupo)
            .addGap(20)
            .addComponent(btnHorario)
            .addGap(15)
            .addComponent(btnMetas)
        );

        pack();

        setLocationRelativeTo(null);
    }
}