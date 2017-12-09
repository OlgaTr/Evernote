package dao;

import model.Note;

import java.sql.SQLException;
import java.util.List;

public interface NoteDAO {

    void add (Note note) throws SQLException;

    List<Note> getAll() throws SQLException;

    Note getById(long id) throws SQLException;

    void update (Note note) throws SQLException;

    void remove (Note note) throws SQLException;
}
