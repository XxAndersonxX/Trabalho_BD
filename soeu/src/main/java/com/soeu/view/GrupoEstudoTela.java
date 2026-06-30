package com.soeu.view;

import java.time.LocalTime;
import java.util.List;

import javax.swing.JOptionPane;

import com.soeu.entities.GrupoEstudo;
import com.soeu.entities.HorarioEstudo;
import com.soeu.services.HorarioService;

public class GrupoEstudoTela extends javax.swing.JFrame {

    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnMetas;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel lblGrupo;
    private final HorarioService horaService;
    private final GrupoEstudo grupoAtual;

    public GrupoEstudoTela(GrupoEstudo grupo) {
        initComponents();

        this.horaService = new HorarioService();

        this.grupoAtual = grupo;

        lblGrupo.setText("Grupo: " + grupo.getDescricao());
    }

    private void initComponents() {

        titulo = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();

        btnHorario = new javax.swing.JButton();
        btnMetas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setText("Sistema de Estudos Universitário");

        lblGrupo.setText("Grupo: Programação Java");

        btnHorario.setText("Horário de Estudo");

        btnHorario.addActionListener(evt -> {
            abrirMenuHorario();
        });

        btnMetas.setText("Metas de Estudo");

        btnMetas.addActionListener(evt -> {
            JOptionPane.showMessageDialog(
                this,
                "Tela de metas será implementada"
            );
        });

        javax.swing.GroupLayout layout =
                new javax.swing.GroupLayout(getContentPane());

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

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")
    private void abrirMenuHorario(){

        String[] opcoes = {
            "Criar horário de estudo",
            "Ver horários do grupo",
            "Alterar horário",
            "Apagar horário"
        };

        int escolha = JOptionPane.showOptionDialog(
                this,
                "Escolha uma opção:",
                "Horários de Estudo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );

        switch(escolha){
            case 0 -> criarHorario();

            case 1 -> listarHorarios();

            case 2 -> alterarHorario();

            case 3 -> apagarHorario();
        }

    }

    private void criarHorario(){

        JOptionPane.showMessageDialog(this, "Criar Horário");

        String inicio = JOptionPane.showInputDialog(this, "Digite o horário inicial:");
        String fim = JOptionPane.showInputDialog(this, "Digite o horário final:");

        try{
            LocalTime horaInicio = LocalTime.parse(inicio);
            LocalTime horaFinal = LocalTime.parse(fim);

            HorarioEstudo horario = new HorarioEstudo(horaInicio, horaFinal, grupoAtual);
            horaService.createHorario(horario);

            JOptionPane.showMessageDialog(this, "Horário criado!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Formato de hora inválido. Use HH:mm");
        }
    }

    private void listarHorarios(){

        JOptionPane.showMessageDialog(this, "Horários disponíveis");

        List<HorarioEstudo> horarios = horaService.readHorario();
        StringBuilder texto = new StringBuilder();

        for(HorarioEstudo h : horarios){
            texto.append("Hora inicial: " + h.getHoraInicio()
                        + " Hora final: " + h.getHoraFim() + "\n");
        }

        JOptionPane.showMessageDialog(this, texto.toString());
    }

    private void alterarHorario(){

        JOptionPane.showMessageDialog(this, "Alterar Horário");

        String inicio1 = JOptionPane.showInputDialog(this, "Novo horário inicial:");
        String fim1 = JOptionPane.showInputDialog(this, "Novo horário final:");

        try{
            LocalTime horaInicio = LocalTime.parse(inicio1);
            LocalTime horaFinal = LocalTime.parse(fim1);

            HorarioEstudo horario = new HorarioEstudo(horaInicio, horaFinal, grupoAtual);
            horaService.updateHorario(horario);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Formato de hora inválido. Use HH:mm");
        }
    }

    private void apagarHorario(){

        JOptionPane.showMessageDialog(this,"Abrir tela Apagar Horário");

        List<HorarioEstudo> horariosDel = horaService.readHorario();

        HorarioEstudo[] vetor = horariosDel.toArray(new HorarioEstudo[0]);

        HorarioEstudo horarioDel =
            (HorarioEstudo)
            JOptionPane.showInputDialog(
                    this,
                    "Selecione horário:",
                    "Apagar",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    vetor,
                    vetor[0]
            );

        if(horarioDel != null){
            horaService.deleteHorario(horarioDel);

            JOptionPane.showMessageDialog(this, "Horário apagado");
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            GrupoEstudo grupo = new GrupoEstudo();

            grupo.setDescricao("Programação Java");

            new GrupoEstudoTela(grupo).setVisible(true);
        });

    }
}