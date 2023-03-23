package prince.data;

import prince.models.Song;

import java.util.List;

public interface SongRepository {


    List<Song> findAll();

    Song findById(int songId);
}
