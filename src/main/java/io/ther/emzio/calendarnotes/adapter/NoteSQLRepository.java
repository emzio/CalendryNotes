package io.ther.emzio.calendarnotes.adapter;

import io.ther.emzio.calendarnotes.model.Note;
import io.ther.emzio.calendarnotes.model.NoteRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteSQLRepository extends NoteRepository, JpaRepository<Note, Long> {

}
