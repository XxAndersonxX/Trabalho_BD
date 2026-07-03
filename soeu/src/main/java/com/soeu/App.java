package com.soeu;

//import com.soeu.entities.GrupoEstudo;
//import com.soeu.view.GrupoEstudoTela;
import com.soeu.view.LoginTela;

public class App {

        public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginTela().setVisible(true);
        });
    }
}
