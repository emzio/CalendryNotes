package io.ther.emzio.calendarnotes.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteSQLRepository extends NoteRepository, JpaRepository<Note, Long> {

}
