package com.example.NotesAPI.controller;

import com.example.NotesAPI.model.Note;
import com.example.NotesAPI.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Note> getAll(){
        return service.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getNoteById(id));
    }

    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note note){
        Note created = service.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@PathVariable String id, @RequestBody Note note){
        return ResponseEntity.ok(service.updateNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        service.deleteNote(id);
        return ResponseEntity.noContent().build();
    }
}
