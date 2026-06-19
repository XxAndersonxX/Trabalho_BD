package com.soeu;

import com.soeu.conexaobanco.conexaofac;
import java.sql.Connection;

public class App {

    public static void main(String[] args) {
        Connection conexao = conexaofac.getConnection();

        if (conexao != null) {
            System.out.println("Conectado com sucesso!");
        }
    }
}