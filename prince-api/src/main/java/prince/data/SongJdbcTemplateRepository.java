package prince.data;

import org.springframework.jdbc.core.JdbcTemplate;
import prince.data.mapper.SongMapper;
import prince.models.Song;

import java.util.List;

public class SongJdbcTemplateRepository implements SongRepository {

    private final JdbcTemplate jdbcTemplate;

    public SongJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Song> findAll() {
        final String sql = "select song_id, song_name, video_url, track, album_id from song;";
        return jdbcTemplate.query(sql, new SongMapper());
    }

    @Override
    public Song findById(int songId){
        final String sql = "select song_id, song_name, video_url, track, album_id "
                + "from song "
                + "where song_id = ?;";

        return jdbcTemplate.query(sql, new SongMapper(), songId).stream()
                .findFirst()
                .orElse(null);
    }
}
