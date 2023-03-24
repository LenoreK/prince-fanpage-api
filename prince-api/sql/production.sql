drop database if exists prince;
create database prince;
use prince;

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