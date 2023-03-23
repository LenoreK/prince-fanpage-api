package prince.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import prince.models.Song;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SongJdbcTemplateRepositoryTest {

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
    }

    @Test
    void findById() {
        Song song = repository.findById(5);
        assertNotNull(song);

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