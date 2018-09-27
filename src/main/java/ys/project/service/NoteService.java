package ys.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.project.model.Note;
import ys.project.repos.NoteRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by zorrax on 10.09.2018.
 */
@Service
public class NoteService {
    private NoteRepository noteRepository;
    @Autowired
    public void setNoteRepository(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll(){
        List<Note> list;
        list = noteRepository.findAll();
        return list;
    }


    public void saveNote(Note note){
        noteRepository.save(note);
    }

    public Note findNoteById(String id){
    // @TODO если в модель не переданн массив бросает исключение
        return noteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("NULL"));
        //return noteRepository.findNoteById(id);
    }


    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }
}
