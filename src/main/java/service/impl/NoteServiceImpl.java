package service.impl;

import dao.NoteDAO;
import model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.NoteService;

import java.sql.SQLException;
import java.util.List;

@Service("NoteService")
public class NoteServiceImpl implements NoteService{

    private NoteDAO noteDAO;

    @Autowired
    public void setNoteDAO(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }


    @Override
    public void add(Note note) {
        try {
            noteDAO.add(note);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Note> getAll() {
        try {
            return noteDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Note getById(long id) {
        try {
            return noteDAO.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Note note) {
        try {
            noteDAO.update(note);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(Note note) {
        try {
            noteDAO.remove(note);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
