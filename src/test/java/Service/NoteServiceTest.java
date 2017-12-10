package Service;

import dao.impl.NoteDAOImpl;
import model.Note;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.NoteServiceImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NoteServiceTest {

    List<Note> notes = new ArrayList<>();
    Note note = new Note();
    Note note2 = new Note();
    NoteDAOImpl noteDAO;
    NoteServiceImpl noteService = new NoteServiceImpl();

    @Before
    public void init() {
        note.setId(1);
        note.setTitle("New Year");
        note.setContent("Make New Year resolutions");
        note.setPublishDate(new Date( 2017, 12, 10));

        note2.setId(2);
        note2.setTitle("Best coffee");
        note2.setContent("Coffee + milk");
        note2.setPublishDate(new Date( 2015, 10, 10));

        notes.add(note);
        notes.add(note2);

        noteDAO = mock(NoteDAOImpl.class);

    }

    @Test
    public void getById() throws SQLException {
        when(noteDAO.getById(1)).thenReturn(note);
        String actualResult = noteService.getById(1).getTitle();
        String expectedResult = "New Year";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getAll() throws SQLException {
        when(noteDAO.getAll()).thenReturn(notes);
        String actualResult = noteService.getAll().get(1).getContent();
        String expectedResult = "Coffee + milk";
        Assert.assertEquals(expectedResult, actualResult);
    }

}
