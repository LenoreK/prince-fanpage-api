package prince.domain;

import org.springframework.stereotype.Service;
import prince.data.SongRepository;
import prince.models.Song;

import java.time.LocalDate;
import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Song findById(int songId) {
        return songRepository.findById(songId);

    }
    public Result<Song> add(Song song) {
        Result<Song> result = validate(song);
        if (!result.isSuccess()) {
            return result;
        }

        if (song.getSongId() != 0) {
            result.addMessage("songId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        song = songRepository.add(song);
        result.setPayload(song);
        return result;
    }

    public Result<Song> update(Song song) {
        Result<Song> result = validate(song);
        if (!result.isSuccess()) {
            return result;
        }

        if (song.getSongId() <= 0) {
            result.addMessage("songId must be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!songRepository.update(song)) {
            String msg = String.format("songId: %s, not found", song.getSongId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

    public boolean deleteById(int songId) {
        return songRepository.deleteById(songId);
    }

    private Result<Song> validate(Song song) {
        Result<Song> result = new Result<>();
        if (song == null) {
            result.addMessage("song cannot be null", ResultType.INVALID);
            return result;
        }

        if (Validations.isNullOrBlank(song.getName())) {
            result.addMessage("song name is required", ResultType.INVALID);
        }

        if (Validations.isNullOrBlank(song.getVideoUrl())) {
            result.addMessage("video url is required", ResultType.INVALID);
        }

        return result;
    }
}