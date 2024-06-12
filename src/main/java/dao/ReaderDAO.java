/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.Connect.connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Reader;

/**
 *
 * @author Admin
 */
public class ReaderDAO extends Connect{
    public Reader getReaderByReaderId(String readerid) throws SQLException{
        String sql = "SELECT * FROM `reader` WHERE readerid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, readerid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapReader(rs);
                }
            }
        }
        return null;
    }
    
    public Reader getReaderById(int id) throws SQLException{
        String sql = "SELECT * FROM `reader` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapReader(rs);
                }
            }
        }
        return null;
    }

    private Reader mapReader(ResultSet rs) throws SQLException {
        return new Reader(rs.getInt("id"), rs.getString("readerid"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("address"), rs.getDate("date"));
    }

    public List<Reader> getAllReader() throws SQLException {
        List<Reader> list = new ArrayList<>();
        String sql = "SELECT * FROM librarymanagement.reader";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reader r = mapReader(rs);
                    list.add(r);
                }
            }
        }
        return list;
    }

    public List<Reader> getReaderByKey(String key) throws SQLException {
        List<Reader> list = new ArrayList<>();
        String sql = "SELECT * FROM librarymanagement.reader where fullname like '%" + key + "%' or readerid like '%" + key + "%'";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reader r = mapReader(rs);
                    list.add(r);
                }
            }
        }
        return list;
    }

    public void addReader(Reader a) throws SQLException {
        int id = this.getReaderIdEnd();
        String readerid = "BD" + String.format("%03d", id+1);
        this.insertReader(a, readerid);
        
    }
    
    public void insertReader (Reader a, String readerid)throws SQLException {
        String sql = "INSERT INTO `librarymanagement`.`reader`(`fullname`, `email`, `phone`, `address`, `date`, `readerid`) VALUES (?, ?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, a.getFullname());
            ps.setString(2, a.getEmail());
            ps.setString(3, a.getPhone());
            ps.setString(4, a.getAddress());
            ps.setDate(5, a.getDate());
            ps.setString(6, readerid);
            ps.executeUpdate();
        }
    }

    private int getReaderIdEnd() throws SQLException {
        String sql = "SELECT id FROM reader ORDER BY id desc LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        }
        return 0;
    }

    public List<Reader> getReaderByDate(Date datestart, Date dateend) throws SQLException {
        List<Reader> list = new ArrayList<>();
        String sql = "select * FROM `librarymanagement`.`reader` WHERE date >= ? and date <= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, datestart);
            ps.setDate(2, dateend);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reader r = mapReader(rs);
                    list.add(r);
                }
            }
        }
        return list;
    }

    public void updateReader(Reader r, int id) throws SQLException {
        String sql = "UPDATE `librarymanagement`.`reader` SET `fullname` = ?, `email` = ?, `phone` = ?, `address` = ?, `date` = ? WHERE `id` = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, r.getFullname());
            ps.setString(2, r.getEmail());
            ps.setString(3, r.getPhone());
            ps.setString(4, r.getAddress());
            ps.setDate(5, r.getDate());
            ps.setInt(6, id);
            ps.executeUpdate();
        }
    }

    public boolean deleteReader(int id) {
        String sql = "DELETE FROM `librarymanagement`.`reader` WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
//            Logger.getLogger(ReaderDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
