package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soeu.dao.interfaces.EntityDAO;
import com.soeu.entities.Aluno;
import com.soeu.mapper.AlunoMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class AlunoDAO implements EntityDAO<Aluno>{
    private Connection conn;

    public AlunoDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Aluno aluno) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Aluno " +
                "(email, curso, senha, ira, periodo, data_nascimento) " +
                "VALUES " +
                "(?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, aluno.getEmail());
            ps.setString(2, aluno.getCurso());
            ps.setString(3, aluno.getSenha());
            ps.setDouble(4, aluno.getIra());
            ps.setInt(5, aluno.getPeriodo());
            ps.setDate(6, java.sql.Date.valueOf(aluno.getDataNascimento()));

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    aluno.setMatricula(id);
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
    public void update(Aluno aluno) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Aluno " + 
                "SET email = ?, curso = ?, senha = ?, ira = ?, periodo = ?, data_nascimento = ? " +
                "WHERE matricula = ?"
            );

            ps.setString(1, aluno.getEmail());
            ps.setString(2, aluno.getCurso());
            ps.setString(3, aluno.getSenha());
            ps.setDouble(4, aluno.getIra());
            ps.setInt(5, aluno.getPeriodo());
            ps.setDate(6, java.sql.Date.valueOf(aluno.getDataNascimento()));
            ps.setInt(7, aluno.getMatricula());

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
                "DELETE FROM Aluno WHERE matricula = ?"
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
    public Aluno findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Aluno " +
                "WHERE matricula = ?"
            );
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Aluno aluno = AlunoMapper.createAluno(rs);
                return aluno;
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
    public List<Aluno> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Aluno"
            );
            rs = ps.executeQuery();

            List<Aluno> alunos = new ArrayList<>();
            while(rs.next()){
                Aluno aluno = AlunoMapper.createAluno(rs);
                alunos.add(aluno);
            }
            return alunos;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}