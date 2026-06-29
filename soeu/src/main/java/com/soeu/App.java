package com.soeu;

import java.sql.Connection;

import com.soeu.conexaobanco.conexaofac;

public class App {

    public static void main(String[] args) {
        Connection conexao = conexaofac.getConnection();

        if (conexao != null) {
            System.out.println("Conectado com sucesso!");
        }
    }
}