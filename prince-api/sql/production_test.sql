drop database if exists prince_test;
create database prince_test;
use prince_test;

create table album (
	album_id int primary key auto_increment,
    album_name varchar(100) not null,
    release_year int not null,
    riaa_certification varchar(30),
    photo_url varchar(320)
);

create table song (
	song_id int primary key auto_increment,
    song_name varchar(50) not null,
    video_url varchar(320),
    track int,
    album_id int not null,
    constraint fk_album_song_id
		foreign key (album_id)
        references album(album_id)
);

delimiter //
create procedure set_known_good_state()
begin
	truncate table song;
	truncate table album;
    
    insert into album(album_id, album_name, release_year, riaa_certification, photo_url) values
		(1, "For You", 1978, Null, 'https://upload.wikimedia.org/wikipedia/en/a/ac/Prince_-_For_You.jpg'),
        (2, "Purple Rain", 1984, "Platinum", "https://upload.wikimedia.org/wikipedia/en/9/9c/Princepurplerain.jpg"),
        (3, "Parade", 1986, "Platinum", "https://upload.wikimedia.org/wikipedia/en/c/c6/ParadeLP.jpg");

	insert into song(song_id, song_name, video_url, track, album_id) values
		(1, "For You", Null, 1, 1),
		(2, "Let's Go Crazy", Null, 1, 2),
		(3, "The Beautiful Ones", Null, 2, 2),
        (4, "Darling Nikki", Null, 3, 2),
        (5, "When doves cry", Null, 6, 2),
        (6, "Christopher Tracy's Parade", Null, 1, 3),
        (7, "girls & Boys", Null, 3, 3),
        (8, "Anotherloverholenyohead", Null, 4, 3);
    
end //
delimiter ;