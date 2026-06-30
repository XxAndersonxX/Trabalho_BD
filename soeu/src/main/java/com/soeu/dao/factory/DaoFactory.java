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
import com.soeu.util.DB;

public class DaoFactory {
    public static AlunoDAO createAlunoDAO(){
        return new AlunoDAO(DB.getMySQLConnection());
    }

    public static DisciplinaDAO createDisciplinaDAO(){
        return new DisciplinaDAO(DB.getMySQLConnection());
    }

    public static GrupoEstudoDAO createGrupoEstudoDAO(){
        return new GrupoEstudoDAO(DB.getMySQLConnection());
    }

    public static HorarioEstudoDAO createHorarioEstudoDAO(){
        return new HorarioEstudoDAO(DB.getMySQLConnection());
    }

    public static MetasEstudoDAO createMetasEstudoDAO(){
        return new MetasEstudoDAO(DB.getMySQLConnection());
    }

    public static NotificacoesDAO createNotificacoesDAO(){
        return new NotificacoesDAO(DB.getMySQLConnection());
    }

    public static ProfessorDAO createProfessorDAO(){
        return new ProfessorDAO(DB.getMySQLConnection());
    }

    public static ProvaDAO createProvaDAO(){
        return new ProvaDAO(DB.getMySQLConnection());
    }

    public static TarefaDAO createTarefaDAO(){
        return new TarefaDAO(DB.getMySQLConnection());
    }

    public static TurmaDAO createTurmaDAO(){
        return new TurmaDAO(DB.getMySQLConnection());
    }
}