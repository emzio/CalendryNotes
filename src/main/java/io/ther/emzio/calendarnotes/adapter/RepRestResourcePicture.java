package io.ther.emzio.calendarnotes.adapter;

import io.ther.emzio.calendarnotes.model.Picture;
import io.ther.emzio.calendarnotes.model.PictureRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "testing")
public interface RepRestResourcePicture extends PictureRepository, JpaRepository<Picture, Long> {

}
