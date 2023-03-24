import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { findAll } from "../service/albumService";
import Album from "./Album";

function Home() {

    const [albums, setAlbums] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        findAll()
            .then(setAlbums)
            .catch(error => navigate("/error", { state: { msg: error } }))
    }, [navigate]);

    return albums.map((album) => (
        <Album key={album.albumId} album={album} />
    ))
}

export default Home;