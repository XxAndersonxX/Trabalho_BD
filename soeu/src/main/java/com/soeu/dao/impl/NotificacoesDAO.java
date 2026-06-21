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
import com.soeu.entities.Aluno;
import com.soeu.entities.Notificacoes;
import com.soeu.mapper.AlunoMapper;
import com.soeu.mapper.NotificacoesMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class NotificacoesDAO implements EntityDAO<Notificacoes>{
    private Connection conn;

    public NotificacoesDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Notificacoes notificacoes) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Notificacoes " +
                "(data, status, descricao, matricula_FK) " +
                "VALUES " +
                "(?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setDate(1, java.sql.Date.valueOf(notificacoes.getData()));
            ps.setString(2, notificacoes.getStatus());
            ps.setString(3, notificacoes.getDescricao());
            ps.setInt(4, notificacoes.getAluno().getMatricula());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();

                if(rs.next()){
                    int id = rs.getInt(1);
                    notificacoes.setIdNotificacao(id);
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
    public void update(Notificacoes notificacoes) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Notificacoes " + 
                "SET data = ?, status = ?, descricao = ?, matricula_FK = ? " +
                "WHERE id_notificacao = ?"
            );

            ps.setDate(1, java.sql.Date.valueOf(notificacoes.getData()));
            ps.setString(2, notificacoes.getStatus());
            ps.setString(3, notificacoes.getDescricao());
            ps.setInt(4, notificacoes.getAluno().getMatricula());
            ps.setInt(5, notificacoes.getIdNotificacao());

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
                "DELETE FROM Notificacoes WHERE id_notificacao = ?"
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
    public Notificacoes findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Notificacoes.*, Aluno.*" +
                "FROM Notificacoes " +
                "INNER JOIN Aluno " +
                "ON Notificacoes.matricula_FK = Aluno.matricula " +
                "WHERE id_notificacao = ?"
            );
            
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                Aluno aluno = AlunoMapper.createAluno(rs);
                Notificacoes notificacao = NotificacoesMapper.createNotificacao(rs);
                notificacao.setAluno(aluno);

                return notificacao;
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
    public List<Notificacoes> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Notificacoes.*, Aluno.* " +
                "FROM Notificacoes " +
                "INNER JOIN Aluno " +
                "ON Notificacoes.matricula_FK = Aluno.matricula "
            );

            rs = ps.executeQuery();

            List<Notificacoes> notificacoes = new ArrayList<>();
            Map<Integer, Aluno> alunoMap = new HashMap<>();

            while(rs.next()){
                Integer key = rs.getInt("matricula_FK");

                if(!alunoMap.containsKey(key)){
                    Aluno aluno = AlunoMapper.createAluno(rs);
                    alunoMap.put(key, aluno);
                }

                Notificacoes notificacao = NotificacoesMapper.createNotificacao(rs);
                notificacao.setAluno(alunoMap.get(key));

                notificacoes.add(notificacao);
            }
            
            return notificacoes;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }
}