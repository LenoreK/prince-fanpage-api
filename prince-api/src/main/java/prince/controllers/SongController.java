package prince.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prince.domain.SongService;
import prince.models.Song;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/song")
public class SongController {

    private final SongService songService;


    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> findAll() { return songService.findAll(); }
}
