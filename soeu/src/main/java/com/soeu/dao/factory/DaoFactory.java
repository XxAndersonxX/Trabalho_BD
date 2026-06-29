package com.soeu.dao.factory;

import com.soeu.dao.impl.AlunoDAO;
import com.soeu.dao.impl.DisciplinaDAO;
import com.soeu.dao.impl.GrupoEstudoDAO;
import com.soeu.dao.impl.HorarioEstudoDAO;
import com.soeu.dao.impl.MetasEstudoDAO;
import com.soeu.dao.impl.NotificacoesDAO;
import com.soeu.dao.impl.ProfessorDAO;
import com.soeu.dao.impl.ProvaDAO;
import com.soeu.dao.impl.TarefaDAO;
import com.soeu.dao.impl.TurmaDAO;
import com.soeu.dao.interfaces.EntityDAO;
import com.soeu.entities.Aluno;
import com.soeu.entities.Disciplina;
import com.soeu.entities.GrupoEstudo;
import com.soeu.entities.HorarioEstudo;
import com.soeu.entities.MetasEstudo;
import com.soeu.entities.Notificacoes;
import com.soeu.entities.Professor;
import com.soeu.entities.Prova;
import com.soeu.entities.Tarefa;
import com.soeu.entities.Turma;
import com.soeu.util.DB;

public class DaoFactory {
    public static EntityDAO<Aluno> createAlunoDao(){
        return new AlunoDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<Disciplina> createDisciplinaDAO(){
        return new DisciplinaDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<GrupoEstudo> createGrupoEstudo(){
        return new GrupoEstudoDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<HorarioEstudo> createHorarioEstudoDAO(){
        return new HorarioEstudoDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<MetasEstudo> createMetasEstudoDAO(){
        return new MetasEstudoDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<Notificacoes> createNotificacoesDAO(){
        return new NotificacoesDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<Professor> createProfessorDAO(){
        return new ProfessorDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<Prova> createProvaDAO(){
        return new ProvaDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<Tarefa> createTarefaDAO(){
        return new TarefaDAO(DB.getMySQLConnection());
    }

    public static EntityDAO<Turma> createTurmaDAO(){
        return new TurmaDAO(DB.getMySQLConnection());
    }
}