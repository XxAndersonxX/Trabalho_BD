package com.soeu.view;

import java.time.LocalTime;
import java.util.List;

import javax.swing.JOptionPane;

import com.soeu.entities.GrupoEstudo;
import com.soeu.entities.HorarioEstudo;
import com.soeu.services.HorarioService;

public class HorarioEstudoPanel {

    private final HorarioService horaService;
    private final GrupoEstudo grupoAtual;

    public HorarioEstudoPanel(GrupoEstudo grupo){
        this.grupoAtual = grupo;
        this.horaService = new HorarioService();
    }

    public void abrirMenuHorario(){

        String[] opcoes = {
            "Criar horário",
            "Ver horários",
            "Alterar horário",
            "Apagar horário"
        };

        int escolha = JOptionPane.showOptionDialog(
            null,
            "Escolha:",
            "Horários",
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
        String inicio = JOptionPane.showInputDialog("Hora inicial (HH:mm)");
        String fim = JOptionPane.showInputDialog("Hora final (HH:mm)");

        try{
            LocalTime horaInicio = LocalTime.parse(inicio);
            LocalTime horaFim = LocalTime.parse(fim);

            HorarioEstudo horario = new HorarioEstudo(horaInicio, horaFim, grupoAtual);

            horaService.create(horario);

            JOptionPane.showMessageDialog(null,"Horário criado!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Formato inválido");
        }
    }

    private void listarHorarios(){

        List<HorarioEstudo> horarios = horaService.read();
        StringBuilder texto = new StringBuilder();

        for(HorarioEstudo h : horarios){
            texto.append(
                "Início: "
                + h.getHoraInicio()
                + " | Fim: "
                + h.getHoraFim()
                + "\n"
            );
        }

        JOptionPane.showMessageDialog(null, texto.toString());
    }

    private void alterarHorario(){
        JOptionPane.showMessageDialog(null, "Implementar seleção do horário");

        String inicio1 = JOptionPane.showInputDialog(this, "Novo horário inicial:");
        String fim1 = JOptionPane.showInputDialog(this, "Novo horário final:"); 
        
        try{ LocalTime horaInicio = LocalTime.parse(inicio1); 
            LocalTime horaFinal = LocalTime.parse(fim1); 
            HorarioEstudo horario = new HorarioEstudo(horaInicio, horaFinal, grupoAtual); 
            
            horaService.update(horario); 
        }catch(Exception e){ 
            JOptionPane.showMessageDialog(null, "Formato de hora inválido. Use HH:mm"); 
        }
    }

    private void apagarHorario(){
        JOptionPane.showMessageDialog(null, "Implementar exclusão");

        List<HorarioEstudo> horariosDel = horaService.read(); 
        HorarioEstudo[] vetor = horariosDel.toArray(new HorarioEstudo[0]); 
        HorarioEstudo horarioDel = 
            (HorarioEstudo) 
            JOptionPane.showInputDialog( 
                null,
                "Selecione horário:", 
                "Apagar", 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                vetor, 
                vetor[0] 
            ); 
            
        if(horarioDel != null){ 
            horaService.delete(horarioDel); 
            JOptionPane.showMessageDialog(null, "Horário apagado"); 
        }
    }
}