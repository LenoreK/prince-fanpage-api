package prince.data;

import org.springframework.transaction.annotation.Transactional;
import prince.models.Album;

import java.util.List;

public interface AlbumRepository {

    List<Album> findAll();

    @Transactional
    Album findByID(int albumId);

    Album add(Album album);

    boolean update(Album album);

    @Transactional
    boolean deleteById(int albumId);
}
