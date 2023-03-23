package prince.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import prince.models.Album;
import prince.models.Song;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AlbumJdbcTemplateRepositoryTest {

    final static int NEXT_ALBUM_ID = 5;

    @Autowired
    AlbumJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup(){
        knownGoodState.set();
    }

    @Test
    void findAll() {
        List<Album> albums = repository.findAll();
        assertNotNull(albums);
        assertTrue(albums.size() >= 3 && albums.size() <= 6);
    }

    @Test
    void findByID() {
        Album album = repository.findByID(3);
        assertNotNull(album);
        assertEquals(3, album.getAlbumId());
        assertEquals("Parade", album.getName());
    }

    @Test
    void add() {
        Album album = makeAlbum();
        Album actual = repository.add(album);
        assertNotNull(actual);
        assertEquals(NEXT_ALBUM_ID, actual.getAlbumId());
    }

    @Test
    void shouldUpdate(){
        Album album = makeAlbum();
        album.setAlbumId(3);
        assertTrue(repository.update(album));
    }

    @Test
    void shouldDelete(){
        assertTrue(repository.deleteById(1));
    }

    private Album makeAlbum() {
        Album album = new Album();
        album.setName("New Album");
        album.setReleaseYear(1973);
        album.setRiaa("Platinum");
        album.setPhotoUrl("URl");
        return album;
    }

}