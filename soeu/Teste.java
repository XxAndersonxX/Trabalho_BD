
import java.time.LocalDate;
import java.time.LocalTime;

import com.soeu.dao.factory.DaoFactory;
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


public class Teste {
     public static void main(String[] args){

        try {
            // ============================
            // Criando DAOs via Factory
            // ============================

            EntityDAO<Aluno> alunoDAO = DaoFactory.createAlunoDao();
            EntityDAO<Disciplina> disciplinaDAO = DaoFactory.createDisciplinaDAO();
            EntityDAO<GrupoEstudo> grupoDAO = DaoFactory.createGrupoEstudo();
            EntityDAO<HorarioEstudo> horarioDAO = DaoFactory.createHorarioEstudoDAO();
            EntityDAO<MetasEstudo> metasDAO = DaoFactory.createMetasEstudoDAO();
            EntityDAO<Notificacoes> notificacoesDAO = DaoFactory.createNotificacoesDAO();
            EntityDAO<Professor> professorDAO = DaoFactory.createProfessorDAO();
            EntityDAO<Prova> provaDAO = DaoFactory.createProvaDAO();
            EntityDAO<Tarefa> tarefaDAO = DaoFactory.createTarefaDAO();
            EntityDAO<Turma> turmaDAO = DaoFactory.createTurmaDAO();

            // ============================
            // ALUNO
            // ============================

            Aluno aluno = new Aluno();

            aluno.setEmail("teste@email.com");
            aluno.setCurso("CC");
            aluno.setSenha("123");
            aluno.setIra(8.5);
            aluno.setPeriodo(5);
            aluno.setDataNascimento(LocalDate.of(2002,5,12));

            alunoDAO.insert(aluno);

            aluno.setCurso("ES");
            alunoDAO.update(aluno);

            alunoDAO.findById(1);

            alunoDAO.findAll();

            alunoDAO.deleteById(5);


            // ============================
            // DISCIPLINA
            // ============================

            Disciplina disciplina = new Disciplina();

            disciplina.setCreditos(4);
            disciplina.setCurso("CC");
            disciplina.setPeriodo(3);

            disciplinaDAO.insert(disciplina);

            disciplina.setPeriodo(5);
            disciplinaDAO.update(disciplina);

            disciplinaDAO.findById(1);

            disciplinaDAO.findAll();

            disciplinaDAO.deleteById(5);


            // ============================
            // PROFESSOR
            // ============================

            Professor professor = new Professor();

            professor.setEmail("prof@email.com");
            professor.setTelefone("619999999");

            professorDAO.insert(professor);

            professor.setTelefone("618888888");

            professorDAO.update(professor);

            professorDAO.findById(1);

            professorDAO.findAll();

            professorDAO.deleteById(5);


            // ============================
            // GRUPO ESTUDO
            // ============================

            GrupoEstudo grupo = new GrupoEstudo();

            grupo.setDescricao("Grupo Java");

            grupoDAO.insert(grupo);

            grupo.setDescricao("Grupo Spring");

            grupoDAO.update(grupo);

            grupoDAO.findById(1);

            grupoDAO.findAll();

            grupoDAO.deleteById(5);


            // ============================
            // HORARIO ESTUDO
            // ============================

            HorarioEstudo horario = new HorarioEstudo();

            horario.setHoraInicio(LocalTime.of(8,0));
            horario.setHoraFim(LocalTime.of(10,0));
            horario.setGrupoEstudo(grupo);

            horarioDAO.insert(horario);

            horario.setHoraFim(LocalTime.of(11,0));

            horarioDAO.update(horario);

            horarioDAO.findById(1);

            horarioDAO.findAll();

            horarioDAO.deleteById(5);


            // ============================
            // METAS ESTUDO
            // ============================

            MetasEstudo meta = new MetasEstudo();

            meta.setHoraMeta(10);
            meta.setMetasEstudo("Resolver exercícios");
            meta.setGrupoEstudo(grupo);

            metasDAO.insert(meta);

            meta.setHoraMeta(15);

            metasDAO.update(meta);

            metasDAO.findById(1);

            metasDAO.findAll();

            metasDAO.deleteById(5);


            // ============================
            // PROVA
            // ============================

            Prova prova = new Prova();

            prova.setPeso(2.5);
            prova.setData(LocalDate.now());

            provaDAO.insert(prova);

            prova.setPeso(3.0);

            provaDAO.update(prova);

            provaDAO.findById(1);

            provaDAO.findAll();

            provaDAO.deleteById(5);


            // ============================
            // TURMA
            // ============================

            Turma turma = new Turma();

            turma.setSemestre(20261);
            turma.setHorario(LocalTime.of(19,0));
            turma.setDisciplina(disciplina);
            turma.setProfessor(professor);

            turmaDAO.insert(turma);

            turma.setSemestre(20262);

            turmaDAO.update(turma);

            turmaDAO.findById(1);

            turmaDAO.findAll();

            turmaDAO.deleteById(5);


            // ============================
            // TAREFA
            // ============================

            Tarefa tarefa = new Tarefa();

            tarefa.setPrazo(LocalDate.now().plusDays(7));
            tarefa.setStatus("Pendente");
            tarefa.setAluno(aluno);

            tarefaDAO.insert(tarefa);

            tarefa.setStatus("Concluída");

            tarefaDAO.update(tarefa);

            tarefaDAO.findById(1);

            tarefaDAO.findAll();

            tarefaDAO.deleteById(5);


            // ============================
            // NOTIFICAÇÕES
            // ============================

            Notificacoes notificacao = new Notificacoes();

            notificacao.setData(LocalDate.now());
            notificacao.setStatus("Pendente");
            notificacao.setDescricao("Nova atividade");
            notificacao.setAluno(aluno);

            notificacoesDAO.insert(notificacao);

            notificacao.setStatus("Lida");

            notificacoesDAO.update(notificacao);

            notificacoesDAO.findById(1);

            notificacoesDAO.findAll();

            notificacoesDAO.deleteById(5);
        } finally {
            DB.closeConnection();
        }
        
    }
}
