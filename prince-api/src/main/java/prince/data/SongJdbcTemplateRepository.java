package prince.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import prince.data.mappers.SongMapper;
import prince.models.Song;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
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

    @Override
    public Song add(Song song) {
        final String sql = "insert into song (song_name, video_url, track, album_id) values (?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, song.getName());
            ps.setString(2, song.getVideoUrl());
            ps.setInt(3, song.getTrackNum());
            ps.setInt(4, song.getAlbumId());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        song.setSongId((keyHolder.getKey().intValue()));
        return song;
    }

    @Override
    public boolean update(Song song) {

        final String sql = "update song set "
                + "song_name = ?, "
                + "video_url = ?, "
                + "track = ?, "
                + "album_id = ? "
                + "where song_id = ?;";

        return jdbcTemplate.update(sql, song.getName(), song.getVideoUrl(), song.getTrackNum(), song.getAlbumId(), song.getSongId()) > 0;
    }

    @Override
    public boolean deleteById(int songId){
        return jdbcTemplate.update("delete from song where song_id = ?", songId) > 0;
    }
}
