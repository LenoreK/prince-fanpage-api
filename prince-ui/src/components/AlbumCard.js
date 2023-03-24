export default function AlbumCard({ album }) {

    // const designer = game.gameRoles.find(gr => gr.role.name === "Designer");

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
                        RIAA Certification: {album}
                    </p>
                </div>
            </div>
        </div>
    );
}

