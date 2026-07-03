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
            String descricao = JOptionPane.showInputDialog("Descrição:");
            int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas meta:"));

            MetasEstudo meta = new MetasEstudo(horas, descricao, grupoAtual);

            metaService.create(meta);

            JOptionPane.showMessageDialog(null, "Meta criada!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Valor inválido");
        }
    }

    private void listarMetas(){

        List<MetasEstudo> metas = metaService.read(grupoAtual.getIdGrupo());
        StringBuilder texto = new StringBuilder();

        for(MetasEstudo m : metas){
            texto.append(
                "Meta: "
                + m.getMetasEstudo()
                + "\nHoras: "
                + m.getHoraMeta()
                + "\n\n"
            );
        }

        JOptionPane.showMessageDialog(null, texto.toString());
    }

    private void alterarMetas(){
        List<MetasEstudo> metas = metaService.read(grupoAtual.getIdGrupo());
        MetasEstudo[] vetor = metas.toArray(MetasEstudo[]::new); 

        MetasEstudo meta = (MetasEstudo) JOptionPane.showInputDialog( 
                null,
                "Selecione meta:", 
                null, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                vetor, 
                vetor[0] 
            ); 

        String metas_estudo = JOptionPane.showInputDialog(null, "Meta de estudo: ");
        String hora = JOptionPane.showInputDialog(null, "Horas a dedicar: ");

        try {
            Integer hora_meta = Integer.valueOf(hora);

            meta.setHoraMeta(hora_meta);
            meta.setMetasEstudo(metas_estudo);
            
            metaService.update(meta);
            JOptionPane.showMessageDialog(null, "Meta alterada"); 
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Formato de hora inválido. Use apenas números");
        }
    }

    private void apagarMetas(){
        List<MetasEstudo> metas = metaService.read(grupoAtual.getIdGrupo()); 
        MetasEstudo[] vetor = metas.toArray(MetasEstudo[]::new); 
        
        MetasEstudo meta = (MetasEstudo) JOptionPane.showInputDialog( 
                null,
                "Selecione meta:", 
                null,
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                vetor, 
                vetor[0] 
            ); 
            
        if(meta != null){ 
            metaService.delete(meta); 
            JOptionPane.showMessageDialog(null, "Meta apagada"); 
        }
    }
}