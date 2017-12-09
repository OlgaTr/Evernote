package service;

import model.Notebook;

import java.util.List;

public interface NotebookService {
    void add (Notebook notebook);

    List<Notebook> getAll();

    Notebook getById(long id);

    void update (Notebook notebook);

    void remove (Notebook notebook);
}
