package com.soeu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soeu.entities.Prova;
import com.soeu.mapper.ProvaMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class TemDAO {
    private Connection conn;

    public TemDAO(Connection conn){
        this.conn = conn;
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