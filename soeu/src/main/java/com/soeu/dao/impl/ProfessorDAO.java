package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soeu.dao.interfaces.EntityDAO;
import com.soeu.entities.Professor;
import com.soeu.mapper.ProfessorMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class ProfessorDAO implements EntityDAO<Professor>{
    private Connection conn;

    public ProfessorDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Professor professor) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Professor " +
                "(email, telefone) " +
                "VALUES " +
                "(?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, professor.getEmail());
            ps.setString(2, professor.getTelefone());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();

                if(rs.next()){
                    int id = rs.getInt(1);
                    professor.setIdProfessor(id);
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
    public void update(Professor professor) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Professor " + 
                "SET email = ?, telefone = ? " +
                "WHERE id_professor = ?"
            );

            ps.setString(1, professor.getEmail());
            ps.setString(2, professor.getTelefone());
            ps.setInt(3, professor.getIdProfessor());

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
                "DELETE FROM Professor WHERE id_professor = ?"
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
    public Professor findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Professor " +
                "WHERE id_professor = ?"
            );

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Professor professor = ProfessorMapper.createProfessor(rs);
                return professor;
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
    public List<Professor> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Professor"
            );

            rs = ps.executeQuery();

            List<Professor> professores = new ArrayList<>();

            while(rs.next()){
                Professor professor = ProfessorMapper.createProfessor(rs);
                professores.add(professor);
            }
            
            return professores;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}