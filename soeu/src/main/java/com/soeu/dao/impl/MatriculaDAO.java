package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soeu.entities.Disciplina;
import com.soeu.entities.Professor;
import com.soeu.entities.Turma;
import com.soeu.mapper.DisciplinaMapper;
import com.soeu.mapper.ProfessorMapper;
import com.soeu.mapper.TurmaMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class MatriculaDAO {
    private Connection conn;

    public MatriculaDAO(Connection conn){
        this.conn = conn;
    }

    public void insert(Integer id_turma, Integer matricula){
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Matricula " +
                "(id_turma, matricula) " +
                "VALUES " +
                "(?, ?)"
            );

            ps.setInt(1, id_turma);
            ps.setInt(2, matricula);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    public void delete(Integer id_turma, Integer matricula){
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "DELETE FROM Matricula " +
                "WHERE id_turma = ? " +
                "AND matricula = ?"
            );

            ps.setInt(1, id_turma);
            ps.setInt(2, matricula);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    public List<Turma> findTurmasByAluno(Integer matricula){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Turma.*, Disciplina.*, Professor.* " +
                "FROM Turma " +
                "INNER JOIN Matricula " +
                "ON Turma.id_turma = Matricula.id_turma " +
                "INNER JOIN Disciplina " +
                "ON Turma.codigo_FK = Disciplina.codigo " +
                "INNER JOIN Professor " +
                "ON Turma.id_professor_FK = Professor.id_professor " +
                "WHERE Matricula.matricula = ?"
            );

            ps.setInt(1, matricula);

            rs = ps.executeQuery();
            
            List<Turma> turmas = new ArrayList<>();

            while(rs.next()){
                Disciplina disciplina = DisciplinaMapper.createDisciplina(rs);
                Professor professor = ProfessorMapper.createProfessor(rs);
                Turma turma = TurmaMapper.createTurma(rs);
                
                turma.setDisciplina(disciplina);
                turma.setProfessor(professor);

                turmas.add(turma);
            }

            return turmas;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}
