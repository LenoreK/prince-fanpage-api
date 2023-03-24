package prince.models;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private int albumId;
    private String name;
    private int releaseYear;
    private String riaa;
    private String photoUrl;
    private List<Song> songs = new ArrayList<>();

    public Album(int albumId, String name, int releaseYear, String riaa, String photoUrl) {
        this.albumId = albumId;
        this.name = name;
        this.releaseYear = releaseYear;
        this.riaa = riaa;
        this.photoUrl = photoUrl;
    }

    public Album() {
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRiaa() {
        return riaa;
    }

    public void setRiaa(String riaa) {
        this.riaa = riaa;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
