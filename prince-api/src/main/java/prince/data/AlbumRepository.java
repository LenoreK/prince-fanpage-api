package prince.data;

import prince.models.Album;

import java.util.List;

public interface AlbumRepository {

    List<Album> findAll();

    Album findByID(int albumId);
}
