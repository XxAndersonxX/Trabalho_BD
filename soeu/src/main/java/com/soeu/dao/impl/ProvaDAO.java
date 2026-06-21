package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soeu.dao.interfaces.EntityDAO;
import com.soeu.entities.Prova;
import com.soeu.mapper.ProvaMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class ProvaDAO implements EntityDAO<Prova>{
    private Connection conn;

    public ProvaDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Prova prova) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Prova " +
                "(peso, data) " +
                "VALUES " +
                "(?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setDouble(1, prova.getPeso());
            ps.setDate(2, java.sql.Date.valueOf(prova.getData()));

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();

                if(rs.next()){
                    int id = rs.getInt(1);
                    prova.setIdProva(id);
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
    public void update(Prova prova) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Prova " + 
                "SET peso = ?, data = ? " +
                "WHERE id_prova = ?"
            );

            ps.setDouble(1, prova.getPeso());
            ps.setDate(2, java.sql.Date.valueOf(prova.getData()));
            ps.setInt(3, prova.getIdProva());

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
                "DELETE FROM Prova WHERE id_prova = ?"
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
    public Prova findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Prova " +
                "WHERE id_prova = ?"
            );

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Prova prova = ProvaMapper.createProva(rs);

                return prova;
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
    public List<Prova> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT * " +
                "FROM Prova"
            );
            rs = ps.executeQuery();

            List<Prova> provas = new ArrayList<>();

            while(rs.next()){

                Prova prova = ProvaMapper.createProva(rs);
                provas.add(prova);
            }
            return provas;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    public void insertTurma(Integer idProva,Integer idTurma){
        PreparedStatement ps=null;

        try{
            ps=conn.prepareStatement(
                "INSERT INTO Tem " +
                "(id_prova,id_turma) " +
                "VALUES " +
                "(?,?)"
            );

            ps.setInt(1, idProva);
            ps.setInt(2, idTurma);

            ps.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    public void deleteTurma(Integer idProva, Integer idTurma){
        PreparedStatement ps=null;

        try{
            ps=conn.prepareStatement(
                "DELETE FROM Tem " +
                "WHERE id_prova = ? " +
                "AND id_turma = ?"
            );

            ps.setInt(1,idProva);
            ps.setInt(2,idTurma);

            ps.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(ps);
        }
    }

    public List<Prova> findTurma(Integer idTurma){
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            ps=conn.prepareStatement(
                "SELECT Prova.* " +
                "FROM Prova " +
                "INNER JOIN Tem " +
                "ON Prova.id_prova = Tem.id_prova " +
                "WHERE Tem.id_turma = ?"
            );
            
            ps.setInt(1, idTurma);

            rs=ps.executeQuery();

            List<Prova> provas = new ArrayList<>();

            while(rs.next()){

                provas.add(ProvaMapper.createProva(rs));
            }

            return provas;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}