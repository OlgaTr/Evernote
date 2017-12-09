package service;

import model.Note;

import java.util.List;

public interface NoteService {

    void add (Note note);

    List<Note> getAll();

    Note getById(long id);

    void update (Note note);

    void remove (Note note);


}
