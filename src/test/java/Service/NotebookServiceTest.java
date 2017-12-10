package Service;

import dao.impl.NotebookDAOImpl;
import model.Notebook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.NotebookServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NotebookServiceTest {

    List<Notebook> notebooks = new ArrayList<>();
    Notebook notebook = new Notebook();
    Notebook notebook2 = new Notebook();
    NotebookDAOImpl notebookDAO;
    NotebookServiceImpl notebookService = new NotebookServiceImpl();

    @Before
    public void init() {
        notebook.setId(1);
        notebook.setName("Sketch book");

        notebook2.setId(2);
        notebook2.setName("Funny cat");

        notebooks.add(notebook);
        notebooks.add(notebook2);

        notebookDAO = mock(NotebookDAOImpl.class);
    }

    @Test
    public void getById() throws SQLException {
        when(notebookDAO.getById(1)).thenReturn(notebook);
        String expectedResult = "Sketch book";
        String actualResult = notebookService.getById(1).getName();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getAll() throws SQLException {
        when(notebookDAO.getAll()).thenReturn(notebooks);
        String expectedResult = "Funny cat";
        String actualResult = notebookService.getAll().get(1).getName();
        Assert.assertEquals(expectedResult, actualResult);
    }

}
