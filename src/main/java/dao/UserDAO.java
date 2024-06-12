/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.Connect.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Reader;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends Connect{
    public User getUser(String username, String password){
        String sql = "SELECT * FROM `user` WHERE username = ? AND password = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapUser(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public User getUserById(int id) throws SQLException{
        String sql = "SELECT * FROM `user` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapUser(rs);
                }
            }
        }
        return null;
    }


    public List<User> getUserByRoleid(int roleid) throws SQLException {
        String sql = "select * from user where roleid = ?";
        List<User> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, roleid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User u = mapUser(rs);
                    list.add(u);
                }
            }
        }
        return list;
    }

    public List<User> getUserByName(String key)  throws SQLException {
        String sql = "select * from user where roleid = 2 and (fullname like '%" + key + "%' or userid like '%" + key + "%');";
        List<User> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User u = mapUser(rs);
                    list.add(u);
                }
            }
        }
        return list;
    }

    public void addUser(User u) throws SQLException {
        this.insertUser(u);
        User u_new = this.getUser(u.getUsername(), u.getPassword());
        String useridString = "NV" + String.format("%03d", u_new.getId());
        this.updateUserId(useridString, u_new.getId());
    }
    
    public void insertUser(User u) throws SQLException{
        String sql = "INSERT INTO `librarymanagement`.`user` (`roleid`, `fullname`, `email`, `phone`, `address`, `username`, `password`, `status`) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, u.getRole().getId());
            ps.setString(2, u.getFullname());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPhone());
            ps.setString(5, u.getAddress());
            ps.setString(6, u.getUsername());
            ps.setString(7, u.getPassword());
            ps.setBoolean(8, true);
            ps.executeUpdate();
        }
    }

    private User mapUser(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("userid"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("address"), rs.getString("username"), rs.getString("password"), rs.getBoolean("status"), new RoleDAO().getRole(rs.getInt("roleid")));
    }

    private void updateUserId(String userid, int id) throws SQLException {
        String sql = "UPDATE `librarymanagement`.`user` SET `userid` = ? WHERE `id` = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, userid);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void updateUser(int id, User u) throws SQLException {
        String sql = "UPDATE `librarymanagement`.`user` "
                + "SET  `fullname` = ?, `email` = ?, `phone` = ?, `address` = ?, `username` = ?, `password` = ? , `status` = ? "
                + "WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, u.getFullname());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getAddress());
            ps.setString(5, u.getUsername());
            ps.setString(6, u.getPassword());
            ps.setBoolean(7, u.isStatus());
            ps.setInt(8, id);
            ps.executeUpdate();
        }
    }

    public void updatePassword(int id, String passnewString) throws SQLException {
        String sql = "UPDATE `librarymanagement`.`user` SET `password` = ? WHERE `id` = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, passnewString);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
