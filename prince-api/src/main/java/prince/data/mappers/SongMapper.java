
package prince.data.mappers;

import org.springframework.jdbc.core.RowMapper;
import prince.models.Song;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongMapper implements RowMapper<Song> {

    @Override
    public Song mapRow(ResultSet resultSet, int i) throws SQLException {
        Song song = new Song();
        song.setSongId(resultSet.getInt("song_id"));
        song.setName(resultSet.getString("song_name"));
        song.setVideoUrl(resultSet.getString("video_url"));
        song.setTrackNum(resultSet.getInt("track"));
        song.setAlbumId(resultSet.getInt("album_id"));
        return song;
    }
}