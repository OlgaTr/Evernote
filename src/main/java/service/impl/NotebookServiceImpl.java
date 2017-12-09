package service.impl;

import dao.NotebookDAO;
import model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.NotebookService;

import java.sql.SQLException;
import java.util.List;

@Service("NotebookService")
public class NotebookServiceImpl implements NotebookService{

    private NotebookDAO notebookDAO;

    @Autowired
    public void setNotebookDAO(NotebookDAO notebookDAO) {
        this.notebookDAO = notebookDAO;
    }

    @Override
    public void add(Notebook notebook) {
        try {
            notebookDAO.add(notebook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Notebook> getAll() {
        try {
            return notebookDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Notebook getById(long id) {
        try {
            return notebookDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Notebook notebook) {
        try {
            notebookDAO.update(notebook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Notebook notebook) {
        try {
            notebookDAO.remove(notebook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
