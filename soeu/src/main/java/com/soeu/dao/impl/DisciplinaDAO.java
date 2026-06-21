package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soeu.dao.interfaces.EntityDAO;
import com.soeu.entities.Disciplina;
import com.soeu.mapper.DisciplinaMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class DisciplinaDAO implements EntityDAO<Disciplina>{
    private Connection conn;

    public DisciplinaDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Disciplina disciplina) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Disciplina " +
                "(creditos, curso, periodo) " +
                "VALUES " +
                "(?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, disciplina.getCreditos());
            ps.setString(2, disciplina.getCurso());
            ps.setInt(3, disciplina.getPeriodo());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    disciplina.setCodigo(id);
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
    public void update(Disciplina disciplina) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Disciplina " + 
                "SET creditos = ?, curso = ?, periodo = ? " +
                "WHERE codigo = ?"
            );

            ps.setInt(1, disciplina.getCreditos());
            ps.setString(2, disciplina.getCurso());
            ps.setInt(3, disciplina.getPeriodo());
            ps.setInt(4, disciplina.getCodigo());

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
                "DELETE FROM Disciplina WHERE codigo = ?"
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
    public Disciplina findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Disciplina " +
                "WHERE codigo = ?"
            );
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Disciplina disciplina = DisciplinaMapper.createDisciplina(rs);
                return disciplina;
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
    public List<Disciplina> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Disciplina"
            );
            rs = ps.executeQuery();

            List<Disciplina> disciplinas = new ArrayList<>();
            while(rs.next()){
                Disciplina disciplina = DisciplinaMapper.createDisciplina(rs);
                disciplinas.add(disciplina);
            }
            return disciplinas;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}