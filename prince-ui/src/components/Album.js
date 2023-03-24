import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { findAll } from "../service/albumService";
import { Link } from "react-router-dom";
import NavBar from "./NavBar";
import AlbumCard from "./AlbumCard";

export default function Album() {

    const [albums, setAlbums] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        findAll()
            .then(setAlbums)
            .catch(() => navigate("/error"));
    }, [navigate])


    return (
        <>
            <NavBar />
            <Link to="/" className="btn btn-success my-2">Home</Link>
            <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-2">
                {albums.map(a => <AlbumCard key={a.albumId} album={a} />)}
            </div>
        </>

    );

}