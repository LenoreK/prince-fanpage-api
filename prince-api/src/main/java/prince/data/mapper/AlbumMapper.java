package prince.data.mapper;

import prince.models.Album;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumMapper implements RowMapper<Album> {

    @Override
    public Album mapRow(ResultSet resultSet, int i) throws SQLException {
        Album album = new Album();
        album.setAlbumId(resultSet.getInt("album_id"));
        album.setName(resultSet.getString("album_name"));
        album.setReleaseYear(resultSet.getInt("release_year"));
        album.setRiaa(resultSet.getString("riaa_certification"));
        album.setPhotoUrl(resultSet.getString("photo_url"));
        return album;
    }
}