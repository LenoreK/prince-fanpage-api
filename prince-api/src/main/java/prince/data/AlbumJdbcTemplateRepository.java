package prince.data;

import org.springframework.jdbc.core.JdbcTemplate;
import prince.data.mapper.AlbumMapper;
import prince.models.Album;

import java.util.List;

public class AlbumJdbcTemplateRepository implements AlbumRepository {

    private final JdbcTemplate jdbcTemplate;

    public AlbumJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Album> findAll() {
        final String sql = "select album_id, album_name, release_year, riaa_certification, photo_url from album;";
        return jdbcTemplate.query(sql, new AlbumMapper());
    }

    @Override
    public Album findByID(int albumId) {

        final String sql = "select album_id, album_name, release_year, riaa_certification, photo_url "
                + "from album "
                + "where album_id = ?;";

        Album result = jdbcTemplate.query(sql, new AlbumMapper(), albumId).stream()
                .findAny().orElse(null);

        if (result !=null) {
            addSong(result);
        }

        return result;
    }



}
