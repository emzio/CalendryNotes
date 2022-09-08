package io.ther.emzio.calendarnotes.controller;

import io.ther.emzio.calendarnotes.model.Note;
import io.ther.emzio.calendarnotes.model.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class NoteController {
    private final NoteRepository repository;
    private final Logger logger = LoggerFactory.getLogger(NoteController.class);

    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/notes", params = {"!sort", "!page", "!size"})
    ResponseEntity<?> readAllTasks(){
        logger.warn("All task exposed!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/notes")
    ResponseEntity<List<Note>> readAllTasks(Pageable page){
        logger.warn("All task exposed!");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }


    @PostMapping("/notes")
    ResponseEntity<Note> createNote(@RequestBody @Valid Note note){
        Note saved = repository.save(note);
        return ResponseEntity.created(URI.create("/" + saved.getId())).body(saved);
    }

    @PutMapping("notes/{id}")
    ResponseEntity<?> updateNote(@RequestBody @Valid Note note, @PathVariable Long id){
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        note.setId(id);
        repository.save(note);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("notes/{id}")
    ResponseEntity<Note> readById(@PathVariable Long id){
        return repository.findById(id)
                .map(note -> ResponseEntity.ok(note))
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("notes/{noteId}")
    ResponseEntity<?> editNote(@PathVariable Long noteId, @RequestBody Note note){
        if(!repository.existsById(noteId)){
            return ResponseEntity.notFound().build();
        }
        repository.findById(noteId).ifPresent(noteToUpdate -> {
            noteToUpdate.setName(note.getName());
            repository.save(noteToUpdate);
        });
        return ResponseEntity.noContent().build();
    }
}
