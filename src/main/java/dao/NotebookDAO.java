package dao;

import model.Notebook;

import java.sql.SQLException;
import java.util.List;

public interface NotebookDAO {

    void add (Notebook notebook) throws SQLException;

    List<Notebook> getAll() throws SQLException;

    Notebook getById(long id) throws SQLException;

    void update (Notebook notebook) throws SQLException;

    void remove (Notebook notebook) throws SQLException;
}
