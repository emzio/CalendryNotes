package io.ther.emzio.calendarnotes.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    private String path;
    @OneToMany(mappedBy="picture")
    private Set<Note> notes;

    public String getPath() {
        return path;
    }

    void setPath(String path) {
        this.path = path;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }
}
