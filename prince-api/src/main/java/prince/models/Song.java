package prince.models;

public class Song {
    private int songId;
    private String name;
    private String videoUrl;
    private int trackNum;
    private int albumId;

    public Song(int songId, String name, String videoUrl, int trackNum, int albumId) {
        this.songId = songId;
        this.name = name;
        this.videoUrl = videoUrl;
        this.trackNum = trackNum;
        this.albumId = albumId;
    }

    public Song() {
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getTrackNum() {
        return trackNum;
    }

    public void setTrackNum(int trackNum) {
        this.trackNum = trackNum;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
