import { Link, useNavigate } from "react-router-dom";

export default function AlbumCard({ album }) {

const navigate = useNavigate();    

const handleDelete = () => {
    navigate(`/delete/${album.albumId}`)
};

    

    return (
        <div className="col">
            <div className="card">
                {album.photoUrl && <img src={album.photoUrl} className="card-img-top" alt={album.name} />}
                <div className="card-body">
                    <div className="row">
                        <h5 className="card-title col">{album.name}</h5>
                        <div className="col">
                            <strong>({album.releaseYear})</strong>
                        </div>
                    </div>
                    <p className="card-text">
                        RIAA Certification: {album.riaa}
                    </p>
                    <div className="d-grid gap-2 d-md-block">
                        <Link to={`/edit/${album.albumId}`} className="btn btn-primary" type="button">Update</Link>
                        <button onClick={handleDelete} className="btn btn-danger" type="button">Delete</button>
                    </div>
                </div>
            </div>
        </div>
    );
}


