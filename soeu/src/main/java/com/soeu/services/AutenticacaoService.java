package com.soeu.services;

import com.soeu.dao.factory.DaoFactory;
import com.soeu.dao.impl.AlunoDAO;
import com.soeu.entities.Aluno;

public class AutenticacaoService {
    public Aluno autenticar(String email, String senha){
        AlunoDAO alunoDAO = DaoFactory.createAlunoDAO();

        Aluno aluno = alunoDAO.findByEmail(email);

        if(aluno == null){
            throw new RuntimeException("Usuario não encontrado");
        }

        if(!aluno.getSenha().equals(senha)){
            throw new RuntimeException("Senha incorreta");
        }
        
        return aluno;
    }
}
