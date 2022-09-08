package io.ther.emzio.calendarnotes.model;


import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    Note save(Note note);

    List<Note> findAll();

    Page<Note> findAll(Pageable pageable);

    boolean existsById(Long id);

    Optional<Note> findById(Long id);
}
