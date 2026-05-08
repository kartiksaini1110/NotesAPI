package com.example.NotesAPI.repository;

import com.example.NotesAPI.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
    
}
