package service;

import config.DBConfig;
import dao.NoteDAO;
import entity.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteService extends DBConfig implements NoteDAO{

    Connection connection = getConnection();

    @Override
    public void add(Note note) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO NOTE (ID, TITLE, CONTENT, PUBLISHDATE) VALUES(?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, note.getId());
            preparedStatement.setString(2, note.getTitle());
            preparedStatement.setString(3, note.getContent());
            preparedStatement.setDate(4, note.getPublishDate());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public List<Note> getAll() throws SQLException {
        List<Note> noteList = new ArrayList<>();

        String sql = "SELECT ID, TITLE, CONTENT, PUBLISHDATE FROM NOTE";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Note note = new Note();
                note.setId(resultSet.getLong("ID"));
                note.setTitle(resultSet.getString("TITLE"));
                note.setContent(resultSet.getString("CONTENT"));
                note.setPublishDate(resultSet.getDate("PUBLISHDATE"));

                noteList.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return noteList;
    }

    @Override
    public Note getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, TITLE, CONTENT, PUBLISHDATE FROM NOTE WHERE ID = ?";

        Note note = new Note();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            note.setId(resultSet.getLong("ID"));
            note.setTitle(resultSet.getString("TITLE"));
            note.setContent(resultSet.getString("CONTENT"));
            note.setPublishDate(resultSet.getDate("PUBLISHDATE"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return note;
    }

    @Override
    public void update(Note note) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE ADDRESS SET TITLE = ?, CONTENT = ?, PUBLISHDATE = ? WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.setDate(3, note.getPublishDate());
            preparedStatement.setLong(4, note.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void remove(Note note) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM NOTE WHERE ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, note.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
