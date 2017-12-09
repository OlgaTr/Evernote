package dao.impl;

import bl.SessionUtil;
import dao.NotebookDAO;
import model.Notebook;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class NotebookDAOImpl extends SessionUtil implements NotebookDAO {

    @Override
    public void add(Notebook notebook) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(notebook);

        closeTransactionSession();
    }

    @Override
    public List<Notebook> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM NOTEBOOK";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Notebook.class);
        List<Notebook> notebookList = query.list();

        closeTransactionSession();
        return notebookList;
    }

    @Override
    public Notebook getById(long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM NOTEBOOK WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Notebook.class);
        query.setParameter("id", id);

        Notebook notebook = (Notebook) query.getSingleResult();

        closeTransactionSession();

        return notebook;
    }

    @Override
    public void update(Notebook notebook) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(notebook);

        closeTransactionSession();
    }

    @Override
    public void remove(Notebook notebook) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(notebook);

        closeTransactionSession();
    }
}