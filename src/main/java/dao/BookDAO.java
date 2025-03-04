package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

public class BookDAO extends Connect {
    public Book getBookById(int id) throws SQLException {
        String sql = "SELECT * FROM `book` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapBook(rs);
                }
            }
        }
        return null;
    }

    public List<Book> getAllBook() throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM `book`";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapBook(rs));
            }
        }
        return list;
    }

    public List<Book> getBookByName(String searchString) throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM `book` WHERE name LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + searchString + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapBook(rs));
                }
            }
        }
        return list;
    }
    
    public int getCountBookById(int id) throws SQLException{
        String sql = "select count(*) from abook where bookid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("count(*)");
                }
            }
        }
        return 0;
    }

    public List<Book> getBookByGenreId(int id) throws SQLException {
        List<Book> list = new ArrayList<>();
        String sql = "select * from book where genreid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapBook(rs));
                }
            }
        }
        return list;
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO `book`(`genreid`, `name`, `author`, `price`, `numberpage`, `description`) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, book.getGenre().getId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getPrice());
            ps.setInt(5, book.getNumberpage());
            ps.setString(6, book.getDescription());
            ps.executeUpdate();
        }
    }

    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE `librarymanagement`.`book` "
                + "SET `genreid` = ?, `name` = ?, `author` = ?, "
                + "`price` = ?, `numberpage` = ?, `description` = ? "
                + "WHERE `id` = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, book.getGenre().getId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getPrice());
            ps.setInt(5, book.getNumberpage());
            ps.setString(6, book.getDescription());
            ps.setInt(7, book.getId());
            ps.executeUpdate();
        }
    }

    public boolean deleteBook(int id) {
        String sql = "DELETE FROM `librarymanagement`.`book` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        return new Book(rs.getInt("id"), rs.getInt("price"), rs.getInt("numberpage"), rs.getString("name"), rs.getString("author"), rs.getString("description"), new GenreDAO().getGenreById(rs.getInt("genreid")));
    }
}
