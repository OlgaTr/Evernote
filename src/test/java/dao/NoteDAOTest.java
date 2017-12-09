package dao;

import bl.HibernateUtil;
import dao.impl.NoteDAOImpl;
import model.Note;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;

public class NoteDAOTest {

    Session session;
    NoteDAOImpl noteDAO = new NoteDAOImpl();
    Note note = new Note();

    @Before
    public void init() {
        note.setId(1);
        note.setTitle("New Year");
        note.setContent("Make New Year resolutions");
        note.setPublishDate(new Date( 2017, 12, 10));

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @Test
    public void add() throws SQLException {
        noteDAO.add(note);
        Assert.assertSame("New Year", noteDAO.getById(1).getTitle());
    }

    @After
    public void cleanUp() throws SQLException {
        noteDAO.remove(note);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
