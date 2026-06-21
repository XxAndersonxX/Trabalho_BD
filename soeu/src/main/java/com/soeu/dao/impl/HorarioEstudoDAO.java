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
import com.soeu.entities.GrupoEstudo;
import com.soeu.entities.HorarioEstudo;
import com.soeu.mapper.GrupoEstudoMapper;
import com.soeu.mapper.HorarioEstudoMapper;
import com.soeu.util.DB;
import com.soeu.util.DbException;

public class HorarioEstudoDAO implements EntityDAO<HorarioEstudo>{
    private Connection conn;

    public HorarioEstudoDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(HorarioEstudo horarioEstudo) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "INSERT INTO Horario_Estudo " +
                "(hora_inicio, hora_fim, id_grupo_FK) " +
                "VALUES " +
                "(?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setTime(1, java.sql.Time.valueOf(horarioEstudo.getHoraInicio()));
            ps.setTime(2, java.sql.Time.valueOf(horarioEstudo.getHoraFim()));
            ps.setInt(3, horarioEstudo.getGrupoEstudo().getIdGrupo());

            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                rs = ps.getGeneratedKeys();
                
                if(rs.next()){
                    int id = rs.getInt(1);
                    horarioEstudo.setIdHorario(id);
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
    public void update(HorarioEstudo horarioEstudo) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                "UPDATE Horario_Estudo " + 
                "SET hora_inicio = ? , hora_fim = ?, id_grupo_FK = ? " +
                "WHERE id_horario = ?"
            );

            ps.setTime(1, java.sql.Time.valueOf(horarioEstudo.getHoraInicio()));
            ps.setTime(2, java.sql.Time.valueOf(horarioEstudo.getHoraFim()));
            ps.setInt(3, horarioEstudo.getGrupoEstudo().getIdGrupo());
            ps.setInt(4, horarioEstudo.getIdHorario());

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
                "DELETE FROM Horario_Estudo WHERE id_horario = ?"
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
    public HorarioEstudo findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Horario_Estudo.*, Grupo_Estudo.* " +
                "FROM Horario_Estudo " +
                "INNER JOIN Grupo_Estudo " +
                "ON Horario_Estudo.id_grupo_FK = Grupo_Estudo.id_grupo " +
                "WHERE id_horario = ?"
            );

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if(rs.next()){
                GrupoEstudo grupoEstudo = GrupoEstudoMapper.createGrupoEstudo(rs);
                HorarioEstudo horarioEstudo = HorarioEstudoMapper.createHorarioEstudo(rs);
                horarioEstudo.setGrupoEstudo(grupoEstudo);

                return horarioEstudo;
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
    public List<HorarioEstudo> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                "SELECT Horario_Estudo.*, Grupo_Estudo.* " +
                "FROM Horario_Estudo " +
                "INNER JOIN Grupo_Estudo " +
                "ON Horario_Estudo.id_grupo_FK = Grupo_Estudo.id_grupo "
            );

            rs = ps.executeQuery();

            List<HorarioEstudo> horariosEstudo = new ArrayList<>();
            Map<Integer, GrupoEstudo> grupoMap = new HashMap<>();
            
            while(rs.next()){
                Integer key = rs.getInt("id_grupo_FK");

                if(!grupoMap.containsKey(key)){
                    GrupoEstudo grupoEstudo = GrupoEstudoMapper.createGrupoEstudo(rs);
                    grupoMap.put(key, grupoEstudo);
                }

                HorarioEstudo horarioEstudo = HorarioEstudoMapper.createHorarioEstudo(rs);
                horarioEstudo.setGrupoEstudo(grupoMap.get(key));

                horariosEstudo.add(horarioEstudo);
            }
            return horariosEstudo;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }   
}