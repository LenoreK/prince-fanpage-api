package prince.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import prince.models.Song;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SongJdbcTemplateRepositoryTest {

    final static int NEXT_SONG_ID = 11;

    @Autowired
    SongJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup(){
        knownGoodState.set();
    }

    @Test
    void findAll() {
        List<Song> songs = repository.findAll();
        assertNotNull(songs);
        assertTrue(songs.size() >= 7 && songs.size() <= 11);
    }

    @Test
    void findById() {
        Song song = repository.findById(5);
        assertNotNull(song);
        assertEquals(5, song.getSongId());
        assertEquals("When Doves Cry", song.getName());
    }

    @Test
    void shouldAdd(){
        Song song = makeSong();
        Song actual = repository.add(song);
        assertNotNull(actual);
        assertEquals(NEXT_SONG_ID, actual.getSongId());
    }

    @Test
    void shouldUpdate(){
        Song song = makeSong();
        song.setSongId(9);
        assertTrue(repository.update(song));
    }

    @Test
    void shouldDelete(){
        assertTrue(repository.deleteById(1));
    }
    Song makeSong(){
        Song song = new Song();
        song.setName("New Song");
        song.setVideoUrl("Some URL");
        song.setTrackNum(5);
        song.setAlbumId(3);
        return song;
    }
}