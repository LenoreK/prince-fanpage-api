import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { deleteById, findById } from "../service/albumService";

function Delete() {

    const [album, setAlbum] = useState();
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            findById(id)
                .then(setAlbum)
                .catch(() => navigate("/album"));
        } else {
            navigate("/");
        }
    }, [id, navigate])

    const cancel = () => navigate("/album");
    const handleDelete = () => {
        deleteById(id)
            .then(() => navigate("/album"))
            .catch(() => navigate("/error", { state: { msg: "⛔" } }));
    };

    return(
        <>
            <div>Are you sure you want to delete Album {album && album.name}?</div>
            <div>
                <button onClick={handleDelete}>Yes, Delete</button>
                <button onClick={cancel}>No, Cancel</button>
            </div>
        </>
    )
}

export default Delete;