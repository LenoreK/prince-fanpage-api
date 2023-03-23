<<<<<<< HEAD:prince-api/src/main/java/prince/data/mappers/SongMapper.java
package prince.data.mappers;

import prince.models.Album;
=======
package prince.data.mapper;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
>>>>>>> 9663cf2d0cbe79101c5c266d9014b71082a8b3d3:prince-api/src/main/java/prince/data/mapper/SongMapper.java
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
<<<<<<< HEAD:prince-api/src/main/java/prince/data/mappers/SongMapper.java
}
=======
}
>>>>>>> 9663cf2d0cbe79101c5c266d9014b71082a8b3d3:prince-api/src/main/java/prince/data/mapper/SongMapper.java
