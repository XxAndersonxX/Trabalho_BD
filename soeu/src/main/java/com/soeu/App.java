package com.soeu;

import com.soeu.entities.GrupoEstudo;
import com.soeu.view.GrupoEstudoTela;

public class App {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            GrupoEstudo grupo = new GrupoEstudo();

            grupo.setIdGrupo(1);
            grupo.setDescricao("Programação Java");

            new GrupoEstudoTela(grupo).setVisible(true);
        });
    }
}