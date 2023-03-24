import * as base from "./baseService";
const model = "album";

export function getEmptyAlbum(){
    return {
        albumId: 0,
        name: "",
        releaseYear: 0,
        riaa: "",
        photoUrl: "",
        songs: []
    };
}

export async function findAll(){
    return base.findAll(model);
}

export async function findById(albumId){
    return base.findById(model, albumId);
}

export async function save(album) {
    return base.save(model, album, album.albumId);
}

export async function deleteById(albumId){
    return base.deleteById(model, albumId);
}