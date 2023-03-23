package prince.data;

import org.springframework.transaction.annotation.Transactional;
import prince.models.Song;

import java.util.List;

public interface SongRepository {


    List<Song> findAll();
    @Transactional
    Song findById(int songId);

    Song add(Song song);

    boolean update(Song song);

    boolean deleteById(int songId);
}
