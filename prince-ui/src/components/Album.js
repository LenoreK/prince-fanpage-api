import { Link, useNavigate } from "react-router-dom";

function Album({ album }) {
    const navigate = useNavigate();

    const handleDelete = () => {
        navigate(`/delete/${album.albumId}`)
    };

    return (

        <div className="row">
            <div className="col">{album.albumId}</div>
            <div className="col">{album.name}</div>
            <div className="col">{album.yearReleased}</div>
            <div className="col">{album.riaa}</div>
            <div className="col-4">
                <Link to={`/edit/${album.albumId}`} >Update</Link>
                <button onClick={handleDelete}>Delete</button>
            </div>
        </div>
    )
}

export default Album;