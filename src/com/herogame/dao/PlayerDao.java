package com.herogame.dao;

import com.herogame.db.DBConnection;
import com.herogame.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {

    public List<String> getAllPlayers() {
        List<String> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT p.PlayerId, p.PlayerName, p.HighScore, p.Level, n.NationalName " +
                    "FROM Player p JOIN National n ON p.NationalId = n.NationalId";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String data = rs.getInt("PlayerId") + " - "
                        + rs.getString("PlayerName") + " - "
                        + rs.getInt("HighScore") + " - "
                        + rs.getInt("Level") + " - "
                        + rs.getString("NationalName");

                list.add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔥 2. Thêm Player (2 PK)
    public void addPlayer(Player p) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO Player VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPlayerId());
            ps.setInt(2, p.getNationalId());
            ps.setString(3, p.getPlayerName());
            ps.setInt(4, p.getHighScore());
            ps.setInt(5, p.getLevel());

            ps.executeUpdate();

            System.out.println("Thêm thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deletePlayer(int playerId, int nationalId) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM Player WHERE PlayerId = ? AND NationalId = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, playerId);
            ps.setInt(2, nationalId);

            ps.executeUpdate();

            System.out.println("Xóa thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> searchByName(String name) {
        List<String> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM Player WHERE PlayerName LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String data = rs.getInt("PlayerId") + " - "
                        + rs.getString("PlayerName");

                list.add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public List<String> top10Players() {
        List<String> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM Player ORDER BY HighScore DESC LIMIT 10";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String data = rs.getString("PlayerName") + " - "
                        + rs.getInt("HighScore");

                list.add(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}