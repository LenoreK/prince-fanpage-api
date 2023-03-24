package prince.domain;

import org.springframework.stereotype.Service;
import prince.data.AlbumRepository;
import prince.models.Album;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album findByID(int albumId) {
        return albumRepository.findByID(albumId);
    }

    public Result<Album> add(Album album) {
        Result<Album>result = validate(album);
        if(!result.isSuccess()) {
            return result;
        }
        if(album.getAlbumId() !=0) {
            result.addMessage("albumId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }
        album = albumRepository.add(album);
        result.setPayload(album);
        return result;
    }
    public Result<Album> update(Album album) {
        Result<Album> result = validate(album);
        if (!result.isSuccess()) {
            return result;
        }

        if (album.getAlbumId() <= 0) {
            result.addMessage("albumId must be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!albumRepository.update(album)) {
            String msg = String.format("albumId: %s, not found", album.getAlbumId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

    public boolean deleteById(int albumId) {
        return albumRepository.deleteById(albumId);
    }


    private Result<Album>validate(Album album) {
        Result<Album> result = new Result<>();
        if(album == null) {
            result.addMessage("album cannot be null", ResultType.INVALID);
            return result;
        }
        if (Validations.isNullOrBlank(album.getName())) {
            result.addMessage("album name is required", ResultType.INVALID);
        }

        return result;

    }

}
