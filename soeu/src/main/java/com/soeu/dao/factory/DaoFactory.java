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
import com.soeu.util.DB;

public class DaoFactory {
    public static EntityDAO createAlunoDao(){
        return new AlunoDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createDisciplinaDAO(){
        return new DisciplinaDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createGrupoEstudo(){
        return new GrupoEstudoDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createHorarioEstudoDAO(){
        return new HorarioEstudoDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createMetasEstudoDAO(){
        return new MetasEstudoDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createNotificacoesDAO(){
        return new NotificacoesDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createProfessorDAO(){
        return new ProfessorDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createProvaDAO(){
        return new ProvaDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createTarefaDAO(){
        return new TarefaDAO(DB.getMySQLConnection());
    }

    public static EntityDAO createTurmaDAO(){
        return new TurmaDAO(DB.getMySQLConnection());
    }
}