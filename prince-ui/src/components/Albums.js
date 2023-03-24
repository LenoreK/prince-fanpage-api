import { Link, useNavigate } from "react-router-dom";
import { findAll } from "../service/albumService"
import {useEffect, useState} from "react";
import Album from "./Album";

function Albums() {
    const [albums, setAlbums] = useState([]);

    useEffect(() => {
        findAll()
            .then(setAlbums)
            .catch(alert);
    }, []);

    return (
        <>
        <div className="row">
            <div className="col">Id</div>
            <div className="col">Name</div>
            <div className="col">Year Released</div>
            <div className="col">RIAA Certification</div>
            <div className="col-4">
            </div>
        </div>
        {albums.map(a => <Album key={a.albumId} album={a} />)}
        </>
    )
}

export default Albums;