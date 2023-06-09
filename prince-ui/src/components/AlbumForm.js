import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { findById, save } from "../service/albumService";

const DEFAULT_ALBUM = {
    name: "",
    releaseYear: "",
    riaa: "",
    photoUrl: ""
};

function AlbumForm() {

    const [album, setAlbum] = useState(DEFAULT_ALBUM);
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            findById(id)
                .then(setAlbum)
                .catch(() => navigate("/"));
        }
    }, [id, navigate]);

    const handleChange = (event) => {
        const updatedAlbum = { ...album };
        updatedAlbum[event.target.name] = event.target.value;
        setAlbum(updatedAlbum);
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        const updatedAlbum = { ...album };

        save(updatedAlbum)
            .then(() => navigate("/confirmation", { state: { msg: "Album Confirmed" } }))
            .catch(() => navigate("/error", { state: { msg: "Could Not Save Album. Error" } }))
    };

    return (
        <form onSubmit={handleSubmit}>
            <h2>{album.albumId ? "Update An Album" : "Add An Album"}</h2>

            <div>
                <label htmlFor="name">Album Name</label>
                <input 
                    type="text"
                    id="name"
                    required
                    value={album.name}
                    name="name"
                    onChange={handleChange}
                />
                <label htmlFor="releaseYear">Release Year</label>
                <input 
                    type="int"
                    id="releaseYear"
                    required
                    value={album.releaseYear}
                    name="releaseYear"
                    onChange={handleChange}
                />
                <label htmlFor="riaa">RIAA Certification</label>
                <input 
                    type="text"
                    id="riaa"
                    value={album.riaa}
                    name="riaa"
                    onChange={handleChange}
                />
                <label htmlFor="photoUrl">Album Art URL</label>
                <input 
                    type="text"
                    id="photoUrl"
                    value={album.photoUrl}
                    name="photoUrl"
                    onChange={handleChange}
                />
            </div>

            <div>
                <button type="submit">Save</button>
                <Link to="/">Cancel</Link>
            </div>
        </form>
    );
    
}

export default AlbumForm;