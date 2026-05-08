package com.example.NotesAPI.service;

import com.example.NotesAPI.model.Note;
import com.example.NotesAPI.repository.NoteRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


import java.util.List;

@Component
public class NoteService {

    private final NoteRepository repo;

    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    public List<Note> getAllNotes(){
        return repo.findAll();
    }

    public Note getNoteById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Note not found with id: " + id));
    }

    public Note createNote(Note note){
        return repo.save(note);
    }

    public Note updateNote(String id, Note updated){
        Note existing = getNoteById(id);
        existing.setTitle(updated.getTitle());
        existing.setContent(updated.getContent());
        return repo.save(existing);
    }

    public void deleteNote(String id){
        getNoteById(id);
        repo.deleteById(id);
    }
}
