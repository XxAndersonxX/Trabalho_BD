package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soeu.dao.interfaces.AbstractDAO;
import com.soeu.entities.Aluno;
import com.soeu.entities.Tarefa;
import com.soeu.mapper.AlunoMapper;
import com.soeu.mapper.TarefaMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class TarefaDAO extends AbstractDAO<Tarefa>{

    public TarefaDAO(Connection conn){
        super(conn);
    }

    @Override
    public void insert(Tarefa tarefa) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Tarefa " +
                "(descricao, prazo, status, matricula_FK) " +
                "VALUES " +
                "(?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, tarefa.getDescricao());
            ps.setDate(2, java.sql.Date.valueOf(tarefa.getPrazo()));
            ps.setString(3, tarefa.getStatus());
            ps.setInt(4, tarefa.getAluno().getMatricula());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();

                if(rs.next()){
                    int id = rs.getInt(1);
                    tarefa.setIdTarefa(id);
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Tarefa tarefa) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Tarefa " + 
                "SET prazo = ?, status = ?, matricula_FK = ? " +
                "WHERE id_tarefa = ?"
            );

            ps.setDate(1, java.sql.Date.valueOf(tarefa.getPrazo()));
            ps.setString(2, tarefa.getStatus());
            ps.setInt(3, tarefa.getAluno().getMatricula());
            ps.setInt(4, tarefa.getIdTarefa());

            ps.executeUpdate();  
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "DELETE FROM Tarefa WHERE id_tarefa = ?"
            );

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    @Override
    public Tarefa findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Tarefa.*, Aluno.* " +
                "FROM Tarefa " +
                "INNER JOIN Aluno " +
                "ON Tarefa.matricula_FK = Aluno.matricula " +
                "WHERE id_tarefa = ?"
            );

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Aluno aluno = AlunoMapper.createAluno(rs);
                Tarefa tarefa = TarefaMapper.createTarefa(rs);
                tarefa.setAluno(aluno);

                return tarefa;
            }

            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage()); 
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
public List<Tarefa> findAllById(Integer id) {
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = conn.prepareStatement(
            "SELECT Tarefa.*, Aluno.* " +
            "FROM Tarefa " +
            "INNER JOIN Aluno " +
            "ON Tarefa.matricula_FK = Aluno.matricula " +
            "WHERE Aluno.matricula = ?"
        );

        ps.setInt(1, id); // faltava isso

        rs = ps.executeQuery();

        List<Tarefa> tarefas = new ArrayList<>();

        while (rs.next()) {
            Aluno aluno = AlunoMapper.createAluno(rs);
            Tarefa tarefa = TarefaMapper.createTarefa(rs);

            tarefa.setAluno(aluno);
            tarefas.add(tarefa);
        }

        return tarefas;

    } catch (SQLException e) {
        throw new DbException(e.getMessage());
    } finally {
        DB.closeResultSet(rs);
        DB.closeStatement(ps);
        }
    }
}