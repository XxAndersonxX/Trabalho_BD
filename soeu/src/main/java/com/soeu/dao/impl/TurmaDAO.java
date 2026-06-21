package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.soeu.dao.interfaces.EntityDAO;
import com.soeu.entities.Disciplina;
import com.soeu.entities.Professor;
import com.soeu.entities.Turma;
import com.soeu.mapper.DisciplinaMapper;
import com.soeu.mapper.ProfessorMapper;
import com.soeu.mapper.TurmaMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class TurmaDAO implements EntityDAO<Turma>{

    private Connection conn;

    public TurmaDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Turma turma) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Turma " +
                "(semestre, horario, codigo_FK, id_professor_FK) " +
                "VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, turma.getSemestre());
            ps.setTime(2, java.sql.Time.valueOf(turma.getHorario()));
            ps.setInt(3, turma.getDisciplina().getCodigo());
            ps.setInt(4, turma.getProfessor().getIdProfessor());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();

                if(rs.next()){
                    turma.setIdTurma(rs.getInt(1));
                }
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Turma turma) {
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement(
                "UPDATE Turma " +
                "SET semestre = ?, horario = ?, codigo_FK = ?, id_professor_FK = ? " +
                "WHERE id_turma = ?"
            );

            ps.setInt(1, turma.getSemestre());
            ps.setTime(2, java.sql.Time.valueOf(turma.getHorario()));
            ps.setInt(3, turma.getDisciplina().getCodigo());
            ps.setInt(4, turma.getProfessor().getIdProfessor());
            ps.setInt(5, turma.getIdTurma());

            ps.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement(
                "DELETE FROM Turma WHERE id_turma = ?"
            );

            ps.setInt(1,id);

            ps.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    @Override
    public Turma findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement(
                "SELECT Turma.*, Disciplina.*, Professor.* " +
                "FROM Turma " +
                "INNER JOIN Disciplina " +
                "ON Turma.codigo_FK = Disciplina.codigo " +
                "INNER JOIN Professor " +
                "ON Turma.id_professor_FK = Professor.id_professor " +
                "WHERE id_turma = ?"
            );

            ps.setInt(1,id);

            rs = ps.executeQuery();

            if(rs.next()){
                Disciplina disciplina = DisciplinaMapper.createDisciplina(rs);
                Professor professor = ProfessorMapper.createProfessor(rs);
                Turma turma = TurmaMapper.createTurma(rs);

                turma.setDisciplina(disciplina);
                turma.setProfessor(professor);

                return turma;
            }

            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public List<Turma> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = conn.prepareStatement(
                "SELECT Turma.*, Disciplina.*, Professor.* " +
                "FROM Turma " +
                "INNER JOIN Disciplina " +
                "ON Turma.codigo_FK = Disciplina.codigo " +
                "INNER JOIN Professor " +
                "ON Turma.id_professor_FK = Professor.id_professor"
            );

            rs = ps.executeQuery();

            List<Turma> turmas = new ArrayList<>();
            Map<Integer,Disciplina> disciplinaMap = new HashMap<>();
            Map<Integer,Professor> professorMap = new HashMap<>();

            while(rs.next()){
                Integer disciplinaKey = rs.getInt("codigo");
                Integer professorKey = rs.getInt("id_professor");

                if(!disciplinaMap.containsKey(disciplinaKey)){
                    Disciplina disciplina = DisciplinaMapper.createDisciplina(rs);

                    disciplinaMap.put(disciplinaKey, disciplina);
                }

                if(!professorMap.containsKey(professorKey)){
                    Professor professor = ProfessorMapper.createProfessor(rs);

                    professorMap.put(professorKey, professor);
                }

                Turma turma = TurmaMapper.createTurma(rs);

                turma.setDisciplina(disciplinaMap.get(disciplinaKey));
                turma.setProfessor(professorMap.get(professorKey));

                turmas.add(turma);
            }

            return turmas;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}